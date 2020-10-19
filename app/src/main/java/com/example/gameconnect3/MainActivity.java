package com.example.gameconnect3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int[][] winningPositions =
            {{0, 1, 2}, {3, 4, 5},
            {6, 7, 8}, {0, 4, 8}, {2, 4, 6}
            ,{0, 3, 6},{1, 4, 7}, {2, 5, 8}};

    //empty array to keep track of game state
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    //Yellow = 0
    //Red = 1
    int activePlayer = 0;


    public void dropIn(View view){
        ImageView counter = (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        gameState[tappedCounter] = activePlayer;

        counter.setTranslationY(-1500);

        Log.i("Tag", counter.getTag().toString());

        if(activePlayer == 0){
            counter.setImageResource(R.drawable.yellow);
            activePlayer = 1;
        }
        else{
            counter.setImageResource(R.drawable.red);
            activePlayer = 0;
        }

        counter.animate().translationYBy(1500).rotation(3600).setDuration(500);

        for(int[] winningPosition : winningPositions){
            if(gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]]
            && gameState[winningPosition[0]] != 2){
                //Some has won

                Toast.makeText(this, "Someone has Won", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}