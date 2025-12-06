package com.example.realestate.service;

import com.example.realestate.dto.AdminDto;
import com.example.realestate.mapper.AdminMapper;
import com.example.realestate.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminServiceImpl implements AdminService {

    private final AdminRepository repo;
    private final AdminMapper mapper;

    @Override
    public AdminDto createAdmin(AdminDto dto) {
        var entity = mapper.toEntity(dto);
        return mapper.toDto(repo.save(entity));
    }

    @Override
    public AdminDto getAdmin(Long id) {
        var admin = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        return mapper.toDto(admin);
    }

    @Override
    public List<AdminDto> getAllAdmins() {
        return repo.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public AdminDto updateAdmin(Long id, AdminDto dto) {
        var admin = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        mapper.updateEntity(admin, dto);
        return mapper.toDto(repo.save(admin));
    }

    @Override
    public void deleteAdmin(Long id) {
        repo.deleteById(id);
    }
}
