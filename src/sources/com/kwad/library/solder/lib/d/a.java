package com.kwad.library.solder.lib.d;

import android.os.Build;
import android.os.Process;
import com.kwad.sdk.utils.s;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    private static String akp;
    private static String akq;
    private static final Map<String, String> akr;

    static {
        HashMap hashMap = new HashMap();
        akr = hashMap;
        hashMap.put("mips", "mips");
        hashMap.put("mips64", "mips64");
        hashMap.put("x86", "x86");
        hashMap.put("x86_64", "x86_64");
        hashMap.put("arm64", "arm64-v8a");
    }

    private static boolean is64Bit() {
        if (Build.VERSION.SDK_INT >= 23) {
            return Process.is64Bit();
        }
        Boolean bool = null;
        try {
            bool = (Boolean) s.callMethod(s.a("dalvik.system.VMRuntime", "getRuntime", new Object[0]), "is64Bit", new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static String xK() {
        return is64Bit() ? "arm64-v8a" : "armeabi-v7a";
    }
}
