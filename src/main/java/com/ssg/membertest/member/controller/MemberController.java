package com.ssg.membertest.member.controller;

import com.ssg.membertest.member.MemberDTO;
import com.ssg.membertest.member.MemberService;
import com.ssg.membertest.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/insert")
    public void insert(){
        log.info("insert 기능 호출, 입력 창 이동");
    }
    @PostMapping("/insert")
    public String insertResult(MemberDTO memberDTO, Model model){
        log.info(memberDTO);
        if(memberService.save(memberDTO)){
            model.addAttribute("message", "입력 성공");
        } else{
            model.addAttribute("message", "입력 실패");
        }
        return "/list";
    }

    @GetMapping("/list")
    public void list(Model model){
        log.info("select 기능 호출");
        model.addAttribute("list",memberService.printAll());
    }
}
