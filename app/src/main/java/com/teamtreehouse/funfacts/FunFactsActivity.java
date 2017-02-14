package com.teamtreehouse.funfacts;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class FunFactsActivity extends Activity {
    private static final String KEY_FACT = "KEY_FACT";
    private static final String KEY_COLOR = "KEY_COLOR";
    private String mFact;
    private int mColor;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        
        outState.putString(KEY_FACT, mFact);
        outState.putInt(KEY_COLOR, mColor);
    }

    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        // Declare our View variables and assign them the Views from the layout file
        final TextView factLabel = (TextView) findViewById(R.id.factTextView);
        final Button showFactButton = (Button) findViewById(R.id.showFactButton);
        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFact = mFactBook.getFact();
                factLabel.setText(mFact);

                mColor = mColorWheel.getColor();
                relativeLayout.setBackgroundColor(mColor);
                showFactButton.setTextColor(mColor);
            }
        };
        showFactButton.setOnClickListener(listener);
    }
}
