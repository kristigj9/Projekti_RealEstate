package com.example.realestate.service;

import com.example.realestate.dto.AdminDto;
import java.util.List;

public interface AdminService {

    AdminDto createAdmin(AdminDto dto);

    AdminDto getAdmin(Long id);

    List<AdminDto> getAllAdmins();

    AdminDto updateAdmin(Long id, AdminDto dto);

    void deleteAdmin(Long id);
}
