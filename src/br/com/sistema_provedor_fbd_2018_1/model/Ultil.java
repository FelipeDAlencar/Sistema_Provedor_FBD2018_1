package br.com.sistema_provedor_fbd_2018_1.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Ultil {
	
	public static String separarString(String txt, int parte) {
		String [] split = txt.split("-");
		return split[parte].trim();
	}
	public static Date converterParaData(String txt) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Date data = null;
		try {
			data = new java.sql.Date(format.parse(txt).getTime());
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 

		return data ;

	}

}
