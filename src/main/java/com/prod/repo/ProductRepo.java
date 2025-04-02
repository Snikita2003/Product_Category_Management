package com.prod.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.prod.entity.Product;


@Repository
public interface ProductRepo extends JpaRepository<Product, Long > {

	public List<Product> findByCategoryId(Long id);
	
}
