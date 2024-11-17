package com.example.GrowthX_OA.Service;

import com.example.GrowthX_OA.Entity.User;
import com.example.GrowthX_OA.REpository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

public User registeredUser(User user){
   return userRepo.save(user);

}
public boolean userLogin(String username,String password){
    User user=userRepo.findByUsername(username);
    if (user == null || user.getPassword() == null) {

        System.out.println("User not found or password is null");
        return false;
    }
    return (user.getPassword().equals(password));
}
}
