package br.unicamp.bookstore.model;

public enum TipoEntregaEnum {
	PAC,
	SEDEX,
	SEDEX10;
	
	public static TipoEntregaEnum getTipoEntregaEnum(int tipoEntrega) {
		switch (tipoEntrega) {
		default:
		case 0:
			return PAC;			
		case 1:
			return SEDEX;
		case 2:
			return SEDEX10;			
		}
	}
}
