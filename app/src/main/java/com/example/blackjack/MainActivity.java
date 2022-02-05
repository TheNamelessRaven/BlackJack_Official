package com.example.blackjack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button rules,more,enough;
    TextView player,aiscore;
    int p1,ai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        p1 = 0;
        Random rnd = new Random();
        boolean end=false;


        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p1 += rnd.nextInt(13 + 1);
                player.setText(String.valueOf(p1));
            }
        });

        rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Az nyer aki közelebb lesz a 21-es értékhez", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void init(){
        rules=findViewById(R.id.rules);
        more=findViewById(R.id.more);
        enough=findViewById(R.id.enough);
        player=findViewById(R.id.player);
        aiscore=findViewById(R.id.ai);
    }
}