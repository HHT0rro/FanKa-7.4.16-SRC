package com.wangmai.common;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface WMAdActListener {
    void adOnActivityResult(int i10, int i11, Intent intent);

    void adOnConfigurationChanged(Configuration configuration);

    boolean adOnKeyDown(int i10, KeyEvent keyEvent);

    Resources getAdResources();

    void onAdCreate(Bundle bundle);

    void onAdDestroy();

    void onAdPause();

    void onAdRestart();

    void onAdResume();

    void onAdStart();

    void onAdStop();
}
