package malharpatel.stormy.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;

import malharpatel.stormy.R;
import malharpatel.stormy.adapters.DayAdapter;
import malharpatel.stormy.weather.Day;

public class DailyForecastActivity extends ListActivity {

    private Day[] mDays;

    //@InjectView(android.R.id.list) ListView mListView;
    //@InjectView(android.R.id.empty) TextView mEmptyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);

        // If you want to not extend ListActivity and choose ActionBarActivity or Activity, then do the following
        //Butterknife.inject(this);

        Intent intent = getIntent();
        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.DAILY_FORECAST);
        mDays = Arrays.copyOf(parcelables, parcelables.length, Day[].class);

        DayAdapter adapter = new DayAdapter(this, mDays);
        setListAdapter(adapter);

        //mListView.setAdapter(adapter);
        //mListView.setEmptyView(mEmptyTextView);
        //mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){};
        //then copy n paste the below code into this new method that is created.


    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String dayOfTheWeek = mDays[position].getDayOfTheWeek();
        String conditions = mDays[position].getSummary();
        String highTemp = mDays[position].getTemperatureMax() + "";
        String message = String.format("On %s the high will be %s and it will have %s", dayOfTheWeek, highTemp, conditions);

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
