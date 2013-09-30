package com.example.rss;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.rss.fragments.DetailList;
import com.example.rss.fragments.FeedListFragment;
import com.example.rss.fragments.SubscriberFragment;

public class MainActivity extends Activity {

	private SubscribedFeedManager feedmanager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		feedmanager= SubscribedFeedManager.getInstance(); //gets instance of the feedmanager (singelton)
		
		FragmentManager fragmentManager = getFragmentManager();
		 FragmentTransaction transaction = fragmentManager.beginTransaction();
		 transaction.add(R.id.main_activity, new FeedListFragment());
		 transaction.commit();
	}
	
	@Override
	protected void onResume()
	{
		super.onResume();
	}
	
	@Override
	protected void onPause()
	{
		super.onPause();
		//TODO stop service here, if necessary
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
	    // Handle item selection
		switch (item.getItemId()) {
        case R.id.action_subscribe:
        	FragmentManager fragmentManager = getFragmentManager();
        	FragmentTransaction transaction = fragmentManager.beginTransaction();
        	transaction.addToBackStack(null);
        	transaction.replace(R.id.main_activity, new SubscriberFragment());
        	transaction.commit();
            return true;
        
        default:
            return super.onOptionsItemSelected(item);
		}

	}

	//Button method to subscribe to the feed with the url from the edittextview of the same fragment
	public void subscribeButtonClick(View v) {
        System.out.println("button was clicked");
        
        EditText urlinput = (EditText) findViewById(R.id.subscribe_url_input);
        System.out.println("Url: "+urlinput.getEditableText());
        
        String feedurlstring = urlinput.getEditableText().toString();
        if(feedurlstring!=""){
        	feedmanager.addFeed(new FeedLink(feedurlstring));
        }
        
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.popBackStack();
      // FragmentTransaction transaction = fragmentManager.beginTransaction();
        //transaction.replace(R.id.main_activity, new FeedListFragment());
       // transaction.commit();
    }
	
}
