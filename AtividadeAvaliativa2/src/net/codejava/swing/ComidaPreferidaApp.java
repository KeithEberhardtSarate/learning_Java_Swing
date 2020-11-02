package net.codejava.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ComidaPreferidaApp extends JFrame {

	private JPanel contentPane;
	private JTextField comidaPreferida;
	private JButton btnInformarComida;
	private JButton btnBGAzul;
	private JButton btnClick;
	private JButton btnSair;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComidaPreferidaApp frame = new ComidaPreferidaApp();
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
	public ComidaPreferidaApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Comida Preferida:");
		lblNewLabel.setBounds(26, 11, 398, 14);
		contentPane.add(lblNewLabel);
		
		comidaPreferida = new JTextField();
		comidaPreferida.setBounds(26, 35, 386, 20);
		contentPane.add(comidaPreferida);
		comidaPreferida.setColumns(10);
		
		JButton btnComidaPreferida = new JButton("Comida");
		btnComidaPreferida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = comidaPreferida.getText().isEmpty() ? "Usuário não possui comida preferida!" : comidaPreferida.getText();
				
				JOptionPane.showMessageDialog(ComidaPreferidaApp.this, message);
			}
		});
		btnComidaPreferida.setBounds(26, 66, 89, 23);
		contentPane.add(btnComidaPreferida);
		
		btnInformarComida = new JButton("Informar Comida");
		btnInformarComida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userOption = "";
				
				while(userOption.isEmpty()){
					userOption = JOptionPane.showInputDialog(ComidaPreferidaApp.this, "Informe sua comida preferida");
		        }				
				
				comidaPreferida.setText(userOption);
			}
		});
		btnInformarComida.setBounds(26, 115, 130, 23);
		contentPane.add(btnInformarComida);
		
		btnBGAzul = new JButton("Azul");
		btnBGAzul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.BLUE);
			}
		});
		btnBGAzul.setBackground(Color.BLUE);
		btnBGAzul.setBounds(176, 115, 109, 23);
		contentPane.add(btnBGAzul);
		
		btnClick = new JButton("Click");
		btnClick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(ComidaPreferidaApp.this, "Botão Click foi pressionado");
			}
		});
		btnClick.setBounds(303, 115, 109, 23);
		contentPane.add(btnClick);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedOption = JOptionPane.showConfirmDialog(ComidaPreferidaApp.this, 
                        "Deseja realmente sair?", 
                        "Sair", 
                        JOptionPane.YES_NO_OPTION); 
				
						if (selectedOption == JOptionPane.YES_OPTION) {
							System.exit(1);
						}
			}
		});
		btnSair.setBounds(303, 194, 109, 23);
		contentPane.add(btnSair);
	}
}
