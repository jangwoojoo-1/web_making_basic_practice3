package com.ssg.membertest.tMember.controller;

import com.ssg.membertest.tMember.dto.MemberDTO;
import com.ssg.membertest.tMember.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String insert(MemberDTO memberDTO, RedirectAttributes rttr) { // ⬅️ 1. Model 대신 RedirectAttributes 사용
        if(memberService.save(memberDTO)){
            rttr.addFlashAttribute("message", "입력 성공");
        } else{
            rttr.addFlashAttribute("message", "입력 실패");
        }
        return "redirect:/list";
    }

    @GetMapping("/list")
    public void list(Model model){
        log.info("select 기능 호출");
        model.addAttribute("list",memberService.printAll());
    }
}
