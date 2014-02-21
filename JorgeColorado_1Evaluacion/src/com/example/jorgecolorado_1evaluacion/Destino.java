package com.example.jorgecolorado_1evaluacion;

import java.io.Serializable;


public class Destino implements Serializable{
	private String zona;
	private String continente;
	private int precio;
		
	public Destino (String zona,String continente,int precio){
		this.zona=zona;
		this.continente=continente;
		this.precio=precio;
		
	}
	
		public String getZona (){
		return zona;
	}
	
	
	public String getContinente(){
		return continente;
	}
	
	
	public int getPrecio(){
		return precio;
	}

	
	public void setZona(String nuevaZon){
		zona=nuevaZon;
	}
	
	
	public void setContinente(String nuevoConti){
		continente=nuevoConti;
	}
	
	
	public void setPrecio (int num){
		precio=num;
	}
}
