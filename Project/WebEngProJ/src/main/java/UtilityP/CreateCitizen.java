package UtilityP;

import java.sql.Connection;

import Models.Citizen;

public class CreateCitizen {
public static Citizen create(Connection c, String Nid)
{
	return DBMan.getCitizen(c, Nid);
}
}
