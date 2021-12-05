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
import msocial.dtos.EmotionDTO;

/**
 *
 * @author phamduchieu
 */
public class EmotionDAO {

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

    public EmotionDTO getEmotionObject(int postID, String emailID) throws NamingException, SQLException {
        EmotionDTO dto = null;
        lookUpConnection();
        String sql = "EXEC getEmotionPostByPostIDAndEmailID ?,?";
        stm = conn.prepareStatement(sql);
        stm.setInt(1, postID);
        stm.setString(2, emailID);
        rs = stm.executeQuery();
        if (rs.next()) {
            dto = new EmotionDTO();
            dto.setEmotionID(rs.getInt("emotionID"));
            dto.setPostID(rs.getInt("postID"));
            dto.setLike(rs.getBoolean("isLike"));
            dto.setCreatedDate(rs.getString("createdDate"));
            dto.setEmailID(rs.getString("emailID"));
            dto.setStatus("actived");
        }
        closeConnection();
        return dto;
    }

    public boolean updateLikeEmotion(int emotionID, boolean isLike) throws NamingException, SQLException {
        boolean check = false;
        lookUpConnection();
        String sql = "UPDATE dbo.EmotionPost SET isLike = ? WHERE emotionID = ?";
        stm = conn.prepareStatement(sql);
        stm.setBoolean(1, isLike);
        stm.setInt(2, emotionID);
        if (stm.executeUpdate() > 0) {
            check = true;
        }
        closeConnection();
        return check;
    }

    public boolean deleteEmotion(int emotionID) throws NamingException, SQLException {
        boolean check = false;
        lookUpConnection();
        String sql = "UPDATE dbo.EmotionPost SET statusID = 3 WHERE emotionID = ?";
        stm = conn.prepareStatement(sql);
        stm.setInt(1, emotionID);
        if (stm.executeUpdate() > 0) {
            check = true;
        }
        closeConnection();
        return check;
    }

    public boolean insertEmotion(EmotionDTO dto) throws NamingException, SQLException {
        boolean check = false;
        lookUpConnection();
        String sql = "INSERT INTO dbo.EmotionPost (isLike, createdDate, postID, emailID, statusID) "
                + "VALUES (?,?,?,?,?)";
        stm = conn.prepareStatement(sql);
        stm.setBoolean(1, dto.isLike());
        stm.setString(2, dto.getCreatedDate());
        stm.setInt(3, dto.getPostID());
        stm.setString(4, dto.getEmailID());
        stm.setInt(5, Integer.parseInt(dto.getStatus()));
        if (stm.executeUpdate() > 0) {
            check = true;
        }
        closeConnection();
        return check;
    }
}
