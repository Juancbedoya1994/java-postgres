/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.modelo.general;

import controlador.general.GestorPropiedades;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 *
 * @author carlosp
 */
public class Propiedades {

    private static Propiedades instancia;
    private Properties propiedades;

    private Propiedades() {
        if (FacesContext.getCurrentInstance() != null) {
            ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            GestorPropiedades gestorPropiedades = new GestorPropiedades();
            try {
                propiedades = gestorPropiedades.cargarPropiedades(context.getRealPath("/WEB-INF/classes/configuracion.properties"));
                 
            } catch (Exception e) {
            }
        } else {
            //File path = new File("C:\\Users\\juan.montoya\\Desktop\\Prueba\\Carrito\\prueba_tecnica\\web\\WEB-INF\\classes\\configuracion.properties");
            File path = new File( "C:\\Carritojava\\src\\conf\\configuracion.properties");
            propiedades = new Properties();

            try {
                propiedades.load(new FileInputStream(path));
            } catch (IOException ex) {
                Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    /**
     * @return the instancia
     */
    public static Propiedades getInstancia() {
        if (instancia == null) {
            synchronized (Propiedades.class) {
                instancia = new Propiedades();
            }
        }
        return instancia;
    }

    public Properties getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(Properties propiedades) {
        this.propiedades = propiedades;
    }
}
