package com.farmer.main.services;

import com.farmer.main.entities.CropResource;
import com.farmer.main.repositories.CropResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CropResourceService {
    @Autowired
    private CropResourceRepository cropResourceRepository;

    public List<CropResource> getAllCropResources() {
        return cropResourceRepository.findAll();
    }

    public CropResource saveCropResource(CropResource cropResource) {
        return cropResourceRepository.save(cropResource);
    }

    public CropResource getCropResourceById(Long id) {
        return cropResourceRepository.findById(id).orElse(null);
    }

    public List<CropResource> getCropResourcesByCategory(CropResource.Season category) {
        return cropResourceRepository.findByCategory(category);
    }

    public void deleteCropResource(Long id) {
        cropResourceRepository.deleteById(id);
    }
}
