package controllers.resident;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Resident;
import utils.DBUtil;

/**
 * Servlet implementation class ResidentDateAfterSearchServlet
 */
@WebServlet("/resident/date/after/search")
public class ResidentDateAfterSearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResidentDateAfterSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setAttribute("_token", request.getSession().getId());
        request.setAttribute("hasError", false);
        if(request.getSession().getAttribute("flush") != null){
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
        }
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/resident/date_after_search.jsp");
        rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        EntityManager em = DBUtil.createEntityManager();

        List<Resident> resident = null;

        int page;

        try{
            page = Integer.parseInt(request.getParameter("page"));
        }catch(Exception e){
            page = 1;
        }

        try{
            Date date = Date.valueOf(request.getParameter("date"));
            resident = em.createNamedQuery("getAfterDate" , Resident.class)
                    .setParameter("date", date)
                    .setFirstResult(15 * (page - 1))
                    .setMaxResults(15)
                    .getResultList();


            long resident_count = (long)em.createNamedQuery("getAfterDateCount" , Long.class)
                    .setParameter("date", date)
                    .getSingleResult();
            em.close();

            request.setAttribute("resident", resident);
            request.setAttribute("resident_count", resident_count);
            request.setAttribute("page", page);

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/resident/date_index.jsp");
            rd.forward(request, response);

        }

        catch (IllegalArgumentException e) {
            request.setAttribute("_token", request.getSession().getId());
            request.setAttribute("hasError", false);
            if(request.getSession().getAttribute("flush") != null){
                request.setAttribute("flush", request.getSession().getAttribute("flush"));
                request.getSession().removeAttribute("flush");
            }
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/resident/date_index.jsp");
            rd.forward(request, response);

        }
    }

    }

