
package org.kpu.di.main;

import org.kpu.di.config.JavaConfig;
import org.kpu.di.domain.StudentVO;
import org.kpu.di.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.GenericXmlApplicationContext;

public class MemberSampleMain {

	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("안녕하세요 DI-JavaConfig");

		ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		MemberService memberService = ctx.getBean("service", MemberService.class);
		
		
		StudentVO vo = new StudentVO(); 
		vo.setId("kanadara");
		memberService.addMember(vo); 
		
		StudentVO member = memberService.readMember("kanadara");
		
		System.out.println(member);
	}

}
