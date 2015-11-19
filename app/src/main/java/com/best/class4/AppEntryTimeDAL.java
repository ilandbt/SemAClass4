package com.best.class4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by ilandbt on 15/11/2015.
 */
public class AppEntryTimeDAL {

    private AppEntryTimeDBHelper helper;

    public AppEntryTimeDAL(Context context){
        helper = new AppEntryTimeDBHelper(context);
    }

    public void addEntryTime(String time){
        //get DB
        SQLiteDatabase db = helper.getWritableDatabase();

        //values to save
        ContentValues values = new ContentValues();
        values.put(AppEntryTimeContract.AppEntryTime.ENTRY_TIME, time);

        //save the values
        db.insert(AppEntryTimeContract.AppEntryTime.TABLE_NAME, null, values);
        db.close();
    }

    public Cursor getAllEntryTimesCursor(){
        //get DB
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM " + AppEntryTimeContract.AppEntryTime.TABLE_NAME, null);

        return c;
    }

    public ArrayList getAllEntryTimesList(){

        ArrayList entryTimes = new ArrayList();

        //get cursor
        Cursor c = getAllEntryTimesCursor();

        if (c != null) {
            while (c.moveToNext()) {
                //get column index
                int  entryTimeColumnIndex = c.getColumnIndex(AppEntryTimeContract.AppEntryTime.ENTRY_TIME);

                //get entry
                String entryTime = c.getString(entryTimeColumnIndex);

                //save in array
                entryTimes.add(entryTime);
            }
        }
        return entryTimes;
    }
}
