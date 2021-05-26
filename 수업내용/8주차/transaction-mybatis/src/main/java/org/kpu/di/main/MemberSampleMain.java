
package org.kpu.di.main;

import org.kpu.di.domain.StudentVO;
import org.kpu.di.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
//import org.springframework.context.support.GenericXmlApplicationContext;

public class MemberSampleMain {

	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("안녕하세요 transaction-xml");

		ctx = new GenericXmlApplicationContext("classpath:applicationContext_annotation.xml");
		MemberService memberService = (MemberService)ctx.getBean(MemberService.class);  // by Class name

		String strID1 = "hansol";
		StudentVO vo1 = new StudentVO(); vo1.setId(strID1); vo1.setPasswd(strID1); vo1.setSnum(strID1);
		vo1.setUsername("가나다라마바사아자사차라라나나아아미미아아나나나어어어울러러오호호호호호호로롷유휴후후");
		
		String strID2 = "dongjin";
		StudentVO vo2 = new StudentVO(); vo2.setId(strID2); vo2.setPasswd(strID2); vo2.setSnum(strID2);
		vo2.setUsername(strID2);
		
		try {
			memberService.updateMemberList(vo1, vo2);
			System.out.println("트랜잭션 처리 완료");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		

	}

}
