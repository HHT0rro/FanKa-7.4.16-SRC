package z5;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.Format;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import z5.k;

/* compiled from: Representation.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public final long f54936a;

    /* renamed from: b, reason: collision with root package name */
    public final Format f54937b;

    /* renamed from: c, reason: collision with root package name */
    public final ImmutableList<z5.b> f54938c;

    /* renamed from: d, reason: collision with root package name */
    public final long f54939d;

    /* renamed from: e, reason: collision with root package name */
    public final List<e> f54940e;

    /* renamed from: f, reason: collision with root package name */
    public final i f54941f;

    /* compiled from: Representation.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class b extends j implements y5.e {

        /* renamed from: g, reason: collision with root package name */
        @VisibleForTesting
        public final k.a f54942g;

        public b(long j10, Format format, List<z5.b> list, k.a aVar, @Nullable List<e> list2) {
            super(j10, format, list, aVar, list2);
            this.f54942g = aVar;
        }

        @Override // y5.e
        public long a(long j10, long j11) {
            return this.f54942g.h(j10, j11);
        }

        @Override // y5.e
        public long b(long j10, long j11) {
            return this.f54942g.d(j10, j11);
        }

        @Override // y5.e
        public long c(long j10) {
            return this.f54942g.j(j10);
        }

        @Override // y5.e
        public long d(long j10, long j11) {
            return this.f54942g.f(j10, j11);
        }

        @Override // y5.e
        public long e(long j10, long j11) {
            return this.f54942g.i(j10, j11);
        }

        @Override // y5.e
        public long f(long j10) {
            return this.f54942g.g(j10);
        }

        @Override // y5.e
        public long g() {
            return this.f54942g.e();
        }

        @Override // y5.e
        public i h(long j10) {
            return this.f54942g.k(this, j10);
        }

        @Override // y5.e
        public boolean i() {
            return this.f54942g.l();
        }

        @Override // y5.e
        public long j(long j10, long j11) {
            return this.f54942g.c(j10, j11);
        }

        @Override // z5.j
        @Nullable
        public String k() {
            return null;
        }

        @Override // z5.j
        public y5.e l() {
            return this;
        }

        @Override // z5.j
        @Nullable
        public i m() {
            return null;
        }
    }

    /* compiled from: Representation.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class c extends j {

        /* renamed from: g, reason: collision with root package name */
        public final Uri f54943g;

        /* renamed from: h, reason: collision with root package name */
        public final long f54944h;

        /* renamed from: i, reason: collision with root package name */
        @Nullable
        public final String f54945i;

        /* renamed from: j, reason: collision with root package name */
        @Nullable
        public final i f54946j;

        /* renamed from: k, reason: collision with root package name */
        @Nullable
        public final m f54947k;

        public c(long j10, Format format, List<z5.b> list, k.e eVar, @Nullable List<e> list2, @Nullable String str, long j11) {
            super(j10, format, list, eVar, list2);
            this.f54943g = Uri.parse(list.get(0).f54885a);
            i c4 = eVar.c();
            this.f54946j = c4;
            this.f54945i = str;
            this.f54944h = j11;
            this.f54947k = c4 != null ? null : new m(new i(null, 0L, j11));
        }

        @Override // z5.j
        @Nullable
        public String k() {
            return this.f54945i;
        }

        @Override // z5.j
        @Nullable
        public y5.e l() {
            return this.f54947k;
        }

        @Override // z5.j
        @Nullable
        public i m() {
            return this.f54946j;
        }
    }

    public static j o(long j10, Format format, List<z5.b> list, k kVar, @Nullable List<e> list2) {
        return p(j10, format, list, kVar, list2, null);
    }

    public static j p(long j10, Format format, List<z5.b> list, k kVar, @Nullable List<e> list2, @Nullable String str) {
        if (kVar instanceof k.e) {
            return new c(j10, format, list, (k.e) kVar, list2, str, -1L);
        }
        if (kVar instanceof k.a) {
            return new b(j10, format, list, (k.a) kVar, list2);
        }
        throw new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
    }

    @Nullable
    public abstract String k();

    @Nullable
    public abstract y5.e l();

    @Nullable
    public abstract i m();

    @Nullable
    public i n() {
        return this.f54941f;
    }

    public j(long j10, Format format, List<z5.b> list, k kVar, @Nullable List<e> list2) {
        List<e> unmodifiableList;
        com.google.android.exoplayer2.util.a.a(!list.isEmpty());
        this.f54936a = j10;
        this.f54937b = format;
        this.f54938c = ImmutableList.copyOf((Collection) list);
        if (list2 == null) {
            unmodifiableList = Collections.emptyList();
        } else {
            unmodifiableList = Collections.unmodifiableList(list2);
        }
        this.f54940e = unmodifiableList;
        this.f54941f = kVar.a(this);
        this.f54939d = kVar.b();
    }
}
