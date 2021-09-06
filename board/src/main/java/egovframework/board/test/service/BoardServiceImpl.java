package egovframework.board.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.board.test.dao.BoardDAO;
import egovframework.board.test.domain.BoardVO;
import egovframework.board.test.domain.Paging;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public List<BoardVO> boardList(Paging paging) throws Exception {
		
		return boardDAO.boardList(paging);
	}

	@Override
	public void boardWrite(BoardVO boardVO) throws Exception {
		boardDAO.boardWrite(boardVO);
	}

	@Override
	public void boardDelete(int bno) throws Exception {
		boardDAO.boardDelete(bno);
	}

	@Override
	public void boardUpdate(BoardVO boardVO) throws Exception {
		boardDAO.boardUpdate(boardVO);
	}

	@Override
	public BoardVO boardDetail(int bno) throws Exception {
		return boardDAO.boardDetail(bno);
	}

	@Override
	public void viewCount(int bno) throws Exception {
		boardDAO.viewCount(bno);
	}

	@Override
	public int listCount() throws Exception {
		return boardDAO.listCount();
	}
}
