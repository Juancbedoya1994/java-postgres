/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.general;

import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 *
 * @author carlosf
 */
public class GestorPropiedades {

    public Properties cargarPropiedades(String ruta) throws Exception {
        Properties p = new Properties();
        try {
           /* ResourceBundle bdl = new PropertyResourceBundle(new FileInputStream(ruta));
            Enumeration keys = bdl.getKeys();
            while (keys.hasMoreElements()) {
                String prop = (String) keys.nextElement();
                String val = bdl.getString(prop);
                p.setProperty(prop, val);
            */
           p.setProperty("usuario", "postgres");
           p.setProperty("clave", "xxxx");
           p.setProperty("urlbd", "jdbc:postgresql://localhost:5432/carrito");
           p.setProperty("controlador", "org.postgresql.Driver");
           p.setProperty("verLogJdbc", "");
        
        } catch (Exception e) {
            throw e;
        }
        return p;
    }
}
