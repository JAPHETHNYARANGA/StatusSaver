package com.kessi.TOStatusSaver;

import android.app.Application;

import com.kessi.TOStatusSaver.util.AdController;
import com.kessi.TOStatusSaver.util.AppOpenManager;
import com.onesignal.OneSignal;

public class MyApp extends Application {

    AppOpenManager appOpenManager;
    private static final String ONESIGNAL_APP_ID = "eb112170-659c-4f21-9a5d-42172ddd2c0a";

    @Override
    public void onCreate() {
        super.onCreate();
        // Enable verbose OneSignal logging to debug issues if needed.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);


        if (!AdController.isLoadIronSourceAd){
            AdController.initAd(this);
            appOpenManager = new AppOpenManager(this);
        }
    }
}
