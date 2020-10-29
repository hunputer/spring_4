package com.choa.s4.member.memberUser;

import java.io.File;
import java.lang.reflect.Member;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.choa.s4.member.MemberDAO;
import com.choa.s4.member.MemberDTO;
import com.choa.s4.member.MemberService;
import com.choa.s4.member.memberFile.MemberFileDAO;
import com.choa.s4.member.memberFile.MemberFileDTO;
import com.choa.s4.util.FileSaver;

@Service
public class MemberUserService implements MemberService {

	@Autowired
	private MemberUserDAO memberUserDAO;
	@Autowired
	private MemberFileDAO memberFileDAO;
	@Autowired
	private FileSaver fileSaver;
	
	@Override
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return memberUserDAO.getMemberLogin(memberDTO);
	}
	
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception{
		return memberUserDAO.setMemberUpdate(memberDTO);
	}
	
	public int setMemberDelete(MemberDTO memberDTO) throws Exception{
		return memberUserDAO.setMemberDelete(memberDTO);
	}

	public int setMemberInsert(MemberDTO memberDTO) throws Exception{
		return memberUserDAO.setMemberInsert(memberDTO);
	}
	
	public MemberDTO getMemberFind(MemberDTO memberDTO) throws Exception{
		return memberUserDAO.getMemberFind(memberDTO);
	}
	
	public MemberFileDTO getOne(MemberDTO memberDTO) throws Exception{
		return memberFileDAO.getOne(memberDTO);
	}
	
	public int setMemberJoin(MemberDTO memberDTO, MultipartFile photo, HttpSession session) throws Exception {
		String path = session.getServletContext().getRealPath("/resources/upload/member");
		File file2 = new File(path);
		String fileName = "";
		
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setId(memberDTO.getId());
		memberFileDTO.setOriname(photo.getOriginalFilename());
		
		int result = memberUserDAO.setMemberInsert(memberDTO);
		
		if(photo != null) {
			fileName = fileSaver.save(file2, photo);
			memberFileDTO.setFileName(fileName);
			result = memberFileDAO.setInsert(memberFileDTO);
		}
		
	    // TODO Auto-generated method stub
	    //HDD 폴더에 이름
//		if(!file2.exists()) {
//			file2.mkdir();
//		}
//	    //1.시간
//	    Calendar ca = Calendar.getInstance();
//	    long time = ca.getTimeInMillis();
//	    String name = photo.getOriginalFilename();
//	    name = time+"_"+name;
//	    
//	    File file = new File(path, name);
//	    System.out.println(file.getPath());
//	    
//	    //HDD저장
//	    //1.FileCopyUtils 라는 객체의 메서드 활용
////	    byte [] ar = photo.getBytes();
////	    FileCopyUtils.copy(ar, file);
//	    
//	    //2. MultipartFile 객체의 메서드 활용
//	    photo.transferTo(file);
	    
	    return result;//memberUserDAO.setMemberJoin(memberDTO);
	   }
}
