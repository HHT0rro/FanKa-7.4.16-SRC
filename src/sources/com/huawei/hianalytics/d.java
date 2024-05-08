package com.huawei.hianalytics;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class d {
    public static x klm(String str, String str2) {
        w lmn;
        z lmn2 = c.klm().lmn(str);
        if (lmn2 == null || (lmn = lmn2.lmn(str2)) == null) {
            return null;
        }
        return lmn.lmn();
    }

    public static Context lmn() {
        return c.klm().lmn.f28748e;
    }

    public static String klm() {
        String str = c.klm().lmn.f28751h;
        return str == null ? "" : str;
    }

    public static w lmn(String str, String str2) {
        z lmn = c.klm().lmn(str);
        if (lmn != null) {
            return lmn.lmn(str2);
        }
        return null;
    }
}
