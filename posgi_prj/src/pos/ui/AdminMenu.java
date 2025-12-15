package pos.ui; // 콘솔 화면 출력, 메뉴 안내, 사용자 입력 처리 등 사용자와 상호작용하는 부분
import pos.model.Product;
import java.util.Scanner;
import pos.manager.ProductManager;


public class AdminMenu { // 관리자 모드 분리: 관리자(팀원 A)가 맡은 모든 등록/수정/조회 기능을 담당하는 인터페이스를 main에서 분리하기 위함.
    
    // 비밀번호 문자열 1234로 가정
    private static final String ADMIN_PASSWORD = "1234"; 
    private ProductManager productManager;
    private Scanner sc = new Scanner(System.in);

    // 생성자
    public AdminMenu(ProductManager pm) {
        this.productManager = pm;
    }
    
    // AdminMenu 실행 메소드 (startMenu)
    public void startMenu() {
        System.out.println("관리자 모드 진입");
        
        // 관리자 비밀번호 확인
        if (!checkPassword()) {
            System.out.println("비밀번호가 일치하지 않습니다.");
            return;
        }
        
        System.out.println("관리자 인증 완료.");
        // 인증시 관리자 메뉴 바로 실행
        runAdminMenu();
    }

    // 비밀번호 확인 
    private boolean checkPassword() {
        System.out.print("관리자 비밀번호를 입력하세요: ");
        String inputPassword = sc.nextLine();
        
        return ADMIN_PASSWORD.equals(inputPassword);
    }
    
    // 관리자 메뉴 로직
    private void runAdminMenu() {
        while (true) {
            System.out.println("\n----------------- 관리자 메뉴 -----------------");
            System.out.println("1. 상품 재고 수정 / 2. 새 상품 등록 / 3. 관리자 모드 종료");
            System.out.print("선택 : ");
            
            try {
                int menu = Integer.parseInt(sc.nextLine());
                
                switch (menu) {
                    case 1:
                        updateProductStock();
                        break;
                    case 2:
                        addNewProduct();
                        break;
                    case 3:
                        System.out.println("관리자 모드를 종료합니다.");
                        return; 
                    default:
                        System.out.println("1, 2, 3 중 하나를 선택해 주세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("유효한 숫자를 입력해주세요.");
            }
        }
    }
    
    // 재고 수정 메소드
    private void updateProductStock() {
        System.out.println("\n--- 1. 상품 재고 수정 ---");
        
        System.out.println("현재 상품 목록:");
        // ProductManager에 상품 리스트 들고 오기 (아직 수정 안함)
        
        System.out.print("재고를 수정할 상품 ID를 입력하세요: ");
        String productId = sc.nextLine();

        System.out.print("새로운 재고 수량을 입력하세요: ");
        try {
            int newStock = Integer.parseInt(sc.nextLine());
            
            // ProductManager를 통해 재고 수정 요청 (업뎃 스톡 아직 추가 안함)
            boolean success = productManager.updateStock(productId, newStock); 

            if (success) {
                System.out.println("상품 번호: " + productId + "의 재고가 " + newStock + "개로 수정되었습니다.");
            } else {
                System.out.println("해당 상품 번호 (" + productId + ")를 찾을 수 없습니다.");
            }
        } catch (NumberFormatException e) {
            System.out.println("재고 수량은 숫자로 입력해야 합니다.");
        }
    }
    
 
    // 상품 추가 메소드
    private void addNewProduct() {
        System.out.println("\n--- 2. 새 상품 등록 ---");
        
        System.out.print("새 상품의 번호를 입력해주세요: ");
        String id = sc.nextLine();
        
        System.out.print("새 상품 이름: ");
        String name = sc.nextLine();
        
        try {
            System.out.print("새 상품 가격: ");
            int price = Integer.parseInt(sc.nextLine());
            
            System.out.print("초기 재고 수량: ");
            int stock = Integer.parseInt(sc.nextLine());

            Product newProduct = new Product(id, name, price, stock); 
            
            // ProductManager에 새 상품 추가 (구현 아직 안함)
            boolean success = productManager.addProduct(newProduct);
            
            if (success) {
                System.out.println("새 상품 '" + name + "등록 완료.");
            } else {
                System.out.println(" 상품 등록에 실패 (이미 존재하는 상품 번호일 수 있습니다)");
            }

        } catch (NumberFormatException e) {
            System.out.println("가격과 재고 수량은 숫자로 입력해야 합니다.");
        }
    }
}
