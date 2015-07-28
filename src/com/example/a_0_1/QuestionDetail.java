package com.example.a_0_1;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;

import java.io.IOException;

public class QuestionDetail extends Fragment {
	public static final String QUESTION = "question";
	private String mFileName = Environment.getExternalStorageDirectory().getAbsolutePath();
	private int fileNo = 0;
	private static final String LOG_TAG = "Record";
	
	private MediaPlayer   mPlayer = null;
	private MediaRecorder mRecorder = new MediaRecorder();
	private MediaController mController;
	
	View rootView;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setHasOptionsMenu(true);
		super.onCreate(savedInstanceState);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Bundle args = getArguments();
		String questionTitle = args.getString(QUESTION);
		//retrieve response from QUESTION
		String[] response = {"Cool","Yes","I","Like","You","Cool","Yes","I","Like","You"};
		rootView = inflater.inflate(R.layout.question_fragment, container, false);
		((TextView)rootView.findViewById(R.id.question_title)).setText(questionTitle);
		//List Implementation
		ListView responseList = (ListView)rootView.findViewById(R.id.response_list);
		//Adapter
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,response);
		//set adapter
		responseList.setAdapter(adapter);
		//set media controller
		mController = new MediaController(getActivity());
		//mController.show();
		return rootView;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return true;
	}
}
