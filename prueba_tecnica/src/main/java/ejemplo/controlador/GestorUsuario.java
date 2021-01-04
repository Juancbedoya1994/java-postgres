/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo.controlador;

import aplicacion.servicios.FabricaRepositorios;
import bd.general.MySqlDAO;
import bd.general.PostgresDAO;
import controlador.general.Gestor;
import ejemplo.dao.UsuarioDAO;
import ejemplo.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jk
 */
public class GestorUsuario extends Gestor{
    
    public GestorUsuario() throws Exception {
    }
      
    public List<Usuario>listadoUsuariosPostgres()throws Exception{
        List<Usuario> listaUsuario = new ArrayList<>();
        PostgresDAO postgresDAO = (PostgresDAO) FabricaRepositorios.crearRepositorioPostgres();
        postgresDAO.abrirConexion();
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.setConexion(postgresDAO.conexion);
        

        listaUsuario = usuarioDAO.consultarListaUsuarios();
        postgresDAO.cerrarConexion();
        return listaUsuario;
        
    }

  
    
    
    /*public List<Usuario>listadoUsuariosMysql()throws Exception{
        List<Usuario> listaUsuario = new ArrayList<Usuario>();
        MySqlDAO mySqlDAO = (MySqlDAO) FabricaRepositorios.crearRepositorioMysql();
        mySqlDAO.abrirConexion();
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.setConexion(mySqlDAO.conexion);
        

        listaUsuario = usuarioDAO.consultarListaUsuarios();
        mySqlDAO.cerrarConexion();
        return listaUsuario;
        
    }*/
    
    public void eliminarUsuario(Usuario usuario) throws Exception{
        PostgresDAO postgresDAO = (PostgresDAO)FabricaRepositorios.crearRepositorioPostgres();
        postgresDAO.abrirConexion();
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.setConexion(postgresDAO.conexion);
        usuarioDAO.eliminarUsuario(usuario);
        
        postgresDAO.cerrarConexion();
    }
    
    public void insertarUsuario(Usuario usuario) throws Exception{
      /*  PostgresDAO postgresDAO = (PostgresDAO)FabricaRepositorios.crearRepositorioPostgres();
        postgresDAO.abrirConexion();
        */
       this.abrirConexion();
        //UsuarioDAO usuarioDAO = new UsuarioDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO(this.staticconexion);
        //usuarioDAO.setConexion(postgresDAO.conexion);
        usuarioDAO.insertarUsuario(usuario);
        
        //postgresDAO.cerrarConexion();
        this.cerrarConexion();
    }
    
    public void modicicarUsuario(Usuario u) throws Exception{
        PostgresDAO postgresDAO = (PostgresDAO)FabricaRepositorios.crearRepositorioPostgres();
        postgresDAO.abrirConexion();
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.setConexion(postgresDAO.conexion);
        usuarioDAO.modificarUsuario(u);
        
        postgresDAO.cerrarConexion();
    }
}
