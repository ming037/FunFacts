package com.teamtreehouse.funfacts;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static com.teamtreehouse.funfacts.R.id.relativeLayout;
import static com.teamtreehouse.funfacts.R.id.showFactButton;


public class FunFactsActivity extends Activity {
    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();
    private static final String KEY_FACT = "KEY_FACT";
    private static final String KEY_COLOR = "KEY_COLOR";
    private String mFact = mFactBook.mFacts[0];
    private int mColor = Color.parseColor(mColorWheel.mColors[8]);

    private TextView mfactLabel;
    private Button mshowFactButton;
    private RelativeLayout mrelativeLayout;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        
        outState.putString(KEY_FACT, mFact);
        outState.putInt(KEY_COLOR, mColor);
    }

    @Override //onCreate에서 해도 되지만 그때는 NULL일 때를 신경써줘야 함.
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mFact = savedInstanceState.getString(KEY_FACT);
        mColor = savedInstanceState.getInt(KEY_COLOR);

        mfactLabel.setText(mFact);
        mrelativeLayout.setBackgroundColor(mColor);
        mshowFactButton.setTextColor(mColor);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        // Declare our View variables and assign them the Views from the layout file
        mfactLabel = (TextView) findViewById(R.id.factTextView);
        mshowFactButton = (Button) findViewById(showFactButton);
        mrelativeLayout = (RelativeLayout) findViewById(relativeLayout);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFact = mFactBook.getFact();
                mfactLabel.setText(mFact);

                mColor = mColorWheel.getColor();
                mrelativeLayout.setBackgroundColor(mColor);
                mshowFactButton.setTextColor(mColor);
            }
        };
        mshowFactButton.setOnClickListener(listener);
    }
}
