package db;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionTest {

    @Test
    public void getInstance_test() {
        // given = 파라미터

        // when
        Connection conn = DBConnection.getInstance();

        //then
        if(conn == null) {
            System.out.println("실패");
        } else {
            System.out.println("성공");
        }
    }
}
