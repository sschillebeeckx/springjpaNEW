package be.abis.exercise.repository;

import be.abis.exercise.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseJpaRepository extends JpaRepository<Course,Integer> {

    Course findCourseByCourseId(int id);

    //@Query(value = "select *  ", nativeQuery = true)
    Course findCourseByShortTitleStartingWithIgnoreCase(String title);
}
