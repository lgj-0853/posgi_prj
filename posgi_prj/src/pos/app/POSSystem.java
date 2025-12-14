package pos.app;


import pos.manager.ProductManager;
import java.util.Scanner;
import pos.ui.AdminMenu;
import pos.ui.SaleMenu;

public class POSSystem {

	public static void main(String[] args) {

		ProductManager pm = new ProductManager();
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			System.out.println("------------------------------------");
			System.out.println("1. 판매모드 / 2. 관리자 모드 / 3. 종료");
			System.out.print("진입 : ");
			int menu = 0;
		
		try {
			menu = sc.nextInt();
			
		} catch (Exception e) {
			System.out.println("유효한 숫자를 입력해주세요.");
			sc.nextLine();
			continue;
		}
		
		switch(menu) {
		case 1:
			System.out.println("판매 모드로 진입합니다");
			SaleMenu sm = new SaleMenu();
//			sm.smgive(pm); // 따로 메소드명 알려주셔야 해요.
			break;
		
		case 2:
			System.out.println("관리자 모드로 진입합니다");
			AdminMenu am = new AdminMenu();
//			am.amgive(pm); // 따로 메소드명 알려주셔야 해요
			break;
		
		case 3:
			System.out.println("종료합니다");
			sc.close();
			return;
		
			default:
				System.out.println("1, 2, 3 중 하나를 선택해 주세요.");
		}
		
		}

	}

}
