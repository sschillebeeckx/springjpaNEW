package be.abis.exercise.mapper;

import be.abis.exercise.dto.PersonDTO;
import be.abis.exercise.model.Person;

public class PersonMapper {

    public static PersonDTO toDTO(Person person){
        return new PersonDTO(person.getFirstName(),
                             person.getLastName(),
                             person.getEmailAddress(),
                             person.getBirthDate(),
                             person.getCompany().getName(),
                             person.getCompany().getAddress().getTown());
    }


}
