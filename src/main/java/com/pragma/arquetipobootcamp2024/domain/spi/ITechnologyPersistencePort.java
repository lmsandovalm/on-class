package com.pragma.arquetipobootcamp2024.domain.spi;

import com.pragma.arquetipobootcamp2024.domain.model.Technology;

import java.util.List;

public interface ITechnologyPersistencePort {
    void addTechnology(Technology technology);
    Technology getTechnology(String name);
    List<Technology> getAllTechnologies(Integer page, Integer size, String sortBy, String sortOrder);
    Technology updateTechnology(Technology technology);
    void deleteTechnology(Long id);
}
