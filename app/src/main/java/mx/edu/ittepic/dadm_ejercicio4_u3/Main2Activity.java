package mx.edu.ittepic.dadm_ejercicio4_u3;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {
    MediaPlayer md;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Lienzo(this));
    }

    public void audioAmarillo(){
        md = MediaPlayer.create(this, R.raw.amarillopaul);
        md.start();
    }

    public void audioAzul(){
        md = MediaPlayer.create(this, R.raw.azulpaul);
        md.start();
    }

    public void audioVerde() {
        md = MediaPlayer.create(this, R.raw.verdepaul);
        md.start();
    }

    public void audioNegro() {
        md = MediaPlayer.create(this, R.raw.negropau);
        md.start();
    }

    public void audioPurpura() {
        md = MediaPlayer.create(this, R.raw.purpurapaul);
        md.start();
    }

    public void audioRojo() {
        md = MediaPlayer.create(this, R.raw.rojopaul);
        md.start();
    }

}
