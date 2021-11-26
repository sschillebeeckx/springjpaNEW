package be.abis.exercise.service;

import be.abis.exercise.dto.EnrolmentDTO;
import be.abis.exercise.dto.SessionDTO;
import be.abis.exercise.exception.EnrolException;
import be.abis.exercise.mapper.EnrolmentMapper;
import be.abis.exercise.mapper.SessionMapper;
import be.abis.exercise.model.Person;
import be.abis.exercise.repository.EnrolmentJpaRepository;
import be.abis.exercise.repository.SessionJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AbisTrainingService implements TrainingService {

    @Autowired
    SessionJpaRepository sessionRepository;

    @Autowired
    EnrolmentJpaRepository enrolmentRepository;


    @Value("Welcome to the Abis Training Service")
    private String welcomeMessage;

    @Autowired
    private PersonService personService;

    @Autowired
    private CourseService courseService;

    @Override
    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public PersonService getPersonService() {
        return personService;
    }

    public CourseService getCourseService() {
        return courseService;
    }


    @Override
    public void enrolForSession(Person person, int sessionId) throws EnrolException {

    }

    @Override
    public List<SessionDTO> findSessionsForCourse(String courseTitle) {

        List<Object[]> result = sessionRepository.findByCourseTitle(courseTitle);

        return result.stream().map(SessionMapper::toDTO).collect(Collectors.toList()) ;
    }



    @Override
    public List<EnrolmentDTO> findEnrolments(int personId) {
        List<Object[]> result = enrolmentRepository.findByEnrolleeNQ(personId);
        return result.stream().map(EnrolmentMapper::toDTO).collect(Collectors.toList()) ;
    }


}
