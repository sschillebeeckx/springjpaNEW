package be.abis.exercise.service;

import be.abis.exercise.dto.EnrolmentDTO;
import be.abis.exercise.dto.SessionDTO;
import be.abis.exercise.exception.EnrolException;
import be.abis.exercise.exception.PersonAlreadyExistsException;
import be.abis.exercise.exception.PersonNotFoundException;
import be.abis.exercise.mapper.EnrolmentMapper;
import be.abis.exercise.mapper.SessionMapper;
import be.abis.exercise.model.*;
import be.abis.exercise.repository.CompanyJpaRepository;
import be.abis.exercise.repository.EnrolmentJpaRepository;
import be.abis.exercise.repository.SessionJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AbisTrainingService implements TrainingService {

    @Autowired
    SessionJpaRepository sessionRepository;

    @Autowired
    EnrolmentJpaRepository enrolmentRepository;

    @Autowired
    CompanyJpaRepository companyRepository;


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
    @Transactional(rollbackOn = EnrolException.class)
    public void enrolForSession(Person person, int sessionId) throws EnrolException {

        Person personToEnrol = null;
        try {
            personToEnrol = personService.addPerson(person);
        } catch (PersonAlreadyExistsException e) {
            personToEnrol = personService.findPerson(person.getEmailAddress());
        }

        System.out.println("person to enrol: " + personToEnrol);
        Session s = sessionRepository.findById(sessionId);
        //System.out.println("session found: " + s.getCourse().getLongTitle());
        if (s == null) throw new EnrolException("Can not enrol, session does not exist");
        Integer eno = enrolmentRepository.getLastEnoForSession(sessionId);
        int newEno = (eno==null)?1:eno+1;
        // double priceToPay = getCourseService().findCourse(s.getCourse().getCourseId()).getPricePerDay();
        try {
            enrolmentRepository.saveEnrolment(s.getSessionId(), newEno, personToEnrol.getPersonId(), s.getCourse().getPricePerDay(), personToEnrol.getCompany().getId());
        } catch (DataAccessException dae){
            throw new EnrolException("oops, something went wrong");
        }
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

    @Override
    @Transactional
    public void cancelSession(int sessionId) {
        sessionRepository.cancelSession(sessionId);
    }

    @Override
    public Integer countEnrolmentsForSession(int sessionId) {
        return enrolmentRepository.countEnrolmentsForSession(sessionId);
    }

    @Transactional
    public void addNewCompanySession(String courseTitle,int personId,int companyId, LocalDate startDate) throws PersonNotFoundException {
        Course course = courseService.findCourse(courseTitle);
        Person instructor = personService.findPerson(personId);
        Company location = companyRepository.findCompanyById(companyId);
        CompanySession cs = new CompanySession(startDate,instructor,location,course);
        sessionRepository.save(cs);
    }


}
