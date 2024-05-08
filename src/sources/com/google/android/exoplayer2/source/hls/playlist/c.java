package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.g0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: HlsMediaPlaylist.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c extends a6.e {

    /* renamed from: d, reason: collision with root package name */
    public final int f21690d;

    /* renamed from: e, reason: collision with root package name */
    public final long f21691e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f21692f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f21693g;

    /* renamed from: h, reason: collision with root package name */
    public final long f21694h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f21695i;

    /* renamed from: j, reason: collision with root package name */
    public final int f21696j;

    /* renamed from: k, reason: collision with root package name */
    public final long f21697k;

    /* renamed from: l, reason: collision with root package name */
    public final int f21698l;

    /* renamed from: m, reason: collision with root package name */
    public final long f21699m;

    /* renamed from: n, reason: collision with root package name */
    public final long f21700n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f21701o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f21702p;

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public final DrmInitData f21703q;

    /* renamed from: r, reason: collision with root package name */
    public final List<d> f21704r;

    /* renamed from: s, reason: collision with root package name */
    public final List<b> f21705s;

    /* renamed from: t, reason: collision with root package name */
    public final Map<Uri, C0199c> f21706t;

    /* renamed from: u, reason: collision with root package name */
    public final long f21707u;

    /* renamed from: v, reason: collision with root package name */
    public final f f21708v;

    /* compiled from: HlsMediaPlaylist.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends e {

        /* renamed from: m, reason: collision with root package name */
        public final boolean f21709m;

        /* renamed from: n, reason: collision with root package name */
        public final boolean f21710n;

        public b(String str, @Nullable d dVar, long j10, int i10, long j11, @Nullable DrmInitData drmInitData, @Nullable String str2, @Nullable String str3, long j12, long j13, boolean z10, boolean z11, boolean z12) {
            super(str, dVar, j10, i10, j11, drmInitData, str2, str3, j12, j13, z10);
            this.f21709m = z11;
            this.f21710n = z12;
        }

        public b b(long j10, int i10) {
            return new b(this.f21716b, this.f21717c, this.f21718d, i10, j10, this.f21721g, this.f21722h, this.f21723i, this.f21724j, this.f21725k, this.f21726l, this.f21709m, this.f21710n);
        }
    }

    /* compiled from: HlsMediaPlaylist.java */
    /* renamed from: com.google.android.exoplayer2.source.hls.playlist.c$c, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class C0199c {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f21711a;

        /* renamed from: b, reason: collision with root package name */
        public final long f21712b;

        /* renamed from: c, reason: collision with root package name */
        public final int f21713c;

        public C0199c(Uri uri, long j10, int i10) {
            this.f21711a = uri;
            this.f21712b = j10;
            this.f21713c = i10;
        }
    }

    /* compiled from: HlsMediaPlaylist.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class e implements Comparable<Long> {

        /* renamed from: b, reason: collision with root package name */
        public final String f21716b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public final d f21717c;

        /* renamed from: d, reason: collision with root package name */
        public final long f21718d;

        /* renamed from: e, reason: collision with root package name */
        public final int f21719e;

        /* renamed from: f, reason: collision with root package name */
        public final long f21720f;

        /* renamed from: g, reason: collision with root package name */
        @Nullable
        public final DrmInitData f21721g;

        /* renamed from: h, reason: collision with root package name */
        @Nullable
        public final String f21722h;

        /* renamed from: i, reason: collision with root package name */
        @Nullable
        public final String f21723i;

        /* renamed from: j, reason: collision with root package name */
        public final long f21724j;

        /* renamed from: k, reason: collision with root package name */
        public final long f21725k;

        /* renamed from: l, reason: collision with root package name */
        public final boolean f21726l;

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(Long l10) {
            if (this.f21720f > l10.longValue()) {
                return 1;
            }
            return this.f21720f < l10.longValue() ? -1 : 0;
        }

        public e(String str, @Nullable d dVar, long j10, int i10, long j11, @Nullable DrmInitData drmInitData, @Nullable String str2, @Nullable String str3, long j12, long j13, boolean z10) {
            this.f21716b = str;
            this.f21717c = dVar;
            this.f21718d = j10;
            this.f21719e = i10;
            this.f21720f = j11;
            this.f21721g = drmInitData;
            this.f21722h = str2;
            this.f21723i = str3;
            this.f21724j = j12;
            this.f21725k = j13;
            this.f21726l = z10;
        }
    }

    /* compiled from: HlsMediaPlaylist.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        public final long f21727a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f21728b;

        /* renamed from: c, reason: collision with root package name */
        public final long f21729c;

        /* renamed from: d, reason: collision with root package name */
        public final long f21730d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f21731e;

        public f(long j10, boolean z10, long j11, long j12, boolean z11) {
            this.f21727a = j10;
            this.f21728b = z10;
            this.f21729c = j11;
            this.f21730d = j12;
            this.f21731e = z11;
        }
    }

    public c(int i10, String str, List<String> list, long j10, boolean z10, long j11, boolean z11, int i11, long j12, int i12, long j13, long j14, boolean z12, boolean z13, boolean z14, @Nullable DrmInitData drmInitData, List<d> list2, List<b> list3, f fVar, Map<Uri, C0199c> map) {
        super(str, list, z12);
        this.f21690d = i10;
        this.f21694h = j11;
        this.f21693g = z10;
        this.f21695i = z11;
        this.f21696j = i11;
        this.f21697k = j12;
        this.f21698l = i12;
        this.f21699m = j13;
        this.f21700n = j14;
        this.f21701o = z13;
        this.f21702p = z14;
        this.f21703q = drmInitData;
        this.f21704r = ImmutableList.copyOf((Collection) list2);
        this.f21705s = ImmutableList.copyOf((Collection) list3);
        this.f21706t = ImmutableMap.copyOf((Map) map);
        if (!list3.isEmpty()) {
            b bVar = (b) g0.f(list3);
            this.f21707u = bVar.f21720f + bVar.f21718d;
        } else if (!list2.isEmpty()) {
            d dVar = (d) g0.f(list2);
            this.f21707u = dVar.f21720f + dVar.f21718d;
        } else {
            this.f21707u = 0L;
        }
        long j15 = -9223372036854775807L;
        if (j10 != -9223372036854775807L) {
            if (j10 >= 0) {
                j15 = Math.min(this.f21707u, j10);
            } else {
                j15 = Math.max(0L, this.f21707u + j10);
            }
        }
        this.f21691e = j15;
        this.f21692f = j10 >= 0;
        this.f21708v = fVar;
    }

    @Override // u5.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c a(List<StreamKey> list) {
        return this;
    }

    public c c(long j10, int i10) {
        return new c(this.f21690d, this.f711a, this.f712b, this.f21691e, this.f21693g, j10, true, i10, this.f21697k, this.f21698l, this.f21699m, this.f21700n, this.f713c, this.f21701o, this.f21702p, this.f21703q, this.f21704r, this.f21705s, this.f21708v, this.f21706t);
    }

    public c d() {
        return this.f21701o ? this : new c(this.f21690d, this.f711a, this.f712b, this.f21691e, this.f21693g, this.f21694h, this.f21695i, this.f21696j, this.f21697k, this.f21698l, this.f21699m, this.f21700n, this.f713c, true, this.f21702p, this.f21703q, this.f21704r, this.f21705s, this.f21708v, this.f21706t);
    }

    public long e() {
        return this.f21694h + this.f21707u;
    }

    public boolean f(@Nullable c cVar) {
        if (cVar == null) {
            return true;
        }
        long j10 = this.f21697k;
        long j11 = cVar.f21697k;
        if (j10 > j11) {
            return true;
        }
        if (j10 < j11) {
            return false;
        }
        int size = this.f21704r.size() - cVar.f21704r.size();
        if (size != 0) {
            return size > 0;
        }
        int size2 = this.f21705s.size();
        int size3 = cVar.f21705s.size();
        if (size2 <= size3) {
            return size2 == size3 && this.f21701o && !cVar.f21701o;
        }
        return true;
    }

    /* compiled from: HlsMediaPlaylist.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d extends e {

        /* renamed from: m, reason: collision with root package name */
        public final String f21714m;

        /* renamed from: n, reason: collision with root package name */
        public final List<b> f21715n;

        public d(String str, long j10, long j11, @Nullable String str2, @Nullable String str3) {
            this(str, null, "", 0L, -1, -9223372036854775807L, null, str2, str3, j10, j11, false, ImmutableList.of());
        }

        public d b(long j10, int i10) {
            ArrayList arrayList = new ArrayList();
            long j11 = j10;
            for (int i11 = 0; i11 < this.f21715n.size(); i11++) {
                b bVar = this.f21715n.get(i11);
                arrayList.add(bVar.b(j11, i10));
                j11 += bVar.f21718d;
            }
            return new d(this.f21716b, this.f21717c, this.f21714m, this.f21718d, i10, j10, this.f21721g, this.f21722h, this.f21723i, this.f21724j, this.f21725k, this.f21726l, arrayList);
        }

        public d(String str, @Nullable d dVar, String str2, long j10, int i10, long j11, @Nullable DrmInitData drmInitData, @Nullable String str3, @Nullable String str4, long j12, long j13, boolean z10, List<b> list) {
            super(str, dVar, j10, i10, j11, drmInitData, str3, str4, j12, j13, z10);
            this.f21714m = str2;
            this.f21715n = ImmutableList.copyOf((Collection) list);
        }
    }
}
