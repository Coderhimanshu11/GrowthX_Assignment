package com.example.GrowthX_OA.Service;

import com.example.GrowthX_OA.Entity.Admin;
import com.example.GrowthX_OA.REpository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminRepo adminRepo;

    public Admin registeredAdmin(Admin admin){
        return adminRepo.save(admin);
    }
    public boolean loginAdmin(String username,String password){
        Admin admin=adminRepo.findByUsername(username);
        if (admin == null || admin.getPassword() == null) {

            System.out.println("Admin not found or password is null");
            return false;
        }
        return (admin.getPassword().equals(password));
    }
}
