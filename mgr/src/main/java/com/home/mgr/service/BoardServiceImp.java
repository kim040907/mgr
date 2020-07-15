package com.home.mgr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.mgr.dao.BoardDAO;
import com.home.mgr.vo.BoardVO;
import com.home.mgr.vo.PagingVO;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	BoardDAO boardDAO;

	@Override
	public List<BoardVO> selectBoardList() {
		// TODO Auto-generated method stub

		return boardDAO.selectBoardList();
	}

	@Override
	public void write(BoardVO boardVO) {
		// TODO Auto-generated method stub
		boardDAO.write(boardVO);
	}

	@Override
	public BoardVO selectBoardDetail(String boardNum) {
		// TODO Auto-generated method stub
		return boardDAO.selectBoardDetail(boardNum);
	}

	@Override
	public void delete(String boardNum) {
		// TODO Auto-generated method stub
		boardDAO.delete(boardNum);
	}

	@Override
	public void update(BoardVO boardVO) {
		// TODO Auto-generated method stub
		boardDAO.update(boardVO);
	}

	@Override
	public List<BoardVO> search(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return boardDAO.search(boardVO);
	}

	@Override
	public int countBoardList() {
		// TODO Auto-generated method stub
		return boardDAO.countBoardList();
	}

	@Override
	public List<BoardVO> pagingBoardList(PagingVO pagingVO) {
		// TODO Auto-generated method stub
		return boardDAO.pagingBoardList(pagingVO);
	}
}
