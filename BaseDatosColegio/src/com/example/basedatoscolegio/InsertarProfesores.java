package com.example.basedatoscolegio;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertarProfesores extends Activity{
	
	EditText et_codigoCentro, et_dni, et_apellidos, et_especialidad;
	
	int codigoCentro, dni;
	String apellidos, especialidad;
	
	Button btn_insertar;
	
	CrearBD cabd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_insertar_profesores);
		
		cabd = new CrearBD(InsertarProfesores.this, "BaseDatosColegio", null, 1);
		
		et_codigoCentro = (EditText)findViewById(R.id.editText1);
		et_dni = (EditText)findViewById(R.id.editText2);
		et_apellidos = (EditText)findViewById(R.id.editText3);
		et_especialidad = (EditText)findViewById(R.id.editText4);
		
		btn_insertar = (Button)findViewById(R.id.button1);
		
		btn_insertar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				codigoCentro = Integer.parseInt(et_codigoCentro.getText().toString());
				dni = Integer.parseInt(et_dni.getText().toString());
				apellidos = et_apellidos.getText().toString();
				especialidad = et_especialidad.getText().toString();
				
				SQLiteDatabase db;
				db = cabd.getWritableDatabase();
				
				db.execSQL("INSERT INTO profesores VALUES ("+codigoCentro+","+dni+",\""+apellidos+"\",\""+especialidad+"\");");
				db.close(); 
				Toast.makeText(InsertarProfesores.this, "Insertado con exito", Toast.LENGTH_SHORT).show();
				
			}
		});
	}
}
