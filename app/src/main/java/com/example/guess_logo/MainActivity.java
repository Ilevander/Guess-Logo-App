package com.example.guess_logo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.graphics.Color;




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
    private String mAnswer;
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
    private void showRadioButtonAnswers(int qnum){
        final LinearLayout answerLayout = findViewById(R.id.answers_layout);

        RadioGroup rg = new RadioGroup(this);
        rg.setOrientation(RadioGroup.VERTICAL);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        rg.setLayoutParams(lp);
        rg.setPadding(400,0,0,0);


        final RadioButton[] rb1 = new RadioButton[3];

        for (int i = 0;i <=2 ; i++){
            rb1[i] = new RadioButton(this);
            rb1[i].setText(mQuestions.getmChoice(qnum) [i]);
            rb1[i].setTextColor(Color.BLACK);
            rb1[i].setPadding(10,16,8,16);
            rb1[i].setTextSize(25);
            rb1[i].setId(i);
            rb1[i].setWidth(1000);

            rg.addView(rb1[i]);
        }

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int Id) {

                mAnswer = mQuestions.getmChoice(QuestionNum)[Id];

            }
        });

        answerLayout.addView(rg);

    }


}
