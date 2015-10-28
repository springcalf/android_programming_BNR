package com.example.administrator.geoquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {
    private TextView mTextView;
    private Button mAnswerShown;
    private  boolean mAnswer;
    private boolean mIsAnswerShown;

    private static  final  String EXTRA_ANSWER_IS_TRUE ="answer_is_true";
    public static final String EXTRA_ANSWER_SHOWN ="answer_show";
    private  void setAnswerShowResult(boolean isAnswerShown)
    {
        Intent data = new Intent();
        mIsAnswerShown = isAnswerShown;
        data.putExtra(EXTRA_ANSWER_SHOWN,isAnswerShown);
        setResult(RESULT_OK,data);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        mTextView = (TextView)findViewById(R.id.show_answer);
        if (savedInstanceState != null)
        {
            mIsAnswerShown = savedInstanceState.getBoolean(EXTRA_ANSWER_SHOWN,false);
            mAnswer = savedInstanceState.getBoolean(EXTRA_ANSWER_IS_TRUE,false);
            if(mIsAnswerShown)
            {
                if (mAnswer)
                {
                    mTextView.setText(R.string.true_button);
                }
                else
                {
                    mTextView.setText(R.string.false_button);
                }
            }
            setAnswerShowResult(mIsAnswerShown);

        }
        else
        {
            setAnswerShowResult(false);
            mAnswer = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE,false);
        }


        mAnswerShown = (Button)findViewById(R.id.show_answer_button);
        mAnswerShown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswer)
                {
                    mTextView.setText(R.string.true_button);
                }
                else
                {
                    mTextView.setText(R.string.false_button);
                }
                setAnswerShowResult(true);
            }
        });


    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean(EXTRA_ANSWER_SHOWN, mIsAnswerShown);
        savedInstanceState.putBoolean(EXTRA_ANSWER_IS_TRUE, mAnswer);
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
