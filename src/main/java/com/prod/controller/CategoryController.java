package com.prod.controller;

import com.prod.entity.Category;
import com.prod.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    
    // 1️⃣ Get all categories with pagination
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(
            @RequestParam(name="page",defaultValue = "0") int page)
    {
        List<Category> categories = categoryService.getAllCategories(page, 10);
        return ResponseEntity.ok(categories);
    }
    

    // 2️ Get category by ID
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);

    }
    
    

    
    
    // 3️ Create a new category
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category createdCategory = categoryService.createCategory(category);
        return ResponseEntity.ok(createdCategory);
    }

    // 4️ Update category by ID
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(
            @PathVariable Long id, 
            @RequestBody Category updatedCategory) {
        Category category = categoryService.updateCategory(id, updatedCategory);
        return ResponseEntity.ok(category);
    }

    // 5️ Delete category by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Long id) {
        Category deletedCategory = this.categoryService.deleteCategory(id) ;
        return ResponseEntity.ok(deletedCategory);
    }
} 










