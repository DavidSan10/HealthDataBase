package model;

public enum DocumentType {
	IDENTITY_CARD("Tarjeta de identidad"), CITIZENSHIP_CARD("Cedula de Ciudadania"),
	IMMIGRATION_CARD("Cedula de Extranjeria"), PASSPORT("Pasaporte");

	private String document;

	DocumentType(String document) {
		this.document = document;
	}

	public String getName() {
		return document;
	}

}
