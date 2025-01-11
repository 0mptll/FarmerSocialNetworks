package com.farmer.main.controllers;

import com.farmer.main.entities.CropResource;
import com.farmer.main.services.CropResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crop-resources")
public class CropResourceController {
    @Autowired
    private CropResourceService cropResourceService;

    @GetMapping
    public List<CropResource> getAllCropResources() {
        return cropResourceService.getAllCropResources();
    }

    @PostMapping
    public CropResource saveCropResource(@RequestBody CropResource cropResource) {
        return cropResourceService.saveCropResource(cropResource);
    }

    @GetMapping("/{id}")
    public CropResource getCropResourceById(@PathVariable Long id) {
        return cropResourceService.getCropResourceById(id);
    }

    @GetMapping("/category/{category}")
    public List<CropResource> getCropResourcesByCategory(@PathVariable CropResource.Season category) {
        return cropResourceService.getCropResourcesByCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCropResource(@PathVariable Long id) {
        cropResourceService.deleteCropResource(id);
    }
}
