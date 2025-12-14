package pos.manager;
import java.util.ArrayList;
import java.util.List;
import pos.model.Product; 		// Product 클래스를 사용하기 위한 import


public class ProductManager { 

    // List<Product> 자료구조 선언
    private List<Product> productList; 

    
    public ProductManager() {
       
        this.productList = new ArrayList<>();
        
       
       SampleData();
        
        System.out.println("총 " + productList.size() + "개 상품 로드됨.");
    }

    
    private void SampleData() {
         
        productList.add(new Product("001", "빼빼로", 1500, 10));
        productList.add(new Product("002", "구구콘", 8000, 25));
        productList.add(new Product("003", "포카칩", 2000, 50));
        productList.add(new Product("004", "참치삼김",1000, 30));
        productList.add(new Product("005", "왕뚜껑", 1800, 15));
    }
    
   
    public Product getProductByCode(String code) {
        if (code == null || code.trim().isEmpty()) {
            return null;
        }

        
        for (Product product : productList) {
            
            if (product.getCode().equals(code)) {
                return product; 
            }
        }
        
        return null; 
    }
    
    
	public static void main(String[] args) {
        
        ProductManager manager = new ProductManager();
        
        System.out.println("--- 상품 검색 테스트 ---");
        
        Product gugucorn = manager.getProductByCode("002");
        if (gugucorn != null) {
            System.out.println("검색 성공 (002): " + gugucorn.getName() + ", 가격: " + gugucorn.getPrice());
        } else {
            System.out.println("검색 실패 (002): 상품을 찾을 수 없음.");
        }
        

	}

}