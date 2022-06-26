package com.company.task_1.service;

import com.company.task_1.dto.request.CompanyRequestDto;
import com.company.task_1.dto.response.DepartmentResponseDto;
import com.company.task_1.dto.response.CompanyResponseDto;
import com.company.task_1.entity.DepartmentEntity;
import com.company.task_1.entity.CompanyEntity;
import com.company.task_1.exp.ItemNotFoundException;
import com.company.task_1.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private CompanyRepository repository;

    public CompanyResponseDto create(CompanyRequestDto dto) {
        CompanyEntity entity = new CompanyEntity();
        entity.setAddress(dto.getAddress());
        entity.setDirectorName(dto.getDirectorName());
        entity.setCorpName(dto.getCorpName());
        repository.save(entity);
        return toResponseDTO(entity);
    }

    private CompanyResponseDto toResponseDTO(CompanyEntity entity) {
        CompanyResponseDto dto = new CompanyResponseDto();
        dto.setId(entity.getId());
        dto.setAddress(entity.getAddress());
        dto.setDirectorName(entity.getDirectorName());
        dto.setCorpName(entity.getCorpName());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }

    public CompanyResponseDto getById(String id) {
        CompanyEntity entity = repository.findById(id).orElseThrow(() -> {
            throw new ItemNotFoundException("Item not Found");
        });
        return toResponseDTO(entity);
    }

    public Boolean update(CompanyRequestDto dto, String id) {
        int n = repository.update(id, dto.getCorpName(), dto.getDirectorName(), dto.getAddress());
        return n > 0;
    }

    public Boolean delete(String id) {
        int n = repository.changeVisible(id, false);
        return n > 0;
    }

    public List<CompanyEntity> getAll() {
        return repository.findAll();
    }
}
