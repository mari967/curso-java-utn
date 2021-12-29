package com.mc.questionados.response;

public class GenericResponse {
	
	public GenericResponse() {}
	
	public GenericResponse(Boolean isOK, String mensaje, Long id) {
		this.isOK = isOK;
		this.mensaje = mensaje;
		this.id = id;
	}
	
	private Boolean isOK;
	private String mensaje = "";
	private Long id;
	
	
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
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
