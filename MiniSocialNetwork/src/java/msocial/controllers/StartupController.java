/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package msocial.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import msocial.daos.ArticleDAO;
import msocial.daos.NoticeDAO;
import msocial.dtos.ArticleDTO;
import msocial.dtos.NoticeDTO;
import msocial.utils.DateUtil;
import org.apache.log4j.Logger;

/**
 *
 * @author phamduchieu
 */
public class StartupController extends HttpServlet {

    private static final String START_PAGE = "login.jsp";
    private static final String DASHBOARD = "dashboard.jsp";
    private static final String ERROR = "error.jsp";

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
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            String currentTime = "";
            int hourInDay = 0;
            DateUtil dateUtil = new DateUtil();
            currentTime = dateUtil.getCurrentDayOfWeek() + ", " + dateUtil.getCurrentDayOfMonth() + " " + dateUtil.getCurrentMonth() + " " + dateUtil.getCurrentYear();
            hourInDay = dateUtil.getHourInDayValue();
            ServletContext context = getServletContext();
            context.setAttribute("CURRENT_TIME", currentTime);
            context.setAttribute("SESSION_IN_DAY", hourInDay);
            if (session.getAttribute("USER_INFO") != null) {
                ArticleDAO articleDAO = new ArticleDAO();
                NoticeDAO noticeDAO = new NoticeDAO();
                List<ArticleDTO> listArticle = articleDAO.getAllArticle();
                List<NoticeDTO> listNotice = new ArrayList<>();
                NoticeDTO noticeDTO = null;
                for (int i = 0; i < listArticle.size(); i++) {
                    noticeDTO = noticeDAO.getEmotionCount(listArticle.get(i).getPostID());
                    noticeDTO.setCommentCount(noticeDAO.getCommentCount(listArticle.get(i).getPostID()));
                    listNotice.add(noticeDTO);
                }
                request.setAttribute("LIST_NOTICE", listNotice);
                request.setAttribute("LIST_POST", listArticle);
                url = DASHBOARD;
            } else {
                url = START_PAGE;
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
