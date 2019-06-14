package com.study.spacequiz;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView question;
    private RadioButton bt1;
    private RadioButton bt2;
    private RadioButton bt3;
    private RadioGroup radioGroup;
    private ImageView imageView;

    private String rightAnswer;
    private int rightCount = 0;

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
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        radioGroup = findViewById(R.id.radioGroup);

        for(int i = 0; i < quizData.length; i++){
            ArrayList<String> tempArray = new ArrayList<>();
            tempArray.add(quizData[i][0]);
            tempArray.add(quizData[i][1]);
            tempArray.add(quizData[i][2]);

            quizArray.add(tempArray);
        }
        showNextQuiz();
    }

    private void showNextQuiz() {
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());
        ArrayList<String> quiz = quizArray.get(randomNum);
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
        builder.setCancelable(false);
        builder.show();
    }
}
