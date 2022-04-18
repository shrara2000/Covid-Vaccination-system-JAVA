package UtilityP;

import java.sql.Connection;

import Models.Nurse;

public class CreateNurse {
public static Nurse create(Connection C,String un,String pw)
{
	return DBMan.getNurse(C, un, pw);
}
}
