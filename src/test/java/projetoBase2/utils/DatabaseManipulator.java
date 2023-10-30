package projetoBase2.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManipulator {

    private DataBaseHelper db;

    public DatabaseManipulator() {
        db = new DataBaseHelper();
    }

    public void restoreDatabase() {
        String sql = "DROP DATABASE IF EXISTS bugtracker; CREATE DATABASE bugtracker;";
        db.executeSQL(sql);
    }
    public void restoreUsers(){
        String sql = "DELETE FROM mantis_user_table WHERE username <> 'administrator' AND email <> 'root@localhost';";
        Connection connection = db.getConnection();

    }

    public static boolean testarConexao(String url, String username, String password) {
        // DataBaseHelper db = new DataBaseHelper(url, username, password);
        DataBaseHelper db = new DataBaseHelper();
        db.close();
        return true; // Conexão bem-sucedida
    }

    public void executeSQL(String sql) {
        Connection connection = new DataBaseHelper().criarConexao(); // Obtenha a conexão criada ou existente

        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (db.getConnection() != null) {
                db.getConnection().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
