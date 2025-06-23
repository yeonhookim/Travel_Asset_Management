package org.scoula.backend.controller;

import org.scoula.backend.dto.MemberDTO;
import org.scoula.backend.dto.TripDTO;
import org.scoula.backend.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}