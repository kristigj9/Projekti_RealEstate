package com.example.realestate.controller;

import com.example.realestate.dto.AdminDto;
import com.example.realestate.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping
    public ResponseEntity<AdminDto> createAdmin(@Validated @RequestBody AdminDto dto) {
        return new ResponseEntity<>(adminService.createAdmin(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminDto> getAdmin(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.getAdmin(id));
    }

    @GetMapping
    public ResponseEntity<List<AdminDto>> getAllAdmins() {
        return ResponseEntity.ok(adminService.getAllAdmins());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdminDto> updateAdmin(@PathVariable Long id, @Validated @RequestBody AdminDto dto) {
        return ResponseEntity.ok(adminService.updateAdmin(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }
}
