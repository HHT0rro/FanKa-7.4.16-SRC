package com.alipay.sdk.tid;

import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class Tid {
    private final String key;
    private final String tid;
    private final long time;

    public Tid(String str, String str2, long j10) {
        this.tid = str;
        this.key = str2;
        this.time = j10;
    }

    public static boolean isEmpty(Tid tid) {
        return tid == null || TextUtils.isEmpty(tid.tid);
    }

    public String getTid() {
        return this.tid;
    }

    public String getTidSeed() {
        return this.key;
    }

    public long getTimestamp() {
        return this.time;
    }
}
