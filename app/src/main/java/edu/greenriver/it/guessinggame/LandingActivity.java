package edu.greenriver.it.guessinggame;
/**
 * This is an application that runs a number guessing game
 * This activity acts as the landing page
 *
 * @author Elizabeth Benner
 * @version 1.0
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LandingActivity extends AppCompatActivity {

    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        getButton();
        bindFunctionality();
    }

    /**
     * Save the start button to a variable to be accessed by the click listener
     */
    void getButton() {
        start = (Button) findViewById(R.id.startButton);
    }

    /**
     * Set the click listener for the button, sends user to GuessingActivity when clicked
     */
    void bindFunctionality() {
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GuessingActivity.class);
                startActivity(intent);
            }
        });
    }
}
