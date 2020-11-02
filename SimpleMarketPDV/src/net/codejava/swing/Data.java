package net.codejava.swing;

import java.util.ArrayList;

public class Data {
	private ArrayList<Product> products;
	
	public Data() {
		this.products = new ArrayList<Product>();
		
		// Valores iniciais para simular um banco de dados
		this.AddProduct(new Product(1, "Coca cola lata 300ml", 3.5, 3, "/net/codejava/swing/images/prod1.png"));
		this.AddProduct(new Product(2, "Massa penne Knorr pacote 500g", 2.35, 1, "/net/codejava/swing/images/prod2.png"));
		this.AddProduct(new Product(3, "Molho pronto Quero bolonhesa", 1.90, 2, "/net/codejava/swing/images/prod3.png"));
		this.AddProduct(new Product(4, "Barra de chocolate Nestlé 90g", 3.00, 5, "/net/codejava/swing/images/prod4.png"));
		this.AddProduct(new Product(5, "Arroz namorado pacote 1kg", 4.00, 5, "/net/codejava/swing/images/prod5.png"));
		this.AddProduct(new Product(6, "Feijão namorado pacote 1kg", 3.00, 3, "/net/codejava/swing/images/prod6.png"));
		this.AddProduct(new Product(7, "Sabão em pó brilhante pacote 1kg", 5.00, 3, "/net/codejava/swing/images/prod7.png"));
	}
	
	public void AddProduct(Product product) {
		this.products.add(product);
	}
	
	public ResponseData GetProductById(int id) {
		
		ResponseData response = new ResponseData(null, false);
		
		for (int i = 0; i < this.products.size(); i++) {
			Product prod = this.products.get(i);
			
			if(prod.id == id) {
				response.obj = prod;
				response.isValid = true;				
			}
		}
		
		return response;
	}
}