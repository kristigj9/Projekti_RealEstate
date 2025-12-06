package com.example.realestate.controller;

import com.example.realestate.dto.OwnerDto;
import com.example.realestate.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerService ownerService;

    @PostMapping
    public ResponseEntity<OwnerDto> createOwner(@Validated @RequestBody OwnerDto dto) {
        return new ResponseEntity<>(ownerService.createOwner(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OwnerDto> getOwner(@PathVariable Long id) {
        return ResponseEntity.ok(ownerService.getOwnerById(id));
    }

    @GetMapping
    public ResponseEntity<List<OwnerDto>> getAllOwners() {
        return ResponseEntity.ok(ownerService.getAllOwners());
    }

    @PutMapping("/{id}")
    public ResponseEntity<OwnerDto> updateOwner(@PathVariable Long id, @Validated @RequestBody OwnerDto dto) {
        return ResponseEntity.ok(ownerService.updateOwner(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable Long id) {
        ownerService.deleteOwner(id);
        return ResponseEntity.noContent().build();
    }
}
