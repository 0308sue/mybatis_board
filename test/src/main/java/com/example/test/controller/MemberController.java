package com.example.test.controller;

import javax.validation.Valid;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.test.domain.members.Member;
import com.example.test.dto.MemberDTO;
import com.example.test.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/members")
@Controller
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping(value = "/new")
    public String memberForm(Model model){
        model.addAttribute("memberDTO",new MemberDTO());
        return "member/memberForm";
    }

    @PostMapping(value = "new")
    public String memberForm(@Valid MemberDTO memberDTO,BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            System.out.println("a");
            return "member/memberForm";
        }
        
        try {
            Member member = Member.creatMember((memberDTO), passwordEncoder);
            memberService.saveMember(member);
            System.out.println("b");
        } catch (IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());
            System.out.println("c");
            return "member/memberForm";
        }
        
        return "redirect:/";
    }
    
}
