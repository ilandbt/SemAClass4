package com.best.class4;

import android.provider.BaseColumns;

/**
 * Created by ilandbt on 15/11/2015.
 */
public class AppEntryTimeContract {

    public AppEntryTimeContract() {};

    public static abstract class AppEntryTime implements  BaseColumns {


        public static final String TABLE_NAME = "entryTimes";
        public static final String ENTRY_TIME = "entryTimeColumn";
    }


}
