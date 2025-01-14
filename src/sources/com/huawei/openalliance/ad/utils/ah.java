package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import com.huawei.hms.ads.gl;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ah {
    private static final String Code = "MetaDataUtils";

    public static Integer Code(Context context, String str, String str2) {
        try {
            Object I = I(context, str, str2);
            if (I != null) {
                return au.F(I.toString());
            }
            return null;
        } catch (Throwable th) {
            gl.I(Code, "getIntegerMetaData %s err: %s", str2, th.getClass().getSimpleName());
            return null;
        }
    }

    private static Object I(Context context, String str, String str2) {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return null;
            }
            return bundle.get(str2);
        } catch (Throwable th) {
            gl.I(Code, "getMetaData %d err: %s", str2, th.getClass().getSimpleName());
            return null;
        }
    }

    public static String V(Context context, String str, String str2) {
        try {
            Object I = I(context, str, str2);
            if (I != null) {
                return I.toString();
            }
            return null;
        } catch (Throwable th) {
            gl.I(Code, "getIntegerMetaData %s err: %s", str2, th.getClass().getSimpleName());
            return null;
        }
    }
}
