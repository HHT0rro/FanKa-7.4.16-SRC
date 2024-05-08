package com.baidu.mobads.sdk.api;

import android.app.Application;
import com.baidu.mobads.sdk.internal.ao;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class NovelSDKConfig {
    public static void attachBaseContext(Application application, String str, String str2) {
        ao.a(application, str, str2);
    }

    public static boolean isInitNovelSDK() {
        return ao.f();
    }
}
