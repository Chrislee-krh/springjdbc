package org.zerock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.command.ScoreVO;
import org.zerock.service.ScoreService;

@Controller
@RequestMapping("/service/**")
public class ScoreController {
	
	@Autowired
	ScoreService scoreService;
	
	@RequestMapping("")
	public String basic() {
		return "home";
	}
	//등록 화면 처리..
	@RequestMapping(value="/1scoreRegister", method=RequestMethod.GET)
	public String scoreRegister() {
		return "service/1scoreRegister";
	}
	//점수 등록 메서드(command로 받음)
	@RequestMapping(value="/scoreForm", method=RequestMethod.POST)
	public String scoreForm(ScoreVO vo) {
		
		//점수 등록 메서드 구현
		scoreService.scoreRegist(vo);
		
		return "service/2scoreResult";
	}
	//결과 출력 메서드
	@RequestMapping(value="/3scoreList", method=RequestMethod.GET)
	public String scoreList(Model model) {
		//점수 결과를 받아서 처리.. model에 넣어서 이동
		List<ScoreVO> list = scoreService.scoreResult(); 
		model.addAttribute("scoreList", list);
		return "service/3scoreList";
	}
	
	//삭제 메서드
	@RequestMapping(value="/scoreDelete")
	public String scoreDelete(@RequestParam("num") String num) {
		//점수 삭제
		scoreService.scoreDelete(num);
		//단순히 service/3scoreList로 이동시키면 화면에 전달할 값이 없음..-이는 viewresolver로 걍 보여주는거고
		//그래서 /service/3scoreList로 이동시켜서, url로 해당 위치로 넘어가서, 
		//즉 다시 컨트롤러에 있는 3scoreList에 도달할 수 있게 강제 이동. redirect처리
		return "redirect:/service/3scoreList";
	}
	
}
