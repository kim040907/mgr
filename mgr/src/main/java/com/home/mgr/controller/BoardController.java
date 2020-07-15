package com.home.mgr.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.home.mgr.service.BoardService;
import com.home.mgr.vo.BoardVO;
import com.home.mgr.vo.PagingVO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService boardService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model, HttpServletRequest request, BoardVO boardVO) {

		// �Խù� �Ѱ���
		int total = boardService.countBoardList();
		// ���� ������
		String currentPage = request.getParameter("currentPage");
		// ����¡�� �Խñۼ�
		String cntPerPage = request.getParameter("cntPerPage");

		// �ʱ����, ����������������� 10���� ��°� �б�ó��
		if (currentPage == null & cntPerPage == null) {
			// �ʱ������� 1, �ʱ��������� 10��
			currentPage = "1";
			cntPerPage = "10";
		} else if (currentPage == null) {
			currentPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "10";
		}

		PagingVO pagingVO = new PagingVO(total, Integer.parseInt(currentPage), Integer.parseInt(cntPerPage));

		System.out.println(pagingVO.toString());
		System.out.println(boardService.pagingBoardList(pagingVO));

		model.addAttribute("paging", pagingVO);
		model.addAttribute("boardList", boardService.pagingBoardList(pagingVO));
		
		// model.addAttribute("boardList", boardService.selectBoardList());

		return "boardList";
	}

	@RequestMapping(value = "/writeForm", method = RequestMethod.GET)
	public String writeForm(Model model, HttpServletRequest request, BoardVO boardVO) {
		return "writeForm";
	}

	@RequestMapping(value = "/updateForm", method = RequestMethod.GET)
	public String updateForm(Model model, HttpServletRequest request, BoardVO boardVO) {

		boardVO = boardService.selectBoardDetail(request.getParameter("boardNum"));

		model.addAttribute("boardDetail", boardVO);

		return "updateForm";
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(Model model, HttpServletRequest request, BoardVO boardVO) {

		boardVO.setBoardTitle(request.getParameter("title"));
		boardVO.setBoardContents(request.getParameter("contents"));

		boardService.write(boardVO);

		model.addAttribute("boardList", boardService.selectBoardList());

		return "boardList";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Model model, HttpServletRequest request, BoardVO boardVO) {

		boardService.delete(request.getParameter("boardNum"));

		model.addAttribute("boardList", boardService.selectBoardList());

		return "boardList";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Model model, HttpServletRequest request, BoardVO boardVO) {

		boardVO.setBoardNum(request.getParameter("num"));
		boardVO.setBoardTitle(request.getParameter("title"));
		boardVO.setBoardContents(request.getParameter("contents"));

		boardService.update(boardVO);

		boardVO = boardService.selectBoardDetail(request.getParameter("num"));

		model.addAttribute("boardDetail", boardVO);

		return "boardDetail";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(Model model, HttpServletRequest request, BoardVO boardVO) {

		boardVO = boardService.selectBoardDetail(request.getParameter("boardNum"));

		model.addAttribute("boardDetail", boardVO);

		return "boardDetail";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(Model model, HttpServletRequest request, BoardVO boardVO) {

		boardVO.setSearchType(request.getParameter("searchType"));
		boardVO.setSearchWord(request.getParameter("searchWord"));

		model.addAttribute("boardList", boardService.search(boardVO));

		return "boardList";
	}
}
