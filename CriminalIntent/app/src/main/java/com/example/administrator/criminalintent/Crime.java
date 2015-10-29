package com.example.administrator.criminalintent;

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
    }
}
