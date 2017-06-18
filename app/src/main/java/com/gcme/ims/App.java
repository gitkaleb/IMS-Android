package com.gcme.ims;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.firebase.client.Firebase;
import com.gcme.ims.Services.SyncService;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by kzone on 6/17/2017.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);

        // Newer version of Firebase
        if (!FirebaseApp.getApps(this).isEmpty()) {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        }

        startService(new Intent(this, SyncService.class));

    }
}
