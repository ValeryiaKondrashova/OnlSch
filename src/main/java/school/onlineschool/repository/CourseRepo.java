package school.onlineschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import school.onlineschool.models.Course;

public interface CourseRepo extends JpaRepository<Course, Long> {
    Course findCourseByNameCourse(String id);
}
