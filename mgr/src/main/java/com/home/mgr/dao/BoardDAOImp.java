package com.home.mgr.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.home.mgr.vo.BoardVO;
import com.home.mgr.vo.PagingVO;

@Repository
public class BoardDAOImp implements BoardDAO {

	@Inject
	SqlSession sqlSession;

	@Override
	public List<BoardVO> selectBoardList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("selectBoardList");
	}

	@Override
	public void write(BoardVO boardVO) {
		// TODO Auto-generated method stub
		sqlSession.insert("write", boardVO);

	}

	@Override
	public BoardVO selectBoardDetail(String boardNum) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("selectBoardDetail", boardNum);
	}

	@Override
	public void delete(String boardNum) {
		// TODO Auto-generated method stub
		sqlSession.delete("delete", boardNum);

	}

	@Override
	public void update(BoardVO boardVO) {
		// TODO Auto-generated method stub
		sqlSession.update("update", boardVO);
	}

	@Override
	public List<BoardVO> search(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("search", boardVO);
	}

	@Override
	public int countBoardList() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("countBoardList");
	}

	@Override
	public List<BoardVO> pagingBoardList(PagingVO pagingVO) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("pagingBoardList", pagingVO);
	}
}
