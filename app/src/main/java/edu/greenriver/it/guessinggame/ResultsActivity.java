package edu.greenriver.it.guessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    TextView report;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        getTextView();
        receiveIntent();
    }

    void getTextView() {
        report = (TextView) findViewById(R.id.countReport);
    }

    void receiveIntent() {
        if(getIntent().hasExtra("intentCount")) {
            String countResult = getIntent().getStringExtra("intentCount");
            report.setText(countResult);
        } else {
            report.setText("Error, could not find count!");
        }


    }

}
