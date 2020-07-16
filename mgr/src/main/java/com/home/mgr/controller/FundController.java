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
		 * ��� ����Ʈ ����
		 */

		// ��� ����Ʈ
		int usePoint = Integer.parseInt(request.getParameter("fundPoint"));
		// �α��θ������ ���
		MemberVO memberVO = new MemberVO();
		memberVO = (MemberVO) session.getAttribute("session");
		// ���� ����Ʈ
		memberVO.setMemberPoint(memberVO.getMemberPoint() - usePoint);
		// ����Ʈ ����
		memberService.memberFundPoint(memberVO);

		/*
		 * �ݵ� ����Ʈ���� �߰�
		 */

		// �ݵ����� ���
		fundVO = fundService.selectFundDetail(fundVO.getFundNum());
		// ���� �ݵ�����Ʈ
		fundVO.setFundCurrentpoint(fundVO.getFundCurrentpoint() + usePoint);
		// �ݵ� ����Ʈ �߰�
		fundService.fundFundPoint(fundVO);
		
		/*
		 *  ����Ʈ��� ����
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
