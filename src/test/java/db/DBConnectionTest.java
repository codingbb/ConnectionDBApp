package db;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionTest {

    @Test
    public void getInstance_test() {
        String username = "root";
        String password = "1234";
        String url = "jdbc:mariadb://localhost:3306/cosdb";

        //프로토콜이 적용된 소켓
        try {
            Connection conn = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
