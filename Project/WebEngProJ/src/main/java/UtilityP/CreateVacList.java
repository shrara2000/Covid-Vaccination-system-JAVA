/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilityP;

import Beans.DatePrinter;
import Models.Citizen;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class CreateVacList {
    
    public static List<Citizen>Create(Connection con,String WorkPlace)
        { 
        try {
            
            List<Citizen> AllCit= new ArrayList<>();
            Statement S = con.createStatement();
            
            ResultSet rs = S.executeQuery("SELECT ID FROM SYSTEM.CITIZEN Where VACCINATIONPLACE='"+WorkPlace+"'");
            while(rs.next())
            {   String temp=rs.getString("ID");
                 Citizen i = UtilityP.CreateCitizen.create(con, temp);
                 if(LocalDate.now().toString().equals(DatePrinter.print(i.getFirstVacD()))&&i.getNumofVac()==0)
                 AllCit.add(i);
                  if(LocalDate.now().toString().equals(DatePrinter.print(i.getSecondVacD()))&&i.getNumofVac()==1)
                 AllCit.add(i);
                   if(LocalDate.now().toString().equals(DatePrinter.print(i.getThirdVacD()))&&i.getNumofVac()==2)
                 AllCit.add(i);
                
                 
            }
            return AllCit;
        } catch (SQLException ex) {
            Logger.getLogger(CreateVacList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
     }

   
}
