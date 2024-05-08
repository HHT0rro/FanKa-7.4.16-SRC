package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.gl;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class t {
    private static final String Code = "HarmonyUtils";
    private static final int V = 1048576;

    private static boolean Code(int i10) {
        return (i10 & 1048576) != 0;
    }

    public static boolean Code(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return Code(new n().Code(e.S(context.getApplicationContext(), str), context));
        } catch (Throwable unused) {
            gl.I(Code, "isHarmonyApp exception");
            return false;
        }
    }
}
