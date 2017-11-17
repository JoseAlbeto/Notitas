package com.example.chris.notasmultimedia;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by Invitado on 28/10/2017.
 */

public class Activity_video extends AppCompatActivity {

    private static final int PICK_VIDEO = 100;
    Uri videoUri;
    Button btnGale;
    VideoView video_gallery;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        video_gallery=(VideoView)findViewById(R.id.videoView);
        btnGale=(Button)findViewById(R.id.btnGaleria);
        btnGale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        });
    }

    private void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.INTERNAL_CONTENT_URI);
        gallery.setType("video/*");
        startActivityForResult(gallery, PICK_VIDEO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK && requestCode == PICK_VIDEO){
            videoUri = data.getData();
            video_gallery.setMediaController(new MediaController(this));
            video_gallery.setVideoURI(videoUri);
            video_gallery.requestFocus();
            video_gallery.start();
        }
    }
}
