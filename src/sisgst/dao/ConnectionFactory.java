package sisgst.dao;

/*
ConnectionFactory.java

Configurações MySQL computadores SENAI

Endereço: 127.0.0.1
Nome do banco: <definido por quem criou o banco de dados>
Usuário: root
Senha: <em branco>

 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1/sistema_gestao", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
