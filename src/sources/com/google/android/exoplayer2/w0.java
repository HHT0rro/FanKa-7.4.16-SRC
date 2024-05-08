package com.google.android.exoplayer2;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.offline.StreamKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* compiled from: MediaItem.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class w0 {

    /* renamed from: f, reason: collision with root package name */
    public static final w0 f23160f = new c().a();

    /* renamed from: g, reason: collision with root package name */
    public static final com.google.android.exoplayer2.g<w0> f23161g = a5.a.f700a;

    /* renamed from: a, reason: collision with root package name */
    public final String f23162a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final g f23163b;

    /* renamed from: c, reason: collision with root package name */
    public final f f23164c;

    /* renamed from: d, reason: collision with root package name */
    public final MediaMetadata f23165d;

    /* renamed from: e, reason: collision with root package name */
    public final d f23166e;

    /* compiled from: MediaItem.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f23167a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public final Object f23168b;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f23167a.equals(bVar.f23167a) && com.google.android.exoplayer2.util.j0.c(this.f23168b, bVar.f23168b);
        }

        public int hashCode() {
            int hashCode = this.f23167a.hashCode() * 31;
            Object obj = this.f23168b;
            return hashCode + (obj != null ? obj.hashCode() : 0);
        }

        public b(Uri uri, @Nullable Object obj) {
            this.f23167a = uri;
            this.f23168b = obj;
        }
    }

    /* compiled from: MediaItem.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c {
        public float A;
        public float B;

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        public String f23169a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public Uri f23170b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public String f23171c;

        /* renamed from: d, reason: collision with root package name */
        public long f23172d;

        /* renamed from: e, reason: collision with root package name */
        public long f23173e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f23174f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f23175g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f23176h;

        /* renamed from: i, reason: collision with root package name */
        @Nullable
        public Uri f23177i;

        /* renamed from: j, reason: collision with root package name */
        public Map<String, String> f23178j;

        /* renamed from: k, reason: collision with root package name */
        @Nullable
        public UUID f23179k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f23180l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f23181m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f23182n;

        /* renamed from: o, reason: collision with root package name */
        public List<Integer> f23183o;

        /* renamed from: p, reason: collision with root package name */
        @Nullable
        public byte[] f23184p;

        /* renamed from: q, reason: collision with root package name */
        public List<StreamKey> f23185q;

        /* renamed from: r, reason: collision with root package name */
        @Nullable
        public String f23186r;

        /* renamed from: s, reason: collision with root package name */
        public List<h> f23187s;

        /* renamed from: t, reason: collision with root package name */
        @Nullable
        public Uri f23188t;

        /* renamed from: u, reason: collision with root package name */
        @Nullable
        public Object f23189u;

        /* renamed from: v, reason: collision with root package name */
        @Nullable
        public Object f23190v;

        /* renamed from: w, reason: collision with root package name */
        @Nullable
        public MediaMetadata f23191w;

        /* renamed from: x, reason: collision with root package name */
        public long f23192x;

        /* renamed from: y, reason: collision with root package name */
        public long f23193y;

        /* renamed from: z, reason: collision with root package name */
        public long f23194z;

        public w0 a() {
            g gVar;
            com.google.android.exoplayer2.util.a.g(this.f23177i == null || this.f23179k != null);
            Uri uri = this.f23170b;
            if (uri != null) {
                String str = this.f23171c;
                UUID uuid = this.f23179k;
                e eVar = uuid != null ? new e(uuid, this.f23177i, this.f23178j, this.f23180l, this.f23182n, this.f23181m, this.f23183o, this.f23184p) : null;
                Uri uri2 = this.f23188t;
                gVar = new g(uri, str, eVar, uri2 != null ? new b(uri2, this.f23189u) : null, this.f23185q, this.f23186r, this.f23187s, this.f23190v);
            } else {
                gVar = null;
            }
            String str2 = this.f23169a;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str2;
            d dVar = new d(this.f23172d, this.f23173e, this.f23174f, this.f23175g, this.f23176h);
            f fVar = new f(this.f23192x, this.f23193y, this.f23194z, this.A, this.B);
            MediaMetadata mediaMetadata = this.f23191w;
            if (mediaMetadata == null) {
                mediaMetadata = MediaMetadata.E;
            }
            return new w0(str3, dVar, gVar, fVar, mediaMetadata);
        }

        public c b(@Nullable String str) {
            this.f23186r = str;
            return this;
        }

        public c c(boolean z10) {
            this.f23182n = z10;
            return this;
        }

        public c d(@Nullable byte[] bArr) {
            this.f23184p = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
            return this;
        }

        public c e(@Nullable Map<String, String> map) {
            Map<String, String> emptyMap;
            if (map != null && !map.isEmpty()) {
                emptyMap = Collections.unmodifiableMap(new HashMap(map));
            } else {
                emptyMap = Collections.emptyMap();
            }
            this.f23178j = emptyMap;
            return this;
        }

        public c f(@Nullable Uri uri) {
            this.f23177i = uri;
            return this;
        }

        public c g(boolean z10) {
            this.f23180l = z10;
            return this;
        }

        public c h(boolean z10) {
            this.f23181m = z10;
            return this;
        }

        public c i(@Nullable List<Integer> list) {
            List<Integer> emptyList;
            if (list != null && !list.isEmpty()) {
                emptyList = Collections.unmodifiableList(new ArrayList(list));
            } else {
                emptyList = Collections.emptyList();
            }
            this.f23183o = emptyList;
            return this;
        }

        public c j(@Nullable UUID uuid) {
            this.f23179k = uuid;
            return this;
        }

        public c k(long j10) {
            this.f23194z = j10;
            return this;
        }

        public c l(float f10) {
            this.B = f10;
            return this;
        }

        public c m(long j10) {
            this.f23193y = j10;
            return this;
        }

        public c n(float f10) {
            this.A = f10;
            return this;
        }

        public c o(long j10) {
            this.f23192x = j10;
            return this;
        }

        public c p(String str) {
            this.f23169a = (String) com.google.android.exoplayer2.util.a.e(str);
            return this;
        }

        public c q(@Nullable List<StreamKey> list) {
            List<StreamKey> emptyList;
            if (list != null && !list.isEmpty()) {
                emptyList = Collections.unmodifiableList(new ArrayList(list));
            } else {
                emptyList = Collections.emptyList();
            }
            this.f23185q = emptyList;
            return this;
        }

        public c r(@Nullable List<h> list) {
            List<h> emptyList;
            if (list != null && !list.isEmpty()) {
                emptyList = Collections.unmodifiableList(new ArrayList(list));
            } else {
                emptyList = Collections.emptyList();
            }
            this.f23187s = emptyList;
            return this;
        }

        public c s(@Nullable Object obj) {
            this.f23190v = obj;
            return this;
        }

        public c t(@Nullable Uri uri) {
            this.f23170b = uri;
            return this;
        }

        public c() {
            this.f23173e = Long.MIN_VALUE;
            this.f23183o = Collections.emptyList();
            this.f23178j = Collections.emptyMap();
            this.f23185q = Collections.emptyList();
            this.f23187s = Collections.emptyList();
            this.f23192x = -9223372036854775807L;
            this.f23193y = -9223372036854775807L;
            this.f23194z = -9223372036854775807L;
            this.A = -3.4028235E38f;
            this.B = -3.4028235E38f;
        }

        public c(w0 w0Var) {
            this();
            d dVar = w0Var.f23166e;
            this.f23173e = dVar.f23197b;
            this.f23174f = dVar.f23198c;
            this.f23175g = dVar.f23199d;
            this.f23172d = dVar.f23196a;
            this.f23176h = dVar.f23200e;
            this.f23169a = w0Var.f23162a;
            this.f23191w = w0Var.f23165d;
            f fVar = w0Var.f23164c;
            this.f23192x = fVar.f23211a;
            this.f23193y = fVar.f23212b;
            this.f23194z = fVar.f23213c;
            this.A = fVar.f23214d;
            this.B = fVar.f23215e;
            g gVar = w0Var.f23163b;
            if (gVar != null) {
                this.f23186r = gVar.f23221f;
                this.f23171c = gVar.f23217b;
                this.f23170b = gVar.f23216a;
                this.f23185q = gVar.f23220e;
                this.f23187s = gVar.f23222g;
                this.f23190v = gVar.f23223h;
                e eVar = gVar.f23218c;
                if (eVar != null) {
                    this.f23177i = eVar.f23202b;
                    this.f23178j = eVar.f23203c;
                    this.f23180l = eVar.f23204d;
                    this.f23182n = eVar.f23206f;
                    this.f23181m = eVar.f23205e;
                    this.f23183o = eVar.f23207g;
                    this.f23179k = eVar.f23201a;
                    this.f23184p = eVar.a();
                }
                b bVar = gVar.f23219d;
                if (bVar != null) {
                    this.f23188t = bVar.f23167a;
                    this.f23189u = bVar.f23168b;
                }
            }
        }
    }

    /* compiled from: MediaItem.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d {

        /* renamed from: f, reason: collision with root package name */
        public static final com.google.android.exoplayer2.g<d> f23195f = a5.a.f700a;

        /* renamed from: a, reason: collision with root package name */
        public final long f23196a;

        /* renamed from: b, reason: collision with root package name */
        public final long f23197b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f23198c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f23199d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f23200e;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f23196a == dVar.f23196a && this.f23197b == dVar.f23197b && this.f23198c == dVar.f23198c && this.f23199d == dVar.f23199d && this.f23200e == dVar.f23200e;
        }

        public int hashCode() {
            long j10 = this.f23196a;
            int i10 = ((int) (j10 ^ (j10 >>> 32))) * 31;
            long j11 = this.f23197b;
            return ((((((i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31) + (this.f23198c ? 1 : 0)) * 31) + (this.f23199d ? 1 : 0)) * 31) + (this.f23200e ? 1 : 0);
        }

        public d(long j10, long j11, boolean z10, boolean z11, boolean z12) {
            this.f23196a = j10;
            this.f23197b = j11;
            this.f23198c = z10;
            this.f23199d = z11;
            this.f23200e = z12;
        }
    }

    /* compiled from: MediaItem.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public final UUID f23201a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public final Uri f23202b;

        /* renamed from: c, reason: collision with root package name */
        public final Map<String, String> f23203c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f23204d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f23205e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f23206f;

        /* renamed from: g, reason: collision with root package name */
        public final List<Integer> f23207g;

        /* renamed from: h, reason: collision with root package name */
        @Nullable
        public final byte[] f23208h;

        @Nullable
        public byte[] a() {
            byte[] bArr = this.f23208h;
            if (bArr != null) {
                return Arrays.copyOf(bArr, bArr.length);
            }
            return null;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return this.f23201a.equals(eVar.f23201a) && com.google.android.exoplayer2.util.j0.c(this.f23202b, eVar.f23202b) && com.google.android.exoplayer2.util.j0.c(this.f23203c, eVar.f23203c) && this.f23204d == eVar.f23204d && this.f23206f == eVar.f23206f && this.f23205e == eVar.f23205e && this.f23207g.equals(eVar.f23207g) && Arrays.equals(this.f23208h, eVar.f23208h);
        }

        public int hashCode() {
            int hashCode = this.f23201a.hashCode() * 31;
            Uri uri = this.f23202b;
            return ((((((((((((hashCode + (uri != null ? uri.hashCode() : 0)) * 31) + this.f23203c.hashCode()) * 31) + (this.f23204d ? 1 : 0)) * 31) + (this.f23206f ? 1 : 0)) * 31) + (this.f23205e ? 1 : 0)) * 31) + this.f23207g.hashCode()) * 31) + Arrays.hashCode(this.f23208h);
        }

        public e(UUID uuid, @Nullable Uri uri, Map<String, String> map, boolean z10, boolean z11, boolean z12, List<Integer> list, @Nullable byte[] bArr) {
            com.google.android.exoplayer2.util.a.a((z11 && uri == null) ? false : true);
            this.f23201a = uuid;
            this.f23202b = uri;
            this.f23203c = map;
            this.f23204d = z10;
            this.f23206f = z11;
            this.f23205e = z12;
            this.f23207g = list;
            this.f23208h = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
        }
    }

    /* compiled from: MediaItem.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class f {

        /* renamed from: f, reason: collision with root package name */
        public static final f f23209f = new f(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, -3.4028235E38f, -3.4028235E38f);

        /* renamed from: g, reason: collision with root package name */
        public static final com.google.android.exoplayer2.g<f> f23210g = a5.a.f700a;

        /* renamed from: a, reason: collision with root package name */
        public final long f23211a;

        /* renamed from: b, reason: collision with root package name */
        public final long f23212b;

        /* renamed from: c, reason: collision with root package name */
        public final long f23213c;

        /* renamed from: d, reason: collision with root package name */
        public final float f23214d;

        /* renamed from: e, reason: collision with root package name */
        public final float f23215e;

        public f(long j10, long j11, long j12, float f10, float f11) {
            this.f23211a = j10;
            this.f23212b = j11;
            this.f23213c = j12;
            this.f23214d = f10;
            this.f23215e = f11;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return this.f23211a == fVar.f23211a && this.f23212b == fVar.f23212b && this.f23213c == fVar.f23213c && this.f23214d == fVar.f23214d && this.f23215e == fVar.f23215e;
        }

        public int hashCode() {
            long j10 = this.f23211a;
            long j11 = this.f23212b;
            int i10 = ((((int) (j10 ^ (j10 >>> 32))) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31;
            long j12 = this.f23213c;
            int i11 = (i10 + ((int) (j12 ^ (j12 >>> 32)))) * 31;
            float f10 = this.f23214d;
            int floatToIntBits = (i11 + (f10 != 0.0f ? Float.floatToIntBits(f10) : 0)) * 31;
            float f11 = this.f23215e;
            return floatToIntBits + (f11 != 0.0f ? Float.floatToIntBits(f11) : 0);
        }
    }

    /* compiled from: MediaItem.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f23216a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public final String f23217b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public final e f23218c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        public final b f23219d;

        /* renamed from: e, reason: collision with root package name */
        public final List<StreamKey> f23220e;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        public final String f23221f;

        /* renamed from: g, reason: collision with root package name */
        public final List<h> f23222g;

        /* renamed from: h, reason: collision with root package name */
        @Nullable
        public final Object f23223h;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return this.f23216a.equals(gVar.f23216a) && com.google.android.exoplayer2.util.j0.c(this.f23217b, gVar.f23217b) && com.google.android.exoplayer2.util.j0.c(this.f23218c, gVar.f23218c) && com.google.android.exoplayer2.util.j0.c(this.f23219d, gVar.f23219d) && this.f23220e.equals(gVar.f23220e) && com.google.android.exoplayer2.util.j0.c(this.f23221f, gVar.f23221f) && this.f23222g.equals(gVar.f23222g) && com.google.android.exoplayer2.util.j0.c(this.f23223h, gVar.f23223h);
        }

        public int hashCode() {
            int hashCode = this.f23216a.hashCode() * 31;
            String str = this.f23217b;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            e eVar = this.f23218c;
            int hashCode3 = (hashCode2 + (eVar == null ? 0 : eVar.hashCode())) * 31;
            b bVar = this.f23219d;
            int hashCode4 = (((hashCode3 + (bVar == null ? 0 : bVar.hashCode())) * 31) + this.f23220e.hashCode()) * 31;
            String str2 = this.f23221f;
            int hashCode5 = (((hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f23222g.hashCode()) * 31;
            Object obj = this.f23223h;
            return hashCode5 + (obj != null ? obj.hashCode() : 0);
        }

        public g(Uri uri, @Nullable String str, @Nullable e eVar, @Nullable b bVar, List<StreamKey> list, @Nullable String str2, List<h> list2, @Nullable Object obj) {
            this.f23216a = uri;
            this.f23217b = str;
            this.f23218c = eVar;
            this.f23219d = bVar;
            this.f23220e = list;
            this.f23221f = str2;
            this.f23222g = list2;
            this.f23223h = obj;
        }
    }

    /* compiled from: MediaItem.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class h {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f23224a;

        /* renamed from: b, reason: collision with root package name */
        public final String f23225b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public final String f23226c;

        /* renamed from: d, reason: collision with root package name */
        public final int f23227d;

        /* renamed from: e, reason: collision with root package name */
        public final int f23228e;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        public final String f23229f;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return this.f23224a.equals(hVar.f23224a) && this.f23225b.equals(hVar.f23225b) && com.google.android.exoplayer2.util.j0.c(this.f23226c, hVar.f23226c) && this.f23227d == hVar.f23227d && this.f23228e == hVar.f23228e && com.google.android.exoplayer2.util.j0.c(this.f23229f, hVar.f23229f);
        }

        public int hashCode() {
            int hashCode = ((this.f23224a.hashCode() * 31) + this.f23225b.hashCode()) * 31;
            String str = this.f23226c;
            int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f23227d) * 31) + this.f23228e) * 31;
            String str2 = this.f23229f;
            return hashCode2 + (str2 != null ? str2.hashCode() : 0);
        }
    }

    public static w0 b(Uri uri) {
        return new c().t(uri).a();
    }

    public c a() {
        return new c();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w0)) {
            return false;
        }
        w0 w0Var = (w0) obj;
        return com.google.android.exoplayer2.util.j0.c(this.f23162a, w0Var.f23162a) && this.f23166e.equals(w0Var.f23166e) && com.google.android.exoplayer2.util.j0.c(this.f23163b, w0Var.f23163b) && com.google.android.exoplayer2.util.j0.c(this.f23164c, w0Var.f23164c) && com.google.android.exoplayer2.util.j0.c(this.f23165d, w0Var.f23165d);
    }

    public int hashCode() {
        int hashCode = this.f23162a.hashCode() * 31;
        g gVar = this.f23163b;
        return ((((((hashCode + (gVar != null ? gVar.hashCode() : 0)) * 31) + this.f23164c.hashCode()) * 31) + this.f23166e.hashCode()) * 31) + this.f23165d.hashCode();
    }

    public w0(String str, d dVar, @Nullable g gVar, f fVar, MediaMetadata mediaMetadata) {
        this.f23162a = str;
        this.f23163b = gVar;
        this.f23164c = fVar;
        this.f23165d = mediaMetadata;
        this.f23166e = dVar;
    }
}
