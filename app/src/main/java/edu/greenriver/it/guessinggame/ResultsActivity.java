package edu.greenriver.it.guessinggame;

/**
 * This is an application that runs a number guessing game
 * This activity reports the number of guesses
 *
 * @author Elizabeth Benner
 * @version 1.0
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    TextView report;
    Button replay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        getTextView();
        getButton();
        reportCount();
        replayListener();
    }

    /**
     * Save the report text view to a variable to be accessed by the application
     */
    void getTextView() {
        report = (TextView) findViewById(R.id.countReport);
    }

    /**
     * Save the replay button to a variable to be used by the click listener
     */
    void getButton() {
        replay = (Button) findViewById(R.id.replayButton);
    }

    /**
     * Take the final count from the intent and display in the report TextView
     */
    void reportCount() {
        if(getIntent().hasExtra("intentCount")) {
            String countResult = getIntent().getStringExtra("intentCount");
            report.setText(countResult);
        } else {
            report.setText("Error, could not find count!");
        }
    }

    /**
     * Click listener for the replay button, sends user back to landing activity
     */
    void replayListener() {
        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LandingActivity.class);
                startActivity(intent);
            }
        });
    }

}
