package com.example.a_0_1;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

public class QuestionDetailBox extends FragmentActivity {
	MainPagerAdapter mainPagerAdapter;
	ViewPager mViewPager;
	String[] questionTitles;
	int position;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//setTitle("Test");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.question_main);
		// set the actionbar to use the custom view
		getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME 
										|ActionBar.DISPLAY_HOME_AS_UP| ActionBar.DISPLAY_SHOW_TITLE);
		View view = View.inflate(getApplicationContext(), R.layout.main, null);
		//set the custom view to use
		getActionBar().setCustomView(view);
		Intent intent = getIntent();
		Bundle extras = intent.getExtras();
		questionTitles = extras.getStringArray(MainActivity.QUESTION_LIST);
		position = extras.getInt(MainActivity.POSITION);
		//get frame manager
		mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
		mViewPager = (ViewPager)findViewById(R.id.ViewPager);
		mViewPager.setAdapter(mainPagerAdapter);
		mViewPager.setCurrentItem(position);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.question, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	public class MainPagerAdapter extends FragmentStatePagerAdapter {
		public MainPagerAdapter(FragmentManager fm){
			super(fm);
		}
		@Override
		public Fragment getItem(int i){
			Fragment fragment = new QuestionDetail();
			Bundle args = new Bundle();
			args.putString(QuestionDetail.QUESTION,questionTitles[i]);
			fragment.setArguments(args);
			return fragment;
		}
		@Override 
		public int getCount(){
			return questionTitles.length;
		}
	}
}