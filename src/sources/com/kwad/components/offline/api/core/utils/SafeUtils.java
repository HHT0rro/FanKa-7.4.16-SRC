package com.kwad.components.offline.api.core.utils;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SafeUtils {
    public static boolean isDebugPkg(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }
}
