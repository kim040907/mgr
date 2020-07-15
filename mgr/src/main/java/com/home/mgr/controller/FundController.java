package com.home.mgr.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.home.mgr.service.FundService;
import com.home.mgr.vo.FundVO;

@Controller
@RequestMapping("/fund")
public class FundController {

	@Autowired
	FundService fundService;
	
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
	public String write(Model model, HttpServletRequest request,  FundVO fundVO) {

		fundVO.setFundCategory(request.getParameter("fundCategory"));
		fundVO.setFundTitle(request.getParameter("fundTitle"));
		fundVO.setFundContents(request.getParameter("fundContents"));
		fundVO.setFundStartDate(request.getParameter("fundStartDate"));
		fundVO.setFundEndDate(request.getParameter("fundEndDate"));
		fundVO.setFundNeedMoney(request.getParameter("fundNeedMoney"));
		
		System.out.println("FUNDVO : " + fundVO.toString());

		fundService.fundWrite(fundVO);

		model.addAttribute("fundList", fundService.selectFundList());

		return "fundList";
	}
	
	@RequestMapping(value = "/fundDetail", method = RequestMethod.GET)
	public String detail(Model model, HttpServletRequest request, FundVO fundVO) {

		fundVO = fundService.selectFundDetail(request.getParameter("fundNum"));

		model.addAttribute("fundDetail", fundVO);

		return "fundDetail";
	}
}
