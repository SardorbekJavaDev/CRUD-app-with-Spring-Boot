package com.company.task_1.controller;

import com.company.task_1.dto.request.CompanyRequestDto;
import com.company.task_1.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService service;

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody CompanyRequestDto dto){
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody CompanyRequestDto dto, @PathVariable String id){
        return ResponseEntity.ok(service.update(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable String id){
        return ResponseEntity.ok(service.getById(id));
    }
}
