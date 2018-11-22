package mx.edu.ittepic.dadm_ejercicio4_u3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Imagen {
    Bitmap icono;
    float x,y;

    public Imagen(int resource, float _x, float _y, Lienzo l){
        icono = BitmapFactory.decodeResource(l.getResources(),resource);
        x = _x;
        y = _y;
    }

    public void pintar(Canvas c, Paint p, String mensaje){
        c.drawBitmap(icono,x,y,p);

        p.setTextSize(50);
        p.setColor(Color.CYAN);
        c.drawText(mensaje,x+50,y+350,p);
    }

    public boolean estaEnArea (float xp, float yp){
        float x2,y2;

        x2 = x + icono.getWidth();
        y2 = y + icono.getHeight();

        if (xp >= x && xp <= x2){
            if (yp >= y && yp <= y2){
                return true;
            }
        }
        return false;
    }
}
