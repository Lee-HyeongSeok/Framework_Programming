package org.kpu.web.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kpu.web.domain.StudentVO;
import org.springframework.stereotype.Component;

@Component
public class MemberDAOImpl implements MemberDAO {
	
	private Map<String, StudentVO> storage = new HashMap<String, StudentVO>();
	
	public StudentVO read(String id){
		return storage.get(id);  
	}
	public void add(StudentVO student){ 
		storage.put(student.getId(), student);
	}
	public List<StudentVO> readList(){
		List<StudentVO> studentlist = null;
		
		return studentlist;
	}
	public void update(StudentVO vo){
		
	}
	public void delete(String id){
		
	}
}
