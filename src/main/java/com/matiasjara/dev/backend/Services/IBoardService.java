package com.matiasjara.dev.backend.Services;

import java.util.List;
import java.util.Optional;

import com.matiasjara.dev.backend.model.Board;

public interface IBoardService {
 
     public List<Board> getAllBoards();

    public Optional<Board> getBoardById(Long id);

    public Board createBoard(Board board);

    public Board updateBoard(Long id, Board updatedBoard);
        
    public void deleteBoard(Long id);
}
