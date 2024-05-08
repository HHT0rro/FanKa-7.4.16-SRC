package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Process;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class AbiUtil {
    private static Abi aOd;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum Abi {
        UNKNOWN,
        ARMEABI_V7A,
        ARM64_V8A
    }

    public static String bD(Context context) {
        return isArm64(context) ? "arm64-v8a" : "armeabi-v7a";
    }

    private static Abi bE(Context context) {
        Abi abi = aOd;
        if (abi != null) {
            return abi;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            aOd = Process.is64Bit() ? Abi.ARM64_V8A : Abi.ARMEABI_V7A;
        } else {
            try {
                aOd = ((Boolean) s.callMethod(s.a("dalvik.system.VMRuntime", "getRuntime", new Object[0]), "is64Bit", new Object[0])).booleanValue() ? Abi.ARM64_V8A : Abi.ARMEABI_V7A;
            } catch (Throwable th) {
                th.printStackTrace();
                try {
                    if (context.getApplicationInfo().nativeLibraryDir.contains("arm64")) {
                        aOd = Abi.ARM64_V8A;
                    } else {
                        aOd = Abi.UNKNOWN;
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    aOd = Abi.UNKNOWN;
                }
            }
        }
        return aOd;
    }

    public static boolean isArm64(Context context) {
        return bE(context) == Abi.ARM64_V8A;
    }
}
