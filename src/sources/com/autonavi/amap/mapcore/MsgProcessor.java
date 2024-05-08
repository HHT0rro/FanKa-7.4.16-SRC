package com.autonavi.amap.mapcore;

import android.content.Context;
import com.amap.api.col.p0003l.hb;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MsgProcessor {
    private static hb mDelegate = new hb();

    public static native int nativeInit(Context context);

    public static void nativeInitInfo(Context context, boolean z10, String str, String str2, String str3, String[] strArr) {
        mDelegate.a(context, z10, str, str2, str3, strArr);
        nativeInit(context);
    }

    public static void nativeMsgProcessor(String str, String str2) {
        mDelegate.a(str, str2);
    }
}
