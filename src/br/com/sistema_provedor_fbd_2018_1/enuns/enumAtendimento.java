package br.com.sistema_provedor_fbd_2018_1.enuns;

public enum enumAtendimento {
	ABERTO("aberto"), CANCELADO("cancelado"),
	CONCLUIDO("concluido"), ESPERA("espera"), ATRASADO("atrasado");
	private String status;
	private enumAtendimento(String status) {
		this.status = status;
	}
	
	public static enumAtendimento getEnum(String status) {
		switch(status) {
		case "aberto":
			return ABERTO;
		case "cancelado":
			return CANCELADO;
		case "espera":
			return ESPERA;
		case "concluido":
			return CONCLUIDO;
		case "atrasado":
			return ATRASADO;
			default:
				return null;
			
		}
	}
	
	
	public String getStatus() {
		return status;
	}
}
