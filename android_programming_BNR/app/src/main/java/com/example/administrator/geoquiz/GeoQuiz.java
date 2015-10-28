package com.example.administrator.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GeoQuiz extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mPreButton;
    private TextView mQuestionTextView;

    private static  final String TAG = "GeoQuiz";
    private static final String KEY_INDEX = "index";

    private TrueFalse[] mQuestionBank = new  TrueFalse[]
            {
                    new TrueFalse(R.string.question_americas,true),
                    new TrueFalse(R.string.question_asia,true),
                    new TrueFalse(R.string.question_mideast,false),
                    new TrueFalse(R.string.question_oceans,true),
                    new TrueFalse(R.string.question_africa,false),
            };
    private int mCurrentIndex = 0;
    private  void updateQuestion()
    {
        int question = mQuestionBank[mCurrentIndex].getQuestion();
        mQuestionTextView.setText(question);
    }

    private  void checkAnswer(boolean userPressedTrue)
    {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();
        int messageResId = 0;
        if (userPressedTrue == answerIsTrue)
        {
            messageResId = R.string.correct_toast;
        }
        else
        {
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(GeoQuiz.this,messageResId,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"onCreate");
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX,0);
        }
        setContentView(R.layout.activity_geo_quiz);
        mFalseButton = (Button)findViewById(R.id.false_button);
        mTrueButton = (Button)findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });
        mQuestionTextView = (TextView)findViewById(R.id.question_text_view);

        mNextButton= (Button)findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex=(mCurrentIndex+1)%mQuestionBank.length;
                updateQuestion();
            }
        });

        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  mCurrentIndex=(mCurrentIndex+1)%mQuestionBank.length;
                  updateQuestion();
              }
        });

        mPreButton = (Button)findViewById(R.id.pre_button);
        mPreButton.setOnClickListener(new View.OnClickListener() {
            @Override
             public void onClick(View v) {
                mCurrentIndex=((mCurrentIndex-1)+mQuestionBank.length)%mQuestionBank.length;
                updateQuestion();
             }
        });

        updateQuestion();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_geo_quiz, menu);
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
    @Override
    public void onStart()
    {
        Log.d(TAG,"onStart");
        super.onStart();
    }
    @Override
    public  void onResume()
    {
        Log.d(TAG,"onResume");
        super.onResume();
    }
    @Override
    public void onPause()
    {
        Log.d(TAG,"onPause");
        super.onPause();
    }
    @Override
    public void onStop()
    {
        Log.d(TAG,"onStop");
        super.onStop();
    }
    @Override
    public void onDestroy()
    {
        Log.d(TAG,"onDestroy");
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        Log.d(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX,mCurrentIndex);
    }
}
