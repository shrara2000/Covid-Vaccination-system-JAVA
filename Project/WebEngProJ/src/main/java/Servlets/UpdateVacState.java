package Servlets;

import Beans.DatePrinter;
import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Citizen;
import Models.Nurse;
import UtilityP.CreateCitizen;
import UtilityP.CreateVacList;
import UtilityP.DBMan;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateVacState
 */
@WebServlet("/UpdateVacState")
public class UpdateVacState extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateVacState() {
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
		// TODO Auto-generated method stub
                 List<Citizen> X= new ArrayList<>();
                 List<Citizen> Y= new ArrayList<>();
		Connection con= DBMan.EstablishCon();
		String citizenID = request.getParameter("ID");
		Citizen C = CreateCitizen.create(con, citizenID);
		int vaccineCount =C.getNumofVac();
		 if(LocalDate.now().toString().equals(DatePrinter.print(C.getFirstVacD()))&&C.getNumofVac()==0)
                {vaccineCount+=1;}
                else
                 if(LocalDate.now().toString().equals(DatePrinter.print(C.getSecondVacD()))&&C.getNumofVac()==1)
                 {vaccineCount+=1;}
                  else  
                   if(LocalDate.now().toString().equals(DatePrinter.print(C.getThirdVacD()))&&C.getNumofVac()==2)
                {vaccineCount+=1;}
		DBMan.UpdateCitizen(con,vaccineCount+"","NumofVac",citizenID );
                HttpSession H= request.getSession();
                H.removeAttribute("List");
               
                X.add(C);
                
                Nurse temp=(Nurse)H.getAttribute("Nurse");
                List<Citizen>t1=CreateVacList.Create(con,temp.getWorkplace());
                for(Citizen i :t1){
               if(LocalDate.now().toString().equals(DatePrinter.print(i.getFirstVacD()))&&i.getNumofVac()==0)
                 Y.add(i);
                  if(LocalDate.now().toString().equals(DatePrinter.print(i.getSecondVacD()))&&i.getNumofVac()==1)
                 Y.add(i);
                   if(LocalDate.now().toString().equals(DatePrinter.print(i.getThirdVacD()))&&i.getNumofVac()==2)
                 Y.add(i);
                
                }
                H.setAttribute("List",Y );
               response.sendRedirect("NurseDashBoard.jsp");
               
		
		
	}

}
