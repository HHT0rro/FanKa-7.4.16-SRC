package com.google.android.exoplayer2;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.source.z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: MediaSourceList.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d1 {

    /* renamed from: d, reason: collision with root package name */
    public final d f19861d;

    /* renamed from: e, reason: collision with root package name */
    public final z.a f19862e;

    /* renamed from: f, reason: collision with root package name */
    public final b.a f19863f;

    /* renamed from: g, reason: collision with root package name */
    public final HashMap<c, b> f19864g;

    /* renamed from: h, reason: collision with root package name */
    public final Set<c> f19865h;

    /* renamed from: j, reason: collision with root package name */
    public boolean f19867j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public o6.v f19868k;

    /* renamed from: i, reason: collision with root package name */
    public ShuffleOrder f19866i = new ShuffleOrder.a(0);

    /* renamed from: b, reason: collision with root package name */
    public final IdentityHashMap<com.google.android.exoplayer2.source.p, c> f19859b = new IdentityHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public final Map<Object, c> f19860c = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final List<c> f19858a = new ArrayList();

    /* compiled from: MediaSourceList.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class a implements com.google.android.exoplayer2.source.z, com.google.android.exoplayer2.drm.b {

        /* renamed from: b, reason: collision with root package name */
        public final c f19869b;

        /* renamed from: c, reason: collision with root package name */
        public z.a f19870c;

        /* renamed from: d, reason: collision with root package name */
        public b.a f19871d;

        public a(c cVar) {
            this.f19870c = d1.this.f19862e;
            this.f19871d = d1.this.f19863f;
            this.f19869b = cVar;
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void B(int i10, @Nullable s.a aVar, Exception exc) {
            if (a(i10, aVar)) {
                this.f19871d.l(exc);
            }
        }

        @Override // com.google.android.exoplayer2.source.z
        public void F(int i10, @Nullable s.a aVar, com.google.android.exoplayer2.source.m mVar, MediaLoadData mediaLoadData) {
            if (a(i10, aVar)) {
                this.f19870c.v(mVar, mediaLoadData);
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void G(int i10, @Nullable s.a aVar) {
            if (a(i10, aVar)) {
                this.f19871d.m();
            }
        }

        public final boolean a(int i10, @Nullable s.a aVar) {
            s.a aVar2;
            if (aVar != null) {
                aVar2 = d1.n(this.f19869b, aVar);
                if (aVar2 == null) {
                    return false;
                }
            } else {
                aVar2 = null;
            }
            int r10 = d1.r(this.f19869b, i10);
            z.a aVar3 = this.f19870c;
            if (aVar3.f22153a != r10 || !com.google.android.exoplayer2.util.j0.c(aVar3.f22154b, aVar2)) {
                this.f19870c = d1.this.f19862e.F(r10, aVar2, 0L);
            }
            b.a aVar4 = this.f19871d;
            if (aVar4.f19969a == r10 && com.google.android.exoplayer2.util.j0.c(aVar4.f19970b, aVar2)) {
                return true;
            }
            this.f19871d = d1.this.f19863f.u(r10, aVar2);
            return true;
        }

        @Override // com.google.android.exoplayer2.source.z
        public void c(int i10, @Nullable s.a aVar, com.google.android.exoplayer2.source.m mVar, MediaLoadData mediaLoadData) {
            if (a(i10, aVar)) {
                this.f19870c.s(mVar, mediaLoadData);
            }
        }

        @Override // com.google.android.exoplayer2.source.z
        public void g(int i10, @Nullable s.a aVar, MediaLoadData mediaLoadData) {
            if (a(i10, aVar)) {
                this.f19870c.E(mediaLoadData);
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void l(int i10, @Nullable s.a aVar) {
            if (a(i10, aVar)) {
                this.f19871d.h();
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void n(int i10, @Nullable s.a aVar, int i11) {
            if (a(i10, aVar)) {
                this.f19871d.k(i11);
            }
        }

        @Override // com.google.android.exoplayer2.source.z
        public void p(int i10, @Nullable s.a aVar, com.google.android.exoplayer2.source.m mVar, MediaLoadData mediaLoadData, IOException iOException, boolean z10) {
            if (a(i10, aVar)) {
                this.f19870c.y(mVar, mediaLoadData, iOException, z10);
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void r(int i10, @Nullable s.a aVar) {
            if (a(i10, aVar)) {
                this.f19871d.j();
            }
        }

        @Override // com.google.android.exoplayer2.source.z
        public void t(int i10, @Nullable s.a aVar, MediaLoadData mediaLoadData) {
            if (a(i10, aVar)) {
                this.f19870c.j(mediaLoadData);
            }
        }

        @Override // com.google.android.exoplayer2.source.z
        public void u(int i10, @Nullable s.a aVar, com.google.android.exoplayer2.source.m mVar, MediaLoadData mediaLoadData) {
            if (a(i10, aVar)) {
                this.f19870c.B(mVar, mediaLoadData);
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void v(int i10, @Nullable s.a aVar) {
            if (a(i10, aVar)) {
                this.f19871d.i();
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public /* synthetic */ void w(int i10, s.a aVar) {
            b5.k.a(this, i10, aVar);
        }
    }

    /* compiled from: MediaSourceList.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.source.s f19873a;

        /* renamed from: b, reason: collision with root package name */
        public final s.b f19874b;

        /* renamed from: c, reason: collision with root package name */
        public final a f19875c;

        public b(com.google.android.exoplayer2.source.s sVar, s.b bVar, a aVar) {
            this.f19873a = sVar;
            this.f19874b = bVar;
            this.f19875c = aVar;
        }
    }

    /* compiled from: MediaSourceList.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements b1 {

        /* renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.source.o f19876a;

        /* renamed from: d, reason: collision with root package name */
        public int f19879d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f19880e;

        /* renamed from: c, reason: collision with root package name */
        public final List<s.a> f19878c = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public final Object f19877b = new Object();

        public c(com.google.android.exoplayer2.source.s sVar, boolean z10) {
            this.f19876a = new com.google.android.exoplayer2.source.o(sVar, z10);
        }

        @Override // com.google.android.exoplayer2.b1
        public Timeline a() {
            return this.f19876a.Q();
        }

        public void b(int i10) {
            this.f19879d = i10;
            this.f19880e = false;
            this.f19878c.clear();
        }

        @Override // com.google.android.exoplayer2.b1
        public Object getUid() {
            return this.f19877b;
        }
    }

    /* compiled from: MediaSourceList.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface d {
        void b();
    }

    public d1(d dVar, @Nullable w4.h1 h1Var, Handler handler) {
        this.f19861d = dVar;
        z.a aVar = new z.a();
        this.f19862e = aVar;
        b.a aVar2 = new b.a();
        this.f19863f = aVar2;
        this.f19864g = new HashMap<>();
        this.f19865h = new HashSet();
        if (h1Var != null) {
            aVar.g(handler, h1Var);
            aVar2.g(handler, h1Var);
        }
    }

    public static Object m(Object obj) {
        return com.google.android.exoplayer2.a.v(obj);
    }

    @Nullable
    public static s.a n(c cVar, s.a aVar) {
        for (int i10 = 0; i10 < cVar.f19878c.size(); i10++) {
            if (cVar.f19878c.get(i10).f21886d == aVar.f21886d) {
                return aVar.c(p(cVar, aVar.f21883a));
            }
        }
        return null;
    }

    public static Object o(Object obj) {
        return com.google.android.exoplayer2.a.w(obj);
    }

    public static Object p(c cVar, Object obj) {
        return com.google.android.exoplayer2.a.y(cVar.f19877b, obj);
    }

    public static int r(c cVar, int i10) {
        return i10 + cVar.f19879d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(com.google.android.exoplayer2.source.s sVar, Timeline timeline) {
        this.f19861d.b();
    }

    public Timeline A(int i10, int i11, ShuffleOrder shuffleOrder) {
        com.google.android.exoplayer2.util.a.a(i10 >= 0 && i10 <= i11 && i11 <= q());
        this.f19866i = shuffleOrder;
        B(i10, i11);
        return i();
    }

    public final void B(int i10, int i11) {
        for (int i12 = i11 - 1; i12 >= i10; i12--) {
            c remove = this.f19858a.remove(i12);
            this.f19860c.remove(remove.f19877b);
            g(i12, -remove.f19876a.Q().p());
            remove.f19880e = true;
            if (this.f19867j) {
                u(remove);
            }
        }
    }

    public Timeline C(List<c> list, ShuffleOrder shuffleOrder) {
        B(0, this.f19858a.size());
        return f(this.f19858a.size(), list, shuffleOrder);
    }

    public Timeline D(ShuffleOrder shuffleOrder) {
        int q10 = q();
        if (shuffleOrder.b() != q10) {
            shuffleOrder = shuffleOrder.f().i(0, q10);
        }
        this.f19866i = shuffleOrder;
        return i();
    }

    public Timeline f(int i10, List<c> list, ShuffleOrder shuffleOrder) {
        if (!list.isEmpty()) {
            this.f19866i = shuffleOrder;
            for (int i11 = i10; i11 < list.size() + i10; i11++) {
                c cVar = list.get(i11 - i10);
                if (i11 > 0) {
                    c cVar2 = this.f19858a.get(i11 - 1);
                    cVar.b(cVar2.f19879d + cVar2.f19876a.Q().p());
                } else {
                    cVar.b(0);
                }
                g(i11, cVar.f19876a.Q().p());
                this.f19858a.add(i11, cVar);
                this.f19860c.put(cVar.f19877b, cVar);
                if (this.f19867j) {
                    x(cVar);
                    if (this.f19859b.isEmpty()) {
                        this.f19865h.add(cVar);
                    } else {
                        j(cVar);
                    }
                }
            }
        }
        return i();
    }

    public final void g(int i10, int i11) {
        while (i10 < this.f19858a.size()) {
            this.f19858a.get(i10).f19879d += i11;
            i10++;
        }
    }

    public com.google.android.exoplayer2.source.p h(s.a aVar, o6.b bVar, long j10) {
        Object o10 = o(aVar.f21883a);
        s.a c4 = aVar.c(m(aVar.f21883a));
        c cVar = (c) com.google.android.exoplayer2.util.a.e(this.f19860c.get(o10));
        l(cVar);
        cVar.f19878c.add(c4);
        com.google.android.exoplayer2.source.n e2 = cVar.f19876a.e(c4, bVar, j10);
        this.f19859b.put(e2, cVar);
        k();
        return e2;
    }

    public Timeline i() {
        if (this.f19858a.isEmpty()) {
            return Timeline.f19653a;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < this.f19858a.size(); i11++) {
            c cVar = this.f19858a.get(i11);
            cVar.f19879d = i10;
            i10 += cVar.f19876a.Q().p();
        }
        return new i1(this.f19858a, this.f19866i);
    }

    public final void j(c cVar) {
        b bVar = this.f19864g.get(cVar);
        if (bVar != null) {
            bVar.f19873a.l(bVar.f19874b);
        }
    }

    public final void k() {
        Iterator<c> iterator2 = this.f19865h.iterator2();
        while (iterator2.hasNext()) {
            c next = iterator2.next();
            if (next.f19878c.isEmpty()) {
                j(next);
                iterator2.remove();
            }
        }
    }

    public final void l(c cVar) {
        this.f19865h.add(cVar);
        b bVar = this.f19864g.get(cVar);
        if (bVar != null) {
            bVar.f19873a.k(bVar.f19874b);
        }
    }

    public int q() {
        return this.f19858a.size();
    }

    public boolean s() {
        return this.f19867j;
    }

    public final void u(c cVar) {
        if (cVar.f19880e && cVar.f19878c.isEmpty()) {
            b bVar = (b) com.google.android.exoplayer2.util.a.e(this.f19864g.remove(cVar));
            bVar.f19873a.b(bVar.f19874b);
            bVar.f19873a.c(bVar.f19875c);
            bVar.f19873a.r(bVar.f19875c);
            this.f19865h.remove(cVar);
        }
    }

    public Timeline v(int i10, int i11, int i12, ShuffleOrder shuffleOrder) {
        com.google.android.exoplayer2.util.a.a(i10 >= 0 && i10 <= i11 && i11 <= q() && i12 >= 0);
        this.f19866i = shuffleOrder;
        if (i10 != i11 && i10 != i12) {
            int min = Math.min(i10, i12);
            int max = Math.max(((i11 - i10) + i12) - 1, i11 - 1);
            int i13 = this.f19858a.get(min).f19879d;
            com.google.android.exoplayer2.util.j0.v0(this.f19858a, i10, i11, i12);
            while (min <= max) {
                c cVar = this.f19858a.get(min);
                cVar.f19879d = i13;
                i13 += cVar.f19876a.Q().p();
                min++;
            }
            return i();
        }
        return i();
    }

    public void w(@Nullable o6.v vVar) {
        com.google.android.exoplayer2.util.a.g(!this.f19867j);
        this.f19868k = vVar;
        for (int i10 = 0; i10 < this.f19858a.size(); i10++) {
            c cVar = this.f19858a.get(i10);
            x(cVar);
            this.f19865h.add(cVar);
        }
        this.f19867j = true;
    }

    public final void x(c cVar) {
        com.google.android.exoplayer2.source.o oVar = cVar.f19876a;
        s.b bVar = new s.b() { // from class: com.google.android.exoplayer2.c1
            @Override // com.google.android.exoplayer2.source.s.b
            public final void a(com.google.android.exoplayer2.source.s sVar, Timeline timeline) {
                d1.this.t(sVar, timeline);
            }
        };
        a aVar = new a(cVar);
        this.f19864g.put(cVar, new b(oVar, bVar, aVar));
        oVar.i(com.google.android.exoplayer2.util.j0.z(), aVar);
        oVar.p(com.google.android.exoplayer2.util.j0.z(), aVar);
        oVar.a(bVar, this.f19868k);
    }

    public void y() {
        for (b bVar : this.f19864g.values()) {
            try {
                bVar.f19873a.b(bVar.f19874b);
            } catch (RuntimeException e2) {
                com.google.android.exoplayer2.util.m.d("MediaSourceList", "Failed to release child source.", e2);
            }
            bVar.f19873a.c(bVar.f19875c);
            bVar.f19873a.r(bVar.f19875c);
        }
        this.f19864g.clear();
        this.f19865h.clear();
        this.f19867j = false;
    }

    public void z(com.google.android.exoplayer2.source.p pVar) {
        c cVar = (c) com.google.android.exoplayer2.util.a.e(this.f19859b.remove(pVar));
        cVar.f19876a.j(pVar);
        cVar.f19878c.remove(((com.google.android.exoplayer2.source.n) pVar).f21811b);
        if (!this.f19859b.isEmpty()) {
            k();
        }
        u(cVar);
    }
}
