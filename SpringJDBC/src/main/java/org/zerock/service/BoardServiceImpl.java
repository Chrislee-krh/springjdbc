package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.command.BoardVO;
import org.zerock.dao.BoardDAO;
import org.zerock.dao.BoardDAOImlpl;

//@Component
//@Component("boardService") // "boardService"는 등록 bean의 id로 사용됨.


@Service("boardService") //3번 어노테이션으로 빈 등록
public class BoardServiceImpl implements BoardService {
	
	// 세가지 방법이 있다.
	// 1.(어노테이션 @Service 주석처리)
//	BoardDAO boardDAO = new BoardDAOImlpl();
	// 2.
	@Autowired
	private BoardDAO boardDAO;
	// 3. annotation

	@Override
	public void register(String name, String title, String content) {
		
//		//1. boardRegister.jsp로 부터 전달받은 값 확인..
		System.out.println("-----service계층-----");
		System.out.println(name);
		System.out.println(title);
		System.out.println(content);
		
		boardDAO.boardInsert(name, title, content);
	}

	@Override
	public List<BoardVO> getList() {
		List<BoardVO> list = boardDAO.boardSelect();
		return list;
	}

	@Override
	public void delete(String num) {
		boardDAO.boardDelete(num);
	}

}
