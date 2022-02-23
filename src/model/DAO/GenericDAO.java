/*
 * Copyright (c) 2022.
 * Raul Pacheco Domingos (raulpacheco2k)
 * https://github.com/raulpacheco2k
 * https://linkedin.com/in/raulpacheco2k/
 * https://twitter.com/raulpacheco2k
 */

package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class GenericDAO {

    PreparedStatement preparedStatement;
    Connection connection;
    ResultSet resultSet;

    public GenericDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public PreparedStatement sqlCode(String string) throws SQLException {
        return this.connection.prepareStatement(string);
    }
}
