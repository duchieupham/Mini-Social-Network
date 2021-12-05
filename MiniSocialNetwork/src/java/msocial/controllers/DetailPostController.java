/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package msocial.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import msocial.daos.ArticleDAO;
import msocial.daos.CommentDAO;
import msocial.daos.EmotionDAO;
import msocial.dtos.CommentDTO;
import msocial.daos.NoticeDAO;
import msocial.dtos.AccountDTO;
import msocial.dtos.ArticleDTO;
import msocial.dtos.EmotionDTO;
import msocial.dtos.NoticeDTO;
import org.apache.log4j.Logger;

/**
 *
 * @author phamduchieu
 */
public class DetailPostController extends HttpServlet {

    private static final String SUCCESS = "StartupController";

    private static Logger log = Logger.getLogger(MainController.class.getName());

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {
            String postID = request.getParameter("articleID");
            ArticleDAO articleDAO = new ArticleDAO();
            ArticleDTO articleDTO = articleDAO.getArticleByID(Integer.parseInt(postID));
            CommentDAO commentDAO = new CommentDAO();
            List<CommentDTO> listComment = commentDAO.getListCommentByPostID(Integer.parseInt(postID));
            NoticeDAO noticeDAO = new NoticeDAO();
            NoticeDTO noticeDTO = noticeDAO.getEmotionCount(Integer.parseInt(postID));
            noticeDTO.setCommentCount(noticeDAO.getCommentCount(Integer.parseInt(postID)));
            HttpSession session = request.getSession();
            EmotionDAO emotionDAO = new EmotionDAO();
            AccountDTO accountDTO = (AccountDTO) session.getAttribute("USER_INFO");
            EmotionDTO emotionDTO = emotionDAO.getEmotionObject(Integer.parseInt(postID), accountDTO.getEmail());
            request.setAttribute("NOTICE_POST", noticeDTO);
            request.setAttribute("LIST_COMMENT", listComment);
            request.setAttribute("POST_DETAIL", articleDTO);
            request.setAttribute("EMOTION_OBJECT", emotionDTO);
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            request.getRequestDispatcher(SUCCESS).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
