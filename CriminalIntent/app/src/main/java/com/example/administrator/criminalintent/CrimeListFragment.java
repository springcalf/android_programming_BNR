package com.example.administrator.criminalintent;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/10/29.
 */
public class CrimeListFragment extends ListFragment {
    private static  final  String TAG = "CrimeListFragment";
    private ArrayList<Crime> mCrimes;
    @Override
    public  void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.crime_title_label);
        mCrimes = CrimeLab.get(getActivity()).getmCrimes();

        ArrayAdapter<Crime> adapter = new ArrayAdapter<Crime>(getActivity(),android.R.layout.simple_list_item_1,mCrimes);
        setListAdapter(adapter);
    }
    @Override
    public void onListItemClick(ListView l,View v,int position,long id)
    {
        Crime c = (Crime)(getListAdapter()).getItem(position);
        Log.d(TAG,c.getmTitle()+" was clicked");
    }
}
