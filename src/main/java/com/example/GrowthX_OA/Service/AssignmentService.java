package com.example.GrowthX_OA.Service;

import com.example.GrowthX_OA.Entity.Admin;
import com.example.GrowthX_OA.Entity.Assignment;
import com.example.GrowthX_OA.REpository.AdminRepo;
import com.example.GrowthX_OA.REpository.AssignmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService {

    @Autowired
    AssignmentRepo assignmentRepo;

    public Assignment uploadAssignment(Assignment assignment){
        return assignmentRepo.save(assignment);
    }
    public List<Assignment> getAssignmentByAdmin(String admin){
        return assignmentRepo.findByAdmin(admin);
    }
    public Assignment updateAssignmentStatus(String id, String status) {
        Assignment assignment = assignmentRepo.findById(id).orElse(null);
        if (assignment != null) {
            assignment.setStatus(status);
            assignmentRepo.save(assignment);
        }
        return assignment;
    }



}
