package UtilityP;

import java.sql.Connection;
import java.time.LocalDate;

import Models.Citizen;

public class MakeAppointment {
public static boolean Update(int x, Citizen current, String VacType,String VD)
{
	if(x==1)
	{  
		if(!VD.equals("")&&!(LocalDate.parse(VD).isBefore(LocalDate.now())))
		{ current.setFirstVacD(LocalDate.parse(VD));
		switch (VacType)
		{
		case "Pfizer":
	     current.setSecondVacD(current.getFirstVacD().plusDays(21));//Set the Param of plusDays to 0
	     
	     return true;
		case  "Sinopharm":
		current.setSecondVacD(current.getFirstVacD().plusDays(28));//Set the Param of plusDays to 0
		case "Moderna":
		current.setSecondVacD(current.getFirstVacD().plusDays(35));//Set the Param of plusDays to 0
		return true;
                   
		default : return false;
		
		}
	    }
		else return false;
	}
        int days=0;
        if(current.getVacType().equals("Pfizer"))
        days=21;
        else
          if(current.getVacType().equals("Moderna"))
            days=35;
          else if(current.getVacType().equals("Sinopharm"))
              days=21;
	if(x==3&&current.getSecondVacD()!=null&&LocalDate.parse(VD).isAfter(current.getSecondVacD().plusDays(days)))
	{
		current.setThirdVacD(LocalDate.parse(VD));
		
		return true;
		
		
	}
	else return false;
}
}
