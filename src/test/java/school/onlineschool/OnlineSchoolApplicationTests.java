package school.onlineschool;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import school.onlineschool.models.*;
import school.onlineschool.repository.UserRepo;
import school.onlineschool.service.*;

import java.util.Collections;
import java.util.Set;


@SpringBootTest
class OnlineSchoolApplicationTests {

    @Autowired
    private CourseService courseService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TeacherServiceC teacherServiceC;

    @Autowired
    private PositionService positionService;

    @Autowired
    private UserService userService;



    @Test
    void CreateCourse(){
        Course course = new Course("HTML/CSS2", 3, 1500);

        course = courseService.add(course);

        Assertions.assertNotNull(course);

        Assertions.assertEquals(course.getId(), courseService.find(course.getId()).getId());
    }

    @Test
    void UpdateCourse() {
        Course course = courseService.findAll().get(0);
        String newNameCourse = "NewName2";

        Assertions.assertNotNull(course);

        course.setNameCourse(newNameCourse);

        course = courseService.update(course);

        Assertions.assertNotNull(course);

        Assertions.assertEquals(course.getNameCourse(), newNameCourse);
    }

    @Test
    void UpdateTeacherPosition() {
        Teacher teacher = teacherServiceC.findAll().get(0);
        Position newPosition = positionService.findAll().get(0);

        Assertions.assertNotNull(teacher);
        teacher.setPosition(newPosition);

        teacher = teacherServiceC.update(teacher);
        Assertions.assertNotNull(teacher);

        Assertions.assertEquals(teacher.getPosition().getId(), newPosition.getId());
    }

    @Test
    void ChangeRole() {
        Set<Role> newRole = Collections.singleton(Role.STUDENT);

        User user = userService.findAll().get(0);

        Assertions.assertNotNull(user);

        user.setRoles(newRole);

        user = userService.update(user);

        Assertions.assertNotNull(user);

        Assertions.assertEquals(user.getRoles(), newRole);
    }



//    @Autowired
//	private UserRepo userRepo;

    /*

     * This test need for check user in Database and use in addUser(registration user).
     * 	Note! Two person don't have equals username!
     *
     * 	If user will be in Database, so Test return result - failed. (because: Two person don't have equals username!)
     * 	And
     * 	If we don't find user in Database, so Test return result - passed.
     *
     */

    @Test
    void contextLoads() {

//        User user = new User("userLogin");
//		User userFromDb = userRepo.findByUsername(user.getUsername());
//
//		assertsEquals(user, userFromDb);

    }

//	private String assertsEquals(User user, User userFromDb) {
//		if(user.equals(userFromDb)){
//			fail("User already exists!");
//			return "User already exists!";
//		}
//		else{
//			return "This is a new user! Good!";
//		}
//
//	}

}
