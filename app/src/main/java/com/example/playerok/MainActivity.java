package com.example.playerok;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.graphics.Color.*;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static Button b1, b2;
    private static MediaPlayer mp;
    private static TextView namesong;
    private static Boolean need = false;
    private static Boolean ispaused = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(this, R.raw.song1);
        b1 = (Button) findViewById(R.id.start);
        b2 = (Button) findViewById(R.id.pause);
        namesong = (TextView) findViewById(R.id.name);
        namesong.setText("Slava");

        Toast toast = Toast.makeText(this,
                "onCreate", Toast.LENGTH_SHORT);
        toast.show();

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);



    }


    public void run(View view) {
        if (!ispaused) {
            mp.start();
            b1.setBackgroundColor(Color.RED);
        }
    }

    public void pause(View view) {
        if (ispaused) {
            ispaused = false;
            mp.start();
            b2.setText("Pause");

            Toast toastresumed = Toast.makeText(this,
                    "resumed", Toast.LENGTH_SHORT);

            toastresumed.show();
        } else {
            ispaused = true;
            mp.pause();
            b2.setText("Resume");
            Toast toastpaused = Toast.makeText(this,
                    "paused", Toast.LENGTH_SHORT);
            toastpaused.show();
        }



    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.start){
            run(v);
        }
        if (v.getId() == R.id.pause){
            pause(v);
        }

    }
}