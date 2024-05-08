package com.huawei.hms.opendevice;

import android.text.TextUtils;

/* compiled from: StringUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class n {
    public static boolean a(String... strArr) {
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
        }
        return true;
    }
}
