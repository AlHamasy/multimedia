package com.catatanasad.multimedia;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class AudioSederhanaActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnPlay, btnStop;

    MediaPlayer player;

    String PLAY = "PLAY", STOP = "STOP", RESUME = "RESUME", PAUSE = "PAUSE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_sederhana);

        btnPlay = findViewById(R.id.btn_play);
        btnStop = findViewById(R.id.btn_stop);

        btnPlay.setOnClickListener(this);
        btnStop.setOnClickListener(this);

        btnPlay.setText(PLAY);
        btnStop.setText(STOP);

    }

    @Override
    public void onClick(View v) {

        int id = v.getId();

        if (id == R.id.btn_play){

            if(btnPlay.getText().toString().equals(PLAY)){
                btnPlay.setText(PAUSE);

                Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.music);

                player = new MediaPlayer();
                player.setAudioStreamType(AudioManager.STREAM_MUSIC);

                try {
                    player.setDataSource(AudioSederhanaActivity.this, uri);
                    player.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                player.start();
            }
            else if (btnPlay.getText().toString().equals(PAUSE)){
                btnPlay.setText(RESUME);
                if (player.isPlaying()){
                    player.pause();
                }
            }
            else if (btnPlay.getText().toString().equals(RESUME)){
                btnPlay.setText(PAUSE);
                player.start();
            }
        }

        else if (id == R.id.btn_stop){

            btnPlay.setText(PLAY);
            if (player.isPlaying() && player != null){
                player.stop();

            }
        }
    }
}
