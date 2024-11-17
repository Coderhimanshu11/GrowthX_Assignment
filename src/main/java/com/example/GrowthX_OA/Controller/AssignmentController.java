package com.example.GrowthX_OA.Controller;

import com.example.GrowthX_OA.Entity.Assignment;
import com.example.GrowthX_OA.Service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignment")
public class AssignmentController {
    @Autowired
    AssignmentService assignmentService;

    @PostMapping("/addAssignment")
    public Assignment addAssignment(@RequestBody Assignment assignment){
        return assignmentService.uploadAssignment(assignment);
    }


//    @PostMapping("/assignments/{id}/accepted")
//    public Assignment acceptedAssignment(@PathVariable String id){
//
//    }
}
