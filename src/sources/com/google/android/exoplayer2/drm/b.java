package com.google.android.exoplayer2.drm;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.util.j0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: DrmSessionEventListener.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface b {

    /* compiled from: DrmSessionEventListener.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f19969a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public final s.a f19970b;

        /* renamed from: c, reason: collision with root package name */
        public final CopyOnWriteArrayList<C0187a> f19971c;

        /* compiled from: DrmSessionEventListener.java */
        /* renamed from: com.google.android.exoplayer2.drm.b$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static final class C0187a {

            /* renamed from: a, reason: collision with root package name */
            public Handler f19972a;

            /* renamed from: b, reason: collision with root package name */
            public b f19973b;

            public C0187a(Handler handler, b bVar) {
                this.f19972a = handler;
                this.f19973b = bVar;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(b bVar) {
            bVar.l(this.f19969a, this.f19970b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(b bVar) {
            bVar.v(this.f19969a, this.f19970b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(b bVar) {
            bVar.r(this.f19969a, this.f19970b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(b bVar, int i10) {
            bVar.w(this.f19969a, this.f19970b);
            bVar.n(this.f19969a, this.f19970b, i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(b bVar, Exception exc) {
            bVar.B(this.f19969a, this.f19970b, exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(b bVar) {
            bVar.G(this.f19969a, this.f19970b);
        }

        public void g(Handler handler, b bVar) {
            com.google.android.exoplayer2.util.a.e(handler);
            com.google.android.exoplayer2.util.a.e(bVar);
            this.f19971c.add(new C0187a(handler, bVar));
        }

        public void h() {
            Iterator<C0187a> iterator2 = this.f19971c.iterator2();
            while (iterator2.hasNext()) {
                C0187a next = iterator2.next();
                final b bVar = next.f19973b;
                j0.E0(next.f19972a, new Runnable() { // from class: b5.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.a.this.n(bVar);
                    }
                });
            }
        }

        public void i() {
            Iterator<C0187a> iterator2 = this.f19971c.iterator2();
            while (iterator2.hasNext()) {
                C0187a next = iterator2.next();
                final b bVar = next.f19973b;
                j0.E0(next.f19972a, new Runnable() { // from class: b5.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.a.this.o(bVar);
                    }
                });
            }
        }

        public void j() {
            Iterator<C0187a> iterator2 = this.f19971c.iterator2();
            while (iterator2.hasNext()) {
                C0187a next = iterator2.next();
                final b bVar = next.f19973b;
                j0.E0(next.f19972a, new Runnable() { // from class: b5.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.a.this.p(bVar);
                    }
                });
            }
        }

        public void k(final int i10) {
            Iterator<C0187a> iterator2 = this.f19971c.iterator2();
            while (iterator2.hasNext()) {
                C0187a next = iterator2.next();
                final b bVar = next.f19973b;
                j0.E0(next.f19972a, new Runnable() { // from class: b5.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.a.this.q(bVar, i10);
                    }
                });
            }
        }

        public void l(final Exception exc) {
            Iterator<C0187a> iterator2 = this.f19971c.iterator2();
            while (iterator2.hasNext()) {
                C0187a next = iterator2.next();
                final b bVar = next.f19973b;
                j0.E0(next.f19972a, new Runnable() { // from class: b5.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.a.this.r(bVar, exc);
                    }
                });
            }
        }

        public void m() {
            Iterator<C0187a> iterator2 = this.f19971c.iterator2();
            while (iterator2.hasNext()) {
                C0187a next = iterator2.next();
                final b bVar = next.f19973b;
                j0.E0(next.f19972a, new Runnable() { // from class: b5.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.a.this.s(bVar);
                    }
                });
            }
        }

        public void t(b bVar) {
            Iterator<C0187a> iterator2 = this.f19971c.iterator2();
            while (iterator2.hasNext()) {
                C0187a next = iterator2.next();
                if (next.f19973b == bVar) {
                    this.f19971c.remove(next);
                }
            }
        }

        @CheckResult
        public a u(int i10, @Nullable s.a aVar) {
            return new a(this.f19971c, i10, aVar);
        }

        public a(CopyOnWriteArrayList<C0187a> copyOnWriteArrayList, int i10, @Nullable s.a aVar) {
            this.f19971c = copyOnWriteArrayList;
            this.f19969a = i10;
            this.f19970b = aVar;
        }
    }

    void B(int i10, @Nullable s.a aVar, Exception exc);

    void G(int i10, @Nullable s.a aVar);

    void l(int i10, @Nullable s.a aVar);

    void n(int i10, @Nullable s.a aVar, int i11);

    void r(int i10, @Nullable s.a aVar);

    void v(int i10, @Nullable s.a aVar);

    @Deprecated
    void w(int i10, @Nullable s.a aVar);
}
