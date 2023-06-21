package com.example.bai_tap_on_tap.service.picture;

import com.example.bai_tap_on_tap.model.Category;
import com.example.bai_tap_on_tap.model.Picture;
import com.example.bai_tap_on_tap.service.IGeneralService;

import java.util.List;
import java.util.Optional;

public interface IPictureService extends IGeneralService<Picture> {
    Iterable<Picture> findAllByPictureNameContainingIgnoreCase(String name);

    //    List<Picture> findByCategories(Long categoryId);
    List<Picture> findPictureByCategories(Category category);
}
