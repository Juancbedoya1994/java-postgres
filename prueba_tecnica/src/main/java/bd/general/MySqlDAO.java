/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.general;

import bd.interfase.IMySqlDAO;
import controlador.modelo.general.Propiedades;
import java.sql.Connection;

/**
 *
 * @author jk
 */
public class MySqlDAO extends FabricaDAO implements IMySqlDAO{
    private BaseDatos bd;
    public  Connection conexion;
    
    public MySqlDAO()  throws Exception {
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

    public MySqlDAO getFabricaMySqlDAO() throws Exception {
      return new MySqlDAO();
    }
    

    
}
