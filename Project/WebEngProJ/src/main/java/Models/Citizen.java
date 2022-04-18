package Models;

import java.time.LocalDate;

public class Citizen {
public String getVacType() {
		return vacType;
	}
	public void setVacType(String vacType) {
		this.vacType = vacType;
	}
public String getVacPlace() {
		return VacPlace;
	}
	public void setVacPlace(String vacPlace) {
		VacPlace = vacPlace;
	}
public LocalDate getFirstVacD() {
		return FirstVacD;
	}
	public void setFirstVacD(LocalDate firstVacD) {
		FirstVacD = firstVacD;
	}
	public LocalDate getSecondVacD() {
		return SecondVacD;
	}
	public void setSecondVacD(LocalDate secondVacD) {
		SecondVacD = secondVacD;
	}
	public LocalDate getThirdVacD() {
		return ThirdVacD;
	}
	public void setThirdVacD(LocalDate thirdVacD) {
		ThirdVacD = thirdVacD;
	}
public String getID() {
		return ID;
	}
	public boolean setID(String iD) {
		if(iD.length()==10)
		{ID = iD;
		return true;}
		else
			return false;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public LocalDate getDOB() {
		return DOB;
	}
	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getNumofVac() {
		return numofVac;
	}
	public void setNumofVac(int numofVac) {
		this.numofVac = numofVac;
	}
String ID;
String Fname;
String Lname;
LocalDate DOB;
String VacPlace;
LocalDate FirstVacD;
LocalDate SecondVacD;
LocalDate ThirdVacD;
String Address;
int numofVac;
String vacType;
public Citizen()
{
 numofVac=0;
 FirstVacD=null;
 SecondVacD=null;
 ThirdVacD=null;
 
}


}
