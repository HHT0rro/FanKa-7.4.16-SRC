package com.huawei.hms.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface IBridgeActivityDelegate {
    int getRequestCode();

    void onBridgeActivityCreate(Activity activity);

    void onBridgeActivityDestroy();

    boolean onBridgeActivityResult(int i10, int i11, Intent intent);

    void onBridgeConfigurationChanged();

    void onKeyUp(int i10, KeyEvent keyEvent);
}
