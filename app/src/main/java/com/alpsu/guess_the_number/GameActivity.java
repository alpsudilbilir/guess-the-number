package com.alpsu.guess_the_number;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    TextView txtAttempts;
    TextView txtRemain;
    TextView txtClue;
    EditText editTxtNum;
    Button btnGuess;
    Random rand = new Random();
    int trueNumber;
    int userGuess;
    int remainingttempts = 10;
    public static boolean youWon = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initViews();
        trueNumber = rand.nextInt(1000);
        btnGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtAttempts.setVisibility(View.VISIBLE);
                txtRemain.setVisibility(View.VISIBLE);
                txtClue.setVisibility(View.VISIBLE);
                try{
                    userGuess = Integer.parseInt(editTxtNum.getText().toString());
                }catch (NumberFormatException n){
                    Toast.makeText(GameActivity.this, "Enter a number!", Toast.LENGTH_SHORT).show();
                }
                if(trueNumber == userGuess){
                    Intent intent = new Intent(GameActivity.this,GameOver.class);
                    youWon = true;
                    startActivity(intent);
                    finish();
                }
                if(trueNumber > userGuess){
                    txtClue.setText("Guess Bigger!");
                    remainingttempts--;
                    editTxtNum.setText("");
                    isGameOver();
                }
                if(trueNumber < userGuess){
                    txtClue.setText("Guess Lower!");
                    remainingttempts--;
                    editTxtNum.setText("");
                    isGameOver();
                }
                txtRemain.setText(String.valueOf(remainingttempts));
            }
        });





    }
    public void initViews(){
        txtAttempts = findViewById(R.id.txtAttempts);
        txtRemain = findViewById(R.id.txtRemain);
        txtClue = findViewById(R.id.txtClue);
        editTxtNum = findViewById(R.id.editTxtNum);
        btnGuess = findViewById(R.id.btnGuess);
    }
    public void isGameOver(){
        if(remainingttempts <= 0){
            Intent intent = new Intent(GameActivity.this,GameOver.class);
            startActivity(intent);
            finish();
        }

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(GameActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}