package com.qq.e.comm.pi;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface ACTD {
    public static final String APPID_KEY = "appid";
    public static final String DELEGATE_NAME_KEY = "gdt_activity_delegate_name";

    void onActivityResult(int i10, int i11, Intent intent);

    void onAfterCreate(Bundle bundle);

    void onBackPressed();

    void onBeforeCreate(Bundle bundle);

    void onConfigurationChanged(Configuration configuration);

    void onDestroy();

    void onPause();

    void onResume();

    void onStop();
}
