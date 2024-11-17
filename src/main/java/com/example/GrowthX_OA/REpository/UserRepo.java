package com.example.GrowthX_OA.REpository;

import com.example.GrowthX_OA.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface UserRepo extends MongoRepository<User,String> {
    User findByUsername(String username);
}
