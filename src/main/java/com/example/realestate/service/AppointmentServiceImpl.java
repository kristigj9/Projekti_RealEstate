package com.example.realestate.service;
import com.example.realestate.dto.AppointmentDto;
import com.example.realestate.mapper.AppointmentMapper;
import com.example.realestate.model.Appointment;
import com.example.realestate.repository.AppointmentRepository;
import com.example.realestate.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository repo;
    private final AppointmentMapper mapper;

    @Override
    public AppointmentDto create(AppointmentDto dto) {
        Appointment entity = mapper.toEntity(dto);
        return mapper.toDto(repo.save(entity));
    }

    @Override
    public AppointmentDto get(Long id) {
        return repo.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    @Override
    public List<AppointmentDto> getAll() {
        return repo.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public AppointmentDto update(Long id, AppointmentDto dto) {
        Appointment appointment = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        mapper.updateFromDto(appointment, dto);

        return mapper.toDto(repo.save(appointment));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
