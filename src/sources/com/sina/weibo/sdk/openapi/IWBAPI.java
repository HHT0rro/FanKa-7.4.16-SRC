package com.sina.weibo.sdk.openapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.share.WbShareCallback;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IWBAPI {
    void authorize(Activity activity, WbAuthListener wbAuthListener);

    void authorizeCallback(Activity activity, int i10, int i11, Intent intent);

    void authorizeClient(Activity activity, WbAuthListener wbAuthListener);

    void authorizeWeb(Activity activity, WbAuthListener wbAuthListener);

    void doResultIntent(Intent intent, WbShareCallback wbShareCallback);

    boolean isWBAppInstalled();

    boolean isWBAppSupportMultipleImage();

    void registerApp(Context context, AuthInfo authInfo);

    void registerApp(Context context, AuthInfo authInfo, SdkListener sdkListener);

    void registerApp(Context context, AuthInfo authInfo, SdkListener sdkListener, SdkConfig sdkConfig);

    void setLoggerEnable(boolean z10);

    void shareMessage(Activity activity, WeiboMultiMessage weiboMultiMessage, boolean z10);
}
