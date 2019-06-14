package com.study.spacequiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView resultAnswers = findViewById(R.id.resultAnswers);
        MediaPlayer win;
        MediaPlayer fail;
        int score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT", 0);

        win = MediaPlayer.create(this, R.raw.nice);
        fail = MediaPlayer.create(this, R.raw.lose);

        if (score >=4 ) {
            win.start();
        } else {
            fail.start();
        }
    }
    public void returnInitial(View view){
        Intent intent = new Intent(getApplicationContext(), InitialActivity.class);
        startActivity(intent);
    }
}
