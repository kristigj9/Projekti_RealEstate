package com.example.realestate.controller;

import com.example.realestate.dto.PropertyRequestDto;
import com.example.realestate.service.PropertyRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/property-requests")
@RequiredArgsConstructor
public class PropertyRequestController {

    private final PropertyRequestService propertyRequestService;

    // CREATE
    @PostMapping
    public ResponseEntity<PropertyRequestDto> createRequest(
            @Validated @RequestBody PropertyRequestDto dto) {
        PropertyRequestDto created = propertyRequestService.createRequest(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<PropertyRequestDto> getRequest(@PathVariable Long id) {
        PropertyRequestDto dto = propertyRequestService.getRequest(id);
        return ResponseEntity.ok(dto);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<PropertyRequestDto>> getAllRequests() {
        List<PropertyRequestDto> list = propertyRequestService.getAllRequests();
        return ResponseEntity.ok(list);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<PropertyRequestDto> updateRequest(
            @PathVariable Long id,
            @Validated @RequestBody PropertyRequestDto dto) {
        PropertyRequestDto updated = propertyRequestService.updateRequest(id, dto);
        return ResponseEntity.ok(updated);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) {
        propertyRequestService.deleteRequest(id);
        return ResponseEntity.noContent().build();
    }
}
