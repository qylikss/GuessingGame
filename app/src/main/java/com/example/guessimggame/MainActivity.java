package com.example.guessimggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.view.Menu;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Button btnGuess;
    private Button btnTicTacToe;
    private Button btnRock;
    private TextView txtWelcome;
    private TextView txtCondition;
    private TextView txtWork;
    private EditText txtGuess;
    private int theNumber;

    public void checkGuess() {
        String guessText = txtGuess.getText().toString();
        String message = "";
        try {
            int guess = Integer.parseInt(guessText);
            if (guess < theNumber)
                message = guess + " is too low. Try again.";
            else if (guess > theNumber)
                message = guess + " is too high. Try again.";
            else {
                message = guess + " is correct. You win! Let's play again!";
                newGame();
            }
        } catch (Exception e) {
            message = "Enter a whole number between 1 and 100.";
        }
        finally {
            txtWork.setText(message); txtGuess.requestFocus(); txtGuess.selectAll();
        }
    }

    public void newGame() {
        theNumber = (int)(Math.random() * 100 + 1);
    }

        @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtGuess = (EditText) findViewById(R.id.txtGuess);
        btnGuess = (Button) findViewById(R.id.btnGuess);
        txtWork = (TextView) findViewById(R.id.txtWork);
        btnTicTacToe = (Button) findViewById(R.id.btnTicTacToe);
        btnRock = (Button) findViewById(R.id.btnRock);
        newGame();
        btnGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkGuess(); }
        });

        btnTicTacToe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TicTacToeActivity.class));
            }
        });

        btnRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RockPaperScissorsActivity.class));
            }
        });
    }
}