package com.example.GrowthX_OA.REpository;

import com.example.GrowthX_OA.Entity.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends MongoRepository<Admin,String > {
    Admin findByUsername(String username);
}
