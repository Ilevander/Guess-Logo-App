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
import android.widget.ScrollView;
import android.os.Handler;
import android.content.Intent;
import android.widget.Toast;
import com.example.guess_logo.ResultActivity;





public class MainActivity extends AppCompatActivity {

    private TextView questionTextView;
    private Button submitButton;
    private ImageView mQuizImage;
    private int mScore = 0;
    private int mQuizNum = 1;
    private int QuestionNum = 0;
    private TextView mQuestionView;
    private TextView mQuizNumView;
    private Questions questions = new Questions();
    private String mAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuestionView = findViewById(R.id.question_textview);
        mQuizNumView = findViewById(R.id.quiznum_textview);

        updateQuestion();

        Button submit = findViewById(R.id.button_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ("radiobutton".equals(questions.getType(QuestionNum))) {
                    if (questions.getmCorrecrtAnswers(QuestionNum).equals(mAnswer)) {
                        mScore++;
                        displayToastCorrectAnswer();
                    } else {
                        displayToastWrongAnswer();
                    }
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (QuestionNum == questions.getLenght() - 1) {
                    Intent intent_result = new Intent(MainActivity.this, ResultActivity.class);
                    intent_result.putExtra("totalQuestions", questions.getLenght());
                    intent_result.putExtra("finalScore", mScore);
                    startActivity(intent_result);

                    QuestionNum = 0;
                    mQuizNum = 0;
                    mScore = 0;
                } else {
                    QuestionNum++;
                    mQuizNum++;
                }

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        updateQuestion();
                    }
                }, 1000);
            }
        });
    }



    private void displayToastCorrectAnswer(){
        Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
    }
    private void displayToastWrongAnswer(){
        Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
    }


    @SuppressLint("DiscouragedApi")
    private void showMainImage() {
        mQuizImage = findViewById(R.id.quiz_image);
        String img = questions.getmImages(QuestionNum);
        mQuizImage.setImageResource(getResources().getIdentifier(img, "drawable", getPackageName()));
    }

    // Dynamic Radio Button
    private void showRadioButtonAnswers(int qnum) {
        final LinearLayout answerLayout = findViewById(R.id.answers_layout);

        RadioGroup rg = new RadioGroup(this);
        rg.setOrientation(RadioGroup.VERTICAL);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        rg.setLayoutParams(lp);
        rg.setPadding(400, 0, 0, 0);

        final RadioButton[] rb1 = new RadioButton[3];

        for (int i = 0; i <= 2; i++) {
            rb1[i] = new RadioButton(this);
            rb1[i].setText(questions.getmChoice(qnum)[i]);
            rb1[i].setTextColor(Color.BLACK);
            rb1[i].setPadding(10, 16, 8, 16);
            rb1[i].setTextSize(25);
            rb1[i].setId(i);
            rb1[i].setWidth(1000);

            rg.addView(rb1[i]);
        }

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int Id) {
                mAnswer = questions.getmChoice(QuestionNum)[Id];
            }
        });

        answerLayout.addView(rg);
    }

    // Update Questions
    private void updateQuestion() {
        LinearLayout answerLayout = findViewById(R.id.answers_layout);
        answerLayout.removeAllViews();
        mAnswer = "";

        mQuizNumView.setText(mQuizNum + "/" + String.valueOf(questions.getLenght())); // Corrected method call
        mQuestionView.setText(questions.getmQuestions(QuestionNum));

        if ("radiobutton".equals(questions.getType(QuestionNum))) {
            showRadioButtonAnswers(QuestionNum);
        }

        showMainImage();

        ScrollView sv = findViewById(R.id.scrollView);
        sv.smoothScrollTo(0, 0);
    }
}
