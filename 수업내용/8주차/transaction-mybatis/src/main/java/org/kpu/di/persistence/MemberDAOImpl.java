package org.kpu.di.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.kpu.di.domain.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "org.kpu.tran.mapper.StudentMapper";
	
	@Override
	public void add(StudentVO student) throws Exception {
		sqlSession.insert(namespace+".insert", student);
	}

	@Override
	public List<StudentVO> readList() throws Exception {
		List<StudentVO> studentList = new ArrayList<StudentVO>();
		studentList = sqlSession.selectList(namespace+".selectAll");
		return studentList;
	}

	@Override
	public StudentVO read(String id) throws Exception {
		StudentVO vo = sqlSession.selectOne(namespace+".selectByid", id);
		return vo;
	}

	@Override
	public void delete(String id) throws Exception {
		sqlSession.delete(namespace+".delete", id);
	}

	@Override
	public void update(StudentVO student) throws Exception {
		sqlSession.update(namespace+".update", student);
	}
	
	
}
