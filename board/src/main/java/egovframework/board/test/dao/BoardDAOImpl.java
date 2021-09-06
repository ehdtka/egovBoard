package egovframework.board.test.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import egovframework.board.test.domain.BoardVO;
import egovframework.board.test.domain.Paging;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Autowired
	private SqlSession sqlSession;
	
	final String NAMESPACE = "boardMapper.";
	
	@Override
	public List<BoardVO> boardList(Paging paging) throws Exception {
		return sqlSession.selectList(NAMESPACE + "boardList", paging);
	}

	@Override
	public void boardWrite(BoardVO boardVO) throws Exception {
		sqlSession.insert(NAMESPACE + "boardWrite", boardVO);
	}

	@Override
	public void boardDelete(int bno) throws Exception {
		sqlSession.delete(NAMESPACE + "boardDelete", bno);
	}

	@Override
	public void boardUpdate(BoardVO boardVO) throws Exception {
		sqlSession.update(NAMESPACE + "boardUpdate", boardVO);
	}

	@Override
	public BoardVO boardDetail(int bno) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "detailSelect", bno);
	}

	@Override
	public void viewCount(int bno) throws Exception {
		sqlSession.update(NAMESPACE + "ViewCount", bno);
	}

	@Override
	public int listCount() throws Exception {
		return sqlSession.selectOne(NAMESPACE + "listCount");
	}

}
