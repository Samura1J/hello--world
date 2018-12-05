package io.che.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class NumbersGame extends AppCompatActivity {

    public int winner;

    public void backToMainFunction(View view) {

        finish();

    }

    public void guessNumber(View view) {

        EditText userGuess = (EditText) findViewById(R.id.userGuessEditText);

        String guessText = userGuess.getText().toString();
        Integer guess = Integer.parseInt(guessText);

        if (guess == winner) {
            Toast.makeText(NumbersGame.this, "You Win!! The winning number is " + winner, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(NumbersGame.this, "Sorry, try again. :(", Toast.LENGTH_SHORT).show();
        }
    }

    public void numberHint(View view) {

        Toast.makeText(NumbersGame.this, "The number is " + winner, Toast.LENGTH_SHORT).show();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers_game);

        Random random = new Random();
        winner = random.nextInt(20) + 1;

    }
}
