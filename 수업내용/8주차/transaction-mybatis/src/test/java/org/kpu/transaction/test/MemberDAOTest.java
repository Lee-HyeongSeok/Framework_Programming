package org.kpu.transaction.test;


import java.util.List;

import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kpu.di.domain.StudentVO;
import org.kpu.di.persistence.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:/applicationContext.xml"})
public class MemberDAOTest {
	@Autowired
	private MemberDAO dao;
	
	/*
	@Test
	public void testInsertMember() throws Exception{
		StudentVO vo = new StudentVO();
		vo.setId("dongjin");
		vo.setPasswd("dongjin1234");
		vo.setUsername("dongjin");
		vo.setSnum("2016156002");
		vo.setDepart("소프르웨어");
		vo.setMobile("010-3321-1156");
		vo.setEmail("dong@gmail.com");
		dao.add(vo);
	}
	*/
	@Test
	public void testReadByid1() throws Exception{
		StudentVO vo;
		vo = dao.read("hansol");
		System.out.println(vo.toString());
	}
	
	@Test
	public void testReadByid2() throws Exception{
		StudentVO vo;
		vo = dao.read("dongjin");
		System.out.println(vo.toString());
	}
	

}
