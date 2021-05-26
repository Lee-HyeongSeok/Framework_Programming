package org.kpu.di.service;

import org.kpu.di.domain.StudentVO;
import org.kpu.di.persistence.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;
			
	public MemberServiceImpl(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	public StudentVO readMember(String id) throws Exception {
		return memberDAO.read(id);
	}
	
	public void addMember(StudentVO student) throws Exception {
		memberDAO.add(student);
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, timeout=10)
	public void updateMemberList(StudentVO student1, StudentVO student2) throws Exception {
		memberDAO.update(student2);
		memberDAO.update(student1);
	}

}
