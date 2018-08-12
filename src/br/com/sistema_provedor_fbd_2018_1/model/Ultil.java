package br.com.sistema_provedor_fbd_2018_1.model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.sistema_provedor_fbd_2018_1.view.Menssagens;

public class Ultil {
	private static Calendar calendar;
	public static String separarString(String txt, int parte) {
		String[] split = txt.split("-");
		return split[parte].trim();
	}

	public static Date converterStringParaDataSQL(String txt) {
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

	public static String converterDataSQLParaString(Date date) {

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
		return dataFormatada;

	}

	public static String dataAtualEmString() {
		Calendar c = Calendar.getInstance();
		java.util.Date data = c.getTime();
		DateFormat f = DateFormat.getDateInstance();
		return f.format(data);
	}
	public static String converterJavaDateEmString(java.util.Date data) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return String.valueOf(format.format(data));
	}
	public static Calendar pegarDataParaEdicao(String data) {
		if(calendar == null) {
			calendar = Calendar.getInstance();
		}
		calendar.setTime(Ultil.converterStringEmJavaDate(data));
		return calendar;
		
	}
}
