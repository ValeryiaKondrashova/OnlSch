package school.onlineschool.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.onlineschool.models.*;
import school.onlineschool.repository.CourseRepo;
import school.onlineschool.repository.HomeWorkRepo;
import school.onlineschool.repository.TeacherRepo;
import school.onlineschool.response.ResCourse;
import school.onlineschool.response.ResHomework;
import school.onlineschool.response.ResTeacher;
import school.onlineschool.service.TeacherService;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ResController{

    @Autowired
    private HomeWorkRepo homeWorkRepo;

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private TeacherRepo teacherRepo;

    private final TeacherService teacherService;

    @GetMapping("/viewHomework/{id}")
    public ResponseEntity<?> getHomework(@PathVariable Long id) {
        HomeWork homeWork;
        try {
            homeWork = homeWorkRepo.findById(id).orElseThrow();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ResHomework resHomework = new ResHomework();
        resHomework.setId(homeWork.getId());
        resHomework.setTaskHomework(homeWork.getTaskHomework());
        resHomework.setDateTask(homeWork.getDateTask());
        resHomework.setDeadlineTask(homeWork.getDeadlineTask());
        return new ResponseEntity<>(resHomework, HttpStatus.OK);
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<?> getCourse(@PathVariable Long id) {
        Course course;
        try {
            course = courseRepo.findById(id).orElseThrow();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ResCourse resCourse = new ResCourse();
        resCourse.setId(course.getId());
        resCourse.setNameCourse(course.getNameCourse());
        resCourse.setDuration(course.getDuration());
        resCourse.setPrice(course.getPrice());
        return new ResponseEntity<>(resCourse, HttpStatus.OK);
    }

//    @GetMapping("/teacher/{id}")
//    public ResponseEntity<?> getTeacher(@PathVariable Long id) {
//        Teacher teacher;
//        try {
//            teacher = teacherRepo.findById(id).orElseThrow();
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        ResTeacher resTeacher = new ResTeacher();
//        resTeacher.setId(teacher.getId());
//        resTeacher.setFirstName(teacher.getFirstName());
//        resTeacher.setLastName(teacher.getLastName());
//        resTeacher.setPatronymic(teacher.getPatronymic());
//        resTeacher.setBirthday(teacher.getBirthday());
//        resTeacher.setExperience(teacher.getExperience());
//        resTeacher.setTelephone(teacher.getTelephone());
//        resTeacher.setEmail(teacher.getEmail());
//        return new ResponseEntity<>(resTeacher, HttpStatus.OK);
//    }

/*Из SOLID это D*/
    /*Доп для реализации: Для этого еще создали TeacherService TeacherServiceImpl. Суть в том, что в сервисе мы просто объявляем функция, а в сервисеИмплимент описываем саму функцию. */
    /*А для D: Сделать так, чтобы мы вызывали findTeacherId() не напрямую к бд(с помощью репозитория), а вызывали с помощью сервиса(для этого сделали манипуляции, описанные на строчку выше) */
/* : сделать так, чтобы контроллер не взаимодействоал с бд напрямую */
    @GetMapping("/teacher/{id}")
    public ResponseEntity<?> getTeacherAccount(@PathVariable Long id) {

        Teacher teacher;
        try {
            teacher = teacherService.findTeacherId(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ResTeacher resTeacher = new ResTeacher();
        resTeacher.setId(teacher.getId());
        resTeacher.setFirstName(teacher.getFirstName());
        resTeacher.setLastName(teacher.getLastName());
        resTeacher.setPatronymic(teacher.getPatronymic());
        resTeacher.setBirthday(teacher.getBirthday());
        resTeacher.setExperience(teacher.getExperience());
        resTeacher.setTelephone(teacher.getTelephone());
        resTeacher.setEmail(teacher.getEmail());
        return new ResponseEntity<>(resTeacher, HttpStatus.OK);
    }

    /*Конец D*/

    @PostMapping("/homework/add")
    public ResponseEntity<?> addDoc(@RequestBody HomeWork homeWork) {
        if (homeWork == null || homeWork.getTaskHomework() == null  || homeWork.getDateTask() == null  || homeWork.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        homeWork = homeWorkRepo.saveAndFlush(homeWork);
        ResHomework resHomework = new ResHomework(homeWork.getId(), homeWork.getTaskHomework(), homeWork.getDateTask(), homeWork.getDeadlineTask());
        return new ResponseEntity<>(resHomework, HttpStatus.OK);
    }

    @PostMapping("/course/add")
    public ResponseEntity<?> addCourse(@RequestBody Course course) {
        if (course == null || course.getNameCourse() == null || course.getPrice() == 0 || course.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        course = courseRepo.saveAndFlush(course);
        ResCourse resCourse = new ResCourse(course.getId(), course.getNameCourse(), course.getDuration(), course.getPrice());
        return new ResponseEntity<>(resCourse, HttpStatus.OK);
    }
}
