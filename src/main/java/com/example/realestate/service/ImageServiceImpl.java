package com.example.realestate.service;

import com.example.realestate.dto.ImageDto;
import com.example.realestate.mapper.ImageMapper;
import com.example.realestate.model.Image;
import com.example.realestate.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;
    private final ImageMapper imageMapper;

    // POST /api/images
    @Override
    public ImageDto uploadImage(ImageDto dto) {
        Image image = imageMapper.toEntity(dto);
        Image saved = imageRepository.save(image);
        return imageMapper.toDto(saved);
    }

    // GET /api/images/{id}
    @Override
    public ImageDto getImageById(Long id) {
        Image image = imageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Image not found with id: " + id));
        return imageMapper.toDto(image);
    }

    // GET /api/images
    @Override
    public List<ImageDto> getAllImages() {
        return imageRepository.findAll()
                .stream()
                .map(imageMapper::toDto)
                .collect(Collectors.toList());
    }

    // PUT /api/images/{id}
    @Override
    public ImageDto updateImage(Long id, ImageDto dto) {
        Image existing = imageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Image not found with id: " + id));
        imageMapper.updateFromDto(dto, existing);
        Image updated = imageRepository.save(existing);
        return imageMapper.toDto(updated);
    }

    // DELETE /api/images/{id}
    @Override
    public void deleteImage(Long id) {
        if (!imageRepository.existsById(id)) {
            throw new RuntimeException("Image not found with id: " + id);
        }
        imageRepository.deleteById(id);
    }
}
