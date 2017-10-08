package com.example.whatyourgrade;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class GradeResult extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_grade);

        Intent intent = getIntent();
        String name= intent.getStringExtra("name_1");
        String scoreText= intent.getStringExtra("score_1");
        TextView showName = (TextView) findViewById(R.id.showName);
        TextView showGrade = (TextView) findViewById(R.id.showGrade);
        showName.setText(name);
        showGrade.setText(scoreText);
    }

}