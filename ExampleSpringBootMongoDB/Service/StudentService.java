package com.MongoDB.ExampleSpringBootMongoDB.Service;

import com.MongoDB.ExampleSpringBootMongoDB.Entities.Student;
import com.MongoDB.ExampleSpringBootMongoDB.Repository.StudentRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepoImpl studentRepo;


    public List<Student> performOperations(){
        return  studentRepo.findAllStudents();
    }
}
