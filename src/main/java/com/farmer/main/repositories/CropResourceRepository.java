package com.farmer.main.repositories;

import com.farmer.main.entities.CropResource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CropResourceRepository extends JpaRepository<CropResource, Long> {
    List<CropResource> findByCategory(CropResource.Season category);
}