package com.example.basedatoscolegio;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertarCentro extends Activity{

	EditText et_codigo, et_tipo, et_nombre, et_direccion, et_telefono, et_numPlazas;
	Button btn_insertar, btn_consultar; 
	int codigo, numPlazas;
	String  nombre, direccion, telefono;
	Character tipo;
	CrearBD cabd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		cabd = new CrearBD(InsertarCentro.this, "BaseDatosColegio", null, 1);
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_insertar_colegio);
		
		et_codigo = (EditText)findViewById(R.id.editText1);
		et_tipo = (EditText)findViewById(R.id.editText2);
		et_nombre = (EditText)findViewById(R.id.editText3);
		et_direccion = (EditText)findViewById(R.id.editText4);
		et_telefono = (EditText)findViewById(R.id.editText5);
		et_numPlazas = (EditText)findViewById(R.id.editText6);
		
		
		
		btn_insertar = (Button)findViewById(R.id.button1);
		//btn_consultar = (Button)findViewById(R.id.button2);
		
		btn_insertar.setOnClickListener(new View.OnClickListener() {
			
			
			
			@Override
			public void onClick(View v) {
				
				codigo = Integer.parseInt(et_codigo.getText().toString());
				tipo = et_tipo.getText().charAt(0);
				//Toast.makeText(ConsultaColegio.this, tipo, Toast.LENGTH_SHORT).show();
				Log.d("char", tipo+"");
				nombre = et_nombre.getText().toString();
				direccion = et_direccion.getText().toString();
				telefono = et_telefono.getText().toString();
				numPlazas = Integer.parseInt(et_numPlazas.getText().toString());
				
				//abrir/crear base datos
				
				SQLiteDatabase db;
				db = cabd.getWritableDatabase();
				
				if (codigo == 0 || nombre == null || direccion == null 
						|| telefono == null || numPlazas == 0) {
					Toast.makeText(InsertarCentro.this, "Es obligatorio rellenar todos los campos", Toast.LENGTH_LONG).show(); 
				} else {
					//consulta insertar base datos
					db.execSQL("INSERT INTO centros VALUES ("+codigo+",'"+tipo+"',\""+nombre+"\",\""+direccion+"\",\""+telefono+"\","+numPlazas+");");
					db.close();
					Toast.makeText(InsertarCentro.this, "Insertado con exito", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
}
