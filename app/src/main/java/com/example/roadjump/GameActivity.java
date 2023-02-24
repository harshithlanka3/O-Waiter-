package com.example.roadjump;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import android.animation.ObjectAnimator;

import com.example.roadjump.game_classes.Player;


public class GameActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.gameplay);

        Intent intent = getIntent();

        int characterNum = intent.getIntExtra("character", 0);
        int difficultyNum = intent.getIntExtra("difficulty", 0);
        String inputUsername = intent.getExtras().getString("user");

        //ImageView backgroundImage = findViewById(R.id.characterSpriteImage);

        ImageView characterImage = findViewById(R.id.characterSpriteImage);
        TextView livesText = findViewById(R.id.livesNumTxt);
        TextView userText = findViewById(R.id.playerEnteredNameTxt);

        switch (characterNum) {
        case 1:
            characterImage.setImageResource(R.drawable.pengu);
            break;
        case 2:
            characterImage.setImageResource(R.drawable.pepe);
            break;
        default:
            characterImage.setImageResource(R.drawable.bunny);
            break;
        }

        Player currentGamePlayer = new Player(characterImage);

        switch (difficultyNum) {
        case 1:
            livesText.setText("<3 <3");
            break;
        case 2:
            livesText.setText("<3");
            break;
        default:
            livesText.setText("<3 <3 <3");
            break;
        }

        userText.setText(inputUsername);

        //making the character move

    }
}
