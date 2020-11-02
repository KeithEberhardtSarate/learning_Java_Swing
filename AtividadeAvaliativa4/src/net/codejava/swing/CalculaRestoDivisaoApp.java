package net.codejava.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculaRestoDivisaoApp extends JFrame {

	private JPanel contentPane;
	private JTextField valor1;
	private JTextField valor2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculaRestoDivisaoApp frame = new CalculaRestoDivisaoApp();
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
	public CalculaRestoDivisaoApp() {
		setTitle("Calcula Resto da Divis\u00E3o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblValor1 = new JLabel("Valor 1:");
		lblValor1.setBounds(20, 11, 46, 14);
		contentPane.add(lblValor1);
		
		JLabel lblValor2 = new JLabel("Valor 2:");
		lblValor2.setBounds(20, 36, 46, 14);
		contentPane.add(lblValor2);
		
		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setBounds(20, 95, 201, 14);
		contentPane.add(lblResultado);
		
		valor1 = new JTextField();
		valor1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				jTextFieldKeyTyped(e);
			}
		});
		valor1.setBounds(73, 8, 159, 20);
		contentPane.add(valor1);
		valor1.setColumns(10);
		
		valor2 = new JTextField();
		valor2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				jTextFieldKeyTyped(e);
			}
		});
		valor2.setBounds(73, 33, 159, 20);
		contentPane.add(valor2);
		valor2.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 
					int resultado = calculaRestoDaDivisao(Integer.parseInt(valor1.getText()), Integer.parseInt(valor2.getText()));
					lblResultado.setText(String.valueOf("Resultado: " + resultado));
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(CalculaRestoDivisaoApp.this, String.valueOf("Os campos Valor1 e Valor 2 devem ser maior que zero e menor que " + Integer.MAX_VALUE + " !"));
				} catch (ArithmeticException  ex) {
					JOptionPane.showMessageDialog(CalculaRestoDivisaoApp.this, "Valor 2 deve ser maior que zero!");
				}	
			}
		});
		btnCalcular.setBounds(20, 61, 98, 23);
		contentPane.add(btnCalcular);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valor1.setText("");
				valor2.setText("");
				lblResultado.setText("Resultado: ");
			}
		});
		btnLimpar.setBounds(134, 61, 98, 23);
		contentPane.add(btnLimpar);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		btnFechar.setBounds(319, 209, 89, 23);
		contentPane.add(btnFechar);
		
		JButton btnMetal = new JButton("Metal");
		btnMetal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alteralookAndFeel("Metal");
			}
		});
		btnMetal.setBounds(63, 146, 89, 23);
		contentPane.add(btnMetal);
		
		JButton btnMotif = new JButton("Motif");
		btnMotif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alteralookAndFeel("CDE/Motif");
			}
		});
		btnMotif.setBounds(174, 146, 89, 23);
		contentPane.add(btnMotif);
		
		JButton btnWindows = new JButton("Windows");
		btnWindows.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alteralookAndFeel("Windows");
			}
		});
		btnWindows.setBounds(284, 146, 89, 23);
		contentPane.add(btnWindows);
	}
	
	private void jTextFieldKeyTyped(KeyEvent evt) {
		String caracteres = "0987654321";
		if(!caracteres.contains(evt.getKeyChar()+"")){
			evt.consume();
		}
	}
	
	private int calculaRestoDaDivisao(int valor1, int valor2) {
		return valor1%valor2;
	}
	
	private void alteralookAndFeel(String lf) {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			    if (lf.equals(info.getName())) {
			    	 UIManager.setLookAndFeel(info.getClassName());
				        SwingUtilities.updateComponentTreeUI(CalculaRestoDivisaoApp.this);
				        break;
			    }
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(CalculaRestoDivisaoApp.this, "Erro ao tentar alterar o layout");
		} 
	}
}
