package be.abis.exercise.mapper;

import be.abis.exercise.dto.SessionDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SessionMapper {

    public static SessionDTO toDTO(Object[] objArray){
        SessionDTO sessionDTO= new SessionDTO();

        sessionDTO.setSessionNumber(Integer.parseInt(objArray[0].toString()));

        String dateFound= objArray[1].toString();
        System.out.println("date found= " + dateFound);
        //dev
        // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //prod
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
        sessionDTO.setStartDate(LocalDate.parse(dateFound, dtf));

        sessionDTO.setInstructorFirstName(objArray[2].toString());
        sessionDTO.setInstructorLastName(objArray[3].toString().trim());

        sessionDTO.setLocationCompany(objArray[4].toString().trim());
        sessionDTO.setLocationTown(objArray[5].toString().trim());

        sessionDTO.setKind(objArray[6].toString());

        Object obj = objArray[7];
        sessionDTO.setCancelled((obj == null) ? false : true);

        sessionDTO.setCourseTitle(objArray[8].toString());

        return sessionDTO;

    }
}
