package com.example.basedatoscolegio;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class ConsultaCentros extends Activity {

	public static final int CODIGO_RESPUESTA = 123;
	
	CrearBD base;
	private Centros[] datos;
	
	class AdaptadorCentro extends ArrayAdapter<Centros> 
	{
		Activity a;
		AdaptadorCentro(Activity b) 
		{
			super(b, R.layout.estructura_consulta_centros, datos);
			this.a = b;
		}
		public View getDropDownView (int position,View convertView,ViewGroup parent) {
			
			return getView (position, convertView, parent);
			}
		public View getView(int position,View convertView,ViewGroup parent) 
		{
	
			LayoutInflater inflater = a.getLayoutInflater();	
			View item = inflater.inflate(R.layout.estructura_consulta_centros, null);
			 	 	 
			final TextView lblCodigo=(TextView)item.findViewById(R.id.textView1);
			final TextView lblTipo = (TextView)item.findViewById(R.id.textView2);
			final TextView lblNombre = (TextView)item.findViewById(R.id.textView3);
			final TextView lblDireccion = (TextView)item.findViewById(R.id.textView4);
			final TextView lblTelefono = (TextView)item.findViewById(R.id.textView5);
			final TextView lblPlazas = (TextView)item.findViewById(R.id.textView6);
			
			lblNombre.setText(datos[position].nombre);
			lblTipo.setText(datos[position].tipo_centro);
			lblCodigo.setText(datos[position].codigo);
			lblDireccion.setText(datos[position].direccion);
			lblTelefono.setText(datos[position].telefono);
			lblPlazas.setText(datos[position].num_plazas);
			
			return(item);
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_consulta_centros);
		
				
		try 
		{
			
			String[] campos = new String[] {"cod_centro","tipo_centro","nombre","direccion","telefono","num_plazas"};
			
			base=new CrearBD(this,"BaseDatosColegio",null,1);
			SQLiteDatabase db=base.getReadableDatabase();
			
			
			Cursor rs=db.query("centros", campos, null,null,null,null,null);
			
			datos=new Centros[rs.getCount()+1];//Devuelve el numero de filas + 1 
			datos[0]= new Centros("Codigo","Tipo","Nombre","Direccion","Telefono","NumPlazas");
			int i=1;
	        if (rs.moveToFirst()) 
	        {
	                do 
	                {
	                		String cod=rs.getString(0);
	                		String tip=rs.getString(1);
	                		String nom=rs.getString(2);
	                        String dir=rs.getString(3);
	                        String tel=rs.getString(4);
	                        String num=rs.getString(5);
	                        
	                        
	                        datos[i]=new Centros(cod,tip,nom,dir,tel,num);
	                        i++;       
	                }
	                while (rs.moveToNext());
	        }
			
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		
		final Spinner spinner=(Spinner)findViewById(R.id.spinnercentros);
		AdaptadorCentro adaptador =new AdaptadorCentro(this); 
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adaptador);
		

		
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, android.view.View v, int position, long id) {
				Intent intent = new Intent(ConsultaCentros.this, MostrarCentro.class);
				
				Bundle b = new Bundle();
				String codigocentro = ((Centros)parent.getAdapter().getItem(position)).codigo;
				String tipocentro = ((Centros)parent.getAdapter().getItem(position)).tipo_centro;
				String nombrecentro = ((Centros)parent.getAdapter().getItem(position)).nombre;
				String direccion = ((Centros)parent.getAdapter().getItem(position)).direccion;
				String telefono = ((Centros)parent.getAdapter().getItem(position)).telefono;
				String numplazas = ((Centros)parent.getAdapter().getItem(position)).num_plazas;
				
				b.putString("Codigo", codigocentro);
				b.putString("Nombre", nombrecentro);
				b.putString("Direccion", direccion);
				b.putString("Tipo", tipocentro);
				b.putString("Telefono", telefono);
				b.putString("NumPlazas", numplazas);
				  				
				intent.putExtras(b);
				
				
				if(position > 0)
				startActivityForResult(intent, CODIGO_RESPUESTA);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}

			
			
		});
		
		
		Button insertar = (Button)findViewById(R.id.insertarCentro);
		
		insertar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ConsultaCentros.this, InsertarCentro.class);
				
				startActivityForResult(intent, CODIGO_RESPUESTA);
				
			}
		});
			
				
	}
	
	protected void onActivityResult(int requestCode,int resultCode, Intent pData)            
    {
        if ( requestCode == CODIGO_RESPUESTA )//Si el código de respuesta es igual al requestCode
            {
            if (resultCode == Activity.RESULT_OK )//Si resultCode es igual a ok
                {
                    final String dato = pData.getExtras().getString(MostrarCentro.DATO_SUBACTIVIDAD );//Obtengo el string de la subactividad
                    //Aquí se hara lo que se desee con el valor recuperado

                    SQLiteDatabase db=base.getWritableDatabase();
                    db.execSQL(dato);
                    
                    Intent intent = new Intent(ConsultaCentros.this, ConsultaCentros.class);
                    finish();
                    startActivity(intent);
                }
            }
    }
	
}
