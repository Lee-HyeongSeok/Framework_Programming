package org.kpu.myweb.controller;

import java.nio.charset.Charset;
import java.util.List;

import org.kpu.myweb.domain.StudentVO;
import org.kpu.myweb.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value= {"/list"}, method=RequestMethod.GET)
	public String listMember(Model model) throws Exception{
		List<StudentVO> students = memberService.readMemberList();
		model.addAttribute("students", students);
		return "member/member_list";
	}
	
	@RequestMapping(value= "/read", method=RequestMethod.GET)
	public String readMember(@RequestParam("id") String id, Model model) throws Exception{
		StudentVO student = memberService.readMember(id);
		model.addAttribute("student", student);
		return "member/member_read";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String createMemberGet() throws Exception{
		return "member/member_register";
	}
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String createMemberGet(@ModelAttribute("student") StudentVO vo) throws Exception{
		memberService.addMember(vo);
		return "redirect:/member/list";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modifyMemberGet(@RequestParam("id") String id, Model model) throws Exception{
		StudentVO student = memberService.readMember(id);
		model.addAttribute("student",student);
		return "member/member_modify";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyMemberPost(@ModelAttribute("student") StudentVO vo) throws Exception{
		memberService.updateMember(vo);
		return "redirect:/member/list";
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String deleteMemberGet(@RequestParam("id") String id) throws Exception{
		memberService.deleteMember(id);
		return "redirect:/member/list";
	}
	
	@RequestMapping(value="/rest/{id}", method=RequestMethod.GET)
	public ResponseEntity<StudentVO> readMemberJson(@PathVariable String id) throws Exception{
		StudentVO student = memberService.readMember(id);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		headers.set("My-Header", "MyHeaderValue");
		return new ResponseEntity<StudentVO>(student, headers, HttpStatus.OK);
	}
}
