/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.interfase;

import bd.general.MySqlDAO;

/**
 *
 * @author jk
 */
public interface IMySqlDAO {
     public MySqlDAO getFabricaMySqlDAO()throws Exception;
}
