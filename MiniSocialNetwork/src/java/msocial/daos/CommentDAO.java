/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package msocial.daos;

import msocial.dtos.CommentDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author phamduchieu
 */
public class CommentDAO {

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

    public List<CommentDTO> getListCommentByPostID(int postID) throws SQLException, NamingException {
        List<CommentDTO> list = null;
        CommentDTO dto = null;
        lookUpConnection();
        String sql = "EXEC getCommentListByPostID ?";
        stm = conn.prepareStatement(sql);
        stm.setInt(1, postID);
        rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            dto = new CommentDTO();
            dto.setCommentID(rs.getInt("commentID"));
            dto.setDescription(rs.getString("description"));
            dto.setCreatedDate(rs.getString("createdDate"));
            dto.setFullname(rs.getString("lastname") + " " + rs.getString("firstname"));
            dto.setEmailID(rs.getString("emailID"));
            dto.setStatus(rs.getString("status"));
            list.add(dto);
        }
        closeConnection();
        return list;
    }

    public boolean insertComment(CommentDTO dto, int postID) throws SQLException, NamingException {
        boolean check = false;
        lookUpConnection();
        String sql = "INSERT INTO dbo.Comment (description, createdDate, postID, emailID, statusID) "
                + "VALUES (?,?,?,?,?)";
        stm = conn.prepareStatement(sql);
        stm.setNString(1, dto.getDescription());
        stm.setString(2, dto.getCreatedDate());
        stm.setInt(3, postID);
        stm.setString(4, dto.getEmailID());
        stm.setInt(5, Integer.parseInt(dto.getStatus()));
        if (stm.executeUpdate() > 0) {
            check = true;
        }
        closeConnection();
        return check;
    }
}
