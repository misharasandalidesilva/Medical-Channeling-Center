//package org.example.helthfirstchannelingcenter.controller;
//
//import com.helthfirstchannelingcenter.dto.AdminDTO;
//import com.h.service.AdminService;
//import org.example.helthfirstchannelingcenter.dto.AdminProfileDTO;
//import org.example.helthfirstchannelingcenter.service.AdminProfileService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.UUID;

//@RestController
//@RequestMapping("/api/admin")
//@CrossOrigin(origins = "*") // Allow frontend access
//public class AdminController {
//
//    @Autowired
//    private AdminProfileService adminProfileService;
//
//    // GET admin profile by ID
//    @GetMapping("/profile/{id}")
//    public AdminProfileDTO getAdminProfile(@PathVariable UUID id) {
//        return adminProfileService.getAdminProfile(id);
//    }
//
//    // UPDATE admin profile
//    @PutMapping("/profile/{id}")
//    public AdminProfileDTO updateAdminProfile(@PathVariable UUID id, @RequestBody AdminProfileDTO dto) {
//        return adminProfileService.updateAdminProfile(id, dto);
//    }
//}
