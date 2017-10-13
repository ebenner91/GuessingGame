package edu.greenriver.it.guessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GuessingActivity extends AppCompatActivity {

    EditText input;
    Button submit;

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

            }
        });
    }
}
