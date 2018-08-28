package com.catatanasad.multimedia;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoStreamingActivity extends AppCompatActivity {

    // todo deklarasi
    VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_streaming);

        // todo inisialisasi ID
        video = findViewById(R.id.video_view_streaming);

        // todo membuat progress dialog
        final ProgressDialog dialog = new ProgressDialog(VideoStreamingActivity.this);
        dialog.setTitle("Loading");
        dialog.setMessage("Harap tunggu");
       //dialog.setIndeterminate(false);
        dialog.setCancelable(false);
        dialog.show();

        // todo media controller
        MediaController controller = new MediaController(VideoStreamingActivity.this);
        controller.setAnchorView(video);
        video.setMediaController(controller);

        // todo set url video
        String url = "http://www.androidbegin.com/tutorial/AndroidCommercial.3gp";
        Uri uri_url = Uri.parse(url);
        video.setVideoURI(uri_url);

        // todo play video
        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                dialog.dismiss();
                mp.start();
            }
        });
    }
}







