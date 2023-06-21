package com.example.bai_tap_on_tap.controller;

import com.example.bai_tap_on_tap.model.Category;
import com.example.bai_tap_on_tap.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ICategoryService iCategoryService;


    @GetMapping
    public ResponseEntity<Iterable<Category>> showAll() {
        Iterable<Category> categories = iCategoryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }


//    @GetMapping("/search")
//    public ResponseEntity<Iterable<Category>> searchCategory(@RequestParam("name") String name){
//        Iterable<Category> categoryIterable = iCategoryService.findAllByCategoryNameEqualsIgnoreCase(name);
//       return new ResponseEntity<>(categoryIterable,HttpStatus.OK);
//
//    }
}
