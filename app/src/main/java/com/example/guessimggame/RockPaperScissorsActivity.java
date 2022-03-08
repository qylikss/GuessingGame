package com.example.guessimggame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class RockPaperScissorsActivity extends AppCompatActivity {

    private Button[] buttons = new Button[3];
    private TextView txtChoose;
    private ImageButton button_0;
    private ImageButton button_1;
    private ImageButton button_2;
    private ImageButton buttonComp0;
    private ImageButton buttonComp1;
    private ImageButton buttonComp2;
    private int theChoose;

    public void newGame() {
        theChoose = (int) (Math.random() * 3);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_paper_scissors);

        txtChoose = (TextView) findViewById(R.id.txtChoose);
        button_0 = (ImageButton) findViewById(R.id.button_0);
        button_1 = (ImageButton) findViewById(R.id.button_1);
        button_2 = (ImageButton) findViewById(R.id.button_2);
        buttonComp0 = (ImageButton) findViewById(R.id.buttonComp0);
        buttonComp1 = (ImageButton) findViewById(R.id.buttonComp1);
        buttonComp2 = (ImageButton) findViewById(R.id.buttonComp2);


        Button buttonReset = findViewById(R.id.btnResetRock);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });
//Камень
        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame();
                button_1.setVisibility(View.INVISIBLE);
                button_2.setVisibility(View.INVISIBLE);
                txtChoose.setVisibility(View.INVISIBLE);
                if (theChoose == 0){
                    buttonComp0.setVisibility(View.VISIBLE);
                    draw();
                }
                else if(theChoose == 1){
                    buttonComp1.setVisibility(View.VISIBLE);
                    playerWin();
                }
                else{
                    buttonComp2.setVisibility(View.VISIBLE);
                    playerLoose();
                }
            }
        });
//Ножницы
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame();
                button_0.setVisibility(View.INVISIBLE);
                button_2.setVisibility(View.INVISIBLE);
                txtChoose.setVisibility(View.INVISIBLE);
                if (theChoose == 0){
                    buttonComp0.setVisibility(View.VISIBLE);
                    playerLoose();
                }
                else if(theChoose == 1){
                    buttonComp1.setVisibility(View.VISIBLE);
                    draw();
                }
                else{
                    buttonComp2.setVisibility(View.VISIBLE);
                    playerWin();
                }
            }
        });
//Бумага
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame();
                button_0.setVisibility(View.INVISIBLE);
                button_1.setVisibility(View.INVISIBLE);
                txtChoose.setVisibility(View.INVISIBLE);
                if (theChoose == 0){
                    buttonComp0.setVisibility(View.VISIBLE);
                    playerWin();
                }
                else if(theChoose == 1){
                    buttonComp1.setVisibility(View.VISIBLE);
                    playerLoose();
                }
                else{
                    buttonComp2.setVisibility(View.VISIBLE);
                    draw();
                }
            }
        });
    }

    private void playerLoose() {
        Toast.makeText(this, "You loose!", Toast.LENGTH_SHORT).show();
    }

    private void playerWin() {
        Toast.makeText(this, "You win!", Toast.LENGTH_SHORT).show();
    }

    private void draw() {
        Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show();
    }

    private void resetBoard() {
        buttonComp0.setVisibility(View.INVISIBLE);
        buttonComp1.setVisibility(View.INVISIBLE);
        buttonComp2.setVisibility(View.INVISIBLE);
        button_0.setVisibility(View.VISIBLE);
        button_1.setVisibility(View.VISIBLE);
        button_2.setVisibility(View.VISIBLE);
        txtChoose.setVisibility(View.VISIBLE);
    }

    private void resetGame() {
        resetBoard();
    }
}