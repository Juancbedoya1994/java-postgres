/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.general;


import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author va
 */
public abstract class FabricaDAO {

    // List of DAO types supported by the factory
    public static final int POSTGRES = 1;
    public static final int MYSQL = 2;

    //public abstract FuncionarioDAO getFuncionarioDAO() throws SQLException;

    public static FabricaDAO getDAOFactory(int whichFactory) {
        try {
            switch (whichFactory) {
                case POSTGRES:
                    return new PostgresDAO();
                case MYSQL    :
                     return new MySqlDAO();
                //  ......
            }
        
        } catch (Exception ex) {
            Logger.getLogger(FabricaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}