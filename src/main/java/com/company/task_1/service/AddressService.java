package com.company.task_1.service;

import com.company.task_1.dto.request.AddressRequestDto;
import com.company.task_1.dto.response.DepartmentResponseDto;
import com.company.task_1.dto.response.AddressResponseDto;
import com.company.task_1.entity.DepartmentEntity;
import com.company.task_1.entity.AddressEntity;
import com.company.task_1.exp.ItemNotFoundException;
import com.company.task_1.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private AddressRepository repository;

    public AddressResponseDto create(AddressRequestDto dto) {
        AddressEntity entity = new AddressEntity();
        entity.setStreet(dto.getStreet());
        entity.setHomeNumber(dto.getHomeNumber());
        repository.save(entity);
        return toResponseDTO(entity);
    }

    private AddressResponseDto toResponseDTO(AddressEntity entity) {
        AddressResponseDto dto = new AddressResponseDto();
        dto.setId(entity.getId());
        dto.setStreet(entity.getStreet());
        dto.setHomeNumber(entity.getHomeNumber());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }

    public AddressResponseDto getById(String id) {
        AddressEntity entity = repository.findById(id).orElseThrow(() -> {
            throw new ItemNotFoundException("Item not Found");
        });
        return toResponseDTO(entity);
    }

    public Boolean update(AddressRequestDto dto, String id) {
        int n = repository.update(id, dto.getStreet(), dto.getHomeNumber());
        return n > 0;
    }

    public Boolean delete(String id) {
        int n = repository.changeVisible(id, false);
        return n > 0;
    }

    public List<AddressEntity> getAll() {
        return repository.findAll();
    }
}
