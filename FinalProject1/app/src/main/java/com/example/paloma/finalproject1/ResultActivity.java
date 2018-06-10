package com.example.paloma.finalproject1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {
ImageView ivFinal;
TextView textVScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        int score= getIntent().getIntExtra("score", 0);
        textVScore=(TextView)findViewById(R.id.ScoreTV);

        Toast.makeText(this, ""+score, Toast.LENGTH_SHORT).show();
        ivFinal=(ImageView)findViewById(R.id.ivEmoji);
        if(score<3){
            ivFinal.setImageResource(R.drawable.sad);
        }else{
            ivFinal.setImageResource(R.drawable.happy);
        }

        textVScore.setText("Score: "+score);

    }
}
