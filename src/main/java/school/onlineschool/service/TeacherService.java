package school.onlineschool.service;


import school.onlineschool.models.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> findAll();

    Teacher findTeacherId(Long id);
}
