/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emuladorgameboy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author whysxpvrrv
 */
public class Consultar extends Conexion {

    String nombreRecuperado = "";
    String iniciales;

    /**
     * Función que consultara los valores en la bdd
     *
     * @return true/false en caso de que se haya completado con exito la
     * iniciales
     * @throws SQLException
     */
    public boolean consulta() throws SQLException {

        //Preparamos la conexion
        PreparedStatement stmt = null;
        Connection con = getConexion();
        String sql = "SELECT nombre FROM ds WHERE nombre = '" + iniciales + "';";

        try {
            //Ejecutamos nuestra selección
            stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            //Consultamos la base de datos
            while (rs.next()) {
                //Guardamos los datos en variables
                nombreRecuperado = rs.getString(1);
            }

            //Cerramos la conexión 
            rs.close();
            stmt.close();
            //Devolvemos true
            return true;

            //En caso de excepción devolvemos false
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean comprobar() {
        if (nombreRecuperado.equals(iniciales)) {
            return true;
        } else {
            return false;
        }
    }

    public Consultar(String iniciales) {
        this.iniciales = iniciales;
    }


    public String getIniciales() {
        return iniciales;
    }

    public void FetIniciales(String iniciales) {
        this.iniciales = iniciales;
    }
}
