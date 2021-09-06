package egovframework.board.test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import egovframework.board.test.domain.BoardVO;
import egovframework.board.test.domain.Pagination;
import egovframework.board.test.domain.Paging;
import egovframework.board.test.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String boardListPage(Model model,Paging paging) throws Exception {
		
		model.addAttribute("boardList", boardService.boardList(paging));
		
		Pagination pagination = new Pagination();
		pagination.setPaging(paging);
		pagination.setTotalCount(boardService.listCount());
		
		model.addAttribute("pagination", pagination);
		
		return "board/boardList";
	}
	
	// 글쓰기 폼
	@RequestMapping(value = "/writeView.do", method = RequestMethod.GET)
	public String boardWriteForm(Model model) throws Exception {
		return "board/boardWrite";
	}
	
	// 글쓰기 액션
	@RequestMapping(value = "/write.do", method = RequestMethod.POST)
	public String boardWriteAction(BoardVO boardVO) throws Exception {
		
		boardService.boardWrite(boardVO);
		System.out.println(boardVO);
		return "redirect:/list.do";
	}
	
	// 글 상세보기
	@RequestMapping(value = "/detail.do", method = RequestMethod.GET)
	public String boardDetailView(int bno, Model model) throws Exception {
		boardService.viewCount(bno);
		model.addAttribute("boardVO", boardService.boardDetail(bno));
		return "board/boardDetail";
	}
	
	// 글 수정 폼
	@RequestMapping(value = "/updateView.do")
	public String boardUpdateForm(int bno, Model model) throws Exception {
		model.addAttribute("boardVO", boardService.boardDetail(bno));
		return "board/boardUpdate";
	}
	// 글 수정 액션
	@RequestMapping(value = "/update.do")
	public String boardUpdateAction(BoardVO boardVO) throws Exception {
		boardService.boardUpdate(boardVO);
		System.out.println(boardVO);
		int bno = boardVO.getBno();
		return "redirect:/detail.do?bno=" + bno;
	}
	
	// 글 삭제 액션
	@RequestMapping(value = "/delete.do")
	public String boardDeleteAction(int bno) throws Exception {
		boardService.boardDelete(bno);
		return "redirect:/list.do";
	}
}
