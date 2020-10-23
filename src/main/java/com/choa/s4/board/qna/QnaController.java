package com.choa.s4.board.qna;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.choa.s4.board.BoardDTO;
import com.choa.s4.board.notice.NoticeDTO;
import com.choa.s4.util.Pager;

@Controller
@RequestMapping(value = "/qna/**")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@GetMapping("qnaWrite")
	public ModelAndView setInsert() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", "qna");
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	@PostMapping("qnaReply")
	public ModelAndView setReply(QnaDTO qnaDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setReply(qnaDTO);
		String msg = "reply fail";
		if(result > 0) {
			msg = "reply Success";
		}
		mv.setViewName("common/result");
		mv.addObject("msg", msg);
		mv.addObject("path", "./qnaList");
		return mv;
	}
	
	@GetMapping("qnaReply")
	public ModelAndView setReply() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("board","qna");
		mv.setViewName("board/boardReply");
		return mv;
	}
	
	@GetMapping(value = "qnaList")
	public ModelAndView getList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> lists = qnaService.getList(pager);
		mv.addObject("pager", pager);
		mv.addObject("lists", lists);
		mv.addObject("board", "qna");
		mv.setViewName("board/boardList");
		return mv;
	}
	
	@PostMapping("qnaWrite")
	public ModelAndView setInsert(QnaDTO qnaDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setInsert(qnaDTO);
		String msg = "insert fail";
		if(result > 0) {
			msg = "insert Success";
		}
		mv.setViewName("common/result");
		mv.addObject("msg", msg);
		mv.addObject("path", "./qnaList");
		return mv;
	}
	
	@GetMapping("qnaSelect")
	public ModelAndView getOne(QnaDTO qnaDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		BoardDTO boardDTO = qnaService.getOne(qnaDTO);
		
		mv.addObject("dto", boardDTO);
		mv.addObject("board", "qna");
		mv.setViewName("board/boardSelect");
		
		return mv;
	}
	
	@GetMapping("qnaUpdate")
	public ModelAndView setUpdate(long num) throws Exception{
		ModelAndView mv = new ModelAndView();
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setNum(num);
		BoardDTO boardDTO = qnaService.getOne(qnaDTO);
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/boardUpdate");
		mv.addObject("board", "qna");
		
		return mv;
		
	}
	
	@PostMapping("qnaUpdate")
	public ModelAndView setUpdate(NoticeDTO noticeDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setUpdate(noticeDTO);
		String msg = "update fail";
		if(result > 0) {
			msg = "update Success";
		}
		
		mv.addObject("msg", msg);
		mv.addObject("path", "./qnaList");
		mv.setViewName("common/result");
		
		return mv;
	}
	
	@GetMapping("qnaDelete")
	public ModelAndView setDelete(QnaDTO qnaDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setDelete(qnaDTO);
		String msg = "delete fail";
		if(result > 0) {
			msg = "delete Success";
		}
		
		mv.addObject("msg", msg);
		mv.addObject("path", "./qnaList");
		mv.setViewName("common/result");
		return mv;
	}
	
}
