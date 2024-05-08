package com.kwad.sdk.api.loader;

import android.os.Build;
import android.os.Process;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class w {
    public static boolean is64Bit() {
        if (Build.VERSION.SDK_INT >= 23) {
            return Process.is64Bit();
        }
        try {
            return ((Boolean) Reflect.cg("dalvik.system.VMRuntime").cj("getRuntime").cj("is64Bit").get()).booleanValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static String xK() {
        return is64Bit() ? "arm64-v8a" : "armeabi-v7a";
    }
}
