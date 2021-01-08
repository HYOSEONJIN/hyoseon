package member.service;



import javax.annotation.Resource;

import member.dao.Dao;

public class MemberRegService3 implements MemberService {


	@Resource(name = "GuestDao")
	private Dao dao; // 주입받아야하는 참조변수
	

	@Override
	public Object process() {
		System.out.println("MemberRegService 실행");
		dao.insert();
		
		return null;
	}
	
	

}