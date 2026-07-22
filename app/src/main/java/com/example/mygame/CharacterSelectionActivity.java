package com.example.mygame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class CharacterSelectionActivity extends AppCompatActivity {

    public static final String EXTRA_SELECTED_CHARACTER = "selected_character";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_selection);

        ImageButton buttonBoy = findViewById(R.id.buttonBoy);
        ImageButton buttonGirl = findViewById(R.id.buttonGirl);

        buttonBoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGameWithCharacter("boy");
            }
        });

        buttonGirl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGameWithCharacter("girl");
            }
        });
    }

    private void startGameWithCharacter(String character) {
        Intent intent = new Intent(CharacterSelectionActivity.this, GameActivity.class);
        intent.putExtra(EXTRA_SELECTED_CHARACTER, character);
        startActivity(intent);
        finish();
    }
}
}
