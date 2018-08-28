package com.catatanasad.multimedia;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        video = findViewById(R.id.video_view);

        // todo panggil resource dengan uri
        Uri alamat_video = Uri.parse("android.resource://" +getPackageName()+ "/" +R.raw.androidcommercial);

        // todo membuat media controler
        MediaController controller = new MediaController(VideoActivity.this);

        // todo set controller di video view
        controller.setAnchorView(video);
        video.setMediaController(controller);

        // todo play video
        video.setVideoURI(alamat_video);
        video.start();

    }
}
