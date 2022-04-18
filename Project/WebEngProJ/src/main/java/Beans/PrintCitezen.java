/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Models.Citizen;
import UtilityP.CreateCitizen;
import UtilityP.CreateVacList;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author USER
 */
public class PrintCitezen {
    public static String Print( List<Citizen> LS)
    {String s = "<table class= \"button-33\" style=\"style=\"margin-top: 40px; margin-left: 30px;\">";
            s+="<thead> <th>First Name</th>  <th>Last Name</th>  <th>ID</th>  <th>Vac#</th>  <th>VacType</th>  <th>1st</th> <th>2nd</th> <th>Booster</th>";
     for(Citizen i : LS)
     {s+="<form action= \"UpdateVacState\" method=\"POST\">";
         s += "<tr class=\"table-row\">";
			
				s += "<td>";
				s += i.getFname() ;
				s += "</td>";
                                s += "<td>";
				s += i.getLname() ;
				s += "</td>";
                                s += "<td>";
                                s +="<Input type=\"text\" name=\"ID\" value="+i.getID()+" readonly = \"readonly\"/>";
				s += "</td>";
                                s += "<td>";
				s += i.getNumofVac()+1;
				s += "</td>";
                                s += "<td style=\"font-weight: bold ; color: #000\">";
				s += i.getVacType();
				s += "</td>";
                                s += "<td>";
				s += DatePrinter.print(i.getFirstVacD());
				s += "</td>";
                                s += "<td>";
				s += DatePrinter.print(i.getSecondVacD());
				s += "</td>";
                                s += "<td>";
				s += DatePrinter.print(i.getThirdVacD());
				s += "</td>";
                                s += "<td>";
				s +="<input type=\"submit\" value=\"REGESTER\" class=\"button-33\">" ;
				s += "</td>";
			 
			s += "</tr>";
                        s +="</form>";
     }
     s += "</table>";
     return s;
    }
}
