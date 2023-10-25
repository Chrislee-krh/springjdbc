package org.zerock.mybatistest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.command.ScoreVO;
import org.zerock.mapper.ScoreMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MyBatisScore {
   // mapper 설정
   // 1) 테스트 메서드는 mapper인터페이스를 출력하는 메서드 구현
   // root-context -> mapper 관련 설정을 추가해야 함
   
   @Autowired
   ScoreMapper scoreMapper;
   
   @Test
   public void test1() {
      System.out.println(">>>>>>>>ScoreMapper : "+scoreMapper);
   }
   @Test
   public void insert() {
      for(int i = 1; i <=5; i++){
         ScoreVO vo = new ScoreVO();
         vo.setName("Chris");
         vo.setKor("100");
         vo.setEng("100");
         vo.setMath("100");
         
         scoreMapper.insert(vo);
         }
      } 
   
    @Test
   	public boolean insert(ScoreVO vo) {
   		
   		boolean result = scoreMapper.insert(vo);
   		return result;
   	}
   	@Test
   	public void select(){
//   		List<ScoreVO> list = new ArrayList<>();
   		//1st
//   		list.addAll(scoreMapper.select());
//   		System.out.println(Arrays.asList(list));
   		//2nd
   		List<ScoreVO> list = scoreMapper.select();
   		for(ScoreVO vo:list) System.out.println(vo);
   	}
   	@Test
   	public void delete() {
   		//1st
//   		String num = "3";
//   		scoreMapper.delete(num);
   		//2nd
   		Scanner scan = new Scanner(System.in);
   		System.out.println("삭제 게시글 번호: ");
   		String num = scan.next();
   		scoreMapper.delete(num);
   		System.out.println("결과 확인");
   		List<ScoreVO> list = scoreMapper.select();
   		for(ScoreVO vo:list) System.out.println(vo);
   		scan.close();
   	}
}