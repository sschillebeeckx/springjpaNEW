package be.abis.exercise.controller;

import be.abis.exercise.dto.PersonDTO;
import be.abis.exercise.exception.PersonAlreadyExistsException;
import be.abis.exercise.exception.PersonCanNotBeDeletedException;
import be.abis.exercise.exception.PersonNotFoundException;
import be.abis.exercise.mapper.PersonMapper;
import be.abis.exercise.model.Login;
import be.abis.exercise.model.Person;
import be.abis.exercise.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("persons")
public class PersonApiController {

    @Autowired
    PersonService personService;

    @Autowired
    PersonService ps;

    @GetMapping("")
    public List<PersonDTO> getAllPersons(){

        List<PersonDTO> personDTOs = new ArrayList<>();
        List<Person> persons = ps.getAllPersons();
        for (Person p : persons){
            personDTOs.add(PersonMapper.toDTO(p));
        }
        return personDTOs;


    }

    @GetMapping("{id}")
    public PersonDTO findPerson(@PathVariable("id") int id) throws PersonNotFoundException {
       return PersonMapper.toDTO(ps.findPerson(id));
    }

    @PostMapping("/login")
    public PersonDTO findPersonByMailAndPwd(@RequestBody Login login) throws PersonNotFoundException {
        return PersonMapper.toDTO(ps.findPerson(login.getEmail(), login.getPassword()));
    }

    @GetMapping(path="/compquery")
    public List<Person> findPersonsByCompanyName(@RequestParam("compname") String compName) {
        return ps.findPersonsByCompanyName(compName);
    }

    @PostMapping(path="")
    public void addPerson(@RequestBody Person p) throws PersonAlreadyExistsException {
            ps.addPerson(p);
    }

    @DeleteMapping("{id}")
    public void deletePerson(@PathVariable("id") int id) throws PersonCanNotBeDeletedException {
        ps.deletePerson(id);
    }

    @PutMapping("{id}")
    public void changePassword(@PathVariable("id") int id, @RequestBody Person person) throws PersonNotFoundException {
            System.out.println("changing password to newpswd= " + person.getPassword());
            ps.changePassword(person, person.getPassword());
    }





}
