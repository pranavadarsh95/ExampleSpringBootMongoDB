package com.MongoDB.ExampleSpringBootMongoDB.Controller;

import com.MongoDB.ExampleSpringBootMongoDB.Entities.Student;
import com.MongoDB.ExampleSpringBootMongoDB.Repository.StudentRepo;
import com.MongoDB.ExampleSpringBootMongoDB.Repository.StudentRepoImpl;
import com.MongoDB.ExampleSpringBootMongoDB.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mongoDB")
public class MongoController {

   @Autowired
   StudentRepoImpl studentRepo;
//    @Autowired
//    StudentService studentService;

    @RequestMapping(value = "/Ping", method = RequestMethod.GET)
    public String check() {
        return "CALLED BY MongoController check method";
    }

    //   Save Student
    @RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
    public String saveStudent(@RequestBody Student student) {
        studentRepo.saveStudent(student);

        return "Added Student with EmailId "+student.getEmailId();
    }

    @RequestMapping(value = "/getAllStudents", method = RequestMethod.GET)
    public List<Student> fetchAllStudent() {

       return studentRepo.findAllStudents();

    }

    //   Update Student
    @RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
    public String updateStudent(@RequestBody Student student) {

        Student student1 = studentRepo.findStudentByEmailId(student.getEmailId());
        student1.setRollNumber(student.getRollNumber());
        studentRepo.saveStudent(student1);

        return "Student Updated with RollNo "+student.getRollNumber();
    }

}
