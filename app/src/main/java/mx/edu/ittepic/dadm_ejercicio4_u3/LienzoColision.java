package mx.edu.ittepic.dadm_ejercicio4_u3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class LienzoColision extends View {
    ImagenColision azul, amarillo,verde,letraamarilla,letraazul,letraverde, puntero;

    public LienzoColision(Context context) {
        super(context);

        azul = new ImagenColision(R.drawable.azul, 150, 200, this);
        amarillo = new ImagenColision(R.drawable.amarillo, 150, 600, this);
        verde = new ImagenColision(R.drawable.verde, 150, 1000, this);

        letraverde =  new ImagenColision(R.drawable.letraverde, 700, 600, this);
        letraamarilla = new ImagenColision(R.drawable.letraamarilla, 700, 200, this);
        letraazul = new ImagenColision(R.drawable.letraazul, 700, 1000, this);


        puntero = null;// para que un objeto se vuelva puntero tiene no tener memoria

    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        canvas.drawColor(Color.BLACK);

        azul.pintar(canvas, p);
        amarillo.pintar(canvas, p);
        verde.pintar(canvas,p);
        letraverde.pintar(canvas,p);
        letraamarilla.pintar(canvas,p);
        letraazul.pintar(canvas,p);

    }

    public boolean onTouchEvent(MotionEvent e){
        float xp = e.getX(); //recuperando la posicion en donde se encuentra el "touch" en el eje de las x (lo ancho de la pantalla)
        float yp = e.getY(); //recuperando la posicion en donde se encuentra el "touch" en el eje de las y (lo alto de la pantalla)



        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (letraazul.estaEnArea(xp,yp)){ //validamos que el toque este en el area
                    //mensaje = "SE TOCO ICONO 1";

                    puntero = letraazul;//puntero APUNTA A icono1
                }

                if (letraamarilla.estaEnArea(xp,yp)){
                    //mensaje = "TOCASTE ICONO 2";

                    puntero = letraamarilla;
                }

                if (letraverde.estaEnArea(xp,yp)){
                    //mensaje = "TOCASTE ICONO 2";

                    puntero = letraverde;
                }
                break;

            case MotionEvent.ACTION_MOVE:
                if (puntero!= null){
                    puntero.mover(xp,yp);

                    if (puntero.colision(azul) && puntero == letraazul){
                        azul.hacerVisible(false);
                        letraazul.hacerVisible(false);
                    }
                }

                if (puntero!= null){
                    puntero.mover(xp,yp);

                    if (puntero.colision(amarillo) && puntero == letraamarilla){
                        amarillo.hacerVisible(false);
                        letraamarilla.hacerVisible(false);
                    }
                }

                if (puntero!= null){
                    puntero.mover(xp,yp);

                    if (puntero.colision(verde) && puntero == letraverde){
                        verde.hacerVisible(false);
                        letraverde.hacerVisible(false);
                    }
                }
                break;

            case MotionEvent.ACTION_UP:
                puntero = null;
                break;
        }
        invalidate();
        return true;
    }
}
