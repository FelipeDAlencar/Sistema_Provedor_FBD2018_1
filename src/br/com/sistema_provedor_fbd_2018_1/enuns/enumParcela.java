package br.com.sistema_provedor_fbd_2018_1.enuns;

public enum enumParcela {
	ABERTO("em aberto"), PAGO("pago"), CANCELADA("cancelada"), ATRASADA("atrasada");
	private String status;
	private enumParcela(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
	
	public static enumParcela getEnum(String status) {
		switch (status) {
		case "em aberto":
			return ABERTO;
		case "pago":
			return PAGO;
		case "cancelada":
			return CANCELADA;
		case "atrasada":
			return ATRASADA;
		default:
			return null;
		}
	}
}
