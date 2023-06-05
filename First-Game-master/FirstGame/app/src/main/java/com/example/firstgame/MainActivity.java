package com.example.firstgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    private int playerScore = 0;
    private int enemyScore = 0;

    private ImageView playerHealthbar;
    private ImageView enemyHealthbar;

    private TextView playerScoreText1;
    private TextView enemyScoreText1;

    private ArrayList<Integer> playerHealth = new ArrayList();
    private ArrayList<Integer> enemyHealth = new ArrayList();

    private TextView playerScoreText;
    private TextView enemyScoreText;

    private Button playerAttackButton;
    private Button enemyAttackButton;

    private ImageView playerStickCharacter;
    private ImageView enemyStickCharacter;

    public MainActivity() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerHealthbar = findViewById(R.id.player_health_bar);
        enemyHealthbar = findViewById(R.id.enemy_health_bar);
        playerScoreText = findViewById(R.id.player_score_text);
        enemyScoreText = findViewById(R.id.enemy_score_text);
        playerAttackButton = findViewById(R.id.player_attack_button);
        enemyAttackButton = findViewById(R.id.enemy_attack_button);
        playerStickCharacter = findViewById(R.id.player_stick_character);
        enemyStickCharacter = findViewById(R.id.enemy_stick_character);
        playerScoreText1 = findViewById(R.id.player_score_text1);
        enemyScoreText1 = findViewById(R.id.enemy_score_text1);



        for (int i = 0; i < 10; i++) {
            playerHealth.add(1);
            enemyHealth.add(1);
        }

        playerAttackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (enemyHealth.size() > 0) {
                    enemyHealth.remove(0);
                    enemyHealthbar.setScaleX((float) enemyHealth.size() / 10);
                }
                if (enemyHealth.size() == 0) {
                    playerScore++;
                    playerScoreText.setText("Pontuação do jogador: " + playerScore);
                    for (int i = 0; i < 0; i++) {
                        enemyHealth.add(1);
                        playerHealth.add(1);
                    }
                    enemyHealthbar.setScaleX(1);
                    playerHealthbar.setScaleX(1);
                }
            }
        });

        enemyAttackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (playerHealth.size() > 0) {
                    playerHealth.remove(0);
                    playerHealthbar.setScaleX((float) enemyHealth.size() / 10);
                }
                if (playerHealth.size() == 0) {
                    enemyScore++;
                    enemyScoreText.setText("Pontuação do inimigo: " + enemyScore);
                    for (int i = 0; i < 0; i++) {
                        playerHealth.add(1);
                        enemyHealth.add(1);
                    }
                    playerHealthbar.setScaleX(1);
                    enemyHealthbar.setScaleX(1);

                }
            }
        });

    }
}