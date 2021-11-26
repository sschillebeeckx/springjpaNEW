package be.abis.exercise;

import be.abis.exercise.model.Course;
import be.abis.exercise.service.CourseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class TestCourseService {

	@Autowired
	CourseService courseService;

	@Test
	public void sizeListIs24(){
		List<Course> allCourses = courseService.findAllCourses();
		assertEquals(24,allCourses.size());
	}

	@Test
	public void course7850IsDB2BAS() {
		int id = 7850;
		Course found = courseService.findCourse(id);
		assertEquals("DB2BAS", found.getShortTitle().trim());
	}

	@Test
	public void courseSQLWStakes3Days() {
		String shortTitle = "SQLWS";
		Course found = courseService.findCourse(shortTitle);
		assertEquals(3,found.getNumberOfDays());
	}

	@Test
	//@Transactional
	public void addCourse() {
		Course c = new Course();
		c.setShortTitle("SPRINGJPA");
		c.setLongTitle("Using JPA with Spring Boot");
		c.setNumberOfDays(2);
		c.setPricePerDay(425.0);
		long sizeBefore = courseService.countAllCourses();
		courseService.addCourse(c);
		long sizeAfter = courseService.countAllCourses();
		assertEquals(1,sizeAfter-sizeBefore);
	}

	@Test
	@Transactional
	public void updateCourse() {
		Course c = courseService.findCourse(7800);
		c.setLongTitle("Using IMSADFII");
		courseService.updateCourse(c);
		assertEquals("Using IMSADFII", courseService.findCourse(7800).getLongTitle());
	}

	@Test
	@Transactional
	public void deleteCourse8055WhichHasNoChildren() {
		long sizeBefore = courseService.countAllCourses();
		int id = 8055;
		courseService.deleteCourse(id);
		long sizeAfter = courseService.countAllCourses();
		assertEquals(1,sizeBefore-sizeAfter);
	}

	
	

}
