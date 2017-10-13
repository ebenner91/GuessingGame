package edu.greenriver.it.guessinggame;

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

    void getTextView() {
        report = (TextView) findViewById(R.id.countReport);
    }
    void getButton() {
        replay = (Button) findViewById(R.id.replayButton);
    }

    void reportCount() {
        if(getIntent().hasExtra("intentCount")) {
            String countResult = getIntent().getStringExtra("intentCount");
            report.setText(countResult);
        } else {
            report.setText("Error, could not find count!");
        }
    }

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
