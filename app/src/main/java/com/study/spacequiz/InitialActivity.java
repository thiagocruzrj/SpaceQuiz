package com.study.spacequiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class InitialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);
    }

    public void startingQuiz(View view){
        Intent intent = new Intent(InitialActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
