package br.com.sistema_provedor_fbd_2018_1.model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.sistema_provedor_fbd_2018_1.view.Menssagens;

public class Ultil {

	public static String separarString(String txt, int parte) {
		String[] split = txt.split("-");
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

		return data;

	}

	public static String converterDataParaString(Date date) {
		return new SimpleDateFormat("dd/MM/yyyy").format(date);
	}

	public static java.util.Date converterStringEmJavaDate(String txt) {
		try {
			DateFormat f = DateFormat.getDateInstance();
			java.util.Date d;

			d = f.parse(txt);
			return d;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;

	}
	public static String datasParcelas(String dataString) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date data = converterStringEmJavaDate(dataString);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.add(Calendar.MONTH, 1);        
		String dataFormatada = String.valueOf(format.format(calendar.getTime()));    
		return  dataFormatada;
		
	}
}
