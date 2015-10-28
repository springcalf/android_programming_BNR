package com.example.administrator.geoquiz;

/**
 * Created by Administrator on 2015/10/28.
 */
public class TrueFalse {
    private  int mQuestion;
    private  boolean mTrueQuestion;
    public  TrueFalse(int question,boolean trueQuestion)
    {
        mQuestion = question;
        mTrueQuestion = trueQuestion;
    }
    public void setQuestion(int question)
    {
        mQuestion = question;
    }
    public  int getQuestion()
    {
        return  mQuestion;
    }
    public boolean isTrueQuestion()
    {
        return  mTrueQuestion;
    }
    public void setTrueQuestion(boolean trueQuestion)
    {
        mTrueQuestion = trueQuestion;
    }

}
