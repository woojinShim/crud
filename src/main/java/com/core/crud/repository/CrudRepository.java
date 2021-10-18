package com.core.crud.repository;

import com.core.crud.model.Crud;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CrudRepository extends JpaRepository<Crud, Long> {
    List<Crud>findAllByOrderByModifiedAtDesc();
}
