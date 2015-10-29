package com.example.administrator.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by Administrator on 2015/10/29.
 */
public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment()
    {
        return new  CrimeListFragment();
    }
}
