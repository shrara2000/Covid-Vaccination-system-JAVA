package Servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.Citizen;
import UtilityP.DBMan;
import UtilityP.CreateCitizen;
import java.time.LocalDate;

/**
 * Servlet implementation class CLogin
 */
@WebServlet("/CLogin")
public class CLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       public static DBMan INST=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CLogin() {
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
	
         INST=new DBMan();
        String ID= request.getParameter("ID");
	Connection con = DBMan.EstablishCon();
	Citizen Current = CreateCitizen.create(con,ID);
	HttpSession HS = request.getSession(); 
	String s;
	if(Current==null||LocalDate.now().getYear()-Current.getDOB().getYear()<12)
	{
		
	 s="HomePage.jsp";	
	}
	else
	{
	 HS.setAttribute("Citizen",Current );
	 s="CitizenDashBoard.jsp";	
	}
	response.sendRedirect(s);
	
	}

}
