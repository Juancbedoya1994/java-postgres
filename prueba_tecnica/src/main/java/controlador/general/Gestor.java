/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.general;

import bd.general.BaseDatos;
import java.sql.Connection;
import controlador.modelo.general.Propiedades;

/**
 *
 * @author carlosp
 */
public abstract class Gestor {

    private BaseDatos bd;
    public static final int POSTGRES = 1;
    public static final int ORACLE = 2;
    public  Connection staticconexion;

    public Gestor() throws Exception {
        bd = new BaseDatos(Propiedades.getInstancia().getPropiedades());
    }

    public void abrirConexion() throws Exception {
        staticconexion = bd.getConexion();
    }

    public void cerrarConexion() throws Exception {
        if (staticconexion != null) {
            staticconexion.close();
        }
        staticconexion=null;
    }

    public void inicioTransaccion() throws Exception {
        bd.ejecutar(staticconexion, " BEGIN ");
    }

    public void finTransaccion() throws Exception {
        bd.ejecutar(staticconexion, " COMMIT ");
    }

    public void devolverTransaccion() throws Exception {
        bd.ejecutar(staticconexion, " ROLLBACK ");
    }

    /**
     * @return the bd
     */
    public BaseDatos getBd() {
        return bd;
    }

    /**
     * @param bd the bd to set
     */
    public void setBd(BaseDatos bd) {
        this.bd = bd;
    }

   
}
