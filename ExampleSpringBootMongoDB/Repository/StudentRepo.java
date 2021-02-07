package com.MongoDB.ExampleSpringBootMongoDB.Repository;

import com.MongoDB.ExampleSpringBootMongoDB.Entities.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends MongoRepository<Student,Long> {

    @Query("{ 'emailId' : ?0 }")
    Student findByEmailId(String emailId);
}
