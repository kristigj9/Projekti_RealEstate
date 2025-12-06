package com.example.realestate.controller;

import com.example.realestate.dto.AppointmentDto;
import com.example.realestate.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    // CREATE
    @PostMapping
    public ResponseEntity<AppointmentDto> create(@Validated @RequestBody AppointmentDto dto) {
        AppointmentDto created = appointmentService.create(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDto> get(@PathVariable Long id) {
        AppointmentDto dto = appointmentService.get(id);
        return ResponseEntity.ok(dto);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<AppointmentDto>> getAll() {
        List<AppointmentDto> list = appointmentService.getAll();
        return ResponseEntity.ok(list);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDto> update(@PathVariable Long id, @Validated @RequestBody AppointmentDto dto) {
        AppointmentDto updated = appointmentService.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        appointmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
