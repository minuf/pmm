package com.example.visornoticiashttp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class ConectBD extends SQLiteOpenHelper {
	
	String creartabla = "CREATE TABLE IF NOT EXISTS Noticias (codigo INTEGER PRIMARY KEY, noticia varchar(100))";

	public ConectBD(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onCreate(SQLiteDatabase bd) {
		bd.execSQL(creartabla);
	}
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}
