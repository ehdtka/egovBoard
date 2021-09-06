package egovframework.board.test;


import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import egovframework.board.test.dao.BoardDAO;
import egovframework.board.test.domain.BoardVO;
import egovframework.board.test.domain.Paging;
import egovframework.board.test.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/config/egovframework/springmvc/dispatcher-servlet.xml",
		"file:src/main/resources/egovframework/spring/*.xml"
})
@WebAppConfiguration
public class DataSourceTest {

	@Inject
	private DataSource ds;
	
	@Inject
	private BoardDAO boardDAO;
	
	@Inject
	private BoardService boardService;
	
	@Test
	public void DataSource() throws Exception{
		try (Connection con = ds.getConnection()) {
			System.out.println(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void DAO() throws Exception {
		Paging paging = new Paging();
		paging.setsearchValue("qwe");
		System.out.println(paging);
		System.out.println(boardDAO.boardList(paging));	
	}
	
	@Test
	public void service() throws Exception {
		System.out.println(boardDAO.listCount());
	}
	
	@Test
	public void insert() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setContent("내용");
		boardVO.setTitle("제목");
		boardVO.setWriter("제작자");
		
		boardDAO.boardWrite(boardVO);
	}
	
	@Test
	public void detailTest() throws Exception {
		int bno = 5; 
		BoardVO boardVO = boardDAO.boardDetail(bno);
		System.out.println(boardVO);
	}
	
	@Test
	public void updateTest() throws Exception {
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(10);
		boardVO.setTitle("스정");
		boardVO.setWriter("작성자수정");
		boardVO.setContent("내용 수정");
		boardService.boardUpdate(boardVO);
	}
	
	@Test
	public void viewCount() throws Exception {
		boardService.viewCount(33);
	}
}
