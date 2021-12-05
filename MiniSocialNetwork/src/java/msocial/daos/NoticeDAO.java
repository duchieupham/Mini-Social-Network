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
import msocial.dtos.NoticeDTO;

/**
 *
 * @author phamduchieu
 */
public class NoticeDAO {

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

    public NoticeDTO getEmotionCount(int postID) throws NamingException, SQLException {
        NoticeDTO dto = null;
        lookUpConnection();
        String sql = "EXEC getEmotionCount ?";
        stm = conn.prepareStatement(sql);
        stm.setInt(1, postID);
        rs = stm.executeQuery();
        if (rs.next()) {
            dto = new NoticeDTO();
            dto.setLikeCount(rs.getString("likeCount"));
            dto.setDislikeCount(rs.getString("dislikeCount"));
        }
        closeConnection();
        return dto;
    }

    public String getCommentCount(int postID) throws NamingException, SQLException {
        String commentCount = "";
        lookUpConnection();
        String sql = "EXEC getCommentCount ?";
        stm = conn.prepareStatement(sql);
        stm.setInt(1, postID);
        rs = stm.executeQuery();
        if (rs.next()) {
            commentCount = rs.getString("commentCount");
        }
        closeConnection();
        return commentCount;
    }
}
