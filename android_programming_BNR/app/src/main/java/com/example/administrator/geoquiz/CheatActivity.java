package com.example.administrator.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {
    private TextView mTextView;
    private  boolean mAnswer;

    private static  final  String EXTRA_ANSWER_IS_TRUE ="answer_is_true";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mTextView = (TextView)findViewById(R.id.show_answer);
        mAnswer = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE,false);

        if (mAnswer)
        {
            mTextView.setText(R.string.true_button);
        }
        else
        {
            mTextView.setText(R.string.false_button);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cheat, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
