/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.servicios;



import bd.general.FabricaDAO;
import bd.general.MySqlDAO;
import bd.general.PostgresDAO;
import bd.interfase.IMySqlDAO;
import bd.interfase.IPostgresDAO;



/**
 *
 * @author va
 */
public class FabricaRepositorios  {
    
    public FabricaRepositorios() throws Exception {
    }
    
     
    public static IPostgresDAO crearRepositorioPostgres() throws Exception{
        PostgresDAO postgresDAOFactory = (PostgresDAO) FabricaDAO.getDAOFactory(1);
        return postgresDAOFactory;
    }
    
     public static IMySqlDAO crearRepositorioMysql() throws Exception{
         MySqlDAO mySqlDAO = (MySqlDAO) FabricaDAO.getDAOFactory(2);
        return mySqlDAO;
    }
    
}
