/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.general;


import bd.interfase.IPostgresDAO;
import controlador.modelo.general.Propiedades;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author va
 */
public class PostgresDAO extends FabricaDAO implements IPostgresDAO{
    private BaseDatos bd;
    public  Connection conexion;
    
    public PostgresDAO()  throws Exception {
         bd = new BaseDatos(Propiedades.getInstancia().getPropiedades());
    }
   
       
    public PostgresDAO getFabricaPostgresDAO() throws Exception{
        return new PostgresDAO();
    }        
            

    public void abrirConexion() throws Exception {
        conexion = bd.getConexion();
    }

    public void cerrarConexion() throws Exception {
        if (conexion != null) {
            conexion.close();
        }
        conexion=null;
    }

    public void inicioTransaccion() throws Exception {
        bd.ejecutar(conexion, " BEGIN ");
    }

    public void finTransaccion() throws Exception {
        bd.ejecutar(conexion, " COMMIT ");
    }

    public void devolverTransaccion() throws Exception {
        bd.ejecutar(conexion, " ROLLBACK ");
    }
    

}
