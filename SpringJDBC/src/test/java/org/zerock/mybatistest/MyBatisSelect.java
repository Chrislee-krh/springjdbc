package org.zerock.mybatistest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.command.ScoreVO;
import org.zerock.testmapper.TestMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MyBatisSelect {
	// MyBatis는 DAO를 대체
	// 마이바티스 매퍼(mapper scan 또는 직접 지정. mapper interface, mapper.xml이 존재해야 함)
	@Autowired
	private TestMapper mapper;
	
	@Test
	public void select() {
		List<ScoreVO> list = mapper.select();
		
		for(ScoreVO vo : list) {
			System.out.println(vo);				
		}

//		String time = mapper.getTime();
//		System.out.println(time);
	}
	
}
