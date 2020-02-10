package com.example.umpire;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    TextView strikeNum;
    TextView ballNum;
    Button upStrikeButton;
    Button downStrikeButton;
    Button upBallButton;
    Button downBallButton;
    Button clearButton;
    Button exitButton;
    Button aboutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        strikeNum = findViewById(R.id.strikeNum);
        ballNum = findViewById(R.id.ballNum);
        upStrikeButton = findViewById(R.id.upStrikeButton);
        downStrikeButton = findViewById(R.id.downStrikeButton);
        upBallButton = findViewById(R.id.upBallButton);
        downBallButton = findViewById(R.id.downBallButton);
        clearButton = findViewById(R.id.clearButton);
        exitButton = findViewById(R.id.exitButton);
        aboutButton = findViewById(R.id.aboutButton);



        // When button is pressed increment the strikes counter
        findViewById(R.id.upStrikeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countUpStrikes(view, strikeNum);
            }
        });


        // When button is pressed increment the balls counter
        findViewById(R.id.upBallButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countUpBalls(view, ballNum);
            }
        });

        // When button is pressed decrement the strikes counter
        findViewById(R.id.downStrikeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDown(view, strikeNum);
            }
        });

        // When button is pressed decrement the balls counter
        findViewById(R.id.downBallButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDown(view, ballNum);
            }
        });


        // When button is pressed clear the counters
        findViewById(R.id.clearButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear(view);
            }
        });

        // When button is pressed exit the app
        findViewById(R.id.exitButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });

        // When button is pressed information displayed
        findViewById(R.id.aboutButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Umpire Buddy 2.0")
                        .setMessage("Author: Connor Marchand")
                        .setCancelable(true)
                        .setNegativeButton("Back", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        }).show();
            }
        });
    }

    // Helper method to increment a strike text counter
    private void countUpStrikes(View view, TextView textView) {
        String intString = textView.getText().toString();
        Integer count = Integer.parseInt(intString);
        count++;

        if(count == 3){
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Strike Out!")
                    .setMessage("Out!")
                    .setCancelable(true)
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    })
                    .setPositiveButton("Reset", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //do nothing
                        }
                    }).show();
            count = 0;
            ballNum.setText(count.toString());
            strikeNum.setText(count.toString());
        }

        textView.setText(count.toString());
    }

    // Helper method to increment a strike text counter
    private void countUpBalls(View view, TextView textView) {
        String intString = textView.getText().toString();
        Integer count = Integer.parseInt(intString);
        count++;

        if(count == 4){
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Walk!")
                    .setMessage("Walk!")
                    .setCancelable(true)
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    })
                    .setPositiveButton("Reset", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //do nothing
                        }
                    }).show();
            count = 0;
            ballNum.setText(count.toString());
            strikeNum.setText(count.toString());
        }

        textView.setText(count.toString());
    }


    // Helper method to decrement a text counter
    private void countDown(View view, TextView textView) {
        String intString = textView.getText().toString();
        Integer count = Integer.parseInt(intString);
        if(count > 0){
            count--;
        }
        textView.setText(count.toString());
    }

    // Helper method to clear the ball and strike counters
    private void clear(View view) {
        String stikeNumString = strikeNum.getText().toString();
        String ballNumString = ballNum.getText().toString();
        Integer countStrike = Integer.parseInt(stikeNumString);
        Integer countBall = Integer.parseInt(ballNumString);

        countStrike = 0;
        countBall = 0;

        strikeNum.setText(countBall.toString());
        ballNum.setText(countStrike.toString());
    }



}
