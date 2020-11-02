package net.codejava.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;

public class PesoIdealApp extends JFrame {

	private JPanel contentPane;
	private JTextField inputAltura;
	private JLabel lblResultado;
	private JComboBox comboBoxSexo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesoIdealApp frame = new PesoIdealApp();
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
	public PesoIdealApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setBounds(10, 11, 46, 14);
		contentPane.add(lblAltura);
		
		inputAltura = new JTextField();
		inputAltura.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				jTextFieldKeyTyped(e);
			}
		});
		inputAltura.setBounds(59, 8, 236, 20);
		contentPane.add(inputAltura);
		inputAltura.setColumns(10);		
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(10, 46, 46, 14);
		contentPane.add(lblSexo);
		
		comboBoxSexo = new JComboBox(new String[]{"Masculino","Feminino"});
		comboBoxSexo.setBounds(59, 42, 236, 22);
		contentPane.add(comboBoxSexo);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
					Double altura = Double.parseDouble(inputAltura.getText());
					
					String pesoIdeal = calculaPesoIdeal(altura);
					
					String resultado = "Resultado: " + pesoIdeal + "Kg";
					
					lblResultado.setText(resultado);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(PesoIdealApp.this, "Altura inválida");
				}	
			}			
		});
		btnCalcular.setBounds(10, 86, 92, 23);
		contentPane.add(btnCalcular);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(107, 86, 92, 23);
		contentPane.add(btnLimpar);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String[] options = {"Sim", "Não"};
				 
			     int selectedOption = JOptionPane.showOptionDialog(null, "Deseja realmente fechar?",
			             	"Fechar",
			                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
			     
			     if (selectedOption == 0) {
			    	 System.exit(1);
				 }
			}
		});
		btnFechar.setBounds(203, 86, 92, 23);
		contentPane.add(btnFechar);
		
		lblResultado = new JLabel("Resultado:");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblResultado.setBounds(10, 137, 285, 20);
		contentPane.add(lblResultado);
	}
	
	private String calculaPesoIdeal(Double altura) {
		Double pesoIdeal = 0.0;
		DecimalFormat df = new DecimalFormat("#,###.00");
		
		if(comboBoxSexo.getSelectedItem() == "Masculino") {
			pesoIdeal = (72.6 * altura) - 58;
		}
		
		if(comboBoxSexo.getSelectedItem() == "Feminino") {
			pesoIdeal = (62.1 * altura) - 44.7;
		}
		
		return df.format(pesoIdeal); 
	}
	
	private void limpar() {
		inputAltura.setText("");
		lblResultado.setText("Resultado:");
	}
	
	private void jTextFieldKeyTyped(KeyEvent evt) {
		String caracteres = "0987654321.";
		if(!caracteres.contains(evt.getKeyChar()+"")){
			evt.consume();
		}
	}
}
