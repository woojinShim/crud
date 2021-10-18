package com.core.crud.service;

import com.core.crud.dto.CrudRequestDto;
import com.core.crud.model.Crud;
import com.core.crud.repository.CrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CrudService {

    private final CrudRepository crudRepository;

    @Transactional
    public Long update(Long id, CrudRequestDto requestDto) {
        Crud crud = crudRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        crud.update(requestDto);
        return crud.getId();
    }
}
