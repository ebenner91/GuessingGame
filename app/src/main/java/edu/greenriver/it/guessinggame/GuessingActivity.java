package edu.greenriver.it.guessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GuessingActivity extends AppCompatActivity {

    EditText input;
    Button submit;
    int targetNumber = (int)(Math.random() * 21);
    int guessCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing);

        getElements();
        bindFunctionality();

    }

    void getElements() {
        input = (EditText) findViewById(R.id.numberInput);
        submit = (Button) findViewById(R.id.submitButton);
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

                    if(guessNumber > targetNumber) {
                        highGuessToast();
                    } else if (guessNumber < targetNumber) {
                        lowGuessToast();
                    } else if (guessNumber == targetNumber) {
                        successToast();
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

    void successToast() {
        Toast.makeText(this, "Yay, you guessed it!", Toast.LENGTH_SHORT).show();
    }
}
