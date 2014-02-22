package com.example.basedatoscolegio;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	
	Intent i;
	
	Button btn_colegios, btn_personal, btn_profesores, btn_consultas;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btn_colegios = (Button)findViewById(R.id.btn_colegios);
		btn_personal = (Button)findViewById(R.id.btn_personal);
		btn_profesores = (Button)findViewById(R.id.btn_profesores);
		btn_consultas = (Button)findViewById(R.id.btn_consultas);
		
		btn_colegios.setOnClickListener(this);
		btn_personal.setOnClickListener(this);
		btn_profesores.setOnClickListener(this);
		btn_consultas.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == btn_colegios){
			i = new Intent(MainActivity.this, ConsultaCentros.class);
		}
		if (v == btn_personal){
			i = new Intent(MainActivity.this, InsertarPersonal.class);
		}
		if (v == btn_profesores){
	
		}
		if (v == btn_consultas){
	
		}	
		
		startActivity(i);
		
		
	}

}
