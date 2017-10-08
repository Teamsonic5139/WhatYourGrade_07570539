package com.example.whatyourgrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.AlteredCharSequence;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog;
import android.content.DialogInterface;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText NameEditText, ScoreEditText;
    private Button CalculateButton;
    private  Button ExitButton;
    private String errorName = "ป้อนชื่อ";
    private String errorScore = "ป้อนคะแนน";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NameEditText = (EditText) findViewById(R.id.edit_name);
        ScoreEditText = (EditText) findViewById(R.id.edit_score);
        CalculateButton = (Button) findViewById(R.id.cal_button);
        ExitButton = (Button) findViewById(R.id.exit_button);
        CalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(NameEditText.getText().length()==0&&ScoreEditText.getText().length()==0){

                    NameEditText.setError(errorName);
                    ScoreEditText.setError(errorScore);
            }
              else  if(NameEditText.getText().length()==0){

                    NameEditText.setError(errorName);
                }
              else  if(ScoreEditText.getText().length()==0){
                    ScoreEditText.setError(errorScore);

              }else {


                    Integer score = Integer.valueOf(ScoreEditText.getText().toString());
                    String name = NameEditText.getText().toString();
                    String scoreText = getGrade(score);


                    Intent intent = new Intent((MainActivity.this), GradeResult.class);
                    intent.putExtra("name_1", name);
                    intent.putExtra("score_1", scoreText);
                    startActivity(intent);

                }


            }
        });

        ExitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Are you sure you want to exit?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                MainActivity.this.finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }

        });



    }

    private  String getGrade(Integer score){
        String scoreText = "";
        if(score >= 80 ){
            scoreText="A";
        }
        else if(score >=70 ){
            scoreText="B";
        }
        else if(score >= 60 ){
            scoreText="C";
        }
        else if(score >= 50 ){
            scoreText="D";
        }
        else {
            scoreText="F";
        }
        return scoreText;

    }
}
