package com.example.administrator.criminalintent;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * Created by Administrator on 2015/10/29.
 */
public class CrimeFragment extends Fragment {
    private Crime mCrime;
    private EditText mTitleField;
    private static  final  String TAG = "CrimeFragment";
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        Log.d(TAG,"onCreate");
        super.onCreate(savedInstanceState);
        mCrime = new Crime();
    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup parent,Bundle savedInstanceState)
    {
        Log.d(TAG,"onCreateView");
        View v = inflater.inflate(R.layout.fragment_crime,parent,false);
        mTitleField = (EditText)v.findViewById(R.id.crime_title);
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                mCrime.setmTitle(mCrime.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return  v;
    }
    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        Log.d(TAG, "onAttach");
    }
    @Override
    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        Log.d(TAG, "onActivityCreated");
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
    @Override
    public  void onDestroyView()
    {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView");
    }
    @Override
    public  void onDetach()
    {
        super.onDetach();
        Log.d(TAG, "onDetach");
    }
}
