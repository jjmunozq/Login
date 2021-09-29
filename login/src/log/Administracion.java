package log;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Administracion extends JFrame {

	private JPanel contentPane;
	
	
	public static Actualizar actualizar = new Actualizar(); 
	public static Registro registro = new Registro();
	private JTextField textField;
	
	
	
	public Administracion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Administracion");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		lblNewLabel.setBounds(187, 11, 108, 17);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(31, 61, 419, 170);
		contentPane.add(textArea);
		
		JButton buscar_a = new JButton("Buscar");
		buscar_a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuarios usu = new Usuarios(textField.getText());	
	            String resultado= usu.toString();	
	            textArea.setText(resultado);
	            
			}
		});
		buscar_a.setBounds(32, 32, 77, 23);
		contentPane.add(buscar_a);
		
		
		
		JButton btnNewButton = new JButton("Agregar Usuario");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				new Registro().setVisible(true);
                
			}
		});
		btnNewButton.setBounds(32, 259, 116, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Eliminar Usuario");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuarios usu = new Usuarios(textField.getText());	
	            usu.eliminar();
	            
			}
		});
		btnNewButton_1.setBounds(206, 259, 108, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Actualizacion");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Actualizar().setVisible(true);
                
			}
		});
		btnNewButton_2.setBounds(349, 259, 101, 23);
		contentPane.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(121, 33, 116, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}