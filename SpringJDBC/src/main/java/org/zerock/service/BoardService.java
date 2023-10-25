package org.zerock.service;

import java.util.List;

import org.zerock.command.BoardVO;

public interface BoardService {

	//board 등록 메서드(이름, 제목, 내용)
	public void register(String name, String title, String content);
	//모든 게시물 가져오는 메서드(보드vo가 필요)
	public List<BoardVO> getList();
	//게시글 삭제 메서드(글 번호)
	public void delete(String num);//불러들일 때 int로 못 받아서..
}
