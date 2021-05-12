package org.kpu.myweb.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kpu.myweb.domain.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO{

	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "org.kpu.myweb.mapper.StudentMapper";
	@Override
	public void add(StudentVO student) throws Exception {
		sqlSession.insert(namespace + ".insert", student);
	}

	@Override
	public List<StudentVO> readList() throws Exception {
		List<StudentVO> studentlist = new ArrayList<StudentVO>();
		studentlist = sqlSession.selectList(namespace + ".selectAll");
		return studentlist;
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
