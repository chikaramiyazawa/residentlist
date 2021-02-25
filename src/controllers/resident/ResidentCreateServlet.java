package controllers.resident;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Resident;
import models.validators.ResidentValidators;
import utils.DBUtil;

/**
 * Servlet implementation class ResidentCreateServlet
 */
@WebServlet("/resident/create")
public class ResidentCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResidentCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String _token = (String)request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId()));
        EntityManager em = DBUtil.createEntityManager();

        Resident r = new Resident();
        Date date = new Date(System.currentTimeMillis());
        String rd_str = request.getParameter("date");
        if(rd_str != null && !rd_str.equals("")){
            date = Date.valueOf(request.getParameter("date"));
        }
        r.setDate(date);

        String resident = request.getParameter("resident");
        if(resident != null && !resident.equals("")){
            r.setResident(resident);
        }else{
            r.setResident("空");
        }

        String Info = request.getParameter("info");
        if(Info != null && !Info.equals("")){
            r.setInformation(Info);
        }else{
            r.setInformation("情報なし");
        }

        String pro = request.getParameter("pro");
        if(pro != null && !pro.equals("")){
            r.setProfession(pro);
        }else{
            r.setProfession("未設定");
        }

        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        r.setUpdate_at(currentTime);

        r.setRoom(request.getParameter("room"));
        List<String> errors = ResidentValidators.validate(r);
        if(errors.size () >0){
            em.close();

            request.setAttribute("_token", request.getSession().getId());
            request.setAttribute("resident", r);
            request.setAttribute("errors", errors);

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/resident/new.jsp");
            rd.forward(request, response);
        }else{
            em.getTransaction().begin();
            em.persist(r);
            em.getTransaction().commit();
            em.close();
            request.getSession().setAttribute("flush","登録が完了しました。");
            response.sendRedirect(request.getContextPath() + "/resident/index");
        }

    }


    }


