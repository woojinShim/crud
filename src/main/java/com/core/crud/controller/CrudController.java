package com.core.crud.controller;

import com.core.crud.dto.CrudRequestDto;
import com.core.crud.model.Crud;
import com.core.crud.repository.CrudRepository;
import com.core.crud.service.CrudService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CrudController {

    private final CrudRepository crudRepository;
    private final CrudService crudService;

    CrudController(CrudRepository crudRepository, CrudService crudService) {
        this.crudRepository = crudRepository;
        this.crudService = crudService;
    }

    @PostMapping("/user/crud")
    public Crud postCrud(@RequestBody CrudRequestDto requestDto) {
        Crud crud = new Crud(requestDto);
        return crudRepository.save(crud);
    }

    @GetMapping("/user/crud")
    public List<Crud> readCruds() {
        return crudRepository.findAllByOrderByModifiedAtDesc();
    }

    @DeleteMapping("/user/crud{id}")
    public Long deleteCrud(@PathVariable Long id) {
        crudRepository.deleteById(id);
        return id;
    }

    @PutMapping("/user/crud{id}")
    public Long putCrud(@PathVariable Long id, @RequestBody CrudRequestDto requestDto) {
        crudService.update(id, requestDto);
        return id;
    }




}
