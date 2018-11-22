package mx.edu.ittepic.dadm_ejercicio4_u3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo extends View {
    Imagen azul, amarillo, verde,negra, rojo, purpura;
    Main2Activity puntero2;
    public Lienzo(Context context) {
        super(context);

        azul = new Imagen(R.drawable.azul, 150, 200, this);
        amarillo = new Imagen(R.drawable.amarillo, 150, 600, this);
        verde = new Imagen(R.drawable.verde, 150, 1000, this);

        negra = new Imagen(R.drawable.negra, 700, 200, this);
        rojo = new Imagen(R.drawable.rojo, 700, 600, this);
        purpura = new Imagen(R.drawable.purpura, 700, 1000, this);

        puntero2 = (Main2Activity) context;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        canvas.drawColor(Color.DKGRAY);

        azul.pintar(canvas, p,"BLUE");
        rojo.pintar(canvas,p,"RED");
        negra.pintar(canvas,p,"BLACK");
        purpura.pintar(canvas,p,"PURPLE");
        amarillo.pintar(canvas, p,"YELLOW");
        verde.pintar(canvas,p,"GREEN");

    }

    public boolean onTouchEvent(MotionEvent e){
        float xp = e.getX(); //recuperando la posicion en donde se encuentra el "touch" en el eje de las x (lo ancho de la pantalla)
        float yp = e.getY(); //recuperando la posicion en donde se encuentra el "touch" en el eje de las y (lo alto de la pantalla)


        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (amarillo.estaEnArea(xp,yp)){
                    puntero2.audioAmarillo();//mandando a llamar el metodo que contiene el audio
                }

                if (azul.estaEnArea(xp,yp)){
                    puntero2.audioAzul();//mandando a llamar el metodo que contiene el audio
                }

                if (verde.estaEnArea(xp,yp)){
                    puntero2.audioVerde();//mandando a llamar el metodo que contiene el audio
                }

                if (negra.estaEnArea(xp,yp)){
                    puntero2.audioNegro();//mandando a llamar el metodo que contiene el audio
                }

                if (rojo.estaEnArea(xp,yp)){
                    puntero2.audioRojo();//mandando a llamar el metodo que contiene el audio
                }

                if (purpura.estaEnArea(xp,yp)){
                    puntero2.audioPurpura();//mandando a llamar el metodo que contiene el audio
                }
                break;



            case MotionEvent.ACTION_MOVE:

                break;

            case MotionEvent.ACTION_UP:

                break;
        }
        invalidate();
        return true;
    }
}
