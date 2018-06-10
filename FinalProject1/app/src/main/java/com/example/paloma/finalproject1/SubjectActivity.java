package com.example.paloma.finalproject1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class SubjectActivity extends AppCompatActivity {

    ImageView imageVH,imageVG,imageVL;
    DBOpenHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        imageVG=(ImageView)findViewById(R.id.ivG);
        imageVH=(ImageView)findViewById(R.id.ivH);
        imageVL=(ImageView)findViewById(R.id.ivL);
        mydb= new DBOpenHelper(this);

    }
     public void chooseSub(View v){
         ImageView imageView = (ImageView) v;
         if(imageView.getId()==imageVG.getId()){
             Intent intent=new Intent(SubjectActivity.this,QuizActivity.class);
             intent.putExtra("subject","geograph");
             startActivity(intent);
        //  mydb.getAllQuestion("geograph");
            // Toast.makeText(this, "geograph", Toast.LENGTH_LONG).show();
         }
         if(imageView.getId()==imageVL.getId()){
            // mydb.getAllQuestion("history");
             Intent intent=new Intent(SubjectActivity.this,QuizActivity.class);
             intent.putExtra("subject","language");
             startActivity(intent);
            // Toast.makeText(this, "language", Toast.LENGTH_LONG).show();

         }
         if(imageView.getId()==imageVH.getId()){
          //   mydb.getAllQuestion("language");
             Intent intent=new Intent(SubjectActivity.this,QuizActivity.class);
             intent.putExtra("subject","history");
             startActivity(intent);
           //  Toast.makeText(this, "history", Toast.LENGTH_LONG).show();
         }

     }


}
