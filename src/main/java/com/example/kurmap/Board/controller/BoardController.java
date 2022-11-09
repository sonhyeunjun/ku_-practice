package com.example.kurmap.Board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.kurmap.Board.model.service.BoardService;
import com.example.kurmap.Board.model.vos.BoardVo;


import java.util.*;

import javax.servlet.http.HttpSession;


// 1. 사용자에게 웹을 통해 요청을 받음
// 2. 요청받은 것을 서비스를 통해 전달
// 3. 비즈니스 로직 처리
// 4. 처리된 데이터를 모델을 통해 뷰에 전달
// 5. 뷰를 통해 사용자가 전달 된 것을 확인
// 클라이언트 -> 컨트롤러 -> 서비스 -> DAO(Repository) -> DB -> DAO(Repository) -> 서비스 -> 컨트롤러(모델로 전달) -> 뷰
//               DTO(객체를 담은 클래스)       Entity(객체를 담은 클래스)

@Controller
public class BoardController {

    // new 인스턴스 생성자 역할 @Autowired
    @Autowired
    private BoardService boardService;

    // 글 쓰기
    // 사용자가 웹을 통해 요청한 주소 localhost:8090/list
    @RequestMapping(value = "/write.do", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String WriteGet(Model model,HttpSession session) {

        //세션 추가하기
        session.getAttribute("loginId");
        model.addAttribute("loginId", session.getAttribute("loginId"));
        return "Board/write";
    }
    // 글 저장
    @RequestMapping(value = "/writesave.do")
    public String WritePost(BoardVo boardVo) {

        boardService.writedo(boardVo);

        return "redirect:/list.do";
    }

    // 글 목록 출력
    @RequestMapping(value = "/list.do", method = RequestMethod.GET)
    public String listGet(Model model,BoardVo boardVo,String keyword,HttpSession session){
        
        List<BoardVo> list =null;

        if(keyword == null){
            list = boardService.list();
        }else{
            list = boardService.searchList(keyword);
        }

        model.addAttribute("list", list);
    

        session.getAttribute("loginId");
        model.addAttribute("loginId", session.getAttribute("loginId"));
        // 로그인 테스트용 출력
        System.out.println("로그인 세션값: " + session.getAttribute("loginId"));

        return "Board/list";
    }
    // 글 상세보기
    @RequestMapping(value = "/detail.do")
    public String detailGet(Model model, BoardVo boardVo,Integer id,HttpSession session){

        model.addAttribute("boardVo", boardService.Detail(id));
  
        // 로그인 정보 확인
        // 로그인 성공 시 => 네비게이션 바에 로그아웃 메뉴 활성화
        // 비로그인 시 => 로그인/회원가입 메뉴 활성화
        session.getAttribute("loginId");
        model.addAttribute("loginId", session.getAttribute("loginId"));
  
        return "Board/detail";
    }
    //글 삭제
    @RequestMapping(value = "/delete.do")
    public String delete(Integer id,HttpSession session,Model model){

        boardService.Delete(id);

        
        // 로그인 정보 확인
        // 로그인 성공 시 => 네비게이션 바에 로그아웃 메뉴 활성화
        // 비로그인 시 => 로그인/회원가입 메뉴 활성화
        session.getAttribute("loginId");
        model.addAttribute("loginId", session.getAttribute("loginId"));

        return "redirect:/list.do";
    }
    // 글 수정하기
    @RequestMapping(value = "/modify.do")
    public String modifyGet(Model model, Integer id){

        model.addAttribute("list", boardService.Detail(id));
       
        return "Board/modify";
    }

    // 글 수정
    @RequestMapping(value = "/modifyupdate.do")
    public String modifyPost(Model model, Integer id,BoardVo boardVo){

        BoardVo vo = boardService.Detail(id);
        vo.setTitle(vo.getTitle());
        vo.setContent(vo.getContent());

        
        boardService.writedo(boardVo);

        return "redirect:/list.do";
    }

}
