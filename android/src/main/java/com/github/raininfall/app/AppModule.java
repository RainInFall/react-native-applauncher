package com.github.raininfall.app;

import android.app.Application;
import android.content.Intent;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

public class AppModule extends ReactContextBaseJavaModule implements LifecycleEventListener{


    final ReactApplicationContext mContext;

    public AppModule(ReactApplicationContext reactContext) {
        super(reactContext);

        mContext = reactContext;
        mContext.addLifecycleEventListener(this);
    }

    @Override
    public String getName() {
        return "App";
    }

    @ReactMethod
    public void launchByPackageName(String packageName, Callback cb) {
      Intent intent = mContext.getPackageManager().getLaunchIntentForPackage(packageName);
      if (null != intent) {
          mContext.startActivity(intent);
          cb.invoke(true);
          return;
      }
      cb.invoke(false);
    }

    @Override
    public void onHostResume() {
        //TODO:
    }
    @Override
    public void onHostPause() {
        //TODO:
    }

    @Override
    public void onHostDestroy() {
        //TODO:
    }
  }
