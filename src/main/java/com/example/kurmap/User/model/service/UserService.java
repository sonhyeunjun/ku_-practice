package com.example.kurmap.User.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kurmap.User.model.dto.UserDto;
import com.example.kurmap.User.model.repository.UserRepository;
import com.example.kurmap.User.model.vo.UserVo;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public void register(UserVo userVo){

        userRepository.save(userVo);

    }

    /**
     * 로그인페이지에서 입력받은 아이디와, 비밀번호를 받아오고
     * DB로부터 해당 아이디의 정보를 가져와서
     * 입력받은 비밀번호와 DB에서 조회한 비밀번호의 일치여부를 판단하고
     * 일치하면 로그인 성공, 일치하지 않으면 로그인 실패로 처리
     */
    public UserDto memberLoginDo(UserDto userDto) {
        Optional<UserVo> optionalMember = userRepository.findByEmail(userDto.getEmail());
        if (optionalMember.isPresent()) {
            UserVo loginEntity = optionalMember.get();
            if (loginEntity.getPassword().equals(userDto.getPassword())) { // 로그인 성공
                return UserDto.toUserDto(loginEntity);
            } else { // 계정은 맞지만 비밀번호가 틀림
                return null;
            }
        } else { // 해당 계정이 없을 때
            return null;
        }
    }
}
