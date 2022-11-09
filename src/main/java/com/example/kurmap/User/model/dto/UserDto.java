package com.example.kurmap.User.model.dto;

import com.example.kurmap.User.model.vo.UserVo;

import lombok.Data;

@Data
public class UserDto {
    private Integer id;
    private String email;
    private String password;

    // 엔티티타입을 DTO 타입으로 변환
    public static UserDto toUserDto(UserVo userVo) {
        UserDto userDto = new UserDto();
        userDto.setId(userVo.getId());
        userDto.setEmail(userVo.getEmail());
        userDto.setPassword(userVo.getPassword());


        return userDto;
    }

}