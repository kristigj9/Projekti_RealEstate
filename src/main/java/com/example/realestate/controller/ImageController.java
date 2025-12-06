package com.example.realestate.controller;

import com.example.realestate.dto.ImageDto;
import com.example.realestate.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @PostMapping
    public ResponseEntity<ImageDto> createImage(@Validated @RequestBody ImageDto dto) {
        return new ResponseEntity<>(imageService.uploadImage(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageDto> getImage(@PathVariable Long id) {
        return ResponseEntity.ok(imageService.getImageById(id));
    }

    @GetMapping
    public ResponseEntity<List<ImageDto>> getAllImages() {
        return ResponseEntity.ok(imageService.getAllImages());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImageDto> updateImage(@PathVariable Long id, @Validated @RequestBody ImageDto dto) {
        return ResponseEntity.ok(imageService.updateImage(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        imageService.deleteImage(id);
        return ResponseEntity.noContent().build();
    }
}
