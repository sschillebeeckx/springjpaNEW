package be.abis.exercise.service;

import be.abis.exercise.dto.EnrolmentDTO;
import be.abis.exercise.dto.SessionDTO;
import be.abis.exercise.exception.EnrolException;
import be.abis.exercise.exception.PersonNotFoundException;
import be.abis.exercise.model.Person;

import java.time.LocalDate;
import java.util.List;

public interface TrainingService {

    public String getWelcomeMessage();
    public PersonService getPersonService();
    public CourseService getCourseService();


    public void enrolForSession(Person person, int sessionId) throws EnrolException;

    List<SessionDTO> findSessionsForCourse(String courseTitle);

    public List<EnrolmentDTO> findEnrolments(int personId);

    void cancelSession(int sessionId);

    Integer countEnrolmentsForSession(int sessionId);

    void addNewCompanySession(String courseTitle,int personId,int companyId, LocalDate startDate) throws PersonNotFoundException;
}
