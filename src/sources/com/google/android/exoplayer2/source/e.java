package com.google.android.exoplayer2.source;

import android.os.Handler;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.source.z;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: CompositeMediaSource.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class e<T> extends com.google.android.exoplayer2.source.a {

    /* renamed from: h, reason: collision with root package name */
    public final HashMap<T, b<T>> f21369h = new HashMap<>();

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public Handler f21370i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public o6.v f21371j;

    /* compiled from: CompositeMediaSource.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class a implements z, com.google.android.exoplayer2.drm.b {

        /* renamed from: b, reason: collision with root package name */
        public final T f21372b;

        /* renamed from: c, reason: collision with root package name */
        public z.a f21373c;

        /* renamed from: d, reason: collision with root package name */
        public b.a f21374d;

        public a(T t2) {
            this.f21373c = e.this.w(null);
            this.f21374d = e.this.u(null);
            this.f21372b = t2;
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void B(int i10, @Nullable s.a aVar, Exception exc) {
            if (a(i10, aVar)) {
                this.f21374d.l(exc);
            }
        }

        @Override // com.google.android.exoplayer2.source.z
        public void F(int i10, @Nullable s.a aVar, m mVar, MediaLoadData mediaLoadData) {
            if (a(i10, aVar)) {
                this.f21373c.v(mVar, b(mediaLoadData));
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void G(int i10, @Nullable s.a aVar) {
            if (a(i10, aVar)) {
                this.f21374d.m();
            }
        }

        public final boolean a(int i10, @Nullable s.a aVar) {
            s.a aVar2;
            if (aVar != null) {
                aVar2 = e.this.F(this.f21372b, aVar);
                if (aVar2 == null) {
                    return false;
                }
            } else {
                aVar2 = null;
            }
            int H = e.this.H(this.f21372b, i10);
            z.a aVar3 = this.f21373c;
            if (aVar3.f22153a != H || !com.google.android.exoplayer2.util.j0.c(aVar3.f22154b, aVar2)) {
                this.f21373c = e.this.v(H, aVar2, 0L);
            }
            b.a aVar4 = this.f21374d;
            if (aVar4.f19969a == H && com.google.android.exoplayer2.util.j0.c(aVar4.f19970b, aVar2)) {
                return true;
            }
            this.f21374d = e.this.t(H, aVar2);
            return true;
        }

        public final MediaLoadData b(MediaLoadData mediaLoadData) {
            long G = e.this.G(this.f21372b, mediaLoadData.mediaStartTimeMs);
            long G2 = e.this.G(this.f21372b, mediaLoadData.mediaEndTimeMs);
            return (G == mediaLoadData.mediaStartTimeMs && G2 == mediaLoadData.mediaEndTimeMs) ? mediaLoadData : new MediaLoadData(mediaLoadData.dataType, mediaLoadData.trackType, mediaLoadData.trackFormat, mediaLoadData.trackSelectionReason, mediaLoadData.trackSelectionData, G, G2);
        }

        @Override // com.google.android.exoplayer2.source.z
        public void c(int i10, @Nullable s.a aVar, m mVar, MediaLoadData mediaLoadData) {
            if (a(i10, aVar)) {
                this.f21373c.s(mVar, b(mediaLoadData));
            }
        }

        @Override // com.google.android.exoplayer2.source.z
        public void g(int i10, @Nullable s.a aVar, MediaLoadData mediaLoadData) {
            if (a(i10, aVar)) {
                this.f21373c.E(b(mediaLoadData));
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void l(int i10, @Nullable s.a aVar) {
            if (a(i10, aVar)) {
                this.f21374d.h();
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void n(int i10, @Nullable s.a aVar, int i11) {
            if (a(i10, aVar)) {
                this.f21374d.k(i11);
            }
        }

        @Override // com.google.android.exoplayer2.source.z
        public void p(int i10, @Nullable s.a aVar, m mVar, MediaLoadData mediaLoadData, IOException iOException, boolean z10) {
            if (a(i10, aVar)) {
                this.f21373c.y(mVar, b(mediaLoadData), iOException, z10);
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void r(int i10, @Nullable s.a aVar) {
            if (a(i10, aVar)) {
                this.f21374d.j();
            }
        }

        @Override // com.google.android.exoplayer2.source.z
        public void t(int i10, @Nullable s.a aVar, MediaLoadData mediaLoadData) {
            if (a(i10, aVar)) {
                this.f21373c.j(b(mediaLoadData));
            }
        }

        @Override // com.google.android.exoplayer2.source.z
        public void u(int i10, @Nullable s.a aVar, m mVar, MediaLoadData mediaLoadData) {
            if (a(i10, aVar)) {
                this.f21373c.B(mVar, b(mediaLoadData));
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void v(int i10, @Nullable s.a aVar) {
            if (a(i10, aVar)) {
                this.f21374d.i();
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public /* synthetic */ void w(int i10, s.a aVar) {
            b5.k.a(this, i10, aVar);
        }
    }

    /* compiled from: CompositeMediaSource.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b<T> {

        /* renamed from: a, reason: collision with root package name */
        public final s f21376a;

        /* renamed from: b, reason: collision with root package name */
        public final s.b f21377b;

        /* renamed from: c, reason: collision with root package name */
        public final e<T>.a f21378c;

        public b(s sVar, s.b bVar, e<T>.a aVar) {
            this.f21376a = sVar;
            this.f21377b = bVar;
            this.f21378c = aVar;
        }
    }

    @Override // com.google.android.exoplayer2.source.a
    @CallSuper
    public void B(@Nullable o6.v vVar) {
        this.f21371j = vVar;
        this.f21370i = com.google.android.exoplayer2.util.j0.x();
    }

    @Override // com.google.android.exoplayer2.source.a
    @CallSuper
    public void D() {
        for (b<T> bVar : this.f21369h.values()) {
            bVar.f21376a.b(bVar.f21377b);
            bVar.f21376a.c(bVar.f21378c);
            bVar.f21376a.r(bVar.f21378c);
        }
        this.f21369h.clear();
    }

    @Nullable
    public s.a F(T t2, s.a aVar) {
        return aVar;
    }

    public long G(T t2, long j10) {
        return j10;
    }

    public int H(T t2, int i10) {
        return i10;
    }

    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public abstract void I(T t2, s sVar, Timeline timeline);

    public final void K(final T t2, s sVar) {
        com.google.android.exoplayer2.util.a.a(!this.f21369h.containsKey(t2));
        s.b bVar = new s.b() { // from class: com.google.android.exoplayer2.source.d
            @Override // com.google.android.exoplayer2.source.s.b
            public final void a(s sVar2, Timeline timeline) {
                e.this.I(t2, sVar2, timeline);
            }
        };
        a aVar = new a(t2);
        this.f21369h.put(t2, new b<>(sVar, bVar, aVar));
        sVar.i((Handler) com.google.android.exoplayer2.util.a.e(this.f21370i), aVar);
        sVar.p((Handler) com.google.android.exoplayer2.util.a.e(this.f21370i), aVar);
        sVar.a(bVar, this.f21371j);
        if (A()) {
            return;
        }
        sVar.l(bVar);
    }

    public final void L(T t2) {
        b bVar = (b) com.google.android.exoplayer2.util.a.e(this.f21369h.remove(t2));
        bVar.f21376a.b(bVar.f21377b);
        bVar.f21376a.c(bVar.f21378c);
        bVar.f21376a.r(bVar.f21378c);
    }

    @Override // com.google.android.exoplayer2.source.s
    @CallSuper
    public void f() throws IOException {
        Iterator<b<T>> iterator2 = this.f21369h.values().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().f21376a.f();
        }
    }

    @Override // com.google.android.exoplayer2.source.a
    @CallSuper
    public void y() {
        for (b<T> bVar : this.f21369h.values()) {
            bVar.f21376a.l(bVar.f21377b);
        }
    }

    @Override // com.google.android.exoplayer2.source.a
    @CallSuper
    public void z() {
        for (b<T> bVar : this.f21369h.values()) {
            bVar.f21376a.k(bVar.f21377b);
        }
    }
}
