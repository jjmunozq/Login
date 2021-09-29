package log;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JPasswordField;
import javax.swing.border.CompoundBorder;
import javax.swing.ImageIcon;

public class PanelLogin extends JFrame {

	private JPanel contentPane;
	private JLabel titulo;
	public static JTextField text_cedula_l;
	public static JPasswordField passwordField_log;
	final validar_datos validarloggin = new validar_datos();
	public static Registro registro = new Registro();  
	final Administracion admin = new Administracion();
	final menu_usuario usermenu = new menu_usuario();
	

	
	public PanelLogin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder());
		setContentPane(contentPane);
		contentPane.setLayout(null);

		titulo = new JLabel("Bienvenido");
		titulo.setVerticalAlignment(SwingConstants.TOP);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 25));
		titulo.setBounds(168, 16, 110, 27);
		contentPane.add(titulo); 

		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		lblNewLabel.setBounds(78, 92, 62, 14);
		contentPane.add(lblNewLabel);

		text_cedula_l = new JTextField();
		text_cedula_l.setBounds(244, 89, 89, 20);
		contentPane.add(text_cedula_l);
		text_cedula_l.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		lblNewLabel_1.setBounds(78, 145, 89, 14);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent validar) {
				Usuarios usu = new Usuarios(text_cedula_l.getText());	
	            String passoriginal= usu.getContrasena();
	            String pass= text_cedula_l.getText();
	            String rol = usu.getRol();
	            System.out.println("Contraseña original: "+passoriginal+"   contraseña escrita: "+pass);
				if (validarloggin.probarloggin() == 1 ) {
					JOptionPane.showMessageDialog(null, "Datos incompletos");				
					
				}else if(validarloggin.probarloggin() == 0 && rol.equals("admin") ) {
					
					JOptionPane.showMessageDialog(null, "Bienvenido Admin");
					admin.setVisible(true);
					dispose();
  
				}else {
					JOptionPane.showMessageDialog(null, "Bienvenido");
					usermenu.setVisible(true); //se pone el menu del usuario
					dispose();
				}

			}
		});
		btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnNewButton.setBounds(113, 205, 89, 23);
		contentPane.add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("Registrarse");
		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent registrar) {
			
				new Registro().setVisible(true);
		
			}
		});
		btnNewButton_1.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnNewButton_1.setBounds(244, 205, 119, 23);
		contentPane.add(btnNewButton_1);
		
		passwordField_log = new JPasswordField();
		passwordField_log.setBounds(244, 143, 89, 20);
		contentPane.add(passwordField_log);

	}
}
