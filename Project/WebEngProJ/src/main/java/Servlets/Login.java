package Servlets;

import java.io.IOException;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

import Models.Nurse;
import UtilityP.CreateNurse;
import UtilityP.DBMan;
import UtilityP.CreateVacList;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
      super();
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
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
                
                    CLogin.INST=new DBMan();
                
                String Fwd;
		String un = request.getParameter("un");
		String pw = request.getParameter("pw");
		HttpSession S = request.getSession();
		try {
		
	    Connection con = UtilityP.DBMan.EstablishCon();
	    Nurse s=DBMan.getNurse(con, un, pw);
	    if(s==null)
	    {
	    	Fwd="NurseLogin.jsp";
	    	
	    	
	    }
	    else
	    { S.setAttribute("Nurse", s);
	      S.setAttribute("List", CreateVacList.Create(con,s.getWorkplace()));
              Fwd="NurseDashBoard.jsp";
	    	
	    	
	    }
	   response.sendRedirect(Fwd);
	    
	    
		
		}
		catch(Exception e)
		{  
			
		}
	}

}
