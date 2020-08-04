package com.home.mgr.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.home.mgr.service.BoardService;
import com.home.mgr.service.FundService;
import com.home.mgr.service.MemberService;
import com.home.mgr.vo.BoardVO;
import com.home.mgr.vo.MemberVO;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService memberService;

	@Autowired
	BoardService boardService;

	@Autowired
	FundService fundService;

	@RequestMapping(value = "/joinForm", method = RequestMethod.GET)
	public String joinForm(Model model) {
		return "joinForm";
	}

	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public String loginForm(Model model) {
		return "loginForm";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(Model model, HttpServletRequest request, MemberVO memberVO) {

		memberVO.setMemberEmail((String) request.getParameter("memberEmail"));
		memberVO.setMemberPassword((String) request.getParameter("memberPassword"));
		memberVO.setMemberName((String) request.getParameter("memberName"));

		memberService.insertMember(memberVO);

		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, HttpServletRequest request, HttpSession session, MemberVO memberVO,
			BoardVO boardVO) {

		String checkPassword = request.getParameter("memberPassword");

		// 로그인시도 멤버정보 취득
		memberVO = memberService.selectMember((String) request.getParameter("memberEmail"));

		if (memberVO.getMemberPassword().equals(checkPassword)) {

			// 로그인 멤버정보 세션등록
			session.setAttribute("session", memberVO);

			model.addAttribute("fundList", fundService.selectFundList());
			return "home";
		} else {
			// TODO 로그인 실패처리필요
			System.out.println("비번 다름");
			return "home";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, HttpServletRequest request, HttpSession session, MemberVO memberVO,
			BoardVO boardVO) {

		session.invalidate();
		model.addAttribute("fundList", fundService.selectFundList());

		return "fundList";
	}
}
