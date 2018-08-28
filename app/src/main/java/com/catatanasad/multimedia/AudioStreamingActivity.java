package com.catatanasad.multimedia;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.io.IOException;

public class AudioStreamingActivity extends AppCompatActivity {

    Button btnPlay, btnStop;
    ProgressBar progressBar;
    MediaPlayer player;
    String url_streaming = "http://103.16.198.36:9160/stream";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_streaming);

        btnPlay = findViewById(R.id.btn_play_streaming);
        btnStop = findViewById(R.id.btn_stop_streaming);
        progressBar = findViewById(R.id.progress_bar);

        // todo sembuunyikan progress bar
        progressBar.setIndeterminate(false);
        progressBar.setVisibility(View.INVISIBLE);
        progressBar.setMax(100);

        // todo disable stop enable play
        btnPlay.setEnabled(true);
        btnStop.setEnabled(false);

        setPlaying();

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setIndeterminate(false);

                player.prepareAsync();
                player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {

                        mp.start();
                        progressBar.setIndeterminate(true);
                    }
                });

                btnPlay.setEnabled(false);
                btnStop.setEnabled(true);
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (player.isPlaying()){
                    player.stop();
                    player.release();
                    setPlaying();
                    progressBar.setVisibility(View.INVISIBLE);
                    progressBar.setIndeterminate(false);
                }

                btnStop.setEnabled(false);
                btnPlay.setEnabled(true);

            }
        });
    }

    private void setPlaying() {

        player = new MediaPlayer();

        try {
            player.setDataSource(url_streaming);
        } catch (IOException e) {
            e.printStackTrace();
        }

        player.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
            @Override
            public void onBufferingUpdate(MediaPlayer mp, int percent) {

                progressBar.setIndeterminate(true);
                progressBar.setSecondaryProgress(100);

            }
        });

    }
}