package com.example.administrator.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2015/10/29.
 */
public class Crime {
    public UUID getmID() {
        return mID;
    }

    private UUID mID;

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    private String mTitle;
    public  Crime(){
        mID = UUID.randomUUID();
        mDate = new Date();
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    private Date mDate;

    public boolean ismSolved() {
        return mSolved;
    }

    public void setmSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }

    private  boolean mSolved;
}
