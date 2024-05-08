package com.yxcorp.kuaishou.addfp.android;

import android.content.Context;
import com.yxcorp.kuaishou.addfp.c.a.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class Orange {
    private static final int JNI_CONTROL_COMMAND_DIR_DETECT = 1114128;
    private static final int JNI_CONTROL_COMMAND_GK_DETECT = 1114132;
    private static final int JNI_CONTROL_COMMAND_MANU_DETECT = 1114140;
    private static final int JNI_CONTROL_COMMAND_PROPS_DETECT = 1114131;
    private static final int JNI_CONTROL_COMMAND_SERIAL_DETECT = 1179649;
    private static boolean sLibLoadFail = true;
    private static final String sdkVersion = "1.4.0.116.5c39a102";
    private static volatile Orange singleton;

    private Orange() {
        loadSoLib();
    }

    public static String gLs(int i10, String str) {
        try {
            return a.a(i10, str);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private static native String getClock(Context context, byte[] bArr, int i10);

    public static Orange getInstance() {
        if (singleton == null) {
            synchronized (Orange.class) {
                if (singleton == null) {
                    singleton = new Orange();
                }
            }
        }
        return singleton;
    }

    private static native byte[] getMagic(Context context, byte[] bArr, int i10);

    public static String getVersion() {
        return sdkVersion;
    }

    private boolean isReject() {
        return sLibLoadFail;
    }

    private static native Object jniCommand(int i10, Object obj, Object obj2, Object obj3);

    private void loadSoLib() {
        try {
            System.loadLibrary("sgcore");
            sLibLoadFail = false;
        } catch (Throwable th) {
            sLibLoadFail = true;
            th.printStackTrace();
        }
    }

    public byte[] dcc(byte[] bArr, byte[] bArr2) {
        try {
            isReject();
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public String gKpsd() {
        try {
            return isReject() ? "" : (String) jniCommand(JNI_CONTROL_COMMAND_GK_DETECT, null, null, null);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public String gManu(Context context, String str) {
        try {
            return (isReject() || context == null) ? "" : (String) jniCommand(JNI_CONTROL_COMMAND_MANU_DETECT, str, context.getPackageName(), null);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public String gProps() {
        try {
            return isReject() ? "" : (String) jniCommand(JNI_CONTROL_COMMAND_PROPS_DETECT, null, null, null);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public String gRdi() {
        try {
            return isReject() ? "" : (String) jniCommand(JNI_CONTROL_COMMAND_DIR_DETECT, null, null, null);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public String gSer() {
        try {
            return isReject() ? "" : (String) jniCommand(JNI_CONTROL_COMMAND_SERIAL_DETECT, null, null, null);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public synchronized String getClockWrapper(Context context, byte[] bArr, int i10) {
        if (isReject()) {
            return "";
        }
        return getClock(context, bArr, i10);
    }

    public synchronized byte[] getMagicWrapper(Context context, byte[] bArr, int i10) {
        if (isReject()) {
            return null;
        }
        return getMagic(context, bArr, i10);
    }
}
