package com.choa.s4.member.memberUser;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.choa.s4.member.MemberDTO;
import com.choa.s4.member.MemberService;
import com.choa.s4.member.memberFile.MemberFileDTO;

@Controller
@RequestMapping("/member/**")
public class MemberUserController {
	@Autowired
	private MemberUserService memberUserService;
	
	@PostMapping("memberFind")
	public ModelAndView getMemberFind(MemberDTO memberDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberDTO dto = memberUserService.getMemberFind(memberDTO);
		int result = 1;
		if(dto != null) {
			result = 0;
		}
		mv.addObject("msg", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	@GetMapping("memberJoin")
	public ModelAndView setMemberInsert() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberJoin");
		return mv;
	}
	
	@PostMapping("memberJoin")
	public ModelAndView setMemberInsert(MemberDTO memberDTO, MultipartFile photo, HttpSession httpSession) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("memberJoin");
		System.out.println(photo.getOriginalFilename());
		System.out.println(photo.getName());
		System.out.println(photo.getSize());
		System.out.println(photo.getContentType());
		int result = memberUserService.setMemberJoin(memberDTO, photo, httpSession);
		mv.setViewName("redirect:../");
		return mv;
	} 
	
	@GetMapping("memberDelete")
	public ModelAndView setMemberDelete(HttpSession httpSession) throws Exception {
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO)httpSession.getAttribute("member");
		int result = memberUserService.setMemberDelete(memberDTO);
		String msg = "delete fail";
		if(result > 0) {
			httpSession.invalidate();
			msg = "delete success";
			
		}
		mv.addObject("msg", msg);
		mv.addObject("path", "../");
		mv.setViewName("common/result");
		return mv;
	}
	
	@GetMapping("memberPage")
	public ModelAndView getMemberOne(HttpSession httpSession) throws Exception {
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO)httpSession.getAttribute("member");
		MemberFileDTO memberFileDTO = memberUserService.getOne(memberDTO);
		System.out.println(memberFileDTO.getFileName());
		mv.addObject("file", memberFileDTO);
		mv.setViewName("member/memberPage");
		return mv;
	}
	
	@GetMapping("memberUpdate")
	public ModelAndView setMemberUpdate() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberUpdate");
		return mv;
	}
	
	@PostMapping("memberUpdate")
	public ModelAndView setMemberUpdate(MemberDTO memberDTO, HttpSession httpSession) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberDTO member = (MemberDTO)httpSession.getAttribute("member");
		memberDTO.setId(member.getId());
		int result = memberUserService.setMemberUpdate(memberDTO);
		
		if(result > 0) {
			member.setName(memberDTO.getName());
			member.setEmail(memberDTO.getEmail());
			httpSession.setAttribute("member", member);
		}
		
		mv.setViewName("redirect:./memberPage");
		return mv;
	}
	
	@GetMapping("memberLogout")
	public ModelAndView getMemberLogout(HttpSession session)throws Exception{
		//웹브라우저 종료
		//일정시간 경과(로그인 후에 요청이 발생하면 시간이 연장)
		//memberDTO를 NULL로 대체
		//유지시간을 강제로 0으로 변경
		session.invalidate();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:../");
		return mv;
	}
	
	//getMemberLogin
	@GetMapping("memberLogin")
	public ModelAndView getMemberLogin()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberLogin");
		
		return mv;
	}
	
	@PostMapping("memberLogin")
	public ModelAndView getMemberLogin(MemberDTO memberDTO, HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		memberDTO = memberUserService.getMemberLogin(memberDTO);
		
		if(memberDTO != null) {
			session.setAttribute("member", memberDTO);
			mv.setViewName("redirect:../");
			
		}else {
			mv.addObject("msg", "Login Fail");
			mv.addObject("path", "./memberLogin");
			mv.setViewName("common/result");
		}
		
		return mv;
	}
}
