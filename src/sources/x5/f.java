package x5;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.Loader;
import java.util.List;
import java.util.Map;
import o6.t;

/* compiled from: Chunk.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class f implements Loader.e {

    /* renamed from: a, reason: collision with root package name */
    public final long f54506a = com.google.android.exoplayer2.source.m.a();

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.b f54507b;

    /* renamed from: c, reason: collision with root package name */
    public final int f54508c;

    /* renamed from: d, reason: collision with root package name */
    public final Format f54509d;

    /* renamed from: e, reason: collision with root package name */
    public final int f54510e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public final Object f54511f;

    /* renamed from: g, reason: collision with root package name */
    public final long f54512g;

    /* renamed from: h, reason: collision with root package name */
    public final long f54513h;

    /* renamed from: i, reason: collision with root package name */
    public final t f54514i;

    public f(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, int i10, Format format, int i11, @Nullable Object obj, long j10, long j11) {
        this.f54514i = new t(aVar);
        this.f54507b = (com.google.android.exoplayer2.upstream.b) com.google.android.exoplayer2.util.a.e(bVar);
        this.f54508c = i10;
        this.f54509d = format;
        this.f54510e = i11;
        this.f54511f = obj;
        this.f54512g = j10;
        this.f54513h = j11;
    }

    public final long a() {
        return this.f54514i.n();
    }

    public final long c() {
        return this.f54513h - this.f54512g;
    }

    public final Map<String, List<String>> d() {
        return this.f54514i.u();
    }

    public final Uri e() {
        return this.f54514i.t();
    }
}
