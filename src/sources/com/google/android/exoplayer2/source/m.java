package com.google.android.exoplayer2.source;

import android.net.Uri;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: LoadEventInfo.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class m {

    /* renamed from: h, reason: collision with root package name */
    public static final AtomicLong f21803h = new AtomicLong();

    /* renamed from: a, reason: collision with root package name */
    public final long f21804a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.b f21805b;

    /* renamed from: c, reason: collision with root package name */
    public final Uri f21806c;

    /* renamed from: d, reason: collision with root package name */
    public final Map<String, List<String>> f21807d;

    /* renamed from: e, reason: collision with root package name */
    public final long f21808e;

    /* renamed from: f, reason: collision with root package name */
    public final long f21809f;

    /* renamed from: g, reason: collision with root package name */
    public final long f21810g;

    public m(long j10, com.google.android.exoplayer2.upstream.b bVar, long j11) {
        this(j10, bVar, bVar.f22767a, Collections.emptyMap(), j11, 0L, 0L);
    }

    public static long a() {
        return f21803h.getAndIncrement();
    }

    public m(long j10, com.google.android.exoplayer2.upstream.b bVar, Uri uri, Map<String, List<String>> map, long j11, long j12, long j13) {
        this.f21804a = j10;
        this.f21805b = bVar;
        this.f21806c = uri;
        this.f21807d = map;
        this.f21808e = j11;
        this.f21809f = j12;
        this.f21810g = j13;
    }
}
