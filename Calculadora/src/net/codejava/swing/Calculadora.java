package net.codejava.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculadora extends JFrame {

	private JPanel contentPane;
	private JTextField inputValor1;
	private JTextField inputValor2;
	
	private String radioSeleciton;
	private JLabel lblResultado;
	
	private JCheckBox chckMostrarResultadoNaTela;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
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
	public Calculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 232, 271);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblValor1 = new JLabel("Valor 1:");
		lblValor1.setBounds(10, 14, 46, 14);
		contentPane.add(lblValor1);
		
		inputValor1 = new JTextField();
		inputValor1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				jTextFieldKeyTyped(e);
			}
		});
		inputValor1.setColumns(10);
		inputValor1.setBounds(59, 11, 149, 20);
		contentPane.add(inputValor1);
		
		JLabel lblValor2 = new JLabel("Valor 2:");
		lblValor2.setBounds(10, 42, 46, 14);
		contentPane.add(lblValor2);
		
		inputValor2 = new JTextField();
		inputValor2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				jTextFieldKeyTyped(e);
			}
		});
		inputValor2.setColumns(10);
		inputValor2.setBounds(59, 39, 149, 20);
		contentPane.add(inputValor2);
		
		JRadioButton radioBtnSomar = new JRadioButton("Somar");
		radioBtnSomar.setBounds(10, 66, 109, 23);
		contentPane.add(radioBtnSomar);
		
		JRadioButton radioBtnSubtrair = new JRadioButton("Subtrair");
		radioBtnSubtrair.setBounds(132, 66, 109, 23);
		contentPane.add(radioBtnSubtrair);
		
		JRadioButton radioBtnMultiplicar = new JRadioButton("Multiplicar");
		radioBtnMultiplicar.setBounds(10, 92, 109, 23);
		contentPane.add(radioBtnMultiplicar);
		
		JRadioButton radioBtnDividir = new JRadioButton("Dividir");
		radioBtnDividir.setBounds(132, 92, 109, 23);
		contentPane.add(radioBtnDividir);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(radioBtnSomar);
		bg.add(radioBtnSubtrair);
		bg.add(radioBtnMultiplicar);
		bg.add(radioBtnDividir);
		 
		radioBtnSomar.addActionListener(new RadioButtonListener());
		radioBtnSubtrair.addActionListener(new RadioButtonListener());
		radioBtnMultiplicar.addActionListener(new RadioButtonListener());
		radioBtnDividir.addActionListener(new RadioButtonListener());
		 
		chckMostrarResultadoNaTela = new JCheckBox("Mostrar resultado na tela");
		chckMostrarResultadoNaTela.setBounds(10, 129, 198, 23);
		contentPane.add(chckMostrarResultadoNaTela);
		 
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularFlow();
			}
		});
		btnCalcular.setBounds(10, 161, 89, 23);
		contentPane.add(btnCalcular);
		 
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(119, 161, 89, 23);
		contentPane.add(btnLimpar);
		 
		lblResultado = new JLabel("");
		lblResultado.setBounds(10, 205, 198, 14);
		contentPane.add(lblResultado);
	}
	
	class RadioButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JRadioButton radio = (JRadioButton) e.getSource();
            radioSeleciton = radio.getActionCommand();
        }

    }
	
	private void jTextFieldKeyTyped(KeyEvent evt) {
		String caracteres = "0987654321.";
		if(!caracteres.contains(evt.getKeyChar()+"")){
			evt.consume();
		}
	}
	
	private void calcularFlow() {
		try {	
			Double valor1 = Double.parseDouble(inputValor1.getText());
			Double valor2 = Double.parseDouble(inputValor2.getText());
			
			String resultado = calcular(valor1, valor2);
			
			if(chckMostrarResultadoNaTela.isSelected()) {
				lblResultado.setText(resultado);
			}else {
				lblResultado.setText("");
				JOptionPane.showMessageDialog(Calculadora.this, resultado);
			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(Calculadora.this, "Valor 1 e Valor 2 são obrigatórios");
		} catch (NullPointerException ex) {
			JOptionPane.showMessageDialog(Calculadora.this, "Escolha uma operação");
		} catch (ArithmeticException ex) {
			JOptionPane.showMessageDialog(Calculadora.this, "Valor 2 deve ser maior que Zero");
		}
	}
	
	private String calcular(Double valor1, Double valor2) {
		lblResultado.setText("");
		
		Double resultado = 0.0;
		DecimalFormat df = new DecimalFormat("#.##");
		
		switch (radioSeleciton){
        case "Somar":
            resultado = valor1 + valor2;
            break;
        case "Subtrair":
        	resultado = valor1 - valor2;
            break;
        case "Multiplicar":
        	resultado = valor1 * valor2;
            break;
        case "Dividir":
        	if(valor2 == 0 || valor2 == 0.0) {
				throw new ArithmeticException();
			}
        	resultado = valor1 / valor2;
            break;
		}
		
		return df.format(resultado);
	}
	
	private void limpar() {
		inputValor1.setText("");
		inputValor2.setText("");
		lblResultado.setText("");
	}
}
