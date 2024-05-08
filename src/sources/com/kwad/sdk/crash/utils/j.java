package com.kwad.sdk.crash.utils;

import com.huawei.openalliance.ad.constant.u;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class j {
    public static String ay(long j10) {
        String valueOf;
        String valueOf2;
        long j11 = j10 / 60000;
        long j12 = (j10 - (60000 * j11)) / 1000;
        if (j11 < 10) {
            valueOf = "0" + j11;
        } else {
            valueOf = String.valueOf(j11);
        }
        if (j12 < 10) {
            valueOf2 = "0" + j12;
        } else {
            valueOf2 = String.valueOf(j12);
        }
        return valueOf + u.bD + valueOf2;
    }
}
