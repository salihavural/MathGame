package com.example.mygame;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    private TextView tvQuestion, tvScore;
    private LinearLayout answerContainer;
    private int score = 0;
    private int correctAnswer = 8; // Basit örnek için sabit cevap

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        tvQuestion = findViewById(R.id.tvQuestion);
        tvScore = findViewById(R.id.tvScore);
        answerContainer = findViewById(R.id.answerContainer);

        tvQuestion.setText("5 + 3 = ?");

        // Cevap baloncuklarını oluştur
        int[] answers = {7, 8, 9}; // 8 doğru cevap

        for (int ans : answers) {
            Button btn = new Button(this);
            btn.setText(String.valueOf(ans));
            btn.setLayoutParams(new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1.0f));
            btn.setOnClickListener(v -> checkAnswer(ans));
            answerContainer.addView(btn);
        }
    }

    private void checkAnswer(int selectedAnswer) {
        if (selectedAnswer == correctAnswer) {
            score += 10;
            Toast.makeText(this, "Doğru!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Yanlış!", Toast.LENGTH_SHORT).show();
        }
        tvScore.setText("Puan: " + score);
    }
}