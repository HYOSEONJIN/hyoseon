package com.aia.firstspring.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.firstspring.domain.Member;
import com.aia.firstspring.member.dao.MemberDao;

@Service
public class MemberRegService {

	@Autowired
	private MemberDao dao;

	public int insertMember(Member member) {
		int result=0;
		try {
			result = dao.insertMember(member);
		}catch (Exception e){
			e.printStackTrace();
			
		}
		return result;
		
	}
}
