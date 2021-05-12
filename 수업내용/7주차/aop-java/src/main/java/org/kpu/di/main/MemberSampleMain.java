
package org.kpu.di.main;

import org.kpu.di.config.JavaConfig;
import org.kpu.di.domain.StudentVO;
import org.kpu.di.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
//import org.springframework.context.support.GenericXmlApplicationContext;

public class MemberSampleMain {

	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws Exception {
		System.out.println("hello AOP Java Config");
		
		ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		MemberService memberService = ctx.getBean(MemberService.class);
		
		StudentVO vo = new StudentVO();
		vo.setId("Kanadara");
		vo.setDepart("Computer");
		vo.setEmail("hello@naver.com");
		
		StudentVO member = memberService.readMember("kanadara");
		System.out.println(member);
		
	}

}
