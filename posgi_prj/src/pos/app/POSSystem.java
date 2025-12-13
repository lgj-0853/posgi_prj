package pos.app;

import pos.manager.ProductManager;

public class POSSystem { // 프로그램의 시작과 제어: 시스템의 메인 시작점(main 메서드)이자, 메뉴 전환과 핵심 객체(ProductManager)를 생성하는 총괄 담당.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 다른 패키지 클래스 호출해 시스템 흐름 제어 역할
		
		// ProductManager 클래스 생성.
		ProductManager pm = new ProductManager();
		
		
	}

}
