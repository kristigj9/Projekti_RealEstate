package com.example.realestate.controller;

import com.example.realestate.dto.PropertyDto;
import com.example.realestate.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
@RequiredArgsConstructor
public class PropertyController {

    private final PropertyService propertyService;

    // CREATE
    @PostMapping
    public ResponseEntity<PropertyDto> createProperty(
            @Validated @RequestBody PropertyDto dto) {
        PropertyDto created = propertyService.createProperty(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<PropertyDto> getProperty(@PathVariable Long id) {
        PropertyDto dto = propertyService.getPropertyById(id);
        return ResponseEntity.ok(dto);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<PropertyDto>> getAllProperties() {
        List<PropertyDto> list = propertyService.getAllProperties();
        return ResponseEntity.ok(list);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<PropertyDto> updateProperty(
            @PathVariable Long id,
            @Validated @RequestBody PropertyDto dto) {
        PropertyDto updated = propertyService.updateProperty(id, dto);
        return ResponseEntity.ok(updated);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long id) {
        propertyService.deleteProperty(id);
        return ResponseEntity.noContent().build();
    }
}
