/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Uocspacex
 */
public class FactoryCliente {

    public static Cliente getCliente(int tipo, ResultSet result) throws SQLException {

        if (tipo == 0) {
            Cliente cliente = new ClienteEstandar();
            cliente.setNombre(result.getString("nombre"));
            cliente.setDomicilio(result.getString("domicilio"));
            cliente.setNif(result.getString("nif"));
            cliente.setEmail(result.getString("email"));
            cliente.setPremium(result.getBoolean("premium"));
            return cliente;
        } else {
            ClientePremium cliente = new ClientePremium();
            cliente.setNombre(result.getString("nombre"));
            cliente.setDomicilio(result.getString("domicilio"));
            cliente.setNif(result.getString("nif"));
            cliente.setEmail(result.getString("email"));
            cliente.setPremium(result.getBoolean("premium"));
            return cliente;
        }

    }
}
