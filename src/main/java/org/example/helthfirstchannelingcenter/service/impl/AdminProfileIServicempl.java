//package com.medicalchannelingcenter.service.impl;
//
//import com.medicalchannelingcenter.dto.AdminDTO;
//import com.medicalchannelingcenter.model.Admin;
//import com.medicalchannelingcenter.repository.AdminRepository;
//import com.medicalchannelingcenter.service.AdminService;
//import lombok.RequiredArgsConstructor;
//import org.example.helthfirstchannelingcenter.service.AdminProfileService;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class AdminProfileIServicempl implements AdminProfileService {
//
//    private final com.medicalchannelingcenter.repository.AdminProfileRepository adminRepository;
//
//    @Override
//    public AdminDTO getAdminProfile(Long adminId) {
//        Admin admin = adminRepository.findById(adminId)
//                .orElseThrow(() -> new RuntimeException("Admin not found"));
//
//        return mapToDTO(admin);
//    }
//
//    @Override
//    public AdminDTO updateAdminProfile(Long adminId, AdminDTO adminDTO) {
//        Admin admin = adminRepository.findById(adminId)
//                .orElseThrow(() -> new RuntimeException("Admin not found"));
//
//        admin.setFullName(adminDTO.getFullName());
//        admin.setEmail(adminDTO.getEmail());
//        admin.setProfileImageUrl(adminDTO.getProfileImageUrl());
//
//        Admin updated = adminRepository.save(admin);
//        return mapToDTO(updated);
//    }
//
//    private AdminDTO mapToDTO(Admin admin) {
//        return AdminDTO.builder()
//                .id(admin.getId())
//                .fullName(admin.getFullName())
//                .email(admin.getEmail())
//                .profileImageUrl(admin.getProfileImageUrl())
//                .build();
//    }
//}
