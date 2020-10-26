package com.choa.s4.board.memo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.choa.s4.util.Pager;

@Controller
@RequestMapping("/memo/**")
public class MemoController {
	
	@Autowired
	private MemoService memoService;
	
	@PostMapping("memoDelete")
	public ModelAndView setDelete(MemoDTO memoDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = memoService.setDelete(memoDTO);
		
		mv.addObject("msg", result);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}
	
	@GetMapping("memoList")
	public ModelAndView getList(Pager pager)throws Exception{
		System.out.println("Memo List");
		List<MemoDTO> ar = memoService.getList(pager);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", ar);
		mv.setViewName("memo/memoTest");
		return mv;
	}
	
	@PostMapping("memoWrite")
	public ModelAndView setInsert(MemoDTO memoDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = memoService.setInsert(memoDTO);
		String message="Write Fail";
		if(result>0) {
			message= "Write Success";
		}
		
		mv.addObject("msg", message);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}
	
	@GetMapping("memoTest")
	public ModelAndView memoTest(MemoDTO memoDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		memoDTO = memoService.getOne(memoDTO);	
		mv.addObject("dto", memoDTO);
		mv.setViewName("memo/memoTest");
		return mv;
	}
	
	@GetMapping("memoPage")
	public void memoPage() throws Exception{}

}
