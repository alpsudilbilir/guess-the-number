package com.alpsu.guess_the_number;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {

    TextView txtYouWon;
    TextView txtCong;
    Button btnPlayAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        txtYouWon = findViewById(R.id.txtYouWon);
        txtCong = findViewById(R.id.txtCong);
        btnPlayAgain = findViewById(R.id.btnPlayAgain);
        txtCong.setText("Game Over");
        txtYouWon.setText("You Lost!");
        if(GameActivity.youWon){
            txtCong.setText("Congratulations");
            txtYouWon.setText("You Won!");
            GameActivity.youWon = false;
        }
        btnPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameOver.this,GameActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(GameOver.this,MainActivity.class);
        startActivity(intent);
        finish();

    }
}