package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity implements Difficulty {
    Button easy,medium,hard;
    String game_difficulty="medium";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game_difficulty="easy";
                easy.setEnabled(false);
                medium.setEnabled(true);
                hard.setEnabled(true);
            }
        });
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game_difficulty="medium";
                easy.setEnabled(true);
                hard.setEnabled(true);
                medium.setEnabled(false);
            }
        });
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game_difficulty="hard";
                easy.setEnabled(true);
                medium.setEnabled(true);
                hard.setEnabled(false);
            }
        });
    }
    private void init(){
        easy=findViewById(R.id.easy);
        medium=findViewById(R.id.medium);
        hard=findViewById(R.id.hard);
    }
}