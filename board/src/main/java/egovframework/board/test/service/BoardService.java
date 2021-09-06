package egovframework.board.test.service;

import java.util.List;

import egovframework.board.test.domain.BoardVO;
import egovframework.board.test.domain.Paging;

public interface BoardService {
	
	public List<BoardVO> boardList(Paging paging) throws Exception;
	
	public void boardWrite(BoardVO boardVO) throws Exception;

	public void boardDelete(int bno) throws Exception;
	
	public void boardUpdate(BoardVO boardVO) throws Exception;
	
	public BoardVO boardDetail(int bno) throws Exception;
	
	public void viewCount(int bno) throws Exception;
	
	public int listCount() throws Exception;
}
