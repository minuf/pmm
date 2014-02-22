package com.example.basedatoscolegio;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertarPersonal extends Activity{
	
	int codigo, dni;
	String apellidos, funcion;
	Float salario;
	
	EditText et_codigo, et_dni, et_apellidos, et_funcion, et_salario;
	
	Button btn_insertar;
	
	CrearBD cabd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_insertar_personal);
		
		cabd = new CrearBD(InsertarPersonal.this, "BaseDatosColegio", null, 1);
		
		et_codigo = (EditText)findViewById(R.id.editText1);
		et_dni = (EditText)findViewById(R.id.editText2);
		et_apellidos = (EditText)findViewById(R.id.editText3);
		et_funcion = (EditText)findViewById(R.id.editText4);
		et_salario = (EditText)findViewById(R.id.editText5);
		
		
		
		btn_insertar = (Button)findViewById(R.id.button1);
		
		btn_insertar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				try {
					codigo = Integer.parseInt(et_codigo.getText().toString());
					dni = Integer.parseInt(et_dni.getText().toString());
					apellidos = et_apellidos.getText().toString();
					funcion = et_funcion.getText().toString();
					salario = Float.parseFloat(et_salario.getText().toString());
					
					SQLiteDatabase db;
					db = cabd.getWritableDatabase();
					
					db.execSQL("INSERT INTO personal VALUES("+codigo+","+dni+",\""+apellidos+"\",\""+funcion+"\","+salario+");");
					db.close();
					Toast.makeText(InsertarPersonal.this, "Insertado con exito", Toast.LENGTH_SHORT).show();
				} catch(Exception e){
					Toast.makeText(InsertarPersonal.this, "Error"+e.toString(), Toast.LENGTH_SHORT).show();
				}
			}
		});
		
	}
}
