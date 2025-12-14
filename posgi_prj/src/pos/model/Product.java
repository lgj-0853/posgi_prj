package pos.model; // 시스템에서 사용되는 순수한 데이터 객체들


public class Product { // 상품 정보의 틀: 상품 하나의 데이터(코드, 이름, 가격, 재고)를 담기 위한 설계도.
	
		private String code;  
		private String name; 
		private int price;    
		private int stock;    

		//생성자
		public Product() {
			
		}
	    
	    // 초기화
		public Product(String code, String name, int price, int stock) {
			this.code = code;
			this.name = name;
			this.price = price;
			this.stock = stock;
		}

		
		// Getter 및 Setter 
		public String getCode() {
			return code;
		}
		
		public void setCode(String code) {
			this.code = code;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}

		
		public int getPrice() {
			return price;
		}

		
		public void setPrice(int price) {
			this.price = price;
		}


		public int getStock() {
			return stock;
		}

		
		public void setStock(int stock) {
			this.stock = stock;
		}
		
		
		@Override
		public String toString() {
			return "Product [code=" + code + ", name=" + name + ", price=" + price + ", stock=" + stock + "]";
		}

		
		/*
		public static void main(String[] args) {
			// TODO Auto-generated method stub
		}
		*/
	}