package com.choa.s4.member.memberUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choa.s4.member.MemberDTO;
import com.choa.s4.member.MemberService;

@Service
public class MemberUserService implements MemberService {

	@Autowired
	private MemberUserDAO memberUserDAO;
	
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

}
