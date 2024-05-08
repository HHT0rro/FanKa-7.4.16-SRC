package com.google.android.exoplayer2.source;

import android.net.Uri;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: ProgressiveMediaExtractor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface c0 {

    /* compiled from: ProgressiveMediaExtractor.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        c0 a();
    }

    void a(long j10, long j11);

    void b(o6.g gVar, Uri uri, Map<String, List<String>> map, long j10, long j11, d5.e eVar) throws IOException;

    long c();

    void d();

    int e(d5.n nVar) throws IOException;

    void release();
}
