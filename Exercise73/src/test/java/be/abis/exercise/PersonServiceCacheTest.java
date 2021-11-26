package be.abis.exercise;


import be.abis.exercise.exception.PersonNotFoundException;
import be.abis.exercise.model.Person;
import be.abis.exercise.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class PersonServiceCacheTest {
	
	@Autowired
	PersonService personService;

	@Test
	public void person1ShouldBeCalledJAN() throws PersonNotFoundException {
		Person p = personService.findPerson(1);
		System.out.println("person 1 in test 1 " + p);
		assertEquals("JAN",p.getFirstName());
		Person p2 = personService.findPerson(1);
		System.out.println("person 1 in test 1 again " + p2);
	}


}
