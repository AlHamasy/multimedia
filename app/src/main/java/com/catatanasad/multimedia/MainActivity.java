package com.catatanasad.multimedia;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Todo 1 : deklarasi
    Button btnAudio, btnAudioSederhana, btnAudioStreaming, btnVideo, btnVideoStreaming;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // todo 2 : inisialisasi id
        btnAudio = findViewById(R.id.btn_audio);
        btnAudioSederhana = findViewById(R.id.btn_audio_sederhana);
        btnAudioStreaming = findViewById(R.id.btn_audio_streaming);
        btnVideo = findViewById(R.id.btn_video);
        btnVideoStreaming = findViewById(R.id.btn_video_streaming);

        btnAudio.setOnClickListener(this);
        btnAudioSederhana.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn_audio:
                startActivity(new Intent(MainActivity.this, AudioActivity.class));
                break;

            case R.id.btn_audio_sederhana:
                startActivity(new Intent(MainActivity.this, AudioSederhanaActivity.class));
                break;

        }
    }
}
