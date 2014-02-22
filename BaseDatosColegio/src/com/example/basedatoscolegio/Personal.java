package com.example.basedatoscolegio;

public class Personal {

	int codigo_centro, dni;
	String apellidos, funcion;
	Float salario;
	
	public Personal (int codigo_centro, int dni, String apellidos,
			String funcion, Float salario) {
		this.codigo_centro = codigo_centro;
		this.dni = dni;
		this.apellidos = apellidos;
		this.funcion = funcion;
		this.salario = salario;
	}
}
