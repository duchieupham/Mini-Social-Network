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
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import msocial.dtos.ArticleDTO;

/**
 *
 * @author phamduchieu
 */
public class ArticleDAO {

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

    public List<ArticleDTO> getAllArticle() throws NamingException, SQLException {
        List<ArticleDTO> list = null;
        ArticleDTO dto = null;
        lookUpConnection();
        String sql = "EXEC getAllArticle";
        stm = conn.prepareStatement(sql);
        rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            dto = new ArticleDTO();
            dto.setPostID(rs.getInt("postID"));
            dto.setTitle(rs.getString("title"));
            dto.setDescription(rs.getString("description"));
            dto.setImgURL(rs.getString("imgURL"));
            dto.setCreatedDate(rs.getString("createdDate"));
            dto.setStatus(rs.getString("status"));
            dto.setFullname(rs.getString("lastname") + " " + rs.getString("firstname"));
            dto.setEmailID(rs.getString("emailID"));
            list.add(dto);
        }
        closeConnection();
        return list;
    }

    public ArticleDTO getArticleByID(int id) throws NamingException, SQLException {
        ArticleDTO dto = null;
        lookUpConnection();
        String sql = "EXEC getArticleByID ?";
        stm = conn.prepareStatement(sql);
        stm.setInt(1, id);
        rs = stm.executeQuery();
        if (rs.next()) {
            dto = new ArticleDTO();
            dto.setPostID(rs.getInt("postID"));
            dto.setTitle(rs.getString("title"));
            dto.setDescription(rs.getString("description"));
            dto.setImgURL(rs.getString("imgURL"));
            dto.setCreatedDate(rs.getString("createdDate"));
            dto.setEmailID(rs.getString("emailID"));
            dto.setStatus(rs.getString("status"));
            dto.setFullname(rs.getString("lastname") + " " + rs.getString("firstname"));
        }
        closeConnection();
        return dto;
    }
}
