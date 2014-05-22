package com.thebluealliance.androidclient.activities;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.thebluealliance.androidclient.R;
import com.thebluealliance.androidclient.models.Event;
import com.thebluealliance.androidclient.models.Match;

public class SearchResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("create");
        setContentView(R.layout.activity_search_result);
        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        handleIntent(intent);
    }

    public void handleIntent(Intent intent){
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            startActivity(intentFromKey(query));
        }
    }

    public Intent intentFromKey(String key){
        if(key.startsWith("frc")){
            return ViewTeamActivity.newInstance(this, key);
        }else if(Event.validateEventKey(key)){
            return ViewEventActivity.newInstance(this, key);
        }else if(Match.validateMatchKey(key)){
            return ViewMatchActivity.newInstance(this, key);
        }else{
            return null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return super.onOptionsItemSelected(item);
    }
}
