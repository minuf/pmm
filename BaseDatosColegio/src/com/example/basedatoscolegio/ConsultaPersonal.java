package com.example.basedatoscolegio;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Spinner;

public class ConsultaPersonal extends Activity{

	Spinner spin;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_consulta_personal);
		
		spin = (Spinner)findViewById(R.id.spinnercentros);
	}
}
