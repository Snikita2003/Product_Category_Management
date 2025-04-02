package com.prod.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.prod.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {

}
