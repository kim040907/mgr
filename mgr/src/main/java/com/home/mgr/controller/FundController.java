package com.home.mgr.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Parsed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.home.mgr.service.FundService;
import com.home.mgr.service.MemberService;
import com.home.mgr.service.PointService;
import com.home.mgr.vo.FundVO;
import com.home.mgr.vo.MemberVO;
import com.home.mgr.vo.PointVO;

@Controller
@RequestMapping("/fund")
public class FundController {

	@Autowired
	FundService fundService;

	@Autowired
	MemberService memberService;

	@Autowired
	PointService pointService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model, HttpServletRequest request, FundVO fundVO) {

		model.addAttribute("fundList", fundService.selectFundList());

		return "fundList";
	}

	@RequestMapping(value = "/writeForm", method = RequestMethod.GET)
	public String writeForm(Model model, HttpServletRequest request) {
		return "fundWriteForm";
	}

	@RequestMapping(value = "/fundWrite", method = RequestMethod.POST)
	public String write(Model model, HttpServletRequest request, FundVO fundVO) {

		fundVO.setFundCategory(request.getParameter("fundCategory"));
		fundVO.setFundTitle(request.getParameter("fundTitle"));
		fundVO.setFundContents(request.getParameter("fundContents"));
		fundVO.setFundStartDate(request.getParameter("fundStartDate"));
		fundVO.setFundEndDate(request.getParameter("fundEndDate"));
		fundVO.setFundNeedpoint(Integer.parseInt(request.getParameter("fundNeedpoint")));

		System.out.println("FUNDVO : " + fundVO.toString());

		fundService.fundWrite(fundVO);

		model.addAttribute("fundList", fundService.selectFundList());

		return "fundList";
	}

	@RequestMapping(value = "/fundDetail", method = RequestMethod.GET)
	public String detail(Model model, HttpServletRequest request, FundVO fundVO) {

		fundVO = fundService.selectFundDetail(Integer.parseInt(request.getParameter("fundNum")));

		model.addAttribute("fundDetail", fundVO);

		return "fundDetail";
	}

	@RequestMapping(value = "/fundPoint", method = RequestMethod.POST)
	public String fundPoint(Model model, HttpServletRequest request, HttpSession session, FundVO fundVO) {

		/*
		 * 멤버 포인트 차감
		 */

		// 사용 포인트
		int usePoint = Integer.parseInt(request.getParameter("fundPoint"));
		// 로그인멤버정보 취득
		MemberVO memberVO = new MemberVO();
		memberVO = (MemberVO) session.getAttribute("session");
		// 남은 포인트
		memberVO.setMemberPoint(memberVO.getMemberPoint() - usePoint);
		// 포인트 차감
		memberService.memberFundPoint(memberVO);

		/*
		 * 펀드 포인트정보 추가
		 */

		// 펀드정보 취득
		fundVO = fundService.selectFundDetail(fundVO.getFundNum());
		// 현재 펀드포인트
		fundVO.setFundCurrentpoint(fundVO.getFundCurrentpoint() + usePoint);
		// 펀드 포인트 추가
		fundService.fundFundPoint(fundVO);
		
		/*
		 *  포인트등록 내역
		 */
		PointVO pointVO = new PointVO();

		pointVO.setPointType("1");
		pointVO.setPointPoint(usePoint);
		pointVO.setPointMembernum(memberVO.getMemberNum());
		pointVO.setPointFundnum(fundVO.getFundNum());

		pointService.insertPointHistory(pointVO);

		model.addAttribute("fundDetail", fundVO);

		return "fundDetail";
	}
}
