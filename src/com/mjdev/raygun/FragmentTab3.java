package com.mjdev.raygun;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class FragmentTab3 extends Fragment {
	  public View onCreateView(LayoutInflater inflater, ViewGroup container, 
	                           Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.tab_my_badges, container, false);
		view.setClickable(true);
		ListView listView = (ListView) view.findViewById(R.id.completed);
		listView.setOnItemClickListener(myClickListener);
		return view;
	  }
	  public OnItemClickListener myClickListener = new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			MainActivity act = (MainActivity) getActivity();
			String entry = (String) parent.getItemAtPosition(position);
            Intent intent = new Intent(view.getContext(), TaskDescription.class);
            intent.putExtra("task", entry);
        	intent.putStringArrayListExtra("titles", act.titles);
        	Log.v("Time Elements", act.description.get(0).toString());
        	intent.putStringArrayListExtra("descriptions", act.description);
            startActivity(intent);
		}
	  };
	}
