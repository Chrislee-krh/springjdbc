package org.zerock.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.zerock.command.BoardVO;

//DAO의 객체 주입은 일반적으로 Component나 Repository 어노테이션 사용..
//component-scan에 반드시 추가해야함

@Repository
public class BoardDAOImlpl implements BoardDAO {

	//DB로 가정할 ArrayList가 필요
//	List<BoardVO> DB = new ArrayList<>();
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void boardInsert(String name, String title, String content) {
		System.out.println("----- DAO 계층 -----");
		System.out.println(name);
		System.out.println(title);
		System.out.println(content);
		
		//쿼리로 사용할 sql
		String sql = "insert into board01(num, name, title, content)"
				+"values(board01_seq.nextval, ?,?,?)";
		//1st
//		int result = jdbcTemplate.update(sql, new PreparedStatementSetter() {
//			@Override
//			public void setValues(PreparedStatement ps) throws SQLException {
//				// TODO Auto-generated method stub
//				ps.setString(1, name);
//				ps.setString(2, title);
//				ps.setString(3, content);
//			}
//		});
	
		//2nd
		int result = jdbcTemplate.update(sql, new Object[] {name, title, content});
		
		
		
		if(result==1) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		
//		BoardVO vo = new BoardVO();
//		vo.setName(name);
//		vo.setTitle(title);
//		vo.setContent(content);
//		
//		DB.add(vo);
//		System.out.println("현재 게시글 수: " +  DB.size());
	}

	@Override
	public List<BoardVO> boardSelect() { //getList()에서 실행 예정, DB정보 불러서 반환
		/*
		 * query()의 parameter 의미
		 * sql: sql쿼리, ?를 사용하는 preparedStatement용 query
		 * new Object[]{값,값,값}: sql에 ?에 대한 set value를 저장(binding)
		 * new RowMapper<type>(): 조회 결과를 ResultSet에 저장해서, 읽어와 type데이터를 생성.
		 * 		-> 익명클래스로 동작, mapRow() 메서드에서 ResultSet에서 읽어온 값을 처리 후 리턴
		 */
		String sql = "select * from board01 order by num desc";
		//1st
//		List<BoardVO> list = jdbcTemplate.query(sql, new PreparedStatementSetter() {
//			
//			@Override
//			public void setValues(PreparedStatement ps) throws SQLException {
//				
//			}
//		}, new RowMapper<BoardVO>() {
//			@Override
//			public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
//				BoardVO vo = new BoardVO();
//				vo.setNum(rs.getInt("num"));
//				vo.setName(rs.getString("name"));
//				vo.setTitle(rs.getString("title"));
//				vo.setContent(rs.getString("content"));
//				return vo;
//			}	
//		});
//		return list;
		
		//2nd
		List<BoardVO> list = jdbcTemplate.query(sql, new Object[] {},
				new RowMapper<BoardVO>(){
			@Override
			public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardVO vo = new BoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				return vo;
			}	
		});
		return list;
	}
		

	@Override
	public void boardDelete(String num) {
		//1st
		String sql = "delete from board01 where num = ?";
//		int result = jdbcTemplate.update(sql, new PreparedStatementSetter() {
//			@Override
//			public void setValues(PreparedStatement ps) throws SQLException {
//				ps.setNString(1, num);	
//			}
//		});
//		DB.remove(Integer.parseInt(num));
		
		//2nd
		int result = jdbcTemplate.update(sql,new Object[] {num});
		if(result==1) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
	}
}
