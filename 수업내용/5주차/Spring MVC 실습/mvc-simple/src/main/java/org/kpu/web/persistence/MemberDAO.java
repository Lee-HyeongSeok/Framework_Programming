package org.kpu.web.persistence;

import java.util.List;

import org.kpu.web.domain.StudentVO;

public interface MemberDAO {
	public StudentVO read(String id);
	public void add(StudentVO student);
	public List<StudentVO> readList();
	public void update(StudentVO vo);
	public void delete(String id);
}
