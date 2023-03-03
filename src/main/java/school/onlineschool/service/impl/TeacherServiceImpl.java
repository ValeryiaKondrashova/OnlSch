package school.onlineschool.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import school.onlineschool.models.Teacher;
import school.onlineschool.repository.TeacherRepo;
import school.onlineschool.service.TeacherService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepo teacherRepo;

    @Override
    public List<Teacher> findAll() {return (List<Teacher>) teacherRepo.findAll();}

    @Override
    public Teacher findTeacherId(Long id) {return teacherRepo.findById(id).orElseThrow();}
}
