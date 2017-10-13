package edu.greenriver.it.guessinggame;

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
        bindFunctionality();

    }

    void getElements() {
        input = (EditText) findViewById(R.id.numberInput);
        submit = (Button) findViewById(R.id.submitButton);
        prompt = (TextView) findViewById(R.id.promptText);
    }

    void setPromptText() {
        String promptString = "Please enter a number between 1 and " + UPPER_BOUND;
        prompt.setText(promptString);
    }

    void bindFunctionality() {
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
                    } else if(guessNumber > UPPER_BOUND) {
                        pastUpperBoundToast();
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

    void errorToast() {
        Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
    }

    void highGuessToast() {
        Toast.makeText(this, "Too high, guess lower!", Toast.LENGTH_SHORT).show();
    }

    void lowGuessToast() {
        Toast.makeText(this, "Too low, guess higher!", Toast.LENGTH_SHORT).show();
    }

    void pastUpperBoundToast() {
        String boundsWarning = "Out of bounds! Please make sure your guess is between 1 and " +
                UPPER_BOUND;
        Toast.makeText(this, boundsWarning, Toast.LENGTH_SHORT).show();
    }

    void successToast() {
        Toast.makeText(this, "Yay, you guessed it!", Toast.LENGTH_SHORT).show();
    }

    void sendSuccess(String finalCount) {
        Intent intent = new Intent(getApplicationContext(), ResultsActivity.class);
        intent.putExtra("intentCount", finalCount);
        startActivity(intent);
    }
}
