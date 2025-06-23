package org.scoula.backend.controller;

// 회원가입 요청을 처리하는 컨트롤러

import org.scoula.backend.dto.LoginRequest;
import org.scoula.backend.dto.MemberDTO;
import org.scoula.backend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/signup")
    public String signup(@ModelAttribute MemberDTO memberDTO) {
        memberService.signup(memberDTO); // 회원가입 처리
        return "redirect:/login"; // 가입 완료 후 로그인 페이지로 리다이렉
    }

    // 로그인 컨트롤러 구현
    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequest request, Model model, HttpSession session) {
        MemberDTO loginMember = memberService.login(request);

        if (loginMember != null) {
            session.setAttribute("loginUser", loginMember); // 로그인 세션 저장
            return "redirect:/main"; // 메인 페이지로 리다이렉트
        } else {
            model.addAttribute("loginError", "아이디 또는 비밀번호가 틀렸습니다."); // 오류 메시지 전달
            return "member/login"; // 로그인 페이지로 다시 이동
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 초기화
        return "redirect:/login"; // 로그인 페이지로 이동
    }
}