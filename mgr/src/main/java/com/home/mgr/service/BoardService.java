package com.home.mgr.service;

import java.util.List;

import com.home.mgr.vo.BoardVO;
import com.home.mgr.vo.PagingVO;

public interface BoardService {
	// ��� ���
	List<BoardVO> selectBoardList();

	// �۾���
	void write(BoardVO boardVO);

	// �� ��
	BoardVO selectBoardDetail(String boardNum);

	void delete(String boardNum);

	void update(BoardVO boardVO);

	List<BoardVO> search(BoardVO boardVO);

	// Paging Count 
	int countBoardList();

	// Paging After Board List
	List<BoardVO> pagingBoardList(PagingVO pagingVO);
}
