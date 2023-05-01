package com.atlas.service;

import com.atlas.models.Image;
import com.atlas.repository.ImageRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public ImageService() {
    }

    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    public Image getImageById(long id) {
        return imageRepository.findById(id).get();
    }

    @Transactional
    public Image addImage(Image image) {
        return imageRepository.save(image);
    }

    @Transactional
    public Image updateImage(Image image) {
        return imageRepository.save(image);
    }

    @Transactional
    public void deleteImage(long id) {
        imageRepository.deleteById(id);
    }

    public boolean isPresent(long id) {
        return imageRepository.existsById(id);
    }




}
