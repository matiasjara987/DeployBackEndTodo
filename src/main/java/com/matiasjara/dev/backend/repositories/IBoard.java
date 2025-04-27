package com.matiasjara.dev.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matiasjara.dev.backend.model.Board;
@Repository
public interface IBoard extends CrudRepository<Board, Long> {
    
}
