/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.time.LocalDate;

/**
 *
 * @author USER
 */
public class DatePrinter {
    public static String print(LocalDate D ) {
		if(D==null)
                    return "Not Appointed Yet";
                else
                    return D.toString();
	}
}
