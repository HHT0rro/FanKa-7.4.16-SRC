package com.nirvana.tools.core;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ComponentSdkCore {
    public static Context sApplicationContext;

    public static Context getApplicationContext() {
        return sApplicationContext;
    }

    public static void register(Context context) {
        sApplicationContext = context;
    }
}
