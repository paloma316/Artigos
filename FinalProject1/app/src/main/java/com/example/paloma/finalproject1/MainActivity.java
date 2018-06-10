package com.example.paloma.finalproject1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer player;
    ImageView ivPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivPlay=(ImageView)findViewById(R.id.ivPlay);


    }
    public void buttonPlayEvent(View v){
        Intent intent=new Intent(MainActivity.this,SubjectActivity.class);
        startActivity(intent);
    /* if( player!=null){
        player=MediaPlayer.create(this,R.raw.button_sound);

     }
         player.start();*/

    }
}
