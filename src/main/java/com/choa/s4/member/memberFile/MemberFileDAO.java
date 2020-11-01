package com.choa.s4.member.memberFile;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.choa.s4.member.MemberDTO;

@Repository
public class MemberFileDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private String NAMESPACE = "com.choa.s4.member.memberFile.MemberFileDAO.";
	
	public int setInsert(MemberFileDTO memberFileDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setInsert",memberFileDTO);
	}
	
	public MemberFileDTO getOne(MemberDTO memberDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getOne",memberDTO);
	}
	
}
