package com.example.paloma.finalproject1;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

   private TextView textViewQuestion;
   private TextView textViewScore;
   private TextView textViewQuestionCount;
   private TextView textViewCountDown;
   private RadioGroup rGroup;
   private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private Button buttonNext;
    private List<Question> questionList;

    private ColorStateList textColorDeafult;
    public int questionCountTotal;
    private int questionCounter=0;
    private Question currentQuestion;
    public int score=0;
    public boolean answered;



    DBOpenHelper mydb;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        String message=getIntent().getStringExtra("subject");
      //  Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        mydb = new DBOpenHelper(this);


        textViewQuestion=(TextView)findViewById(R.id.textViewQuestion);
        textViewScore=(TextView)findViewById(R.id.textViewScore);
        textViewQuestionCount=(TextView)findViewById(R.id.textView_question_count);
        textViewCountDown=(TextView)findViewById(R.id.textView_countDown);
        rGroup=(RadioGroup)findViewById(R.id.rg);
        rb1=(RadioButton)findViewById(R.id.rb1);
        rb2=(RadioButton)findViewById(R.id.rb2);
        rb3=(RadioButton)findViewById(R.id.rb3);
        rb4=(RadioButton)findViewById(R.id.rb4);
        buttonNext=(Button)findViewById(R.id.button);
      questionList=mydb.getAllQuestion(message);
      textColorDeafult=rb1.getTextColors();
      questionCountTotal=questionList.size();

        Collections.shuffle(questionList);
       showNextQuestion();

         buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!answered) {
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(QuizActivity.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();


                }


            }
        });


    }

    private void showNextQuestion(){
     rb1.setTextColor(textColorDeafult);
        rb2.setTextColor(textColorDeafult);
        rb3.setTextColor(textColorDeafult);
        rb4.setTextColor(textColorDeafult);
        rGroup.clearCheck();





        //  Toast.makeText(this, ""+questionCountTotal, Toast.LENGTH_SHORT).show();





        /*test
        currentQuestion=questionList.get(1);
        textViewQuestion.setText(currentQuestion.getQuestion());
        rb1.setText(currentQuestion.getOp1());
        rb2.setText(currentQuestion.getOp2());
        rb3.setText(currentQuestion.getOp3());
        rb4.setText(currentQuestion.getOp4());
//-------------Fim Test---------------------------------------------------------


*/

       if(questionCountTotal>questionCounter){
            currentQuestion=questionList.get(questionCounter);
            textViewQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOp1());
            rb2.setText(currentQuestion.getOp2());
            rb3.setText(currentQuestion.getOp3());
            rb4.setText(currentQuestion.getOp4());

            questionCounter++;
            textViewQuestionCount.setText("Question "+questionCounter +" / "+questionCountTotal);
            answered=false;
            buttonNext.setText("confirm");
         //   buttonNext.setVisibility(View.INVISIBLE);
       }else{
           // finish();

           Intent intent= new Intent(QuizActivity.this,ResultActivity.class);
           intent.putExtra("score",score);
           startActivity(intent);
        }
    }


   public void checkAnswer(){
        answered=true;
        RadioButton rbSelected=findViewById(rGroup.getCheckedRadioButtonId());
        int answerNr=rGroup.indexOfChild(rbSelected)+1;
        if(answerNr==currentQuestion.getAnswer_nr()){
            score++;
            textViewScore.setText("Score: "+score);
        }
        showAnswer();

    }
  public void  showAnswer(){
      rb1.setTextColor(Color.RED);
      rb2.setTextColor(Color.RED);
      rb3.setTextColor(Color.RED);
      rb4.setTextColor(Color.RED);
   switch (currentQuestion.getAnswer_nr()){
       case 1:
           rb1.setTextColor(Color.GREEN);
          break;

       case 2:
           rb2.setTextColor(Color.GREEN);
           break;
       case 3:
           rb3.setTextColor(Color.GREEN);
           break;
       case 4:
           rb4.setTextColor(Color.GREEN);
           break;

   }
   if(questionCounter<questionCountTotal){
       buttonNext.setText("next");
   }else{
       buttonNext.setText("Confirm");
   }

    }
    //---ActionBar part

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_op, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch(item.getItemId()){

            case R.id.item1:
           Intent intent=new Intent(QuizActivity.this,MainActivity.class);
           startActivity(intent);
                break;

            case R.id.item2:
                onPause();
                break;
            case R.id.item3:
                finish();


        }
        return super.onOptionsItemSelected(item);
    }
}
