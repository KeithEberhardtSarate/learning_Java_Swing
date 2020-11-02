package net.codejava.swing;

public class OrderItem {
	public Product product;
	public int qtd;
	public Double total;
	
	public OrderItem(Product product) {
		this.product = product;
		this.qtd = 1;
		this.total = product.unitPrice;
	}
	
	public void setTotal() {
		this.total = this.product.unitPrice * this.qtd;
	}
	
	public void changeQtd() {
		this.qtd = this.qtd + 1;
		this.product.DecreaseQtdStock();
		this.setTotal();
	}
}
