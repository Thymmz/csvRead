package com.walmart.filequeuedatabase;

import com.walmart.filequeuedatabase.dao.PeopleDao;
import com.walmart.filequeuedatabase.model.PeopleModel;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FileQueueDatabaseApplicationTests {
	@Autowired
	PeopleDao peopleDao;

	@Test
	@Order(1)
	public void testCreatePerson() {
		PeopleModel person = new PeopleModel();
		person.setPersonid("1234");
		person.setName("Burks, Rosella");
		person.setFirst("Rosella");
		person.setLast("Burks");
		person.setMiddle("Middle");
		person.setEmail("test@test.email");
		person.setPhone("123.456.7890");
		person.setFax("123.456.7890");
		person.setTitle("testTitle");
		this.peopleDao.save(person);
		Assertions.assertNotNull(this.peopleDao.findById("1234").get());
	}

	@Test
	@Order(2)
	public void testReadAllPeople() {
		List<PeopleModel> listPeople = this.peopleDao.findAll();
		AssertionsForClassTypes.assertThat(listPeople).asList().size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	public void testSinglePerson() {
		PeopleModel person = (PeopleModel) this.peopleDao.findById("1234").get();
		Assertions.assertEquals("Burks, Rosella", person.getName());
	}

	@Test
	@Order(4)
	public void testDeletePerson() {
		this.peopleDao.deleteById("1234");
		AssertionsForClassTypes.assertThat(this.peopleDao.existsById("1234")).isFalse();
	}


}
