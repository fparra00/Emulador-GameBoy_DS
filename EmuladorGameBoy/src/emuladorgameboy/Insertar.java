/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emuladorgameboy;

import java.sql.*;

/**
 *
 * @author whysxpvrrv
 */
public class Insertar extends Conexion {

    public boolean registro(Usuario usr) throws SQLException {
        //Creamos la conexión
        PreparedStatement ps = null;
        Connection con = getConexion();

        //Declaración INSERT INTO
        String sql = "INSERT INTO ds (nombre,resultado) VALUES(?,?)";

        try {
            //Comprobamos a conectarnos e introducir los datos
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getIniciales());
            ps.setInt(2,0);
            ps.execute();

            //En caso de excepción, devolvemos false
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
}
