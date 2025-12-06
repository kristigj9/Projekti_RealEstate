package com.example.realestate.service;

import com.example.realestate.dto.ImageDto;

import java.util.List;

public interface ImageService {

    ImageDto uploadImage(ImageDto dto);

    ImageDto getImageById(Long id);

    List<ImageDto> getAllImages();

    ImageDto updateImage(Long id, ImageDto dto);

    void deleteImage(Long id);
}
