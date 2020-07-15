package com.home.mgr.service;

import java.util.List;

import com.home.mgr.vo.BoardVO;
import com.home.mgr.vo.PagingVO;

public interface BoardService {
	// 목록 출력
	List<BoardVO> selectBoardList();

	// 글쓰기
	void write(BoardVO boardVO);

	// 글 상세
	BoardVO selectBoardDetail(String boardNum);

	void delete(String boardNum);

	void update(BoardVO boardVO);

	List<BoardVO> search(BoardVO boardVO);

	// Paging Count 
	int countBoardList();

	// Paging After Board List
	List<BoardVO> pagingBoardList(PagingVO pagingVO);
}
