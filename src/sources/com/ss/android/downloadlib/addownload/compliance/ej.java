package com.ss.android.downloadlib.addownload.compliance;

import com.ss.android.socialbase.downloader.utils.LruCache;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ej extends LruCache<Long, com.ss.android.downloadlib.addownload.dk.dk> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class m {

        /* renamed from: m, reason: collision with root package name */
        private static ej f38510m = new ej();
    }

    public static ej m() {
        return m.f38510m;
    }

    private ej() {
        super(16, 16);
    }

    public void m(com.ss.android.downloadlib.addownload.dk.dk dkVar) {
        if (dkVar == null) {
            return;
        }
        put(Long.valueOf(dkVar.m()), dkVar);
    }

    public com.ss.android.downloadlib.addownload.dk.dk m(long j10, long j11) {
        return get(get(Long.valueOf(j10)) != null ? Long.valueOf(j10) : Long.valueOf(j11));
    }

    public com.ss.android.downloadlib.addownload.dk.dk m(long j10) {
        return get(Long.valueOf(j10));
    }
}
