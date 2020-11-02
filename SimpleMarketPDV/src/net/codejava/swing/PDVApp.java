package net.codejava.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextPane;

public class PDVApp extends JFrame {

	private JPanel contentPane;	
	private Data data;
	private Order currentOrder;
	
	private JLabel lblOrderItemCandidateDescription;
	private JLabel lblOrderItemCandidateUnitPrice;
	private JLabel lblOrderItemCandidateImg;	
	private JLabel lblSubTotal;
	private JLabel lblOrderTotal;	
	private JLabel lblValorPago;
	private JLabel lblOrderPayment;
	private JLabel lblTroco;
	private JLabel lblOrderChange;
	
	private JTextPane txtpnOrderItems;
	
	private JButton btnAddToOrder;
	private JButton btnNewOrderItemCandidate;
	private JButton btnEndOrder;
	private JButton btnNewOrder;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PDVApp frame = new PDVApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PDVApp() {
		setResizable(false);		
		setTitle("Simple PDV");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblOrderItemCandidateImg = new JLabel("");
		lblOrderItemCandidateImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderItemCandidateImg.setIcon(new ImageIcon(PDVApp.class.getResource("/net/codejava/swing/images/defaultProd.png")));
		lblOrderItemCandidateImg.setBounds(10, 38, 100, 100);
		contentPane.add(lblOrderItemCandidateImg);
		
		lblOrderItemCandidateDescription = new JLabel("Produto");
		lblOrderItemCandidateDescription.setEnabled(false);
		lblOrderItemCandidateDescription.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblOrderItemCandidateDescription.setBounds(10, 11, 233, 25);
		contentPane.add(lblOrderItemCandidateDescription);
		
		lblOrderItemCandidateUnitPrice = new JLabel("R$ 0.00");
		lblOrderItemCandidateUnitPrice.setEnabled(false);
		lblOrderItemCandidateUnitPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOrderItemCandidateUnitPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderItemCandidateUnitPrice.setBounds(112, 38, 131, 100);
		contentPane.add(lblOrderItemCandidateUnitPrice);
		
		JLabel lblNewLabel_3 = new JLabel("Itens");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(272, 11, 278, 25);
		contentPane.add(lblNewLabel_3);
		
		lblSubTotal = new JLabel("Subtotal");
		lblSubTotal.setEnabled(false);
		lblSubTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lblSubTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSubTotal.setBounds(272, 294, 59, 14);
		contentPane.add(lblSubTotal);
		
		lblOrderTotal = new JLabel("R$ 0.00");
		lblOrderTotal.setEnabled(false);
		lblOrderTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOrderTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrderTotal.setBounds(370, 294, 180, 14);
		contentPane.add(lblOrderTotal);
		
		btnAddToOrder = new JButton("Adicionar ao pedido");		
		btnAddToOrder.setEnabled(false);
		btnAddToOrder.setBounds(10, 152, 233, 32);
		contentPane.add(btnAddToOrder);
		
		btnNewOrderItemCandidate = new JButton("Obter produto");		
		
		btnNewOrderItemCandidate.setBounds(10, 331, 233, 32);
		contentPane.add(btnNewOrderItemCandidate);
		
		btnEndOrder = new JButton("Finalizar Pedido");		
		btnEndOrder.setEnabled(false);
		btnEndOrder.setBounds(272, 331, 139, 32);
		contentPane.add(btnEndOrder);
		
		btnNewOrder = new JButton("Novo Pedido");
		btnNewOrder.setEnabled(false);		
		btnNewOrder.setBounds(431, 331, 119, 32);
		contentPane.add(btnNewOrder);
		
		txtpnOrderItems = new JTextPane();
		txtpnOrderItems.setEditable(false);
		txtpnOrderItems.setBounds(272, 38, 278, 245);
		contentPane.add(txtpnOrderItems);
		
		lblValorPago = new JLabel("");
		lblValorPago.setHorizontalAlignment(SwingConstants.LEFT);
		lblValorPago.setVerticalAlignment(SwingConstants.BOTTOM);
		lblValorPago.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblValorPago.setBounds(10, 215, 77, 14);
		contentPane.add(lblValorPago);
		
		lblOrderPayment = new JLabel("");
		lblOrderPayment.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrderPayment.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOrderPayment.setBounds(112, 214, 130, 14);
		contentPane.add(lblOrderPayment);
		
		lblTroco = new JLabel("");
		lblTroco.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTroco.setHorizontalAlignment(SwingConstants.LEFT);
		lblTroco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTroco.setBounds(10, 231, 77, 25);
		contentPane.add(lblTroco);
		
		lblOrderChange = new JLabel("");
		lblOrderChange.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrderChange.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOrderChange.setBounds(112, 239, 130, 14);
		contentPane.add(lblOrderChange);
		
		btnAddToOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processAddItemCandidateToOrder();
			}
		});
		
		btnNewOrderItemCandidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userOption = JOptionPane.showInputDialog(PDVApp.this, "Informe o código do produto");
				if(userOption != null) {
					newOrderItemCandidate(userOption);
				}
			}
		});
		
		btnEndOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				
				String userOption = JOptionPane.showInputDialog(PDVApp.this, "Informe o valor pago");
				
				if(userOption != null) {
					processEndOrder(userOption);
				}
			}
		});
		
		btnNewOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processNewOrder();
			}
		});
		
		data = new Data();
		
		currentOrder = new Order();
	}
	
	private void newOrderItemCandidate(String userOption) {
		try {	
			ResponseData response = data.GetProductById(Integer.parseInt(userOption));
			
			if(response.isValid) {
				currentOrder.setOrderItemCandidate((Product) response.obj);
				processNewOrderItemCandidate();
			}else {
				throw new Exception();						
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(PDVApp.this, "Produto não encontrado!");
		}		
	}
	
	private void processNewOrderItemCandidate() {		
		lblOrderItemCandidateDescription.setText(currentOrder.orderItemCandidate.product.description);
		lblOrderItemCandidateImg.setIcon(new ImageIcon(PDVApp.class.getResource(currentOrder.orderItemCandidate.product.imageSrc)));
		lblOrderItemCandidateUnitPrice.setText(NumberFormat.getCurrencyInstance().format(currentOrder.orderItemCandidate.product.unitPrice));
		
		currentOrder.orderItemCandidate.setTotal();
		
		lblOrderItemCandidateDescription.setEnabled(true);
		lblOrderItemCandidateUnitPrice.setEnabled(true);
		btnAddToOrder.setEnabled(true);
		btnAddToOrder.requestFocus();
	}
	
	private void processAddItemCandidateToOrder() {		
		try {
			currentOrder.addOrderItem(currentOrder.orderItemCandidate);
			
			String items = "";
			
			for (OrderItem item : currentOrder.getOrderItems()) {
				items += item.qtd + "x - " + item.product.description + " - " + NumberFormat.getCurrencyInstance().format(item.total) + "\n";
			}
			
			txtpnOrderItems.setText(items);
			lblOrderTotal.setText(NumberFormat.getCurrencyInstance().format(currentOrder.getSubtotal()));
			
			btnEndOrder.setEnabled(true);
			btnNewOrder.setEnabled(true);
			lblSubTotal.setEnabled(true);
			lblOrderTotal.setEnabled(true);			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(PDVApp.this, "Produto sem estoque!");
		}
	}
	
	private void processNewOrder() {
		int selectedOption = JOptionPane.showConfirmDialog(this, 
                "Deseja realmente iniciar um novo pedido?", 
                "Sair", 
                JOptionPane.YES_NO_OPTION); 
		
				if (selectedOption == JOptionPane.YES_OPTION) {
					resetOrder();
				}		
	}
	
	private void resetOrder() {
		currentOrder = new Order();
		lblOrderItemCandidateImg.setIcon(new ImageIcon(PDVApp.class.getResource("/net/codejava/swing/images/defaultProd.png")));
		
		lblOrderItemCandidateDescription.setText("Produto");
		lblOrderItemCandidateDescription.setEnabled(false);
		
		lblOrderItemCandidateUnitPrice.setText("R$ 0.00");
		lblOrderItemCandidateUnitPrice.setEnabled(false);
		
		lblOrderTotal.setText("R$ 0.00");
		lblOrderTotal.setEnabled(false);		
		lblSubTotal.setEnabled(false);	
		lblValorPago.setText("");
		lblOrderPayment.setText("");
		lblTroco.setText("");
		lblOrderChange.setText("");
		
		txtpnOrderItems.setText("");
		
		btnAddToOrder.setEnabled(false);
		btnEndOrder.setEnabled(false);
		btnNewOrder.setEnabled(false);
		btnNewOrderItemCandidate.setEnabled(true);
	}
	
	private void processEndOrder(String userOption) {
		try {	
			currentOrder.paymentValue =  Double.parseDouble(userOption);
			currentOrder.setChange();
			lblValorPago.setText("Valor pago");
			lblOrderPayment.setText(NumberFormat.getCurrencyInstance().format(currentOrder.paymentValue));
			lblTroco.setText("Troco");
			lblOrderChange.setText(NumberFormat.getCurrencyInstance().format(currentOrder.getChange()));
			
			lblOrderItemCandidateImg.setIcon(new ImageIcon(PDVApp.class.getResource("/net/codejava/swing/images/defaultProd.png")));
			lblOrderItemCandidateDescription.setText("Produto");
			lblOrderItemCandidateDescription.setEnabled(false);
			lblOrderItemCandidateUnitPrice.setText("R$ 0.00");
			lblOrderItemCandidateUnitPrice.setEnabled(false);
			btnAddToOrder.setEnabled(false);
			btnEndOrder.setEnabled(false);
			btnNewOrderItemCandidate.setEnabled(false);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(PDVApp.this, "Valor inválido!");
		}	
	}
}
