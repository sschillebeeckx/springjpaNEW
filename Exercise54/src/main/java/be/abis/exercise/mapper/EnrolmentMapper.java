package be.abis.exercise.mapper;

import be.abis.exercise.dto.EnrolmentDTO;
import be.abis.exercise.dto.PersonDTO;
import be.abis.exercise.model.Enrolment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EnrolmentMapper {

    public static EnrolmentDTO toDTO(Object[] objArray) {
        EnrolmentDTO dto = new EnrolmentDTO();

        dto.setFirstName(objArray[0].toString());
        dto.setLastName(objArray[1].toString().trim());
        dto.setEnrolleeCompanyName(objArray[2].toString());

        String dateFound = objArray[3].toString();
        System.out.println("date found= " + dateFound);
        //dev
        // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //prod
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
        dto.setStartDate(LocalDate.parse(dateFound, dtf));

        dto.setLocationCompany(objArray[4].toString().trim());
        dto.setLocationTown(objArray[5].toString().trim());

        dto.setCoursetitle(objArray[6].toString());

       return dto;
    }
}
