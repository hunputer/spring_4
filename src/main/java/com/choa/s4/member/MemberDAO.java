package com.choa.s4.member;

public interface MemberDAO {
	
	public MemberDTO getMemberLogin(MemberDTO memberDTO)throws Exception;
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception;
}
