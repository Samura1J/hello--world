package io.che.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView bodyTextView = findViewById(R.id.bodyTextView);
        bodyTextView.setText(bodyTextView.getText().toString().replace("_", " "));
    }


}
