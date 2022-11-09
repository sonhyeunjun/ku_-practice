package com.example.kurmap.Board.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.kurmap.Board.model.vos.BoardVo;

import java.util.*;


@Repository
public interface BoardRepository extends JpaRepository<BoardVo,Integer> {

    List<BoardVo> findByTitleContaining(String keyword);



}
