package com.study.spacequiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView question;
    private RadioGroup radioGroup;
    private RadioButton bt1;
    private RadioButton bt2;
    private RadioButton bt3;
    private Button nextQuestion;

    private String rightAnswer;
    private int rightCount = 0;
    private int quizCount = 1;
    static final private int QUIZ_COUNT = 5;

    ArrayList<ArrayList<String>>quizArray = new ArrayList<>();

    String quizData[][] = {
            // {Question, right, option2, option3}
            {"What kind of astro is the SUN ?", "Star","Planet","White Dwarf"},
            {"What's the first planet in the Solar System ?", "Mercury","Saturne","Earth"},
            {"What does a Nebula create ?", "New stars","New black holes", "New Planets"},
            {"The Sun transform hydrogen in ?","Helium","Oxigen","Ammonia"},
            {"What's the lest planet in th Solar System ?", "Uranus","Pluto","Neptune"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question = findViewById(R.id.question);
        bt1 = findViewById(R.id.a1);
        bt2 = findViewById(R.id.a2);
        bt3 = findViewById(R.id.a3);
        radioGroup = findViewById(R.id.radioGroup);
        nextQuestion = findViewById(R.id.nextQuestion);

        for(int i = 0; i < quizData.length; i++){
            ArrayList<String> tempArray = new ArrayList<>();
            tempArray.add(quizData[i][0]);
            tempArray.add(quizData[i][1]);
            tempArray.add(quizData[i][2]);
            tempArray.add(quizData[i][3]);

            quizArray.add(tempArray);
        }

    }

    private void showNextQuiz() {
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());
        final ArrayList<String> quiz = quizArray.get(randomNum);
        question.setText(quiz.get(0));
        rightAnswer = quiz.get(1);
        quiz.remove(0);
        Collections.shuffle(quiz);

        bt1.setText(quiz.get(0));
        bt2.setText(quiz.get(1));
        bt3.setText(quiz.get(2));

        quizArray.remove(randomNum);
    }

    public void checkAnswer (View view){
        RadioButton answerBtn = findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        String alertTitle;

        if(btnText.equals(rightAnswer)){
            alertTitle = "Nice !";
            rightCount++;
        } else {
            alertTitle = "Wrong answer !";
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Answer: " + rightAnswer);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (quizCount == QUIZ_COUNT){
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    intent.putExtra("RIGHT_ANSWER_COUNT", rightCount);
                    startActivity(intent);
                } else {
                    quizCount++;
                    showNextQuiz();
                }
            }
        });

        builder.setCancelable(false);
        builder.show();
    }
}
