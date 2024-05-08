package com.android.internal.compat;

import android.os.Build;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class AndroidBuildClassifier {
    public boolean isDebuggableBuild() {
        return Build.IS_DEBUGGABLE;
    }

    public boolean isFinalBuild() {
        return "REL".equals(Build.VERSION.CODENAME);
    }

    public int platformTargetSdk() {
        if (isFinalBuild()) {
            return Build.VERSION.SDK_INT;
        }
        return 10000;
    }
}
