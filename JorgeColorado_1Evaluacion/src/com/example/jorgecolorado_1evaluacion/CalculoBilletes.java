package com.example.jorgecolorado_1evaluacion;



import android.app.Activity;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CalculoBilletes extends Activity{
	
	ImageView iv_billetes;

	Bundle myBundle;
	double precio;
	int prec;
	
	int b500, b200, b100, b50, b20, b10, b5, m2, m1, res;
	
	String totalCambio = "";
	
	TextView tvTotal, tvTotalCambio;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_cambio_monedas);
		
		iv_billetes = (ImageView)findViewById(R.id.iv_billetes);
		
		TransitionDrawable mi_transicion = (TransitionDrawable) 
    			getResources().getDrawable(R.drawable.transicion);
    	iv_billetes.setImageDrawable(mi_transicion);
    	mi_transicion.startTransition(2000);
		
		tvTotal = (TextView)findViewById(R.id.tv_prec_total);
		tvTotalCambio = (TextView)findViewById(R.id.tv_tipos_billetes);
		
		myBundle = getIntent().getExtras();
		precio = myBundle.getDouble("PRECIO");
		prec = (int)precio;
		
		Toast.makeText(this, "total"+precio, Toast.LENGTH_SHORT).show();
		calcularCambio(prec);
		tvTotalCambio.setText(totalCambio);
		
	}
	
	public void calcularCambio(int precio){
		if (precio >= 500) {
			b500 = precio/500;
			precio = precio%500;
			totalCambio += "Billetes de 500: "+b500;
		}
		if (precio >= 200) {
			b200 = precio/200;
			precio = precio%200;
			totalCambio += "\nBilletes de 200: "+b200;
		}
		if (precio >= 100) {
			b100 = precio/100;
			precio = precio%100;
			totalCambio += "\nBilletes de 100: "+b100;			
		}
		if (precio >= 50) {
			b50 = precio/50;
			precio = precio%50;
			totalCambio += "\nBilletes de 50: "+b50;			
		}
		if (precio >= 20) {
			b20 = precio/20;
			precio = precio%20;
			totalCambio += "\nBilletes de 20: "+b20;			
		}
		if (precio >= 10) {
			b10 = precio/10;
			precio = precio%10;
			totalCambio += "\nBilletes de 10: "+b10;			
		}
		if (precio >= 5) {
			b5 = precio/5;
			precio = precio%5;
			totalCambio += "\nBilletes de 5: "+b5;			
		}
		if (precio >= 2) {
			m2 = precio/2;
			precio = precio%2;
			totalCambio += "\nMonedas de 2: "+m2;			
		}
		if (precio >= 1) {
			m1 = precio/1;
			precio = precio%1;
			totalCambio += "\nMonedas de 1: "+m1;			
		}
	}
}
