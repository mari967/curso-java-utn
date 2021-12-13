package com.mc.questionados.response;

public class GenericResponse {
	private Boolean isOK;
	private String mensaje = "";
	private long id;
	
	
	public Boolean getIsOK() {
		return isOK;
	}
	public void setIsOK(Boolean isOK) {
		this.isOK = isOK;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
}
