/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author oscar
 */
public class ControladorUsuario {
    static Conexion cn;
    static ResultSet rs;
    private static boolean cambio;

    public static boolean isCambio() {
        return cambio;
    }

    public static void setCambio(boolean cambio) {
        ControladorUsuario.cambio = cambio;
    }
    
    
    public static void Agregar(Usuario pv)throws ErrorTienda{
        try {
            cn=new Conexion();
            cn.st.executeUpdate("INSERT INTO usuario(idUsuario,Nombres,Apellidos, Sexo, FechaNacimiento, DUI, NIT, Direccion, Usuario, Clave) VALUES('"+pv.getIdUsuario()+"','"+pv.getNombres()+"','"+pv.getApellidos()+"','"+pv.getSexo()+"','"+pv.getFechaNacimiento()+"','"+pv.getDUI()+"','"+pv.getNIT()+"','"+pv.getDireccion()+"','"+pv.getUsuario()+"','"+pv.getClave()+"')");
            
        } catch (SQLException ex) {
            throw new ErrorTienda("Class ControladorUsuario/Agregar", ex.getMessage());
        }
    }
    
    public static void AgregarRol(Usuario pv)throws ErrorTienda{
        try {
            cn=new Conexion();
            cn.st.executeUpdate("INSERT INTO usuarioroles(idUsuario,idRol) VALUES('"+pv.getIdUsuario()+"','"+pv.getRol()+"')");
            
        } catch (SQLException ex) {
            throw new ErrorTienda("Class ControladorUsuario/AgregarRolUsuarios", ex.getMessage());
        }
    }
    
    
        public static String ObtenerPass(String id)throws ErrorTienda{
        String Usuario="";   
        cn = new Conexion();
        try {
        rs = cn.st.executeQuery("SELECT Clave FROM usuario WHERE Login='"+id+"';");
            while(rs.next()){
                Usuario = rs.getString(1);
            }
        }catch (Exception ex){
            throw new ErrorTienda("Class ControladorUsuario/ObtenerPass", ex.getMessage());
        } 
        return Usuario;
    
    }
    
    public static String obtenerNombres(String id)throws ErrorTienda{
        String Usuario="";   
        cn = new Conexion();
        try {
        rs = cn.st.executeQuery("SELECT Nombres FROM usuarios WHERE Usuario='"+id+"';");
            while(rs.next()){
                Usuario = rs.getString(1);
            }
        }catch (Exception ex){
            throw new ErrorTienda("Class ControladorProveedor/ObtenerIdProveedor", ex.getMessage());
        } 
        return Usuario;
    
    }    
    
    public static String obtenerRol(String id)throws ErrorTienda{
        String rol="";   
        cn = new Conexion();
        try {
        rs = cn.st.executeQuery("SELECT Rol FROM usuario WHERE Login='"+id+"';");
            while(rs.next()){
                rol = rs.getString(1);
            }
        }catch (Exception ex){
            throw new ErrorTienda("Class ControladorUsuario/ObtenerRol", ex.getMessage());
        } 
        return rol;
    
    }    
    public static int ObtenerIdUsuario()throws ErrorTienda{
        int Usuario=0;   
        cn = new Conexion();
        try {
        rs = cn.st.executeQuery("SELECT max(idUsuario) FROM usuarios");
        
            while(rs.next()){
                Usuario = rs.getInt(1);
            }
        }catch (Exception ex){
            throw new ErrorTienda("Class ControladorProveedor/ObtenerIdProveedor", ex.getMessage());
        } 
        return Usuario;
    
    }
    
    public static int ObtenerIdUser(String login) throws ErrorTienda{
        int user=0;
        cn= new Conexion();
        try {
            rs = cn.st.executeQuery("SELECT IdUsuario FROM usuarios WHERE Login = '"+login+"';");
            while (rs.next()) {
                user = rs.getInt(1);
            }
        } catch (SQLException ex) {
            throw new ErrorTienda("Class ControladorProveedor/ObtenerIdUser", ex.getMessage());
        }
        return user;
    }

}
