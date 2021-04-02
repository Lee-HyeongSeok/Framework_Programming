package org.kpu.di.service;

import org.kpu.di.domain.StudentVO;
import org.kpu.di.persistence.MemberDAO;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MemberServiceImpl implements MemberService, InitializingBean,
DisposableBean {
	
	private MemberDAO memberDAO;
			
	public MemberServiceImpl(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	/*
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	*/
	
	public StudentVO readMember(String id) throws Exception {
		return memberDAO.read(id);
	}
	
	public void addMember(StudentVO student) throws Exception {
		memberDAO.add(student);
	}

	public void afterPropertiesSet() throws Exception{
		System.out.println("init MemberServiceImpl");
	}
	
	public void destroy() throws Exception{
		System.out.println("Destroy MemberServiceImpl");
	}
	
}
