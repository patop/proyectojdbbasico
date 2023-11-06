package com.pjb.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pjb.domain.Persona;

public class PersonaDAO {
    private static final String INSER_QUERY = "INSERT INTO persona (nombre, clave) VALUES (?, ?)";
    private static final String UPDATE_QUERY = "UPDATE persona SET nombre = ?, clave = ? WHERE idpersona = ?";
    private static final String DELETE_QUERY = "DELETE FROM persona WHERE idpersona = ?";
    private static final String SELECT_QUERY = "SELECT * FROM persona";

    public List<Persona> seleccionar() {
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();
        try {
            connection = Conexion.getConexion();
            preparedStatement = connection.prepareStatement(SELECT_QUERY);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idPersona = resultSet.getInt(1);
                String nombrePersona = resultSet.getString(2);
                String clavePersona = resultSet.getString(3);
                persona = new Persona(idPersona, nombrePersona, clavePersona);
                personas.add(persona);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(resultSet);
                Conexion.close(preparedStatement);
                Conexion.close(connection);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return personas;
    }

    public void insertar(Persona persona){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = Conexion.getConexion();
            preparedStatement = connection.prepareStatement(INSER_QUERY);
            preparedStatement.setString(1, persona.getNombrePersona());
            preparedStatement.setString(2, persona.getClavePersona());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally{
            try {
                Conexion.close(preparedStatement);
                Conexion.close(connection);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
    }

    public void eliminar(Persona persona){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Conexion.getConexion();
            preparedStatement = connection.prepareStatement(DELETE_QUERY);
            preparedStatement.setInt(1, persona.getIdPersona());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally{
            try {
                Conexion.close(preparedStatement);
                Conexion.close(connection);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
    }
    public void actualizar(Persona persona){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Conexion.getConexion();
            preparedStatement = connection.prepareStatement(UPDATE_QUERY);
            preparedStatement.setString(1, persona.getNombrePersona());
            preparedStatement.setString(2, persona.getClavePersona());
            preparedStatement.setInt(3, persona.getIdPersona());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally{
            try {
                Conexion.close(preparedStatement);
                Conexion.close(connection);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
    }
}
