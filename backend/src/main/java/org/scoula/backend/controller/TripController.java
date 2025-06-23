package org.scoula.backend.controller;

import org.scoula.backend.dto.MemberDTO;
import org.scoula.backend.dto.TripDTO;
import org.scoula.backend.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TripController {

    @Autowired
    private TripService tripService;

    @GetMapping("/my-trips")
    public String myTrips(HttpSession session, Model model) {
        Object loginUserObj = session.getAttribute("loginUser");

        if (loginUserObj == null) {
            return "redirect:/login";
        }

        int memberId = ((MemberDTO) loginUserObj).getMemberId(); // ✅ 올바른 getter
        List<TripDTO> tripList = tripService.getTripsByMemberId(memberId);
        model.addAttribute("tripList", tripList);

        return "trip/list"; // JSP 파일 이름
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "trip/add"; // trip/add.jsp로 이동
    }

    @PostMapping("/add")
    public String addTrip(@ModelAttribute TripDTO tripDTO, HttpSession session) {
        MemberDTO loginUser = (MemberDTO) session.getAttribute("loginUser");
        tripDTO.setMemberId(loginUser.getMemberId());
        tripService.addTrip(tripDTO);
        return "redirect:/my-trips"; // 여행 목록으로 리디렉션
    }
}