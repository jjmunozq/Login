package log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Usuarios {
	
	DB base= new DB();  //instanciamos nuestra clase de base de datos
    public static Connection conexion;   //hacemos la conexión con ayuda de la clase DB	
    
	
	//Declaramos las variables
	int Edad, Estrato;
    String Nombres, Sexo, Direccion, Ciudad, Contrasena,Rol,Cedula;
		
    
    
    //Constructor
    public Usuarios(String cedula, int edad, int estrato, String nombres, String sexo, String direccion,
			String ciudad, String contrasena, String rol) {
		this.Cedula = cedula;
		this.Edad = edad;
		this.Estrato = estrato;
		this.Nombres = nombres;
		this.Sexo = sexo;
		this.Direccion = direccion;
		this.Ciudad = ciudad;
		this.Contrasena = contrasena;
		this.Rol = rol;
	}
	//Getters y Setters
    
    public String getCedula() {
		return Cedula;
	}
		
	public String getRol() {
		return Rol;
	}
	public void setRol(String rol) {
		Rol = rol;
	}
	public void setCedula(String cedula) {
		Cedula = cedula;
	}
	public int getEdad() {
		return Edad;
	}
	public void setEdad(int edad) {
		Edad = edad;
	}
	public int getEstrato() {
		return Estrato;
	}
	public void setEstrato(int estrato) {
		Estrato = estrato;
	}
	public String getNombres() {
		return Nombres;
	}
	public void setNombres(String nombres) {
		Nombres = nombres;
	}
	
	public String getSexo() {
		return Sexo;
	}
	public void setSexo(String sexo) {
		Sexo = sexo;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getCiudad() {
		return Ciudad;
	}
	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}
	public String getContrasena() {
		return Contrasena;
	}
	public void setContrasena(String Contrasena) {
		Contrasena = Contrasena;
	}
    
	//Metodos 
public boolean Guardar(){  //método para guardar el usuarioe actual en el constructor.
        
        try {
             
            conexion= base.GetConnection();
            PreparedStatement insertar= conexion.prepareStatement("insert into usuarios (Cedula,Nombres,Sexo,Edad,Direccion,Ciudad,Contrasena,Estrato,Rol) values(?,?,?,?,?,?,?,?,?) ");
            insertar.setString(1, Cedula);
            insertar.setString(2, Nombres);
            insertar.setString(3, Sexo);
            insertar.setInt(4, Edad);
            insertar.setString(5, Direccion);
            insertar.setString(6, Ciudad);
            insertar.setString(7, Contrasena);
            insertar.setInt(8, Estrato);
            insertar.setString(9, Rol);
            insertar.executeUpdate();
            conexion.close();
             JOptionPane.showMessageDialog(null,"Guardado!", "Éxito al Guardar",1);
            return true;
           
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Problema al insertar"+ex.getMessage(),"error",1);
            return false;
        }	
        
    }
		
@Override
public String toString() {
	return "Usuarios [Edad=" + Edad + ", Estrato=" + Estrato + ", Nombres=" + Nombres + ", Sexo=" + Sexo
			+ ", Direccion=" + Direccion + ", Ciudad=" + Ciudad + ", Contrasena=" + Contrasena + ", Rol=" + Rol
			+ ", Cedula=" + Cedula + "]";
}

public  void eliminar(){  //elimina el usuarioe actual en constructor
    conexion = base.GetConnection();
    try{
        PreparedStatement borrar = conexion.prepareStatement("DELETE  from usuarios where Cedula='"+this.Cedula+"'" );
     
        borrar.executeUpdate();
     //  JOptionPane.showMessageDialog(null,"borrado");
    }catch(SQLException ex){
        System.err.println("Ocurrió un error al borrar: "+ex.getMessage());
      
    }
 }

//Buscar todos los usuarios
public  List<Usuarios> getUsuarios(){  //retorna una  lista con todos los Usuarios en la database
    List<Usuarios> listaUsuarios = new ArrayList<Usuarios>();
    conexion = base.GetConnection();
    try{
        String consulta = "select Cedula from usuarios";
        PreparedStatement select = conexion.prepareStatement(consulta);
        boolean r = select.execute();
        if(r){
            ResultSet result = select.getResultSet();
            while(result.next()){
                Usuarios usuario = new Usuarios(result.getString(1));
                System.out.println(usuario);
                listaUsuarios.add(usuario);
            }
            result.close();
        }
        conexion.close();
    }catch(SQLException ex){
        System.out.println(ex.toString());
    }
    return listaUsuarios;
}

//busca un usuario con su cedula
public Usuarios(String Cedula){  //método que retorna atributos asociados con la cedula que recibamos
    conexion = base.GetConnection();
    PreparedStatement select;
    try {
        select = conexion.prepareStatement("select * from usuarios where Cedula = ?");
        select.setString(1, Cedula);
        boolean consulta = select.execute();
        if(consulta){
            ResultSet resultado =  select.getResultSet();
            if(resultado.next()){
                this.Cedula= resultado.getString(1);
                this.Nombres= resultado.getString(2);
   
                this.Sexo= resultado.getString(3);
                this.Edad= resultado.getInt(4);
                 this.Direccion= resultado.getString(5);
                 this.Ciudad=resultado.getString(6);
                 this.Contrasena=resultado.getString(7);
                 this.Estrato=resultado.getInt(8);
                 this.Rol=resultado.getString(9);
            }
            resultado.close();
        }
        conexion.close();
    } catch (SQLException ex) {
        System.err.println("Ocurrió un error: "+ex.getMessage().toString());
    }
}

public boolean actualizar(){  //actualiza el usuario actualmente apuntado en el constructor.
    conexion=base.GetConnection();
    if(conexion!=null){
    try{
        String peticion= "update usuarios set Cedula=? ,Nombres=? ,Sexo=? ,Edad=? ,Direccion=? ,Ciudad=? ,Contrasena=? ,Estrato=? ,Rol=?   where Cedula='";
        PreparedStatement actualizar= conexion.prepareStatement(peticion+this.Cedula+"'");
        actualizar.setString(1,this.Cedula);
        actualizar.setString(2,this.Nombres);
        actualizar.setString(3,this.Sexo);
        actualizar.setInt(4,this.Edad);
        actualizar.setString(5,this.Direccion);
        actualizar.setString(6,this.Ciudad);
        actualizar.setString(7,this.Contrasena);
        actualizar.setInt(8,this.Estrato);
        actualizar.setString(9,this.Rol);
        actualizar.executeUpdate();
        conexion.close();
        JOptionPane.showMessageDialog(null,"Usuario Actualizado","Éxito al actualizar",1);
        return true;
    }
    catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error al actualizar: "+ex.getMessage(),"error",1);
        return false;
    }}
    else{
        JOptionPane.showMessageDialog(null,"error al conectar","error",1);
        return false;
    }
}


}
