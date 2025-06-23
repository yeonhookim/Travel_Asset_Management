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


    // 마이페이지 조회 (GET)
    @GetMapping("/mypage")
    public String mypage(HttpSession session, Model model) {
        MemberDTO loginUser = (MemberDTO) session.getAttribute("loginUser"); // 로그인 사용자 세션 확인
        if (loginUser != null) {
            MemberDTO member = memberService.findById(loginUser.getUsername()); // DB에서 최신 정보 조회
            model.addAttribute("member", member); // 뷰에 전달
            return "member/mypage"; // mypage.jsp로 이동
        }
        return "redirect:/login"; // 비로그인 상태면 로그인 페이지로
    }

    // 마이페이지 수정 처리 (POST)
    @PostMapping("/mypage")
    public String updateMypage(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
        memberService.updateMember(memberDTO); // 수정 로직 실행
        session.setAttribute("loginUser", memberDTO); // 세션 정보도 갱신
        return "redirect:/mypage"; // 다시 마이페이지로 이동
    }
    // 로그아웃 처리
    @GetMapping("/logout") // 사용자가 /logout URL에 접근하면 로그아웃 실행
    public String logout(HttpSession session) {
        // 세션에서 사용자 정보 제거, 세션 무효화 (모든 세션 속성 제거)
        session.invalidate(); // 또는 session.removeAttribute("loginUser");

        // 로그아웃 후 메인 페이지로 이동
        return "redirect:/main";
    }
}