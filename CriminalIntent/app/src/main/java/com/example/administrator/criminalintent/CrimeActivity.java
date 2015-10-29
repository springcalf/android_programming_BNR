package com.example.administrator.criminalintent;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;


public class CrimeActivity extends FragmentActivity {
    private static  final  String TAG = "CrimeActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);

        if (fragment == null) {
            fragment = new CrimeFragment();
            fm.beginTransaction().add(R.id.fragmentContainer,fragment).commit();
        }

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
