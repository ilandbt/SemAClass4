package com.best.class4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();

    private AppEntryTimeDAL dal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dal = new AppEntryTimeDAL(this);

        String time = DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
        dal.addEntryTime(time);
        Log.d(TAG, time);
    }

    @Override
    protected void onStop() {
        super.onStop();

        ArrayList list = dal.getAllEntryTimesList();
        String entryTimesString = list.toString();
        Log.d(TAG, entryTimesString);
    }
}
