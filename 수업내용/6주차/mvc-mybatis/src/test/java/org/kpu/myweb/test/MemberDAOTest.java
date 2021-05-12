package org.kpu.myweb.test;

import java.util.List;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kpu.myweb.domain.StudentVO;
import org.kpu.myweb.persistence.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberDAOTest {
	@Autowired
	private MemberDAO dao;
	
	@Test
	public void testReadByid() throws Exception{
		StudentVO vo;
		vo = dao.read("hansol");
		System.out.println(vo.toString());
	}
	
	@Test
	public void testReadList() throws Exception{
		List<StudentVO> voList;
		voList = dao.readList();
		for(StudentVO svo:voList) {
			System.out.println(svo.toString());
		}
	}
}
