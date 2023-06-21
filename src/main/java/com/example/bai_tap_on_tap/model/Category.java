package com.example.bai_tap_on_tap.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;


@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;
    @JsonIgnore
    @ManyToMany(mappedBy = "categories")
    private List<Picture> pictures;

    public Category() {
    }

    public Category(Long id, String categoryName, List<Picture> pictures) {
        this.id = id;
        this.categoryName = categoryName;
        this.pictures = pictures;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> picture) {
        this.pictures = picture;
    }
}
