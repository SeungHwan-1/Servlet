package com.ohgiraffers.mvc.common.jdbc;

import com.ohgiraffers.mvc.common.config.ConfigLocation;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

// jdbc 연결을 관리하는 클래스
public class JDBCTemplate {

    //DB 연결을 생성하는 정적 메소드
    //그래들에 추가해서 됨
    public static Connection getConnection() {
        Connection con = null;

        Properties prop = new Properties();

        try {
            prop.load(new FileReader(ConfigLocation.CONNECTION_CONFIG_LOCATION));
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");

            Class.forName(driver); // JDBC서블릿을 로드할거다 하고 쓴거

            con = DriverManager.getConnection(url,user,password);
            con.setAutoCommit(false); //commit을 꺼줌안끄면 어케된다구?
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;

    }

    public static void close(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void close(Statement stmt) {
        try {
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void close(ResultSet rset) {
        try {
            rset.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //오토커밋을꺼놔서
    public static void commit(Connection con) {
        try {
            if (con != null && con.isClosed()) {
                //널이아니고 isClosed가아니면 커밋을 할것
                con.commit();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void rollback(Connection con) {
        try {
            if (con != null && con.isClosed()) {
                //널이아니고 isClosed가아니면 롤백을 할것
                con.rollback();
                //트랜잭션 내에서 수행된 모든 데이터 변경
                // (INSERT, UPDATE, DELETE 등)이 취소.
                // 즉, 해당 트랜잭션이 시작되기 전의 상태로 돌아감.
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
