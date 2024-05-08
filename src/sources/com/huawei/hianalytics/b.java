package com.huawei.hianalytics;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b {
    public static b klm;
    public Context lmn = d.lmn();

    public static b lmn() {
        b bVar;
        synchronized (a.class) {
            if (klm == null) {
                klm = new b();
            }
            bVar = klm;
        }
        return bVar;
    }
}
