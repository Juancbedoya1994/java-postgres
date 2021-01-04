package conexion;

//~--- JDK imports ------------------------------------------------------------

import java.sql.ResultSet;
import java.sql.SQLException;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author juliano
 */
public class baseDatos {
   private java.sql.Statement  QRYauxiliar;
   private java.sql.Statement  QRYgeneral;
   private java.sql.Connection conexion;

   //~--- constructors --------------------------------------------------------

   public baseDatos() throws ClassNotFoundException, java.sql.SQLException, InstantiationException, IllegalAccessException {
      String controlador = "org.postgresql.Driver";
      Class.forName(controlador).newInstance();
       conectar("postgres", "xxxx");
   }

   //~--- methods -------------------------------------------------------------

   public void cerrarConexion() {
      if (QRYgeneral != null){
         try{
            QRYgeneral.close();
         }
         catch (SQLException e) {}
         QRYgeneral = null;
      }
      if (QRYauxiliar != null){
         try{
            QRYauxiliar.close();
         }
         catch (SQLException e) {}
         QRYauxiliar = null;
      }
      if (conexion != null){
         try{
            conexion.close();
         }
         catch (SQLException e) {}
         conexion = null;
      }
   }

   public void conectar(String usr,String pwd) throws java.sql.SQLException {
      String URL_bd = "jdbc:postgresql://localhost:5432/carrito";
      //String usr = "postgres";
      //String pwd ="xxxx";
      //String URL_bd = "jdbc:postgresql://10.1.1.115:8432/dbsa";
      conexion    = java.sql.DriverManager.getConnection(URL_bd, usr, pwd);
      QRYgeneral  = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
      QRYauxiliar = conexion.createStatement();
   }

   //~--- get methods ---------------------------------------------------------

   public java.sql.Connection getConexion() {
      return conexion;
   }

   public java.sql.Statement getQRYauxiliar() {
      return QRYauxiliar;
   }

   public java.sql.Statement getQRYgeneral() {
      return QRYgeneral;
   }

   //~--- set methods ---------------------------------------------------------

   public void setConexion(java.sql.Connection conexion) {
      this.conexion = conexion;
   }

   public void setQRYauxiliar(java.sql.Statement QRYauxiliar) {
      this.QRYauxiliar = QRYauxiliar;
   }

   public void setQRYgeneral(java.sql.Statement QRYgeneral) {
      this.QRYgeneral = QRYgeneral;
   }
}
