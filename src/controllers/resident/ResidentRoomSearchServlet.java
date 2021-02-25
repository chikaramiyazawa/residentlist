package controllers.resident;

import java.io.IOException;
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
 * Servlet implementation class ResidentRoomSearch
 */
@WebServlet("/resident/room/search")
public class ResidentRoomSearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResidentRoomSearchServlet() {
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
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/resident/room_search.jsp");
        rd.forward(request, response);
    }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        EntityManager em = DBUtil.createEntityManager();

        List<Resident> resident = null;
        String room = request.getParameter("room");

        int page;

        try{
            page = Integer.parseInt(request.getParameter("page"));
        }catch(Exception e){
            page = 1;
        }


        resident = em.createNamedQuery("getRoomSearch" , Resident.class)
                    .setParameter("room", "%" + room + "%" )
                    .setFirstResult(10 * (page - 1))
                    .setMaxResults(10)
                    .getResultList();


            long resident_count = (long)em.createNamedQuery("getRoomCount" , Long.class)
                    .setParameter("room",  room)
                    .getSingleResult();
            em.close();

            request.setAttribute("resident", resident);
            request.setAttribute("resident_count", resident_count);
            request.setAttribute("page", page);

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/resident/room_index.jsp");
            rd.forward(request, response);

        }



    }
