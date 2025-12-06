package com.example.realestate.controller;

import com.example.realestate.dto.BuyerDto;
import com.example.realestate.service.BuyerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buyers")
@RequiredArgsConstructor
public class BuyerController {

    private final BuyerService buyerService;

    @PostMapping
    public ResponseEntity<BuyerDto> createBuyer(@Validated @RequestBody BuyerDto dto) {
        return new ResponseEntity<>(buyerService.createBuyer(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuyerDto> getBuyer(@PathVariable Long id) {
        return ResponseEntity.ok(buyerService.getBuyer(id));
    }

    @GetMapping
    public ResponseEntity<List<BuyerDto>> getAllBuyers() {
        return ResponseEntity.ok(buyerService.getAllBuyers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BuyerDto> updateBuyer(@PathVariable Long id, @Validated @RequestBody BuyerDto dto) {
        return ResponseEntity.ok(buyerService.updateBuyer(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuyer(@PathVariable Long id) {
        buyerService.deleteBuyer(id);
        return ResponseEntity.noContent().build();
    }
}
