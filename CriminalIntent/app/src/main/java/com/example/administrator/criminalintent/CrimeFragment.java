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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.UUID;


/**
 * Created by Administrator on 2015/10/29.
 */
public class CrimeFragment extends Fragment {
    private Crime mCrime;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;
    private static  final  String TAG = "CrimeFragment";
    public  static  final  String CRIME_UUID="Crime_UUID";
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
      //  mCrime = new Crime();
      //  UUID crime_uuid = (UUID)getActivity().getIntent().getSerializableExtra(CRIME_UUID);
        UUID crime_uuid = (UUID)getArguments().getSerializable(CRIME_UUID);
        mCrime = CrimeLab.get(getActivity()).getCrime(crime_uuid);
    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup parent,Bundle savedInstanceState)
    {
        Log.d(TAG,"onCreateView");
        View v = inflater.inflate(R.layout.fragment_crime,parent,false);

        mDateButton = (Button)v.findViewById(R.id.crime_date);
        mDateButton.setText(mCrime.getmDate().toString());
        mDateButton.setEnabled(false);

        mSolvedCheckBox = (CheckBox)v.findViewById(R.id.crime_solved);
        mSolvedCheckBox.setChecked(mCrime.ismSolved());
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setmSolved(isChecked);
            }
        });
        mTitleField = (EditText)v.findViewById(R.id.crime_title);
        mTitleField.setText(mCrime.getmTitle());
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
    public  static CrimeFragment newInstance(UUID uuid)
    {
        Bundle args = new Bundle();
        args.putSerializable(CRIME_UUID, uuid);
        CrimeFragment crimeFragment = new CrimeFragment();
        crimeFragment.setArguments(args);
        return  crimeFragment;
    }
}
