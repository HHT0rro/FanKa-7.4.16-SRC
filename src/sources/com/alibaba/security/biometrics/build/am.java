package com.alibaba.security.biometrics.build;

import android.os.Bundle;

/* compiled from: ABLogSender.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class am {
    public static void a(int i10, int i11) {
        if (i10 == 0) {
            Bundle bundle = new Bundle();
            bundle.putInt("succ", 1);
            bundle.putInt("reason", i10);
            bundle.putInt("retry_tt", i11);
            ak.b().a("10031", bundle);
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("succ", 0);
            bundle2.putInt("reason", i10);
            bundle2.putInt("retry_tt", i11);
            ak.b().a("10031", bundle2);
        }
        if (i10 == -1) {
            ak.b().a("10030", (Bundle) null);
        }
    }
}
