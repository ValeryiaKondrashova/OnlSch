package school.onlineschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.onlineschool.models.Course;
import school.onlineschool.repository.CourseRepo;

import java.util.List;

@Service
public class CourseService {

    private CourseRepo courseRepo;

    @Autowired
    public CourseService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    public List<Course> findAll(){
        return courseRepo.findAll();
    }

    public Course add(Course course) {
        return courseRepo.save(course);
    }

    public Course find(Long id) {
        return courseRepo.getReferenceById(id);
    }

    public Course update(Course course){
        return courseRepo.save(course);
    }

}
