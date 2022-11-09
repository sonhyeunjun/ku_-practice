package com.example.kurmap.Dog.model;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DogMapper {
    @Select(" SELECT * FROM map ")
    List<DogDto> selectList();

    @Select(" SELECT * FROM map WHERE NAME LIKE CONCAT('%', #{hospitalname}, '%')  ")
    List<DogDto> selectSearchList(String hospitalname);
}
