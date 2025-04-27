package com.matiasjara.dev.backend.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.matiasjara.dev.backend.model.Board;
import com.matiasjara.dev.backend.repositories.IBoard;
@Service
public class BoardServiceImpl implements IBoardService{
   private final IBoard boardRepository;

    
    public BoardServiceImpl(IBoard boardRepository) {
        this.boardRepository = boardRepository;
    }
    @Override
    @Transactional(readOnly = true)
    public List<Board> getAllBoards() {
        return (List<Board>)boardRepository.findAll();
    }
    @Override
    @Transactional
    public Optional<Board> getBoardById(Long id) {
        return boardRepository.findById(id);
    }
    @Override
    @Transactional
    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }

    @Override
    @Transactional
    public Board updateBoard(Long id, Board updatedBoard) {
        Optional<Board> existingBoard = boardRepository.findById(id);
        if (existingBoard.isPresent()) {
            updatedBoard.setId(id);
            return boardRepository.save(updatedBoard);
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }
}
