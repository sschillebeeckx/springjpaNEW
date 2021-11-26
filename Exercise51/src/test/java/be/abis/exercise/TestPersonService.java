package be.abis.exercise;


import be.abis.exercise.exception.PersonAlreadyExistsException;
import be.abis.exercise.exception.PersonCanNotBeDeletedException;
import be.abis.exercise.exception.PersonNotFoundException;
import be.abis.exercise.model.Address;
import be.abis.exercise.model.Company;
import be.abis.exercise.model.Person;
import be.abis.exercise.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class TestPersonService {
	
	@Autowired
	PersonService personService;

	@Test
	public void person1ShouldBeCalledJAN() throws PersonNotFoundException {
		String firstName = personService.findPerson(1).getFirstName();
		assertEquals("JAN",firstName);
	}

	@Test
	public void thereShouldBe45PersonsInTheFile(){
		int nrOfPersons = personService.getAllPersons().size();
		assertEquals(45,nrOfPersons);
	}

	@Test
	public void person3ByEmailAndPassword() throws PersonNotFoundException {
		Person person = personService.findPerson("ann.dekeyser@abis.be","adk789");
		assertEquals(3,person.getPersonId());
	}

	@Test
	public void thereAre3PersonsForAbis()  {
		List<Person> persons = personService.findPersonsByCompanyName("ABIS");
		assertEquals(3,persons.size());
	}

	@Test
	//@Transactional
	public void addNewPersonWithNewCompany() throws PersonAlreadyExistsException {
		Address a = new Address("Some Street","32","1000","BRUSSEL");
		Company c = new Company("BBIS","016/123455","BE12345678",a);
		Person p = new Person("Sandy","Schillebeeckx", LocalDate.of(1978,04,10),"sschillebeeckx@abis.be","abis123","nl",c);
		long sizeBefore = personService.count();
		personService.addPerson(p);
		long sizeAfter = personService.count();
		assertEquals(1,sizeAfter-sizeBefore);
	}

	@Test
	//@Transactional
	public void addNewPersonWithExistingCompany() throws PersonAlreadyExistsException {
		Address a = new Address("Diestsevest","32","3000","LEUVEN");
		Company c = new Company("ABIS N.V.","016/455610","BE12345678",a);
		Person p = new Person("Sandy","Schillebeeckx", LocalDate.of(1978,04,10),"sschillebeeckx@abis.be","abis123","nl",c);
		long sizeBefore = personService.count();
		personService.addPerson(p);
		long sizeAfter = personService.count();
		assertEquals(1,sizeAfter-sizeBefore);
	}

	@Test
	//@Transactional
	public void changePassWordOfPerson3() throws  PersonNotFoundException {
		Person p = personService.findPerson(3);
		personService.changePassword(p,"blabla");
		assertEquals("blabla",personService.findPerson(3).getPassword());
	}

	@Test
	//@Transactional
	public void deletePerson92WorksForComp20() throws PersonCanNotBeDeletedException {
		long sizeBefore = personService.count();
		personService.deletePerson(92);
		long sizeAfter = personService.count();
		assertEquals(-1,sizeAfter-sizeBefore);
	}

	
	

}
