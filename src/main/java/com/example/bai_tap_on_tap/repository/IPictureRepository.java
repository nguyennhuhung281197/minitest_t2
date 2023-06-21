package com.example.bai_tap_on_tap.repository;

import com.example.bai_tap_on_tap.model.Category;
import com.example.bai_tap_on_tap.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPictureRepository extends JpaRepository<Picture , Long>{
    Iterable<Picture> findAllByPictureNameContainingIgnoreCase(String name);
//    @Query("SELECT p FROM Picture p " +
//            "JOIN painting_category pc ON pc.pictureId = p.id " +
//            "JOIN Category c ON pc.categoryId = c.id " +
//            "WHERE c.categoryName = ?")
//    List<Picture> getPicturesByCategoryName(String name);

   List<Picture> findPictureByCategories(Category category);




}
