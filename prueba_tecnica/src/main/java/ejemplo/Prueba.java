/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;

import aplicacion.servicios.FabricaRepositorios;
import bd.general.PostgresDAO;
import ejemplo.controlador.GestorUsuario;
import ejemplo.modelo.Usuario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author jk
 */
@ManagedBean
public class Prueba {
    
    private String codigo,nombre,apellido;
    
    public static void main(String args[]) {
        
     /*   Prueba prueba = new Prueba();
        List<Usuario> lista;
        try {
            lista = prueba.listadoUsuarios();
            for (Usuario lista1 : lista) {

                System.out.println("codigo==>" + lista1.getCodigo());
               
            }
        } catch (Exception ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
*/
    }

   
    
    public void resultado(){
    Prueba prueba = new Prueba();
        List<Usuario> lista;
        try {
            lista = prueba.listadoUsuarios();
            for (Usuario lista1 : lista) {

                System.out.println("Usuario==>" + lista1.getNombre());
                 System.out.println("Apellido==>" + lista1.getApellido());
                System.out.println("Codigo==>" + lista1.getCodigo());
            }
        } catch (Exception ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Usuario> listadoUsuarios() throws Exception {
        GestorUsuario gestorUsuario = new GestorUsuario();
        return gestorUsuario.listadoUsuariosPostgres();
    }
    
    public void eliminar() throws Exception{
        GestorUsuario gestorUsuario = new GestorUsuario();
        Usuario usuario = new Usuario();
        usuario.setCodigo(codigo);
        gestorUsuario.eliminarUsuario(usuario);        
    }
    
    public void insertar() throws Exception{
        GestorUsuario gestorUsuario = new GestorUsuario();
        Usuario usuario = new Usuario();
        usuario.setCodigo(codigo);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        gestorUsuario.insertarUsuario(usuario);
    }
    
    public void modificar() throws Exception{
        GestorUsuario gestorUsuario = new GestorUsuario();
        Usuario usuario = new Usuario();
        usuario.setCodigo(codigo);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        gestorUsuario.modicicarUsuario(usuario);
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
