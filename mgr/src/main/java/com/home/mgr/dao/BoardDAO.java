package com.home.mgr.dao;

import java.util.List;

import com.home.mgr.vo.BoardVO;
import com.home.mgr.vo.PagingVO;

public interface BoardDAO {
	// 목록 출력
	List<BoardVO> selectBoardList();

	// 글쓰기
	void write(BoardVO boardVO);

	// 글보기
	BoardVO selectBoardDetail(String boardNum);

	// 삭제
	void delete(String boardNum);

	// 수정
	void update(BoardVO boardVO);

	// 검색
	List<BoardVO> search(BoardVO boardVO);

	
	// Paging count 
	int countBoardList();

	// BoardList after Paging
	List<BoardVO> pagingBoardList(PagingVO pagingVO);
}
