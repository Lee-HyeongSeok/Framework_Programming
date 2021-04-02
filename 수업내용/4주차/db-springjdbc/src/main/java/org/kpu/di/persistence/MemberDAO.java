package org.kpu.di.persistence;

import java.util.List;

import org.kpu.di.domain.StudentVO;

public interface MemberDAO {
	public StudentVO read(String id) throws Exception;
	public void add(StudentVO student) throws Exception;
	public List<StudentVO> readList() throws Exception;
}
