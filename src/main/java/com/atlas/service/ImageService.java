package com.atlas.service;

import com.atlas.repository.ImageRepository;
import com.atlas.models.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    private ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Image getIamgeById(long id) {
         Optional<Image> image = imageRepository.findById(id);
         if (image.isPresent()) {
              return image.get();
         } else {
              throw new RuntimeException("Image not found");
         }
     }



    public List<Image> getAllImages() {
            return imageRepository.findAll();
    }

    public Image addImage(Image image) {
            return imageRepository.save(image);
    }

    public Image updateImage(Image image) {
            return imageRepository.save(image);
    }

    public void deleteImage(long id) {
            imageRepository.deleteById(id);
    }
}



   