package com.example.administrator.criminalintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

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

        //ArrayAdapter<Crime> adapter = new ArrayAdapter<Crime>(getActivity(),android.R.layout.simple_list_item_1,mCrimes);
        CrimeAdapter adapter = new CrimeAdapter(mCrimes);
        setListAdapter(adapter);
    }
    @Override
    public void onListItemClick(ListView l,View v,int position,long id)
    {
       // Crime c = (Crime)(getListAdapter()).getItem(position);
        Crime c =((CrimeAdapter)getListAdapter()).getItem(position);
      //  Log.d(TAG,c.getmTitle()+" was clicked");

        // start Activity
        Intent i = new Intent(getActivity(),CrimeActivity.class);
        i.putExtra(CrimeFragment.CRIME_UUID,c.getmID());
        startActivity(i);
    }
    private class CrimeAdapter extends  ArrayAdapter<Crime>
    {
        public  CrimeAdapter(ArrayList<Crime> crimes)
        {
            super(getActivity(),0,crimes);
        }
        @Override
        public View getView(int position,View convertView,ViewGroup parent)
        {
            if (convertView == null)
            {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_crime,null);
            }
            Crime c = getItem(position);
            TextView titleTextView = (TextView)convertView.findViewById(R.id.crime_list_item_titleTextView);
            titleTextView.setText(c.getmTitle());

            TextView dateTextView = (TextView)convertView.findViewById(R.id.crime_list_item_dateTextView);
            dateTextView.setText(c.getmDate().toString());

            CheckBox checkBox = (CheckBox)convertView.findViewById(R.id.crime_list_item_solvedCheckBox);
            checkBox.setChecked(c.ismSolved());
            return convertView;
        }
    }
    @Override
    public  void onResume()
    {
        super.onResume();
        ((CrimeAdapter)getListAdapter()).notifyDataSetChanged();
    }
}
