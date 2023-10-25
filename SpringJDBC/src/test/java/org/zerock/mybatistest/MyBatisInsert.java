package org.zerock.mybatistest;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.command.ScoreVO;
import org.zerock.mapper.ScoreMapper;
import org.zerock.testmapper.TestMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
public class MyBatisInsert {
	
	@Autowired
	TestMapper mapper;
	
	@Autowired
	ScoreMapper scoreMapper;
	
	@Test
	public void insert() {
		try {
			// 맵 넣기
			Map<String, String> map = new HashMap<>();
			map.put("p1", "홍길동");
			map.put("p2", "100");
			map.put("p3", "90");
			map.put("p4", "80");
			
			boolean result = scoreMapper.insert2(map);
			//vo넣기
//			ScoreVO vo = new ScoreVO();
//			vo.setName("Lana");
//			vo.setKor("100");
//			vo.setEng("100");
//			vo.setMath("100");
//			
//			boolean result = mapper.insert(vo);
			System.out.println("성공?: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
