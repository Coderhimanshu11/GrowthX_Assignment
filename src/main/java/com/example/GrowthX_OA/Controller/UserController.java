package com.example.GrowthX_OA.Controller;

import com.example.GrowthX_OA.Entity.Assignment;
import com.example.GrowthX_OA.Entity.User;
import com.example.GrowthX_OA.Service.AssignmentService;
import com.example.GrowthX_OA.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.Assign;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AssignmentService assignmentService;

    @PostMapping("/registerUser")
    public User registeredUser(@RequestBody User user){
        return userService.registeredUser(user);
    }
    @PostMapping("/loginuser")
    public ResponseEntity<String> loginUser(@RequestParam String username, @RequestParam String password){
        boolean loginSuccessful = userService.userLogin(username, password);

        if (loginSuccessful) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
//    @PostMapping("/upload")
//    public Assignment uploadAssignment(@RequestBody Assignment assignment){
//        return assignmentService.

   // }
}
