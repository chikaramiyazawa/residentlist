package controllers.resident;

import java.io.IOException;

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
 * Servlet implementation class ResidentEditServlet
 */
@WebServlet("/resident/edit")
public class ResidentEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResidentEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        EntityManager em = DBUtil.createEntityManager();

        Resident r = em.find(Resident.class, Integer.parseInt(request.getParameter("id")));

       em.close();


           request.setAttribute("resident", r);
           request.setAttribute("_token", request.getSession().getId());
           request.getSession().setAttribute("id", r.getId());

       RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/resident/edit.jsp");
       rd.forward(request, response);
   }

}
