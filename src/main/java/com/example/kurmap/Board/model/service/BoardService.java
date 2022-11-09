package com.example.kurmap.Board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kurmap.Board.model.repository.BoardRepository;
import com.example.kurmap.Board.model.vos.BoardVo;



@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;


    // 글 쓰기
    public void writedo(BoardVo boardVo) {
        boardRepository.save(boardVo);
    }
    
    // 글 목록 출력
    public List<BoardVo> list(){
        return boardRepository.findAll();
    }
    // 특정 키워드 출력
    public List<BoardVo> searchList(String keyword){
        return boardRepository.findByTitleContaining(keyword);
    }
    // 글 상세페이지
    public BoardVo Detail(Integer id) {
        return boardRepository.findById(id).get();
    }
    // 글 삭제
    public void Delete(Integer id){
        boardRepository.deleteById(id);
    }

}
