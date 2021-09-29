package log;

public class validar_datos {
	public validar_datos() {

	}
	String nombre_a ="";
	String edad_a ="";
	String contrasena_a ="";
	String cedula_a ="";
	String direccion_a="";
	String estrato_a ="";
	String ciudad_a ="";
	String pass_a="";
	String Rpass_a="";

	String nombre ="";
	String edad ="";
	String contrasena ="";
	String cedula ="";
	String direccion="";
	String estrato ="";
	String ciudad ="";
	String pass="";
	String Rpass="";
	String Contrasenalog=("");
	String cedula_log=("");
	

	public int probarDatos() {
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

				
		if (nombre.equals("") || contrasena.equals("")|| edad.equals("")|| cedula.equals("")|| direccion.equals("")|| estrato.equals("")
				|| ciudad.equals("")||  Rpass.equals("")) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public int actualizarDatos() {
		nombre_a = Actualizar.update_nombre.getText();	
		edad_a = Actualizar.update_edad.getText();	
		cedula_a = Actualizar.update_cedula.getText();	
		direccion_a = Actualizar.update_direccion.getText();		
		estrato_a = Actualizar.update_estrato.getText();	
		ciudad_a = Actualizar.update_ciudad.getText(); 	
		contrasena_a = Actualizar.update_passwordField.getText();	
		Rpass_a = Actualizar.update_passwordField_1.getText();
		

				
		if (nombre_a.equals("") || contrasena_a.equals("")|| edad_a.equals("")|| cedula_a.equals("")|| direccion_a.equals("")|| estrato_a.equals("")
				|| ciudad_a.equals("")||  Rpass_a.equals("")) {
			return 1;
		} else {
			return 0;
		}
	}
	public int probarContrasena(){
		pass = Registro.passwordField.getText();
		Rpass = Registro.passwordField_1.getText();
		if (pass.equals(Rpass)) {
			return 1;
			
		} else {
			return 0;
			

		}
		
	}
	public int probarContrasenaUpdate(){
		pass = Actualizar.update_passwordField.getText();
		Rpass = Actualizar.update_passwordField_1.getText();
		if (pass.equals(Rpass)) {
			return 1;
			
		} else {
			return 0;
			

		}
		
	}
	public int probarloggin() {	
		Contrasenalog = PanelLogin.passwordField_log.getText();
		cedula_log = PanelLogin.text_cedula_l.getText();
		if (cedula_log.equals("")|| Contrasenalog.equals("")) {
			return 1;
		}else {
			return 0;
		}
	}
	

}
//(texto_nombre == null || texto_edad == null || texto_cedula == null || texto_direccion == null 
//|| texto_estrato == null || texto_ciudad == null || passwordField == null || passwordField_1 == null)