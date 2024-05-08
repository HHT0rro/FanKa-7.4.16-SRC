package com.wangmai.adIdUtils.oaid;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class OAIDLog {
    public static final String TAG = "OAID";
    public static boolean enable;

    public static void enable() {
        enable = true;
    }

    public static void print(Object obj) {
        if (enable) {
            if (obj == null) {
                obj = "<null>";
            }
            obj.toString();
        }
    }
}
