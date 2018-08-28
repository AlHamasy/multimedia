package com.catatanasad.multimedia;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class AudioActivity extends AppCompatActivity implements View.OnClickListener {

    // todo 1 : deklarasi
    Button btnPlay, btnStop, btnResume, btnPause;

    // todo 4 : panggil kelas media player
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        // todo 2 : inisialisasi id
        btnPlay = findViewById(R.id.btn_play);
        btnStop = findViewById(R.id.btn_stop);
        btnResume = findViewById(R.id.btn_resume);
        btnPause = findViewById(R.id.btn_pause);

        btnPlay.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnResume.setOnClickListener(this);
        btnPause.setOnClickListener(this);

        // todo 3 : enable btnPlay, disable yang lain
        btnPlay.setEnabled(true);
        btnPause.setEnabled(false);
        btnStop.setEnabled(false);
        btnResume.setEnabled(false);

    }

    @Override
    public void onClick(View v) {

        int id = v.getId();

        if (id == R.id.btn_play){

            // todo 5 : panggil file audionya dengan uri
            Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.music);

            // todo 6 : panggil media player
            player = new MediaPlayer();
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);

            try {
                player.setDataSource(AudioActivity.this,uri);
                player.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }


            player.start();

            // todo 7 : btnStop dan btnPause enable, btnPlay dan btnResume disable
            btnStop.setEnabled(true);
            btnPause.setEnabled(true);

            btnPlay.setEnabled(false);
            btnResume.setEnabled(false);
        }
        else if (id == R.id.btn_pause){

            if (player.isPlaying()){
                player.pause();
            }

            // todo 8 : btnResume enable, yang lain disable
            btnResume.setEnabled(true);

            btnPlay.setEnabled(false);
            btnPause.setEnabled(false);
            btnStop.setEnabled(false);
        }
        else if (id == R.id.btn_resume){

            player.start();

            // todo 9 : btnPause dan btnStop enable, btnPlay dan btnResume disable
            btnPause.setEnabled(true);
            btnStop.setEnabled(true);

            btnPlay.setEnabled(false);
            btnResume.setEnabled(false);
        }
        else if (id == R.id.btn_stop){

            if (player.isPlaying() && player != null){
                player.stop();
            }

            // todo 10 : btnPlay enable, yang lain disable, kembali seperti semula
            btnPlay.setEnabled(true);

            btnResume.setEnabled(false);
            btnPause.setEnabled(false);
            btnStop.setEnabled(false);

        }

    }
}
