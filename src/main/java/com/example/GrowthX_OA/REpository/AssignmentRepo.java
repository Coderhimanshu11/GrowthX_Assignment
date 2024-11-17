package com.example.GrowthX_OA.REpository;

import com.example.GrowthX_OA.Entity.Assignment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AssignmentRepo extends MongoRepository<Assignment,String> {
    @Query("{ 'admin' : ?0 }")
    List<Assignment> findByAdmin(String admin);
}
