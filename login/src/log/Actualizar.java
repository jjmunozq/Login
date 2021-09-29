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

public class Actualizar extends JFrame {

	private JPanel contentPane;
	public static JTextField update_nombre;
	public static JTextField update_edad;
	public static JTextField update_cedula;
	public static JTextField update_direccion;
	public static JTextField update_estrato;
	public static JTextField update_ciudad;
	public static JPasswordField update_passwordField;
	public static JPasswordField update_passwordField_1;
	final validar_datos ValidarcontrasenaUpdate = new validar_datos();
	final validar_datos validar_update = new validar_datos(); 
	
	
	
	public Actualizar() {
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

		JLabel lblNewLabel_8 = new JLabel("Confirmar Contrase\u00F1a");
		lblNewLabel_8.setBounds(77, 286, 178, 14);
		contentPane.add(lblNewLabel_8);

		update_nombre = new JTextField();
		update_nombre.setBounds(272, 73, 228, 20);
		contentPane.add(update_nombre);
		update_nombre.setColumns(10);

		update_edad = new JTextField();
		update_edad.setColumns(10);
		update_edad.setBounds(272, 101, 228, 20);
		contentPane.add(update_edad);

		update_cedula = new JTextField();
		update_cedula.setColumns(10);
		update_cedula.setBounds(272, 156, 228, 20);
		contentPane.add(update_cedula);

		update_direccion = new JTextField();
		update_direccion.setColumns(10);
		update_direccion.setBounds(272, 181, 228, 20);
		contentPane.add(update_direccion);

		update_estrato = new JTextField();
		update_estrato.setColumns(10);
		update_estrato.setBounds(272, 207, 228, 20);
		contentPane.add(update_estrato);

		update_ciudad = new JTextField();
		update_ciudad.setColumns(10);
		update_ciudad.setBounds(272, 232, 228, 20);
		contentPane.add(update_ciudad);

		update_passwordField = new JPasswordField();
		update_passwordField.setBounds(272, 259, 228, 20);
		contentPane.add(update_passwordField);

		update_passwordField_1 = new JPasswordField();
		update_passwordField_1.setBounds(272, 286, 228, 20);
		contentPane.add(update_passwordField_1);
			 
		JComboBox caja_sexo = new JComboBox();
		caja_sexo.setModel(new DefaultComboBoxModel(new String[] { "", "Mujer", "Hombre", "Otr@" }));
		caja_sexo.setBounds(272, 128, 228, 22);
		contentPane.add(caja_sexo);
 
		JLabel lblNewLabel_9 = new JLabel("ACTUALIZAR");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Tw Cen MT", Font.BOLD, 25));
		lblNewLabel_9.setBounds(224, 11, 141, 23);
		contentPane.add(lblNewLabel_9);
		
		JButton btn_update = new JButton("Validar");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (validar_update.actualizarDatos() == 1) {
					JOptionPane.showMessageDialog(null, "Datos incompletos");				
					
				}else if (validar_update.probarContrasenaUpdate()==0 ){ 
					JOptionPane.showMessageDialog(null, "Las contrasenas no son iguales");
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
					nombre = Actualizar.update_nombre.getText();	
					edad = Actualizar.update_edad.getText();	
					cedula = Actualizar.update_cedula.getText();	
					direccion = Actualizar.update_direccion.getText();		
					estrato = Actualizar.update_estrato.getText();	
					ciudad = Actualizar.update_ciudad.getText(); 	
					contrasena = Actualizar.update_passwordField.getText();	
					Rpass = Actualizar.update_passwordField_1.getText();
					Contrasenalog = PanelLogin.passwordField_log.getText();
					
					Usuarios usu = new Usuarios(cedula,Integer.parseInt(edad), Integer.parseInt(estrato),nombre, sex, direccion,
							ciudad, contrasena, "User");
					usu.actualizar();
					JOptionPane.showMessageDialog(null, "Registro actualizado");
					dispose();
				}
			}
		});
		btn_update.setBounds(250, 317, 89, 23);
		contentPane.add(btn_update);
		
		JButton atras = new JButton("\u2190");
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				dispose();
				 
			}  
		}); 
		atras.setBounds(10, 15, 89, 23);
		contentPane.add(atras);

	
	}
}