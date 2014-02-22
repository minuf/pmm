package com.example.visornoticiashttp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

 @SuppressLint("NewApi") public class MainActivity extends Activity {
	
	private Button buscar;
	private TextView text;
	private ConectBD conectar;
	private SQLiteDatabase database;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		buscar=(Button)findViewById(R.id.buscar);
		Button vernoticia=(Button)findViewById(R.id.vernoticia);
		text=(TextView)findViewById(R.id.textonoticia);
		conectar=new ConectBD(this,"DBNoticias",null,1);
		database=conectar.getWritableDatabase();
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);

		buscar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try{
				String noticias=buscarNoticias();
				text.append(noticias);
				}catch (Exception e){
					text.append("Error " + e);
					e.printStackTrace();
				}
			}
		});
		vernoticia.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i= new Intent(MainActivity.this,MostrarNoticia.class);
				startActivity(i);
			}
		});
	}		
	private String buscarNoticias() throws Exception {
		String salida="";
		int i=0,j=0;
		
		try{
		URL enlace = new URL("http://ep01.epimg.net/rss/elpais/portada.xml");
		HttpURLConnection conexion=(HttpURLConnection) enlace.openConnection();
		conexion.setRequestProperty("User-Agent", "Mozilla/5.0" +
				" (Linux; Android 1.5; es-ES) Ejemplo HTTP");
		
		
		if(conexion.getResponseCode() == HttpURLConnection.HTTP_OK){
			BufferedReader lector = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
			String lectura=lector.readLine();
			while(lectura!=null){
				if(lectura.indexOf("<description>")>=0){
					i=lectura.indexOf("<description>");
					j=lectura.indexOf("</description>");
					salida+=lectura.substring(i,j);
					System.out.println(lectura.substring(i,j));
					database.execSQL("INSERT INTO Noticias (noticia) values ('"+lectura.substring(i,j)+"')");
					salida+="\n------------\n\n";
				}
				lectura=lector.readLine();
			}
			lector.close();
		}
		
		else{
			salida="No encontrado";
		}
		
		database.close();
		conexion.disconnect();
		}
		catch (Exception e){
			salida="No encontrado servidor o noticia.";
		}
		return salida;
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

    

