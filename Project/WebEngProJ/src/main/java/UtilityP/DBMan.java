package UtilityP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Models.Citizen;
import Models.Nurse;

public class DBMan {
public DBMan()
{
	Connection C=EstablishCon();
    try {
		Statement s=C.createStatement();
                //s.executeUpdate("create table Nurse (username varchar(12),password varchar(25),workplace varchar(25),primary key(username))");
		//s.executeUpdate("create table Citizen (firstName varchar(21),lastName varchar(21),DOB varchar(12),NumofVac integer,FirstVacD varchar(12),SecondVacD varchar(12),ThirdVacD varchar(12),ID varchar(10),Address varchar(50),vaccinationPlace varchar(25),vacType varchar(25),primary key(ID))");
		 
	    Citizen c= new Citizen();
	    LocalDate LD=LocalDate.of(2000, 8, 14);
	   c.setFname("Saif");
	   c.setLname("Hijleh");
	   c.setAddress("Amman-Aljubayha");
	   c.setDOB(LD);
	   c.setID("1022123190");
	   insertCitizen(C, c);
           c.setFname("Hadi");
	   c.setLname("Abdulrahman");
	   c.setAddress("Amman-Aljubayha");
	   c.setDOB(LD);
	   c.setID("123");
	   insertCitizen(C, c);
	   LD=LocalDate.of(2021, 1, 15);
	   c.setFname("Rama");
	   c.setLname("Mahmoud");
	   c.setAddress("Irbid-University ST");
	   c.setDOB(LD);
	   c.setID("1023457621");
	   insertCitizen(C, c);
	   LD=LocalDate.of(1999, 6, 1);
	   c.setFname("Khalid");
	   c.setLname("Walid");
	   c.setAddress("new zarqa");
	   c.setDOB(LD);
	   c.setID("9991123654");
	   insertCitizen(C, c);
           Nurse n= new Nurse();
           n.setUsername("RamiH21");
           n.setWorkplace("Irbid-Alhasan");
           String Password="XCER123";
           insertNurse(C, n, Password);
           n.setUsername("HudaZ22");
           n.setWorkplace("Zarqa-H");
           Password="H@Z2021";
           insertNurse(C, n, Password);
           n.setUsername("RolaA19");
           n.setWorkplace("Amman-H");
           Password="R@A2020";
           insertNurse(C, n, Password);
	   C.commit();
	   C.close();
           
	   
	} catch (SQLException e) {
		// TODO Auto-generated catch block
	
	}
}
public static Connection EstablishCon()
{
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","1234");
		
		}
	catch (Exception e)
	{
		return null;
	}
}
public static void insertCitizen(Connection C,Citizen Cit)
{
try {
    PreparedStatement PS=C.prepareStatement("INSERT INTO SYSTEM.CITIZEN Values (?,?,?,?,?,?,?,?,?,?,?)");
   String FVD=" "; 
   String SVD=" ";
   String TVD=" ";
    if(Cit.getFirstVacD()!=null)
        FVD=Cit.getFirstVacD().toString();
    if(Cit.getSecondVacD()!=null)
        SVD=Cit.getSecondVacD().toString();
    if(Cit.getThirdVacD()!=null)
    {
        TVD=Cit.getThirdVacD().toString();
    }
    PS.setString(1, Cit.getFname());
    PS.setString(2, Cit.getLname());
    PS.setString(3, Cit.getDOB().toString());
    PS.setInt(4,Cit.getNumofVac());
    PS.setString(5,FVD);
    PS.setString(6,SVD);
    PS.setString(7,TVD);
    PS.setString(8, Cit.getID());
    PS.setString(9, Cit.getAddress());
    PS.setString(10,Cit.getVacPlace());
    PS.setString(11,Cit.getVacType());
    PS.executeUpdate();
	
		
	
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	
	e.printStackTrace();
	
}	
}
public static void insertNurse(Connection C,Nurse nurse,String Password)
{
try {
    PreparedStatement PS=C.prepareStatement("INSERT INTO SYSTEM.NURSE Values (?,?,?)");
    PS.setString(1, nurse.getUsername());
    PS.setString(2, Password);
    PS.setString(3, nurse.getWorkplace());
  
    PS.executeUpdate();
	
		
	
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	
	e.printStackTrace();
	
}	
}
public static void UpdateCitizen(Connection Con,String Value,String UpdatedColumn,String ID)
{
	try {
		PreparedStatement p = Con.prepareStatement("UPDATE SYSTEM.CITIZEN SET "+UpdatedColumn+" = ? WHERE ID = ? ");
		
		if(UpdatedColumn.equals("NumofVac"))
                {p.setInt(1, Integer.parseInt(Value));}
		else
                {p.setString(1, Value);}
		p.setString(2, ID);
		p.executeUpdate();
              
                
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public static Nurse getNurse(Connection C,String un,String pw)
{try {
	PreparedStatement p =C.prepareStatement("Select * from SYSTEM.NURSE where ? = USERNAME AND ? =Password  ");
        p.setString(1, un);
        p.setString(2, pw);
	p.execute();
 ResultSet rs = p.getResultSet();
 Nurse temp=null;
 while(rs.next())
 {
	 temp= new Nurse(); 
	 temp.setUsername(rs.getString("USERNAME"));
	 temp.setWorkplace(rs.getString("WORKPLACE"));
 }
return temp;

} catch (SQLException e) {
	// TODO Auto-generated catch block
	return null;
	
}
	}
public static Citizen getCitizen(Connection c,String Nid)
{try {
	PreparedStatement p =c.prepareStatement("Select * from SYSTEM.CITIZEN where ? = ID ");
	p.setString(1,Nid);
	p.execute();
 ResultSet rs = p.getResultSet();
 Citizen temp=null;
 while(rs.next())
 {
	 temp= new Citizen(); 
	 temp.setAddress(rs.getString("Address"));
	 temp.setDOB(LocalDate.parse(rs.getString("DOB")));
	 temp.setNumofVac(rs.getInt("NumofVac"));
	 temp.setFname(rs.getString("firstName"));
	 temp.setLname(rs.getString("lastName"));
	 if(!rs.getString("FirstVacD").equals(" ")) {
	 temp.setFirstVacD(LocalDate.parse(rs.getString("FirstVacD")));
	 }
	 else {temp.setFirstVacD(null);}
	 if(!rs.getString("SecondVacD").equals(" ")) {
		 temp.setSecondVacD(LocalDate.parse(rs.getString("SecondVacD")));
		 }
	 else {temp.setSecondVacD(null);}
	 if(!rs.getString("ThirdVacD").equals(" ")) {
		 temp.setThirdVacD(LocalDate.parse(rs.getString("ThirdVacD")));
		 }
	 else {temp.setThirdVacD(null);} 
        temp.setID(Nid);
	temp.setVacPlace(rs.getString("vaccinationPlace"));
        temp.setVacType(rs.getString("vacType"));
          
	 
 }
 
return temp;}
catch (Exception e) {
	return null;
}

}

}
