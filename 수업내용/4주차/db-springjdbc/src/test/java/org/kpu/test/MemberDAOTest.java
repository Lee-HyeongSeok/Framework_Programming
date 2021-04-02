package org.kpu.test;

import java.util.logging.Logger;

import org.junit.runner.RunWith;
import org.kpu.di.domain.StudentVO;
import org.kpu.di.persistence.MemberDAO;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/applicationContext.xml")
public class MemberDAOTest {
	@Autowired
	MemberDAO dao=null;
	
	private static Logger logger = (Logger) LoggerFactory.getLogger(DataSourceTest.class);
	
	@Autowired
	public void daoTest() throws Exception{
		try {
			StudentVO vo = dao.read("hansol");
			logger.info("DAO Test : " + vo);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
