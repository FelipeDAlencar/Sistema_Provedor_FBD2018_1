package br.com.sistema_provedor_fbd_2018_1.sql;

public class Ultil {
	public static String separarString(String txt, int parte) {
		String [] split = txt.split("-");
		return split[parte].trim();
	}

}
