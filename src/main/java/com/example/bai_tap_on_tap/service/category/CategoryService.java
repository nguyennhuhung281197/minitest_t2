package com.example.bai_tap_on_tap.service.category;

import com.example.bai_tap_on_tap.model.Category;
import com.example.bai_tap_on_tap.model.Picture;
import com.example.bai_tap_on_tap.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    ICategoryRepository iCategoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return iCategoryRepository.findById(id);
    }

    @Override
    public Category save(Category category) {
        return iCategoryRepository.save(category);
    }

    @Override
    public void remove(Long id) {
        iCategoryRepository.deleteById(id);
    }



    @Override
    public Iterable<Category> findAllByCategoryNameEqualsIgnoreCase(String name) {
        Iterable<Category> categoryIterable = iCategoryRepository.findAllByCategoryNameEqualsIgnoreCase(name);
        return categoryIterable;
    }
}
