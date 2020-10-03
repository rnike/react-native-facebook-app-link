package com.reactlibrary;

import com.facebook.applinks.AppLinkData;
import com.facebook.FacebookSdk;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;

public class FacebookAppLinkModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public FacebookAppLinkModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "FacebookAppLink";
    }

    @ReactMethod
    public void fetchUrl(final Promise promise) {
        try {
            FacebookSdk.setAutoInitEnabled(true);
            FacebookSdk.fullyInitialize();
            AppLinkData.fetchDeferredAppLinkData(this.reactContext.getApplicationContext(),
                new AppLinkData.CompletionHandler() {
                @Override
                public void onDeferredAppLinkDataFetched(AppLinkData appLinkData) {
                    if (appLinkData != null){
                        promise.resolve(appLinkData.getTargetUri().toString());
                    } else {
                        promise.resolve(null);
                    }
                }
            });
        } catch (Exception e) {
            promise.reject("error", e.getMessage(), e);
        }
    }
}
