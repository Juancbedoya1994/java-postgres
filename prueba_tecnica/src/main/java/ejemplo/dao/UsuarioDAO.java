/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo.dao;

import bd.general.Consulta;
import ejemplo.modelo.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jk
 */
public class UsuarioDAO {
    
     private Connection conexion;

    public UsuarioDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public UsuarioDAO() {
    }

   
    public ArrayList<Usuario> consultarListaUsuarios() throws SQLException {
        Usuario usuario = new Usuario();
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();


        Consulta consulta = null;
        ResultSet rs;
        try {
            consulta = new Consulta(conexion);
            String sql = "select id_usuario,nombre,apellido from public.usuarios ";
            rs = consulta.ejecutar(sql);
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setCodigo(rs.getString("id_usuario"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setNombre(rs.getString("nombre"));
              
                listaUsuarios.add(usuario);
            }
    
            return listaUsuarios;
        } catch (SQLException e) {
            throw e;
        } finally {
            consulta.desconectar();
        }
    }
    
    public void eliminarUsuario(Usuario usuario) throws Exception{
        Consulta consulta= null;
        
        try {
            consulta = new Consulta(conexion);
            String sql = "DELETE from public.usuarios\n"
                    + "WHERE id_usuario = @id_persona; ";
            sql=sql.replace("@id_persona", usuario.getCodigo());
            consulta.actualizar(sql);
            
        } catch (Exception e) {
            throw e;
        }finally{
           consulta.desconectar();
        }
    }
    
    public void insertarUsuario(Usuario u) throws Exception{
        Consulta consulta = null;
        
        try {
            consulta = new Consulta(conexion);
            String sql = "INSERT INTO public.usuarios(id_usuario, nombre, apellido)\n"
	    +"VALUES ('@codigo@', '@nombre@','@apellido@');";
            sql = sql.replace("@codigo@", u.getCodigo());
            sql = sql.replace("@nombre@", u.getNombre());
            sql = sql.replace("@apellido@", u.getApellido());
            consulta.actualizar(sql);
            
        } catch (Exception e) {
             throw e;
        }finally{
           consulta.desconectar();
        }
    }
    
    public void modificarUsuario(Usuario u) throws Exception{
    Consulta consulta = null;
    
        try {
            consulta = new Consulta(conexion);
            String sql = "UPDATE public.usuarios SET id_persona='@codigo@', nombre='@nombre@', apellido='@apellido@'\n"+
            "WHERE <id_persona='@codigo@'>;";
            sql = sql.replace("@codigo@",u.getCodigo());
            sql = sql.replace("@nombre@",u.getNombre());
            sql = sql.replace("@apellido@",u.getApellido());
            consulta.actualizar(sql);
        } catch (Exception e) {
            throw e;
        }finally{
        consulta.desconectar();
        }
    }

    /**
     * @return the conexion
     */
    public Connection getConexion() {
        return conexion;
    }

    /**
     * @param conexion the conexion to set
     */
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    

    public void cerrarConexion() throws Exception {
        if (conexion != null) {
            conexion.close();
        }
        conexion=null;
    }
    
    
}

    

