package com.example.bai_tap_on_tap.controller;

import com.example.bai_tap_on_tap.model.Category;
import com.example.bai_tap_on_tap.model.Picture;
import com.example.bai_tap_on_tap.repository.ICategoryRepository;
import com.example.bai_tap_on_tap.repository.IPictureRepository;
import com.example.bai_tap_on_tap.service.category.ICategoryService;
import com.example.bai_tap_on_tap.service.picture.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/picture")
public class PictureController {

    @Autowired
    IPictureService iPictureService;
    @Autowired
    ICategoryService iCategoryService;


    @PostMapping
    public ResponseEntity<Picture> create(@RequestBody Picture picture) {
        return new ResponseEntity<>(iPictureService.save(picture), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Picture>> showAll() {
        Iterable<Picture> pictures = iPictureService.findAll();
        return new ResponseEntity<>(pictures, HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Picture> ById(@PathVariable Long id) {
//        Optional<Picture> picture = iPictureService.findById(id);
//        if (picture.isPresent()) {
//            return new ResponseEntity<>(picture.get(), HttpStatus.OK);
//
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<Picture>> search(@RequestParam("name") String name) {
        return ResponseEntity.ok(iPictureService.findAllByPictureNameContainingIgnoreCase(name));
    }

    @GetMapping("/{id}")
    public Iterable<Picture> searchCategory(@PathVariable Long id){
       Category categoryOptional = iCategoryService.findById(id).orElse(null);
          Iterable<Picture> pictures = iPictureService.findPictureByCategories(categoryOptional);
          return new ResponseEntity<>(pictures,HttpStatus.OK).getBody();
    }
}
