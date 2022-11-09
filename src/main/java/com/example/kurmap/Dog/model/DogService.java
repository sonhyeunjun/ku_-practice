package com.example.kurmap.Dog.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {

    @Autowired
    private DogMapper dogMapper;

    public List<DogDto> selectList() {
        return dogMapper.selectList();
    }

    public List<DogDto> selectSearchList(String hospitalname){
        return dogMapper.selectSearchList(hospitalname);
    }
}