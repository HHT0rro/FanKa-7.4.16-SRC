package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.b;
import com.google.android.exoplayer2.util.j0;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import o6.k;
import o6.t;

/* compiled from: ParsingLoadable.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class i<T> implements Loader.e {

    /* renamed from: a, reason: collision with root package name */
    public final long f22896a;

    /* renamed from: b, reason: collision with root package name */
    public final b f22897b;

    /* renamed from: c, reason: collision with root package name */
    public final int f22898c;

    /* renamed from: d, reason: collision with root package name */
    public final t f22899d;

    /* renamed from: e, reason: collision with root package name */
    public final a<? extends T> f22900e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public volatile T f22901f;

    /* compiled from: ParsingLoadable.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a<T> {
        T a(Uri uri, InputStream inputStream) throws IOException;
    }

    public i(com.google.android.exoplayer2.upstream.a aVar, Uri uri, int i10, a<? extends T> aVar2) {
        this(aVar, new b.C0209b().i(uri).b(1).a(), i10, aVar2);
    }

    public long a() {
        return this.f22899d.n();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public final void b() {
    }

    public Map<String, List<String>> c() {
        return this.f22899d.u();
    }

    @Nullable
    public final T d() {
        return this.f22901f;
    }

    public Uri e() {
        return this.f22899d.t();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public final void load() throws IOException {
        this.f22899d.v();
        k kVar = new k(this.f22899d, this.f22897b);
        try {
            kVar.b();
            this.f22901f = this.f22900e.a((Uri) com.google.android.exoplayer2.util.a.e(this.f22899d.i()), kVar);
        } finally {
            j0.o(kVar);
        }
    }

    public i(com.google.android.exoplayer2.upstream.a aVar, b bVar, int i10, a<? extends T> aVar2) {
        this.f22899d = new t(aVar);
        this.f22897b = bVar;
        this.f22898c = i10;
        this.f22900e = aVar2;
        this.f22896a = m.a();
    }
}
