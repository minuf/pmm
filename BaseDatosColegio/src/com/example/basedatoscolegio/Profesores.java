package com.example.basedatoscolegio;

public class Profesores {

	int codigo_centro, dni;
	String apellidos, especialidad;
	
	public Profesores(int codigo_centro, int dni, String apellidos, String especialidad){
		this.codigo_centro = codigo_centro;
		this.dni = dni;
		this.apellidos = apellidos;
		this.especialidad = especialidad;
	}
}
