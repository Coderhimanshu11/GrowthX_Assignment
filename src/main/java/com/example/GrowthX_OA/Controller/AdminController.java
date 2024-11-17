package com.example.GrowthX_OA.Controller;

import com.example.GrowthX_OA.Entity.Admin;
import com.example.GrowthX_OA.Entity.Assignment;
import com.example.GrowthX_OA.Service.AdminService;
import com.example.GrowthX_OA.Service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @Autowired
    AssignmentService assignmentService;

    @PostMapping("/registerAdmin")
    public Admin registeredAdmin(@RequestBody Admin admin){
        return adminService.registeredAdmin(admin);
    }
    @PostMapping("/loginAdmin")
    public ResponseEntity<String> loginAdmin(@RequestParam String username,@RequestParam String password){
        boolean loginSuccessful = adminService.loginAdmin(username, password);

        if (loginSuccessful) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid admin or password");
        }
    }
    @GetMapping("/assignment")
    public List<Assignment> getAssignmentByAdmin(@RequestParam String admin){
        return assignmentService.getAssignmentByAdmin(admin);

    }
    @PostMapping("/assignments/{id}/accept")
    public Assignment acceptAssignment(@PathVariable String id) {
        return assignmentService.updateAssignmentStatus(id, "ACCEPTED");
    }

    @PostMapping("/assignments/{id}/reject")
    public Assignment rejectAssignment(@PathVariable String id) {
        return assignmentService.updateAssignmentStatus(id, "REJECTED");
    }
}
