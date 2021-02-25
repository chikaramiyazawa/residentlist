package controllers.resident;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Resident;

/**
 * Servlet implementation class ResidentNewServlet
 */
@WebServlet("/resident/new")
public class ResidentNewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResidentNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setAttribute("_token",request.getSession().getId());

        Resident r = new Resident();
        r.setDate(new Date(System.currentTimeMillis()));
        request.setAttribute("Resident", r);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/resident/new.jsp");
        rd.forward(request, response);
    }

}
