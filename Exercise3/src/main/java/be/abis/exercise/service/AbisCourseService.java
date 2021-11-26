package be.abis.exercise.service;

import be.abis.exercise.model.Course;
import be.abis.exercise.repository.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbisCourseService implements CourseService {

    @Autowired
    CourseJpaRepository courseRepository;

    @Override
    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course findCourse(int id) {
        return courseRepository.findCourseByCourseId(id);
    }

    @Override
    public Course findCourse(String shortTitle) {
        return courseRepository.findCourseByShortTitleStartingWithIgnoreCase(shortTitle);
    }

    @Override
    public void addCourse(Course c) {
        courseRepository.save(c);
    }

    @Override
    public void updateCourse(Course c) {
        Course course = courseRepository.findCourseByCourseId(c.getCourseId());
        if (course!=null) courseRepository.save(c);
    }

    @Override
    public void deleteCourse(int id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Long countAllCourses() {
        return courseRepository.count();
    }


}
