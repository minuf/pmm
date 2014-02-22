package com.example.basedatoscolegio;

public class Centros {
	String nombre, direccion, telefono, codigo, num_plazas, tipo_centro;

	
	public Centros (String codigo, String tipo_centro, String nombre, 
			String direccion, String telefono, String num_plazas) {
		this.codigo = codigo;
		this.tipo_centro = tipo_centro;		
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.num_plazas = num_plazas;		
	}

}
