package de.bytropical.tropicallib.database.mysql;

import lombok.Getter;

import java.sql.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TropiMySQLManager {

    @Getter
    private ExecutorService executor = Executors.newFixedThreadPool(4);

    @Getter
    private Connection connection;

    private final String host, user, password, database;
    private final int port;

    public TropiMySQLManager(final String host, final String user, final String password, final String database, final int port) {
        this.host = host;
        this.user = user;
        this.password = password;
        this.database = database;
        this.port = port;

        executor.execute(() -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database, this.user, this.password);

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });


    }

    public void update(String qry) {
        executor.execute(() -> {
            Statement st;
            try {
                st = connection.createStatement();
                st.executeUpdate(qry);
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public ResultSet query(String qry) {
        ResultSet rs = null;

        try {
            Statement st = getConnection().createStatement();
            rs = st.executeQuery(qry);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return rs;
    }

}

