package com.example.jorgecolorado_1evaluacion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Resultado extends Activity{
	
	Bundle myBundle;
	TextView tv_zona, tv_tarifa, tv_peso, tv_decoracion, tv_precio;
	
	ImageView iv_foto;
	
	String  deco, urg; Boolean urgente; double prec; int peso;
	
	Button btn_calcular_billetes;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_resultado_envio);
		
		btn_calcular_billetes = (Button)findViewById(R.id.btn_calcular_monedas);
		
		tv_zona = (TextView)findViewById(R.id.tv_tipos_billetes);
		tv_tarifa = (TextView)findViewById(R.id.textView3);
		tv_peso = (TextView)findViewById(R.id.textView4);
		tv_decoracion = (TextView)findViewById(R.id.textView5);
		tv_precio = (TextView)findViewById(R.id.textView6);
		iv_foto = (ImageView)findViewById(R.id.imageView2);
		
		myBundle = getIntent().getExtras();
		Destino destino = (Destino) myBundle.getSerializable("DESTINO");
		
		urgente = myBundle.getBoolean("URGENTE");
		peso = myBundle.getInt("PESO");
		deco = myBundle.getString("DECORACION");
		
		prec = destino.getPrecio();
		
		//peso = Integer.parseInt(pes);
		
		///*calcular el peso del paquete y sumarle la cantidad correspondiente
		if (peso <= 5){
			prec = prec+peso;
		}
		if (peso > 5 && peso <= 10){
			prec = prec+peso*1.5;
		}
		if (peso >10) {
			prec = prec+peso*2;
		}
		
		//calcular si el pedido es urgente y sumarle la cantidad correspondiente
		if (urgente) {
			urg = "urgente";
			prec = 	prec + prec*0.30;
		}else {
			urg = "normal";
			prec = prec;
		}		
		/**********/

		tv_zona.setText("Zona: "+destino.getZona()+" ("+destino.getContinente()+")");
		tv_tarifa.setText("Tarifa: "+urg);
		
		tv_peso.setText("Peso: "+peso+" kg");
		tv_decoracion.setText("Decoracion: "+deco);
		tv_precio.setText("Precio: "+prec+" €");
		
		
		if (destino.getZona().equalsIgnoreCase("A")){
			iv_foto.setImageResource(R.drawable.america_africa);
		}else {
			if (destino.getZona().equalsIgnoreCase("B")){
				iv_foto.setImageResource(R.drawable.asia_oceania);
			}else {
				if (destino.getZona().equalsIgnoreCase("C")) iv_foto.setImageResource(R.drawable.europa); 
			}
		}		
		
		btn_calcular_billetes.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(Resultado.this, CalculoBilletes.class);
				i.putExtra("PRECIO", prec);
				startActivity(i);
				finish();				
			}
		});
		
		
		
		
		
		
	}

}
