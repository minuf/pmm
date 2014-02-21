package com.example.jorgecolorado_1evaluacion;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	Spinner spinner1;
	RadioGroup grupoRadio;
	RadioButton rb1, rb2;
	CheckBox cb1, cb2;
	EditText et_peso;
	Button btn_calcular;
	
	Destino destino;
	Boolean urgente;
	int peso;
	String decoracion;
	
	Destino [] destinos = {
			new Destino("A", "Asia y Oceania", 30),
			new Destino("B", "America y Asia", 20),
			new Destino("C", "Europa", 10)};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/*Intent in = new Intent(MainActivity.this, DibujoPersona.class);
		 startActivity(in);*/
		
		spinner1 = (Spinner)findViewById(R.id.spinner1);
		grupoRadio = (RadioGroup)findViewById(R.id.radioGroup1);
		rb1 = (RadioButton)findViewById(R.id.radio0);
		rb2 = (RadioButton)findViewById(R.id.radio1);
		cb1 = (CheckBox)findViewById(R.id.checkBox1);
		cb2 = (CheckBox)findViewById(R.id.checkBox2);
		et_peso = (EditText)findViewById(R.id.editText1);
		btn_calcular = (Button)findViewById(R.id.btn_calcular_monedas);
		
		et_peso.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				et_peso.setText("");				
			}
		});
		
		
		//creamos el adaptador y se lo asignamos al spinner
		AdaptadorDestino adaptador = new AdaptadorDestino(this);
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(adaptador);
		//creamos el listener del spinner
		spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				destino = destinos[position];
			}

			
			public void onNothingSelected(AdapterView<?> arg0) {
				
			}
        	
		});
		//////////////////Listener de los radiobutton////////////////
		grupoRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				
				switch(checkedId){
					case R.id.radio0: urgente = false;
						break;
					case R.id.radio1: urgente = true;
						break;
					default:				
				}				
			}
		});
		///////////////////////////////////////////////////////////
		
		/////////////////////////////
		decoracion = decoracion();
		////////////////////////
		
		btn_calcular.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try {
					peso = Integer.parseInt(et_peso.getText().toString());
				}catch(Exception e){
					peso = 0;
				}
				if (peso == 0 || peso/peso != 1){
					Toast.makeText(MainActivity.this, "Debes introducir el peso.", Toast.LENGTH_SHORT).show();
				}else {					
					Intent i = new Intent(MainActivity.this, Resultado.class);
					i.putExtra("DESTINO", destino);
					i.putExtra("URGENTE", urgente);
					i.putExtra("PESO", peso);
					i.putExtra("DECORACION", decoracion());
					startActivity(i);
				}				
			}
		});
		
		
		
	}
	
	public String decoracion() {
		String deco = "";
		if (cb1.isChecked()){
			deco += "Con caja regalo. ";			
		}
		if (cb2.isChecked()) deco += "Con dedicatoria. ";
		return deco;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	 public boolean onOptionsItemSelected(MenuItem item) {
		 switch(item.getItemId()) {
		 case R.id.dibujar: Intent in = new Intent(MainActivity.this, DibujoPersona.class);
		 startActivity(in);
		 return true;
		 case R.id.acerca_de: Toast.makeText(getApplicationContext(), "Desarrollador: Jorge Colorado", Toast.LENGTH_SHORT).show();
		 return true;
		 }
		return true;
		 
	 }
	
	// clase interna para crear el adaptador personalizado para nuestro listview
		class AdaptadorDestino extends ArrayAdapter {
			
			Activity context;

			public AdaptadorDestino(Activity context) {
				super(context, R.layout.layout_spinner_compuesto, destinos);
				this.context = context;
				// TODO Auto-generated constructor stub
			}
			
			//este metodo sirve para que cuando se despliegue el spinner infle cada una de las opciones
			public View getDropDownView(int position, View convertView, ViewGroup parent) {
				return getView(position, convertView, parent);
			}
			
			public View getView(int position, View convertView, ViewGroup parent) {
	            LayoutInflater inflater = context.getLayoutInflater();
	            View item = inflater.inflate(R.layout.layout_spinner_compuesto, null);
	     
	            TextView lbl_zona = (TextView)item.findViewById(R.id.tv_prec_total);
	            lbl_zona.setText(destinos[position].getZona());
	     
	            TextView lbl_continente = (TextView)item.findViewById(R.id.tv_tipos_billetes);
	            lbl_continente.setText(destinos[position].getContinente());
	            
	            TextView lbl_precio = (TextView)item.findViewById(R.id.textView3);
	            lbl_precio.setText(""+destinos[position].getPrecio());
	            
	            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	     
	            return(item);
	            }
			
		}

}
