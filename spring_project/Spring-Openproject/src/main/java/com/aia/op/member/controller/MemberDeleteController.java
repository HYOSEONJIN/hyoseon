package com.aia.op.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aia.op.member.service.MemberDeleteService;

@Controller
public class MemberDeleteController {
	
	@Autowired
	private MemberDeleteService delService;
	
	@RequestMapping("/member/delete")
	public String deleteMember(
			@RequestParam("idx") int idx,
			Model model) {
		
		model.addAttribute("result", delService.deleteMember(idx));
		
		return "member/delete";
	}

}