package school.onlineschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.onlineschool.models.Teacher;
import school.onlineschool.repository.TeacherRepo;

import java.util.List;

@Service
public class TeacherServiceC {

    private TeacherRepo teacherRepo;

    @Autowired
    public TeacherServiceC(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    public Teacher update(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    public List<Teacher> findAll() {
        return (List<Teacher>) teacherRepo.findAll();
    }
}
