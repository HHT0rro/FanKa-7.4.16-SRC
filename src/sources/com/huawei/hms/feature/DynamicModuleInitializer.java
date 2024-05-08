package com.huawei.hms.feature;

import android.content.Context;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class DynamicModuleInitializer {
    private static WeakReference<Context> sContext;

    public static Context getContext() {
        WeakReference<Context> weakReference = sContext;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static void initializeModule(Context context) {
        sContext = new WeakReference<>(context);
    }
}
