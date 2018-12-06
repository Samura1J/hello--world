package io.che.firstapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    protected void logger(Object string) {

        Log.i("Info:", string.toString());

    }

    public void changeActivityFunction(View view) {

        switch(view.getId())
        {
            case R.id.firstToolImageButton:
                startActivity(new Intent(MainActivity.this, FirstTool.class));
                break;

            case R.id.numberGameImageButton:
                startActivity(new Intent(MainActivity.this, NumbersGame.class));
                break;

//            case R.id.button3:
//                // Code for button 3 click
//                break;
        }

    }

    public void imageChangeFunction(View view) {


//        Create objects to manipulate items in view
        ImageView toolboxImage = (ImageView) findViewById(R.id.toolboxImageView);
        TextView titleTextView = (TextView) findViewById(R.id.titleTextView);

//        Change image
//        toolboxImage.setImageResource(R.drawable.toolbox);
//        toolboxImage.setTag(R.drawable.toolbox);

//        Set focus
        titleTextView.setFocusableInTouchMode(true);
        titleTextView.requestFocus();

//        Toggle image
        Integer tb1 = R.drawable.toolbox;
        Integer tb2 = R.drawable.toolbox_sat;
        Integer currentImage = (Integer) toolboxImage.getTag();

        if ( tb1.equals(currentImage) ) {
            toolboxImage.setImageResource(tb2);
            toolboxImage.setTag(tb2);
            logger("Image set to " + tb2.toString() );

        } else {
            toolboxImage.setImageResource(tb1);
            toolboxImage.setTag(tb1);
            logger("Image set to " + tb1.toString() );

        }

//        Hide KB
        hideKBFunction(view);

    }

    public void hideKBFunction(View view) {

//        Hide keyboard
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }

    public void loginFunction(View view) {

//        Cast the view returned by findViewById to the type of object you expect to get from the view
        TextView titleTextView = (TextView) findViewById(R.id.titleTextView);
        EditText nameEditText = (EditText) findViewById(R.id.nameEditText);
        EditText emailEditText = (EditText) findViewById(R.id.emailEditText);

//        Toast used for popup on screen
        Toast.makeText(MainActivity.this, "We got you " + nameEditText.getText(), Toast.LENGTH_SHORT).show();

//        Use getText() to access whats currently stored in the text field
        titleTextView.setText("Hello " + nameEditText.getText() + ". We got your email as: " + emailEditText.getText());

        logger("Clicked Button");

        //        Hide KB
        hideKBFunction( view );

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView toolboxImage = findViewById(R.id.toolboxImageView);
        toolboxImage.setImageResource(R.drawable.toolbox_sat);
        toolboxImage.setTag(R.drawable.toolbox_sat);

        toolboxImage.setFocusableInTouchMode(true);
        toolboxImage.requestFocus();

    }


}
