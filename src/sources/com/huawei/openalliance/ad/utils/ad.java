package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.gl;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class ad {
    private static final String Code = "LogTool";

    public static void Code(Context context, int i10, String str) {
        if (i10 < 4) {
            i10 = 4;
        }
        if (TextUtils.isEmpty(str)) {
            str = ar.Code(context);
            if (TextUtils.isEmpty(str)) {
                gl.I(Code, "enable log failed, due to root path is null");
                return;
            }
        }
        gl.Code(i10, str, "HiAd");
    }
}
