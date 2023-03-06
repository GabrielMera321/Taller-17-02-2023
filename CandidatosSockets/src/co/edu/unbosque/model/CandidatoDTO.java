package co.edu.unbosque.model;

import java.io.Serializable;

public class CandidatoDTO implements Serializable{
	
	private String nombre;
	private int cedula;
	private String cargo;
	private int edad;
	
	public CandidatoDTO() {
		// TODO Auto-generated constructor stub
	}

	public CandidatoDTO(String nombre, int cedula, String cargo, int edad) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
		this.cargo = cargo;
	
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getEps() {
		return cargo;
	}

	public void setEps(String eps) {
		this.cargo = cargo;
	}


	public int getHora_llegada() {
		return edad;
	}

	public void setHora_llegada(int edad) {
		this.edad = edad;
	}
	@Override
	public String toString() {
		String res ="";
		res += this.nombre+","+this.cedula+","+this.cargo+","+this.edad+"\n";
	return res;
	}
}
