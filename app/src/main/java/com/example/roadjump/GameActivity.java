package com.example.roadjump;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.*;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.animation.ObjectAnimator;

import com.example.roadjump.game_classes.Player;


public class GameActivity extends AppCompatActivity {

    private Button upBtn;

    private Button downBtn;

    private Button leftBtn;

    private Button rightBtn;

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

        //making the character move buttons establishment

        // registering button
        upBtn = findViewById(R.id.upBtn);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) characterImage.getLayoutParams();

        //handling the start button
        upBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentGamePlayer.setyCoord(currentGamePlayer.getyCoord() + 1);

                layoutParams.topMargin = layoutParams.topMargin - 10;
                //layoutParams.bottomMargin = (int) currentGamePlayer.getyCoord();//your bottom margin value
                characterImage.setLayoutParams(layoutParams);
            }
        });

        downBtn = findViewById(R.id.downBtn);


        //Constraints.LayoutParams layoutParams = (Constraints.LayoutParams) characterImage.getLayoutParams();
        //RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) characterImage.getLayoutParams();

        //handling the start button
        downBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentGamePlayer.setyCoord(currentGamePlayer.getyCoord() - 10);
                layoutParams.bottomMargin = layoutParams.bottomMargin - 10;
                //layoutParams.bottomMargin = (int) currentGamePlayer.getyCoord();//your bottom margin value
                characterImage.setLayoutParams(layoutParams);

                //Constraints.LayoutParams lp= (ConstraintLayout.LayoutParams) characterImage.getLayoutParams();
                //lp.setMargins(left, top, right, bottom);
                //list.setLayoutParams(lp);
            }
        });

        leftBtn = findViewById(R.id.leftBtn);

        //handling the start button
        leftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentGamePlayer.setxCoord(currentGamePlayer.getxCoord() - 10);

                layoutParams.leftMargin = layoutParams.leftMargin - 10;
                //layoutParams.bottomMargin = (int) currentGamePlayer.getyCoord();//your bottom margin value
                characterImage.setLayoutParams(layoutParams);
            }
        });

        rightBtn = findViewById(R.id.rightBtn);

        rightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentGamePlayer.setxCoord(currentGamePlayer.getxCoord() + 1);

                layoutParams.rightMargin = layoutParams.rightMargin - 10;
                //layoutParams.bottomMargin = (int) currentGamePlayer.getyCoord();//your bottom margin value
                characterImage.setLayoutParams(layoutParams);
            }
        });
    }
}
