package com.google.android.exoplayer2.source;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.source.z;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: BaseMediaSource.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class a implements s {

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<s.b> f21175b = new ArrayList<>(1);

    /* renamed from: c, reason: collision with root package name */
    public final HashSet<s.b> f21176c = new HashSet<>(1);

    /* renamed from: d, reason: collision with root package name */
    public final z.a f21177d = new z.a();

    /* renamed from: e, reason: collision with root package name */
    public final b.a f21178e = new b.a();

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public Looper f21179f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public Timeline f21180g;

    public final boolean A() {
        return !this.f21176c.isEmpty();
    }

    public abstract void B(@Nullable o6.v vVar);

    public final void C(Timeline timeline) {
        this.f21180g = timeline;
        Iterator<s.b> iterator2 = this.f21175b.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().a(this, timeline);
        }
    }

    public abstract void D();

    @Override // com.google.android.exoplayer2.source.s
    public final void a(s.b bVar, @Nullable o6.v vVar) {
        Looper myLooper = Looper.myLooper();
        Looper looper = this.f21179f;
        com.google.android.exoplayer2.util.a.a(looper == null || looper == myLooper);
        Timeline timeline = this.f21180g;
        this.f21175b.add(bVar);
        if (this.f21179f == null) {
            this.f21179f = myLooper;
            this.f21176c.add(bVar);
            B(vVar);
        } else if (timeline != null) {
            k(bVar);
            bVar.a(this, timeline);
        }
    }

    @Override // com.google.android.exoplayer2.source.s
    public final void b(s.b bVar) {
        this.f21175b.remove(bVar);
        if (this.f21175b.isEmpty()) {
            this.f21179f = null;
            this.f21180g = null;
            this.f21176c.clear();
            D();
            return;
        }
        l(bVar);
    }

    @Override // com.google.android.exoplayer2.source.s
    public final void c(z zVar) {
        this.f21177d.C(zVar);
    }

    @Override // com.google.android.exoplayer2.source.s
    public /* synthetic */ Timeline g() {
        return r.a(this);
    }

    @Override // com.google.android.exoplayer2.source.s
    public final void i(Handler handler, z zVar) {
        com.google.android.exoplayer2.util.a.e(handler);
        com.google.android.exoplayer2.util.a.e(zVar);
        this.f21177d.g(handler, zVar);
    }

    @Override // com.google.android.exoplayer2.source.s
    public final void k(s.b bVar) {
        com.google.android.exoplayer2.util.a.e(this.f21179f);
        boolean isEmpty = this.f21176c.isEmpty();
        this.f21176c.add(bVar);
        if (isEmpty) {
            z();
        }
    }

    @Override // com.google.android.exoplayer2.source.s
    public final void l(s.b bVar) {
        boolean z10 = !this.f21176c.isEmpty();
        this.f21176c.remove(bVar);
        if (z10 && this.f21176c.isEmpty()) {
            y();
        }
    }

    @Override // com.google.android.exoplayer2.source.s
    public final void p(Handler handler, com.google.android.exoplayer2.drm.b bVar) {
        com.google.android.exoplayer2.util.a.e(handler);
        com.google.android.exoplayer2.util.a.e(bVar);
        this.f21178e.g(handler, bVar);
    }

    @Override // com.google.android.exoplayer2.source.s
    public final void r(com.google.android.exoplayer2.drm.b bVar) {
        this.f21178e.t(bVar);
    }

    @Override // com.google.android.exoplayer2.source.s
    public /* synthetic */ boolean s() {
        return r.b(this);
    }

    public final b.a t(int i10, @Nullable s.a aVar) {
        return this.f21178e.u(i10, aVar);
    }

    public final b.a u(@Nullable s.a aVar) {
        return this.f21178e.u(0, aVar);
    }

    public final z.a v(int i10, @Nullable s.a aVar, long j10) {
        return this.f21177d.F(i10, aVar, j10);
    }

    public final z.a w(@Nullable s.a aVar) {
        return this.f21177d.F(0, aVar, 0L);
    }

    public final z.a x(s.a aVar, long j10) {
        com.google.android.exoplayer2.util.a.e(aVar);
        return this.f21177d.F(0, aVar, j10);
    }

    public void y() {
    }

    public void z() {
    }
}
