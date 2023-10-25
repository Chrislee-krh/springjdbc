package org.zerock.JDBCTest;

import org.junit.Test;

// Car interface 생성
interface Car{
	public void run();
}

public class AnonymousTest {
	
	@Test //junit(단위테스트) 테스트할 대상 메서드에 추가
	public void good() { //인터페이스 car로 익명 객체 만듦
		Car car = new Car() {
			@Override
			public void run() {
				System.out.println("끼릭끼릭~");
			}
		};
		// 보통의 경우 구현하는 별도의 클래스를 생성하여 사용하지만,
		// 재사용할 일이 없으면 익명클래스로 선언하여 1회성으로 사용 가능.
		car.run();
		
		DB.query(new Car() {
			@Override
			public void run() {
				System.out.println("오버라이딩된 메서드 실행");
			}
			
		});

	}

}

// DB클래스
class DB {
	static void query(Car car) {
		car.run();
		System.out.println("여기서는 전달받은 Car객체로 SQL문을 처리합니다.");	
	}
}