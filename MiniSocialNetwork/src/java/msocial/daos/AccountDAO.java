/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package msocial.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import msocial.dtos.AccountDTO;

/**
 *
 * @author phamduchieu
 */
public class AccountDAO {

    Connection conn;
    PreparedStatement stm;
    ResultSet rs;

    private void closeConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    private void lookUpConnection() throws NamingException, SQLException {
        Context context = new InitialContext();
        Context envContext = (Context) context.lookup("java:comp/env");
        DataSource ds = (DataSource) envContext.lookup("MSSQLConnection");
        conn = ds.getConnection();
    }

    public AccountDTO checkLogin(String email, String password) throws NamingException, SQLException {
        AccountDTO dto = null;
        lookUpConnection();
        String sql = "EXEC checkLogin ?, ?";
        stm = conn.prepareStatement(sql);
        stm.setString(1, email);
        stm.setString(2, password);
        rs = stm.executeQuery();
        if (rs.next()) {
            dto = new AccountDTO();
            dto.setEmail(rs.getString("emailID"));
            dto.setFirstname(rs.getString("firstname"));
            dto.setLastname(rs.getString("lastname"));
            dto.setBirthdate(rs.getDate("birthdate").toString());
            dto.setStatus(rs.getString("status"));
        }
        closeConnection();
        return dto;
    }
}
