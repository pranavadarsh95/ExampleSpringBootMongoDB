package com.MongoDB.ExampleSpringBootMongoDB.Repository;

import com.MongoDB.ExampleSpringBootMongoDB.Entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public class StudentRepoImpl {

    @Autowired
    StudentRepo studentRepo;

    public void saveStudent(Student student) {

        studentRepo.save(student);
    }



    public List<Student> findAllStudents() {

        return studentRepo.findAll();
    }


    public Student findStudentByEmailId(String emailid) {

        return studentRepo.findByEmailId(emailid);
    }


    public Student findStudentById(Long id) {

        return studentRepo.findById(id).get();
    }



    public void deleteStudentById(Long id) {

        studentRepo.deleteById(id);

    }

    public void deleteAllStudents() {

        studentRepo.deleteAll();

    }
}
