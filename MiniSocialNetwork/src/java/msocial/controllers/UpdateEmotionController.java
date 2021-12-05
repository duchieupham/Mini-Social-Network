/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package msocial.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import msocial.daos.EmotionDAO;
import msocial.dtos.AccountDTO;
import msocial.dtos.EmotionDTO;
import msocial.utils.DateUtil;
import org.apache.log4j.Logger;

/**
 *
 * @author phamduchieu
 */
public class UpdateEmotionController extends HttpServlet {

    private static final String FAIL = "error.jsp";
    private static final String SUCCESS = "DetailPostController";

    private static Logger log = Logger.getLogger(StartupController.class.getName());

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
        String url = FAIL;
        try {
            HttpSession session = request.getSession();
            AccountDTO accountDTO = (AccountDTO) session.getAttribute("USER_INFO");
            String emailID = accountDTO.getEmail();
            EmotionDTO emotionDTO = null;
            DateUtil dateUltil = new DateUtil();
            String emotionID = request.getParameter("emotionID");
            String postID = request.getParameter("articleID");
            String emotionValue = request.getParameter("emotionValue");
            EmotionDAO emotionDAO = new EmotionDAO();
            boolean check = false;
            if (emotionValue.equals("1")) {
                check = emotionDAO.deleteEmotion(Integer.parseInt(emotionID));
            } else if (emotionValue.equals("2")) {
                check = emotionDAO.updateLikeEmotion(Integer.parseInt(emotionID), false);
            } else if (emotionValue.equals("3")) {
                check = emotionDAO.updateLikeEmotion(Integer.parseInt(emotionID), true);
            } else if (emotionValue.equals("4")) {
                check = emotionDAO.deleteEmotion(Integer.parseInt(emotionID));
            } else if (emotionValue.equals("5")) {
                emotionDTO = new EmotionDTO();
                emotionDTO.setLike(true);
                emotionDTO.setCreatedDate(dateUltil.getDateValue());
                emotionDTO.setPostID(Integer.parseInt(postID));
                emotionDTO.setEmailID(emailID);
                emotionDTO.setStatus("1");
                check = emotionDAO.insertEmotion(emotionDTO);
            } else if (emotionValue.equals("6")) {
                emotionDTO = new EmotionDTO();
                emotionDTO.setLike(false);
                emotionDTO.setCreatedDate(dateUltil.getDateValue());
                emotionDTO.setPostID(Integer.parseInt(postID));
                emotionDTO.setEmailID(emailID);
                emotionDTO.setStatus("1");
                check = emotionDAO.insertEmotion(emotionDTO);
            }
            if (check) {
                url = SUCCESS;
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
