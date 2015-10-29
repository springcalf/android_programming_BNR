package com.example.administrator.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Administrator on 2015/10/29.
 */
public class CrimeLab {

    private  static  CrimeLab sCrimeLab;
    private Context mAppContext;

    public ArrayList<Crime> getmCrimes() {
        return mCrimes;
    }
    public  Crime getCrime(UUID id)
    {
        for (Crime c:mCrimes)
        {
            if (c.getmID().equals(id))
                return c;
        }
        return null;
    }
    private ArrayList<Crime> mCrimes;
    private CrimeLab(Context appContext)
    {
        mAppContext = appContext;
        mCrimes = new ArrayList<Crime>();
        for (int i=0;i<100;i++)
        {
            Crime c = new Crime();
            c.setmTitle("Crime #"+i);
            c.setmSolved(i%2==0);
            mCrimes.add(c);
        }
    }
    public  static  CrimeLab get(Context c)
    {
        if (sCrimeLab == null)
        {
            sCrimeLab = new CrimeLab(c.getApplicationContext());
        }
        return  sCrimeLab;
    }
}
