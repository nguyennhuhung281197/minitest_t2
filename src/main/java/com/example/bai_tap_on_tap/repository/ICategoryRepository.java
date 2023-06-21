package com.example.bai_tap_on_tap.repository;

import com.example.bai_tap_on_tap.model.Category;
import com.example.bai_tap_on_tap.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category , Long>{
Iterable<Category> findAllByCategoryNameEqualsIgnoreCase(String name);


}
