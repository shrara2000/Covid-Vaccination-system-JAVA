package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.Citizen;
import UtilityP.DBMan;
import UtilityP.MakeAppointment;

/**
 * Servlet implementation class reserveAppointment
 */
@WebServlet("/reserveAppointment")
public class reserveAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reserveAppointment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = DBMan.EstablishCon();
		HttpSession HS = request.getSession();
		Citizen Current = (Citizen)HS.getAttribute("Citizen");
		
		int x =Current.getNumofVac()+1;
		String vacType="";
		String VD = request.getParameter("VacD");
		String VP = request.getParameter("VacP");
		if(x==1) {
	     vacType= request.getParameter("VacT");
	     if(MakeAppointment.Update(x,Current,vacType,VD)){
	     DBMan.UpdateCitizen(con,VD,"FirstVacD",Current.getID());
	     DBMan.UpdateCitizen(con, vacType,"vacType", Current.getID());
	     DBMan.UpdateCitizen(con, VP, "vaccinationPlace",  Current.getID());
             DBMan.UpdateCitizen(con, Current.getSecondVacD().toString(),"SecondVacD", Current.getID());}
             RequestDispatcher RD = request.getRequestDispatcher("CitizenDashBoard.jsp");
             RD.forward(request, response);
             
		}
		else
                {if(x==3&&Current.getFirstVacD()!=null&&Current.getSecondVacD()!=null)
		{
			HS.setAttribute("Date", VD);
                        response.sendRedirect("BoosterAgreement.jsp");
		}
		else {
			RequestDispatcher RD = request.getRequestDispatcher("CitizenDashBoard.jsp");
                          RD.forward(request, response);
                           response.sendRedirect("BoosterAgreement.jsp");
		}
		}
		
		}
		
		
		
	}


