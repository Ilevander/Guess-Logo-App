package com.example.guess_logo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView questionTextView;
    private Button submitButton;
    private ImageView mQuizImage;
    private int mScore = 0;
    private int mQuizNum = 1;
    private int QuestionNum = 0;
    private TextView mQuestionView;
    private TextView mQuizNumView;
    private Questions mQuestions = new Questions();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       mQuestionView = findViewById(R.id.question_textview);
       mQuizNumView = findViewById(R.id.quiznum_textview);

       Button submit = findViewById(R.id.button_submit);
       submit.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view){
             //Quiz Logic
           }
       });
    }
    @SuppressLint("DiscouragedApi")
    private void showMainImage(){
        mQuizImage = findViewById(R.id.quiz_image);
        String img = mQuestions.getmImages(QuestionNum);
        mQuizImage.setImageResource(getResources().getIdentifier(img,"drawable",getPackageName()));

    }



}
