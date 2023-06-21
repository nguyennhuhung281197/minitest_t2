package com.example.bai_tap_on_tap.service.category;

import com.example.bai_tap_on_tap.model.Category;
import com.example.bai_tap_on_tap.model.Picture;
import com.example.bai_tap_on_tap.service.IGeneralService;

public interface ICategoryService extends IGeneralService<Category> {
    Iterable<Category> findAllByCategoryNameEqualsIgnoreCase(String name);
}
