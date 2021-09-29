package log;

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
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Registro extends JFrame {

	private JPanel contentPane;
	public static JTextField texto_nombre;
	public static JTextField texto_edad;
	public static JTextField texto_cedula;
	public static JTextField texto_direccion;
	public static JTextField texto_estrato;
	public static JTextField texto_ciudad;
	public static JPasswordField passwordField;
	public static JPasswordField passwordField_1;
	final validar_datos validardatos = new validar_datos(); 
	final validar_datos Validarcontrasena = new validar_datos();
	

	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("  Nombre Completo");
		lblNewLabel.setBounds(99, 82, 152, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("    Edad");
		lblNewLabel_1.setBounds(161, 107, 90, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("    Sexo");
		lblNewLabel_2.setBounds(161, 132, 90, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("    Cedula");
		lblNewLabel_3.setBounds(152, 157, 99, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("   Direccion ");
		lblNewLabel_4.setBounds(139, 182, 112, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Estrato socioeconomico");
		lblNewLabel_5.setBounds(64, 213, 187, 14);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("    Ciudad");
		lblNewLabel_6.setBounds(152, 238, 99, 14);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("   Contrase\u00F1a ");
		lblNewLabel_7.setBounds(127, 263, 124, 14);
		contentPane.add(lblNewLabel_7);

		texto_nombre = new JTextField();
		texto_nombre.setBounds(272, 73, 228, 20);
		contentPane.add(texto_nombre);
		texto_nombre.setColumns(10);

		texto_edad = new JTextField();
		texto_edad.setColumns(10);
		texto_edad.setBounds(272, 101, 228, 20);
		contentPane.add(texto_edad);

		texto_cedula = new JTextField();
		texto_cedula.setColumns(10);
		texto_cedula.setBounds(272, 156, 228, 20);
		contentPane.add(texto_cedula);

		texto_direccion = new JTextField();
		texto_direccion.setColumns(10);
		texto_direccion.setBounds(272, 181, 228, 20);
		contentPane.add(texto_direccion);

		texto_estrato = new JTextField();
		texto_estrato.setColumns(10);
		texto_estrato.setBounds(272, 207, 228, 20);
		contentPane.add(texto_estrato);

		texto_ciudad = new JTextField();
		texto_ciudad.setColumns(10);
		texto_ciudad.setBounds(272, 232, 228, 20);
		contentPane.add(texto_ciudad);

		passwordField = new JPasswordField();
		passwordField.setBounds(272, 259, 228, 20);
		contentPane.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(272, 286, 228, 20);
		contentPane.add(passwordField_1);

		JComboBox caja_sexo = new JComboBox();
		caja_sexo.setModel(new DefaultComboBoxModel(new String[] { "", "Mujer", "Hombre", "Otr@" }));
		caja_sexo.setBounds(272, 128, 228, 22);
		contentPane.add(caja_sexo);
 
		JLabel lblNewLabel_9 = new JLabel("REGISTRO");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Tw Cen MT", Font.BOLD, 25));
		lblNewLabel_9.setBounds(241, 11, 124, 23);
		contentPane.add(lblNewLabel_9);
		
		JButton btnNewButton = new JButton("Validar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (validardatos.probarDatos() == 1) {
					JOptionPane.showMessageDialog(null, "Datos incompletos");				
					
				}else if (Validarcontrasena.probarContrasena()==0 ){ 
					JOptionPane.showMessageDialog(null, "Las contrase�as no son iguales");
				}	
				else{
				String nombre ="";
				String edad ="";
				String contrasena ="";
				String sex ="";
				String cedula ="";
				String direccion="";
				String estrato ="";
				String ciudad ="";
				String pass="";
				String Rpass="";
				String Contrasenalog=("");
				String cedula_log=("");
				
				sex = (String) caja_sexo.getSelectedItem();
				nombre = Registro.texto_nombre.getText();	
				edad = Registro.texto_edad.getText();	
				cedula = Registro.texto_cedula.getText();	
				direccion = Registro.texto_direccion.getText();		
				estrato = Registro.texto_estrato.getText();	
				ciudad = Registro.texto_ciudad.getText(); 	
				contrasena = Registro.passwordField.getText();	
				Rpass = Registro.passwordField_1.getText();
				Contrasenalog = PanelLogin.passwordField_log.getText();
				cedula_log = PanelLogin.text_cedula_l.getText();
				Usuarios usu = new Usuarios(cedula,Integer.parseInt(edad), Integer.parseInt(estrato),nombre, sex, direccion,
						ciudad, contrasena, "User");
				usu.Guardar();
					JOptionPane.showMessageDialog(null, "Registro valido");
					dispose();
				}
			}
		});
		btnNewButton.setBounds(127, 341, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton atras = new JButton("\u2190");
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				dispose();
				 
			}  
		}); 
		atras.setBounds(10, 15, 89, 23);
		contentPane.add(atras);
		
		JLabel lblNewLabel_8_1 = new JLabel("Confirmar Contraseña");
		lblNewLabel_8_1.setBounds(99, 289, 178, 14);
		contentPane.add(lblNewLabel_8_1);

	
	}
}
