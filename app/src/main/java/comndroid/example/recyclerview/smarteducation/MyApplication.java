package comndroid.example.recyclerview.smarteducation;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.support.multidex.MultiDexApplication;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cn.jpush.android.api.JPushInterface;
import comndroid.example.recyclerview.smarteducation.Utils.SPHelper;
import comndroid.example.recyclerview.smarteducation.Utils.Utils;

public class MyApplication extends MultiDexApplication implements ActivityLifecycleCallbacks {
    private static Context context;
    public static Context getContext()
    {
        return context;
    }

    private void init()
    {
        context = getApplicationContext();
        SPHelper.init(context);
    }


    public void onCreate()
    {
        super.onCreate();
        Utils.init(getApplicationContext());
       JPushInterface.setDebugMode(true);
     JPushInterface.init(this);
       registerActivityLifecycleCallbacks(this);
        init();
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
