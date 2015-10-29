package com.example.administrator.criminalintent;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;


public class CrimeActivity extends SingleFragmentActivity {
    private static  final  String TAG = "CrimeActivity";
    @Override
    protected  Fragment createFragment()
    {
        return  new CrimeFragment();
    }
    @Override
    public  void onStart()
    {
        super.onStart();
        Log.d(TAG, "onStart");
    }
    @Override
    public  void onResume()
    {
        super.onResume();
        Log.d(TAG, "onResume");
    }
    @Override
    public  void onPause()
    {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    public  void onStop()
    {
        super.onStop();
        Log.d(TAG, "onStop");
    }
    @Override
    public  void onDestroy()
    {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

}
