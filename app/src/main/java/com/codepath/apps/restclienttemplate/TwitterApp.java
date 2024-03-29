package com.codepath.apps.restclienttemplate;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.text.format.DateUtils;

import com.facebook.stetho.Stetho;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/*
 * This is the Android application itself and is used to configure various settings
 * including the image cache in memory and on disk. This also adds a singleton
 * for accessing the relevant rest client.
 *
 *     TwitterClient client = TwitterApp.getRestClient(Context context);
 *     // use client to send requests to API
 *
 */
public class TwitterApp extends Application {

    MyDatabase myDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        // when upgrading versions, kill the original tables by using
		// fallbackToDestructiveMigration()
        myDatabase = Room.databaseBuilder(this, MyDatabase.class,
                MyDatabase.NAME).fallbackToDestructiveMigration().build();

        // use chrome://inspect to inspect your SQL database
        Stetho.initializeWithDefaults(this);
    }

    public static TwitterClient getRestClient(Context context) {
        return (TwitterClient) TwitterClient.getInstance(TwitterClient.class, context);
    }

    public MyDatabase getMyDatabase() {
        return myDatabase;
    }
}