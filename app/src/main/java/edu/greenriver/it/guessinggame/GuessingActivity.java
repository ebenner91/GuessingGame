package edu.greenriver.it.guessinggame;

/**
 * This is an application that runs a number guessing game
 * This activity runs the guessing game
 *
 * @author Elizabeth Benner
 * @version 1.0
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GuessingActivity extends AppCompatActivity {

    EditText input;
    Button submit;
    TextView prompt;
    static final int UPPER_BOUND = 15;
    int targetNumber = (int)(Math.random() * UPPER_BOUND + 1); //generates random number from 1 - upper bound
    int guessCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing);

        getElements();
        setPromptText();
        guessButton();

    }

    /**
     * Saves the design elements into variables to be accessed by the program
     */
    void getElements() {
        input = (EditText) findViewById(R.id.numberInput);
        submit = (Button) findViewById(R.id.submitButton);
        prompt = (TextView) findViewById(R.id.promptText);
    }

    /**
     * Sets the prompt text to reflect the range of the number
     */
    void setPromptText() {
        String promptString = "Please enter a number between 1 and " + UPPER_BOUND;
        prompt.setText(promptString);
    }

    /**
     * Sets the click listener for the guessing button and runs the
     * if/else logic handling the guess
     */
    void guessButton() {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String guessEntered = input.getText().toString();
                if(guessEntered.equals("")) {
                    errorToast();
                } else {
                    int guessNumber = Integer.parseInt(guessEntered);

                    if(guessNumber < 1) {
                        pastUpperBoundToast();
                        //If guess is less than one, it's out of bounds
                        //Alert the user of error and don't count guess
                    } else if(guessNumber > UPPER_BOUND) {
                        pastUpperBoundToast();
                        //If guess is greater than the upper bound, it's out of bounds
                        //Alert the user of error and don't count guess
                    }else if(guessNumber > targetNumber) {
                        highGuessToast();
                        guessCount += 1;
                    } else if (guessNumber < targetNumber) {
                        lowGuessToast();
                        guessCount += 1;
                    } else if (guessNumber == targetNumber) {
                        successToast();
                        guessCount += 1;
                        String finalCount = Integer.toString(guessCount);
                        sendSuccess(finalCount);

                    }
                }

            }
        });
    }

    /**
     * Makes a toast if nothing was entered
     */
    void errorToast() {
        Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
    }

    /**
     * Makes a toast if the user's guess was too high
     */
    void highGuessToast() {
        Toast.makeText(this, "Too high, guess lower!", Toast.LENGTH_SHORT).show();
    }

    /**
     * Makes a toast if the user's guess was too low
     */
    void lowGuessToast() {
        Toast.makeText(this, "Too low, guess higher!", Toast.LENGTH_SHORT).show();
    }

    /**
     * Makes a toast if the user's guess is out of bounds
     */
    void pastUpperBoundToast() {
        String boundsWarning = "Out of bounds! Please make sure your guess is between 1 and " +
                UPPER_BOUND;
        Toast.makeText(this, boundsWarning, Toast.LENGTH_SHORT).show();
    }

    /**
     * Makes a toast when user guesses the target number
     */
    void successToast() {
        Toast.makeText(this, "Yay, you guessed it!", Toast.LENGTH_SHORT).show();
    }

    /**
     * Uses an intent to pass the final guess count to the next activity
     * @param finalCount a String representing the final number of guesses used to find the number
     */
    void sendSuccess(String finalCount) {
        Intent intent = new Intent(getApplicationContext(), ResultsActivity.class);
        intent.putExtra("intentCount", finalCount);
        startActivity(intent);
    }
}
