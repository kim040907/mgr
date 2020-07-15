package com.home.mgr.dao;

import java.util.List;

import com.home.mgr.vo.BoardVO;
import com.home.mgr.vo.PagingVO;

public interface BoardDAO {
	// ��� ���
	List<BoardVO> selectBoardList();

	// �۾���
	void write(BoardVO boardVO);

	// �ۺ���
	BoardVO selectBoardDetail(String boardNum);

	// ����
	void delete(String boardNum);

	// ����
	void update(BoardVO boardVO);

	// �˻�
	List<BoardVO> search(BoardVO boardVO);

	
	// Paging count 
	int countBoardList();

	// BoardList after Paging
	List<BoardVO> pagingBoardList(PagingVO pagingVO);
}
