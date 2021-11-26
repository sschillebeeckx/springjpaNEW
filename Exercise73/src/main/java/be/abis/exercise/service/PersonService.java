package be.abis.exercise.service;


import be.abis.exercise.exception.PersonAlreadyExistsException;
import be.abis.exercise.exception.PersonCanNotBeDeletedException;
import be.abis.exercise.exception.PersonNotFoundException;
import be.abis.exercise.model.Person;

import java.util.List;

public interface PersonService {

    List<Person> getAllPersons();
    Person findPerson(int id) throws PersonNotFoundException;
    Person findPerson(String emailAddress, String passWord) throws PersonNotFoundException;
    Person addPerson(Person p) throws PersonAlreadyExistsException;
    public void deletePerson(int id) throws PersonCanNotBeDeletedException;
    void changePassword(Person p, String newPswd);
    public List<Person> findPersonsByCompanyName(String compName);

    long count();
    Person findPerson(String emailAddress);

    List<String> findHobbiesForPerson(int id);
    void addHobbyForPerson(int personId, String hobby);

}
