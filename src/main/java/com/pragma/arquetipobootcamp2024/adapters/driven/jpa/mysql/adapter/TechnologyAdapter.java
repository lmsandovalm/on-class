package com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.adapter;

import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.ElementNotFoundException;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.NoDataFoundException;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.TechnologyAlreadyExistsException;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.repository.ITechnologyRepository;
import com.pragma.arquetipobootcamp2024.configuration.Constants;
import com.pragma.arquetipobootcamp2024.domain.model.Technology;
import com.pragma.arquetipobootcamp2024.domain.spi.ITechnologyPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@RequiredArgsConstructor
public class TechnologyAdapter implements ITechnologyPersistencePort {
    private final ITechnologyRepository technologyRepository;
    private final ITechnologyEntityMapper technologyEntityMapper;

    @Override
    public void addTechnology(Technology technology) {
        if (technologyRepository.findByName(technology.getName()).isPresent()) {
            throw new TechnologyAlreadyExistsException();
        }
        technologyRepository.save(technologyEntityMapper.toEntity(technology));
    }

    @Override
    public Technology getTechnology(String name) {
        TechnologyEntity technology = technologyRepository.findByNameContaining(name).orElseThrow(ElementNotFoundException::new);
        return technologyEntityMapper.toModel(technology);
    }

    @Override
    public List<Technology> getAllTechnologies(Integer page, Integer size, String sortBy, String sortOrder) {
        Pageable pagination;
        if (sortOrder.equalsIgnoreCase("asc")) {
            pagination = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        } else {
            pagination = PageRequest.of(page, size, Sort.by(sortBy).descending());
        }
        Page<TechnologyEntity> technologiesPage = technologyRepository.findAll(pagination);
        if (technologiesPage.isEmpty()) {
            throw new NoDataFoundException();
        }
        return technologyEntityMapper.toModelList(technologiesPage.getContent());
    }

    @Override
    public Technology updateTechnology(Technology technology) {
        if (technologyRepository.findById(technology.getId()).isEmpty()) {
            throw new ElementNotFoundException();
        }
        return technologyEntityMapper.toModel(technologyRepository.save(technologyEntityMapper.toEntity(technology)));
    }

    @Override
    public void deleteTechnology(Long id) {
        if (technologyRepository.findById(id).isEmpty()) {
            throw new ElementNotFoundException();
        }
        technologyRepository.deleteById(id);
    }
}
