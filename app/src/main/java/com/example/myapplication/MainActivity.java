package com.example.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends Activity{
    Button rules,more,enough,difficulty;
    TextView player,aiscore;
    int p1,ai;
    Integer game_difficulty=1;
    Boolean fail=false,stop=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        p1 = 0;
        Random rnd = new Random();
        boolean end=false;
        difficulty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent diff=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(diff);
                finish();
            }
        });
        if(!fail) {
            more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    p1 += rnd.nextInt(13 + 1);
                    player.setText(String.valueOf(p1));
                    if (p1 >= 22) {
                        more.setEnabled(false);
                        endgame();


                    }
                    else{
                        more.setEnabled(true);
                    }
                }
            });
        }
        else{
            more.setEnabled(false);
        }
        enough.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game_difficulty();
            }
        });
        rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Az nyer aki közelebb lesz a 21-es értékhez", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void new_game(){
        ai=0;
        p1=0;
    }
    public void init(){
        rules=findViewById(R.id.rules);
        more=findViewById(R.id.more);
        enough=findViewById(R.id.enough);
        player=findViewById(R.id.player);
        aiscore=findViewById(R.id.ai);
        difficulty=findViewById(R.id.difficulty);
    }
    public void endgame(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Szeretnéd Újra játszani ?")
                .setPositiveButton("igen", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        new_game();
                    }
                })
                .setNegativeButton("Nem , kilépek!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                        System.exit(0);
                    }
                });
    }
    public void difficulty_settings(){
            String []difficulty={"easy","medium","hard"};
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Nehézségi szint")
                    .setItems(difficulty, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                                //in progress
                        }
                    });
        }
        public void game_difficulty(){
            switch (game_difficulty){
                case(0):{
                    ai=(int)(Math.random()*20)+0;
                    aiscore.setText(String.valueOf(ai));
                    break;
                }
                case(1):{
                    ai=(int)(Math.random()*21-8)+15;
                    aiscore.setText(String.valueOf(ai));
                    break;
                }
                case(2):{
                    ai=(int)(Math.random()*21)+0;
                    aiscore.setText(String.valueOf(ai));
                    break;

                }
                default:{
                    break;
                }
            }
        }

    }

