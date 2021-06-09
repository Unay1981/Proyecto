/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.Connection;   //API DE JAVA
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author TERESA
 */
public class Conexion {

    Connection conexion;

    String host = "localhost:3306";   // ¿Donde me conecto.. a que servidor Mysql? esta variable es para url de conexion
    String usuario = "root"; // para usuario de conexion
    String pwd = "Drogon1981";     // para usuario de conexion
    String nombreBBDD = "certificados";//¿Donde me conecto.., a que BBDD? esta variable es para url de conexion 

    // configuramos la conexion con las clases de java
    String url = "jdbc:mysql://" + host + "/" + nombreBBDD;
    String zonaHoraria = "?serverTimezone=UTC";

    public Conexion() {

    }

    public Connection conectar() {
        try {

            this.conexion = DriverManager.getConnection(url + zonaHoraria, usuario, pwd);
            System.out.println("Conexión realizada");

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error en la conexion: " + e.getMessage());
        }

        return this.conexion;
    }

}

///* NOTA INFORMATIVA
//DESCRIPCIÓN: Realiza la conexión a diferentes tipos de bases de datos (mysql, sqlserver). Para ello  en  el metodo "Conectar" el tipo debe ser:
//  Conexion.CONN_SQLSERVER = 2;
//  Conexion.CONN_MYSQL     = 1;
//  
// Una vez especificado el tipo carga el archivo de configuración en la carpeta de trabaj (ejecución) llamado "config.ini
// [MYSQL]
//    server=localhost
//    port=3306
//    bbdd=centroformacion
//    user=<usuario de mysql/ sql server>
//    pass=<contraseña base de datos>
//
//NOTA: untiliza un jar.
//*/
//package bd;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.nio.file.Paths;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import javax.swing.JOptionPane;
//import org.ini4j.*;
//
//public class Conexion
//{
//  public static final int CONN_MYSQL = 1;               // si la comexión es para mysql
//  public static final int CONN_SQLSERVER = 2;           // si la comexión es para mysql
//  
//  private Connection conn = null;
//  private String bbdd ="";
//  private String server="";
//  private int puerto=0;
//  private String user="";
//  private String pass="";
// 
//
//  public Conexion()  {}
//  
//  // conectart a la bbdd
//  public Connection conectar(int tp) throws ClassNotFoundException
//  {
//    Wini ini =  null ; //new Wini(new File(Paths.get(System.getProperty("user.dir"), "configuracion.ini").toString()));
//    boolean error = false;
//    Class.forName("com.mysql.jdbc.Driver");   ///com.mysql.jdbc.Driver'com.mysql.cj.jdbc.Driver
//    if(tp==CONN_MYSQL)
//    {
//      try
//      {
//        try 
//        { 
//          // LEO LOS DATOS DE CONFIGURACIÓN PARA MYSQL DEFINIDOS EN CONFIG.
//          // SI EXISTE MYSQL.TXT ES PRIORITARIO...
//          File  f =  new File(Paths.get(System.getProperty("user.dir"), "mysql.txt").toString());
//          if (f.exists())
//          {
//            FileReader fr = new FileReader (f);
//            BufferedReader br = new BufferedReader(fr);
//            String l = br.readLine();
//            String m[] = l.split(",");
//            if(m.length == 5) {server = m[0]; puerto = Integer.parseInt(m[1]); bbdd = m[2]; user=m[3]; pass=m[4];  }
//            else error =true;
//          }
//          else
//          {
//            ini   = new Wini(new File(Paths.get(System.getProperty("user.dir"), "config.ini").toString()));
//            bbdd  = ini.get("MYSQL", "bbdd",String.class); server  = ini.get("MYSQL", "server",String.class); puerto = ini.get("MYSQL", "port",int.class);
//            user  = ini.get("MYSQL", "user",String.class); pass  = ini.get("MYSQL", "pass",String.class);
//            error = (bbdd!= null && server!=null && user!=null && pass!=null )? false : true;
//          }
//         
//        } catch( IOException e) { error=true; JOptionPane.showMessageDialog(null, "Error de Acceso a config.ini","Configuracion",JOptionPane.ERROR_MESSAGE);}
//        if(!error) conn = DriverManager.getConnection("jdbc:mysql://"+server+":"+String.valueOf(puerto)+"/"+bbdd+"?serverTimezone=UTC",user,pass);
//      } catch (SQLException e) { this.conn = null; }
//
//    }
//    return(conn);
//  }
//  // DESCONECTAR DE LA BBDD
//  public void desconectar() throws SQLException
//  {
//    try {  if(this.conn!=null) { conn.close(); this.conn= null; } } catch (SQLException e) { this.conn = null; } 
//  }
//
//  public String getBbdd() { return bbdd; }
//  // devuelte la carpeta
//  public String getConfigCon() { return Paths.get(System.getProperty("user.dir"), "config.ini").toString();  }
//
//  
//
//  public boolean isConectado(){ return( (this.conn!=null)? true : false);  }
//}
