package com.example.bai_tap_on_tap.service.picture;

import com.example.bai_tap_on_tap.model.Category;
import com.example.bai_tap_on_tap.model.Picture;
import com.example.bai_tap_on_tap.repository.ICategoryRepository;
import com.example.bai_tap_on_tap.repository.IPictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PictureService implements IPictureService {
    @Autowired
    IPictureRepository iPictureRepository;

    @Autowired
    ICategoryRepository iCategoryRepository;

    @Override
    public Iterable<Picture> findAll() {
        return iPictureRepository.findAll();
    }

    @Override
    public Optional<Picture> findById(Long id) {
        return iPictureRepository.findById(id);
    }

    @Override
    public Picture save(Picture picture) {
        return iPictureRepository.save(picture);
    }

    @Override
    public void remove(Long id) {
        iPictureRepository.deleteById(id);
    }

    @Override
    public Iterable<Picture> findAllByPictureNameContainingIgnoreCase(String name) {
        List<Picture> pictureList = (List<Picture>) iPictureRepository.findAllByPictureNameContainingIgnoreCase(name);
        return pictureList;
    }

    @Override
    public List<Picture> findPictureByCategories(Category category) {
       return iPictureRepository.findPictureByCategories(category);
    }


//    @Override
//    public List<Picture> findByCategories(Long categoryId) {
//        Category category = iCategoryRepository.findById(categoryId).orElse(null);
//        return iPictureRepository.findByCategories(category);
//    }


}
