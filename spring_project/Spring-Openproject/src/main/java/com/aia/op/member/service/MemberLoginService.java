package com.aia.op.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.op.member.dao.MemberDao;
import com.aia.op.member.domain.Member;

@Service
public class MemberLoginService {
	
	private MemberDao dao;
	
	@Autowired
	SqlSessionTemplate template;
	
	public boolean login(HttpServletRequest request,
						HttpServletResponse response) {
		boolean loginChk=false;
		
		String id = request.getParameter("userid");
		String pw = request.getParameter("pw");
		String chk = request.getParameter("chk");
		
		dao = template.getMapper(MemberDao.class);
		// 1. dao > id,pw검색 > 존재하면 로그인 처리아니라면 pass
		
		Member member = dao.selectLogin(id, pw);
		
		if(member != null) {
			System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆일치");
		}
		
		
		// 2. uid 쿠키처리
		
		return loginChk;
	}
}
