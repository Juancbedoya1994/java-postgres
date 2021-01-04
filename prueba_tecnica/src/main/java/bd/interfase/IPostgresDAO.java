package bd.interfase;

import bd.general.PostgresDAO;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carlosp
 */
public interface IPostgresDAO {
    public PostgresDAO getFabricaPostgresDAO()throws Exception;
}
