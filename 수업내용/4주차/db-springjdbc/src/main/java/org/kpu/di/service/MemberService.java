package org.kpu.di.service;

import java.util.List;

import org.kpu.di.domain.StudentVO;

public interface MemberService {
		public StudentVO readMember(String id) throws Exception;
		public void addMember(StudentVO student) throws Exception;
		public List<StudentVO> readMemberList() throws Exception;
}
