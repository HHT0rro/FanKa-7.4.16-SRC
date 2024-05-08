package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: DataSpec.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f22767a;

    /* renamed from: b, reason: collision with root package name */
    public final long f22768b;

    /* renamed from: c, reason: collision with root package name */
    public final int f22769c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final byte[] f22770d;

    /* renamed from: e, reason: collision with root package name */
    public final Map<String, String> f22771e;

    /* renamed from: f, reason: collision with root package name */
    @Deprecated
    public final long f22772f;

    /* renamed from: g, reason: collision with root package name */
    public final long f22773g;

    /* renamed from: h, reason: collision with root package name */
    public final long f22774h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public final String f22775i;

    /* renamed from: j, reason: collision with root package name */
    public final int f22776j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public final Object f22777k;

    /* compiled from: DataSpec.java */
    /* renamed from: com.google.android.exoplayer2.upstream.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class C0209b {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        public Uri f22778a;

        /* renamed from: b, reason: collision with root package name */
        public long f22779b;

        /* renamed from: c, reason: collision with root package name */
        public int f22780c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        public byte[] f22781d;

        /* renamed from: e, reason: collision with root package name */
        public Map<String, String> f22782e;

        /* renamed from: f, reason: collision with root package name */
        public long f22783f;

        /* renamed from: g, reason: collision with root package name */
        public long f22784g;

        /* renamed from: h, reason: collision with root package name */
        @Nullable
        public String f22785h;

        /* renamed from: i, reason: collision with root package name */
        public int f22786i;

        /* renamed from: j, reason: collision with root package name */
        @Nullable
        public Object f22787j;

        public b a() {
            com.google.android.exoplayer2.util.a.j(this.f22778a, "The uri must be set.");
            return new b(this.f22778a, this.f22779b, this.f22780c, this.f22781d, this.f22782e, this.f22783f, this.f22784g, this.f22785h, this.f22786i, this.f22787j);
        }

        public C0209b b(int i10) {
            this.f22786i = i10;
            return this;
        }

        public C0209b c(@Nullable byte[] bArr) {
            this.f22781d = bArr;
            return this;
        }

        public C0209b d(int i10) {
            this.f22780c = i10;
            return this;
        }

        public C0209b e(Map<String, String> map) {
            this.f22782e = map;
            return this;
        }

        public C0209b f(@Nullable String str) {
            this.f22785h = str;
            return this;
        }

        public C0209b g(long j10) {
            this.f22784g = j10;
            return this;
        }

        public C0209b h(long j10) {
            this.f22783f = j10;
            return this;
        }

        public C0209b i(Uri uri) {
            this.f22778a = uri;
            return this;
        }

        public C0209b j(String str) {
            this.f22778a = Uri.parse(str);
            return this;
        }

        public C0209b k(long j10) {
            this.f22779b = j10;
            return this;
        }

        public C0209b() {
            this.f22780c = 1;
            this.f22782e = Collections.emptyMap();
            this.f22784g = -1L;
        }

        public C0209b(b bVar) {
            this.f22778a = bVar.f22767a;
            this.f22779b = bVar.f22768b;
            this.f22780c = bVar.f22769c;
            this.f22781d = bVar.f22770d;
            this.f22782e = bVar.f22771e;
            this.f22783f = bVar.f22773g;
            this.f22784g = bVar.f22774h;
            this.f22785h = bVar.f22775i;
            this.f22786i = bVar.f22776j;
            this.f22787j = bVar.f22777k;
        }
    }

    public static String c(int i10) {
        if (i10 == 1) {
            return "GET";
        }
        if (i10 == 2) {
            return "POST";
        }
        if (i10 == 3) {
            return "HEAD";
        }
        throw new IllegalStateException();
    }

    public C0209b a() {
        return new C0209b();
    }

    public final String b() {
        return c(this.f22769c);
    }

    public boolean d(int i10) {
        return (this.f22776j & i10) == i10;
    }

    public b e(long j10) {
        long j11 = this.f22774h;
        return f(j10, j11 != -1 ? j11 - j10 : -1L);
    }

    public b f(long j10, long j11) {
        return (j10 == 0 && this.f22774h == j11) ? this : new b(this.f22767a, this.f22768b, this.f22769c, this.f22770d, this.f22771e, this.f22773g + j10, j11, this.f22775i, this.f22776j, this.f22777k);
    }

    public String toString() {
        String b4 = b();
        String valueOf = String.valueOf(this.f22767a);
        long j10 = this.f22773g;
        long j11 = this.f22774h;
        String str = this.f22775i;
        int i10 = this.f22776j;
        StringBuilder sb2 = new StringBuilder(String.valueOf(b4).length() + 70 + valueOf.length() + String.valueOf(str).length());
        sb2.append("DataSpec[");
        sb2.append(b4);
        sb2.append(" ");
        sb2.append(valueOf);
        sb2.append(", ");
        sb2.append(j10);
        sb2.append(", ");
        sb2.append(j11);
        sb2.append(", ");
        sb2.append(str);
        sb2.append(", ");
        sb2.append(i10);
        sb2.append("]");
        return sb2.toString();
    }

    public b(Uri uri) {
        this(uri, 0L, -1L);
    }

    public b(Uri uri, long j10, long j11) {
        this(uri, 0L, 1, null, Collections.emptyMap(), j10, j11, null, 0, null);
    }

    public b(Uri uri, long j10, int i10, @Nullable byte[] bArr, Map<String, String> map, long j11, long j12, @Nullable String str, int i11, @Nullable Object obj) {
        byte[] bArr2 = bArr;
        long j13 = j10 + j11;
        boolean z10 = true;
        com.google.android.exoplayer2.util.a.a(j13 >= 0);
        com.google.android.exoplayer2.util.a.a(j11 >= 0);
        if (j12 <= 0 && j12 != -1) {
            z10 = false;
        }
        com.google.android.exoplayer2.util.a.a(z10);
        this.f22767a = uri;
        this.f22768b = j10;
        this.f22769c = i10;
        this.f22770d = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.f22771e = Collections.unmodifiableMap(new HashMap(map));
        this.f22773g = j11;
        this.f22772f = j13;
        this.f22774h = j12;
        this.f22775i = str;
        this.f22776j = i11;
        this.f22777k = obj;
    }
}
