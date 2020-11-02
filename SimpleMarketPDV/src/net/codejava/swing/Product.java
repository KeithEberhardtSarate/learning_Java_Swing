package net.codejava.swing;

public class Product {
	public int id;
	public String description;
	public Double unitPrice;
	public int qtdStock;
	public String imageSrc;
	
	public Product(int id, String description, Double unitPrice, int qtdStock, String imageSrc) {
		this.id = id;
		this.description = description;
		this.unitPrice = unitPrice;
		this.qtdStock = qtdStock;
		this.imageSrc = imageSrc;
	}
	
	public void DecreaseQtdStock() {
		if(this.qtdStock > 0) {
			this.qtdStock--;
		}		
	}
	
	public void IncreaseQtdStock() {
		this.qtdStock++;
	}
}
