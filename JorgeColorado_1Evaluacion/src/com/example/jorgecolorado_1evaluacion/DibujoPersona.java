package com.example.jorgecolorado_1evaluacion;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Paint.Style;
import android.graphics.Path.FillType;
import android.os.Bundle;
import android.view.View;

public class DibujoPersona extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(new Dibujo(this));
	}
	
	public class Dibujo extends View {

		public Dibujo(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}
		
		public void onDraw(Canvas canvas) {
			final Paint pincel1 = new Paint();
			pincel1.setColor(Color.CYAN);
			pincel1.setStrokeWidth(10);
			pincel1.setStyle(Style.FILL);
			canvas.drawRect(0, 0, canvas.getWidth(), 400, pincel1);
			pincel1.setColor(Color.DKGRAY);
			canvas.drawRect(0, 400, canvas.getWidth(), canvas.getHeight(), pincel1);

			//cuerpo de la casa
			
			pincel1.setColor(Color.RED);
			pincel1.setStrokeWidth(5);
			pincel1.setStyle(Style.FILL_AND_STROKE);
			
			canvas.drawRect(50, 250, 150, 500, pincel1);
			
			pincel1.setColor(Color.BLUE);
			canvas.drawRect(150, 250,400, 500, pincel1);
			
			//triangulo de arriba
			pincel1.setColor(Color.RED);
			pincel1.setAntiAlias(true);
			Path path=new Path();
			path.setFillType(FillType.EVEN_ODD);
			path.moveTo(50, 250);
			path.lineTo(100, 200);
			path.lineTo(148, 250);
			path.lineTo(50, 250);
			path.close();
			canvas.drawPath(path, pincel1);
			
			//puerta
			pincel1.setColor(Color.BLACK);
			canvas.drawRect(82, 440, 107, 500, pincel1);
			
			//ventanas
			pincel1.setColor(Color.WHITE);
			pincel1.setStyle(Style.FILL);
			canvas.drawRect(200, 300, 250, 350, pincel1);
			canvas.drawRect(300, 300, 350, 350, pincel1);
			
			canvas.drawCircle(100, 228, 17, pincel1);
			
			//lineas contorno
			pincel1.setColor(Color.BLACK);
			pincel1.setStyle(Style.STROKE);
			pincel1.setStrokeWidth(3);
			
			path.setFillType(FillType.EVEN_ODD);
			path.moveTo(50, 250);
			path.lineTo(400, 250);
			path.lineTo(400, 500);
			path.lineTo(50, 500);
			path.lineTo(50, 250);
			
			path.moveTo(150, 250);
			path.lineTo(150, 500);
			//lineas ventanas contorno
			path.moveTo(200, 300);
			path.lineTo(250, 300);
			path.lineTo(250, 350);
			path.lineTo(200, 350);
			path.lineTo(200, 300);
			
			path.moveTo(300, 300);
			path.lineTo(350, 300);
			path.lineTo(350, 350);
			path.lineTo(300, 350);
			path.lineTo(300, 300);
			
			//lineas cruz
			path.moveTo(100, 200);
			path.lineTo(100, 130);
			path.moveTo(75, 145);
			path.lineTo(125, 145);
			
			
			
			canvas.drawPath(path, pincel1); 
		}
		
	}
}
