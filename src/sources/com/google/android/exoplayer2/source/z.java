package com.google.android.exoplayer2.source;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.source.z;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MediaSourceEventListener.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface z {

    /* compiled from: MediaSourceEventListener.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f22153a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public final s.a f22154b;

        /* renamed from: c, reason: collision with root package name */
        public final CopyOnWriteArrayList<C0206a> f22155c;

        /* renamed from: d, reason: collision with root package name */
        public final long f22156d;

        /* compiled from: MediaSourceEventListener.java */
        /* renamed from: com.google.android.exoplayer2.source.z$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static final class C0206a {

            /* renamed from: a, reason: collision with root package name */
            public Handler f22157a;

            /* renamed from: b, reason: collision with root package name */
            public z f22158b;

            public C0206a(Handler handler, z zVar) {
                this.f22157a = handler;
                this.f22158b = zVar;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null, 0L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(z zVar, MediaLoadData mediaLoadData) {
            zVar.t(this.f22153a, this.f22154b, mediaLoadData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(z zVar, m mVar, MediaLoadData mediaLoadData) {
            zVar.c(this.f22153a, this.f22154b, mVar, mediaLoadData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(z zVar, m mVar, MediaLoadData mediaLoadData) {
            zVar.F(this.f22153a, this.f22154b, mVar, mediaLoadData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(z zVar, m mVar, MediaLoadData mediaLoadData, IOException iOException, boolean z10) {
            zVar.p(this.f22153a, this.f22154b, mVar, mediaLoadData, iOException, z10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(z zVar, m mVar, MediaLoadData mediaLoadData) {
            zVar.u(this.f22153a, this.f22154b, mVar, mediaLoadData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(z zVar, s.a aVar, MediaLoadData mediaLoadData) {
            zVar.g(this.f22153a, aVar, mediaLoadData);
        }

        public void A(m mVar, int i10, int i11, @Nullable Format format, int i12, @Nullable Object obj, long j10, long j11) {
            B(mVar, new MediaLoadData(i10, i11, format, i12, obj, h(j10), h(j11)));
        }

        public void B(final m mVar, final MediaLoadData mediaLoadData) {
            Iterator<C0206a> iterator2 = this.f22155c.iterator2();
            while (iterator2.hasNext()) {
                C0206a next = iterator2.next();
                final z zVar = next.f22158b;
                com.google.android.exoplayer2.util.j0.E0(next.f22157a, new Runnable() { // from class: com.google.android.exoplayer2.source.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        z.a.this.o(zVar, mVar, mediaLoadData);
                    }
                });
            }
        }

        public void C(z zVar) {
            Iterator<C0206a> iterator2 = this.f22155c.iterator2();
            while (iterator2.hasNext()) {
                C0206a next = iterator2.next();
                if (next.f22158b == zVar) {
                    this.f22155c.remove(next);
                }
            }
        }

        public void D(int i10, long j10, long j11) {
            E(new MediaLoadData(1, i10, null, 3, null, h(j10), h(j11)));
        }

        public void E(final MediaLoadData mediaLoadData) {
            final s.a aVar = (s.a) com.google.android.exoplayer2.util.a.e(this.f22154b);
            Iterator<C0206a> iterator2 = this.f22155c.iterator2();
            while (iterator2.hasNext()) {
                C0206a next = iterator2.next();
                final z zVar = next.f22158b;
                com.google.android.exoplayer2.util.j0.E0(next.f22157a, new Runnable() { // from class: com.google.android.exoplayer2.source.y
                    @Override // java.lang.Runnable
                    public final void run() {
                        z.a.this.p(zVar, aVar, mediaLoadData);
                    }
                });
            }
        }

        @CheckResult
        public a F(int i10, @Nullable s.a aVar, long j10) {
            return new a(this.f22155c, i10, aVar, j10);
        }

        public void g(Handler handler, z zVar) {
            com.google.android.exoplayer2.util.a.e(handler);
            com.google.android.exoplayer2.util.a.e(zVar);
            this.f22155c.add(new C0206a(handler, zVar));
        }

        public final long h(long j10) {
            long e2 = com.google.android.exoplayer2.h.e(j10);
            if (e2 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.f22156d + e2;
        }

        public void i(int i10, @Nullable Format format, int i11, @Nullable Object obj, long j10) {
            j(new MediaLoadData(1, i10, format, i11, obj, h(j10), -9223372036854775807L));
        }

        public void j(final MediaLoadData mediaLoadData) {
            Iterator<C0206a> iterator2 = this.f22155c.iterator2();
            while (iterator2.hasNext()) {
                C0206a next = iterator2.next();
                final z zVar = next.f22158b;
                com.google.android.exoplayer2.util.j0.E0(next.f22157a, new Runnable() { // from class: com.google.android.exoplayer2.source.x
                    @Override // java.lang.Runnable
                    public final void run() {
                        z.a.this.k(zVar, mediaLoadData);
                    }
                });
            }
        }

        public void q(m mVar, int i10) {
            r(mVar, i10, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }

        public void r(m mVar, int i10, int i11, @Nullable Format format, int i12, @Nullable Object obj, long j10, long j11) {
            s(mVar, new MediaLoadData(i10, i11, format, i12, obj, h(j10), h(j11)));
        }

        public void s(final m mVar, final MediaLoadData mediaLoadData) {
            Iterator<C0206a> iterator2 = this.f22155c.iterator2();
            while (iterator2.hasNext()) {
                C0206a next = iterator2.next();
                final z zVar = next.f22158b;
                com.google.android.exoplayer2.util.j0.E0(next.f22157a, new Runnable() { // from class: com.google.android.exoplayer2.source.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        z.a.this.l(zVar, mVar, mediaLoadData);
                    }
                });
            }
        }

        public void t(m mVar, int i10) {
            u(mVar, i10, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }

        public void u(m mVar, int i10, int i11, @Nullable Format format, int i12, @Nullable Object obj, long j10, long j11) {
            v(mVar, new MediaLoadData(i10, i11, format, i12, obj, h(j10), h(j11)));
        }

        public void v(final m mVar, final MediaLoadData mediaLoadData) {
            Iterator<C0206a> iterator2 = this.f22155c.iterator2();
            while (iterator2.hasNext()) {
                C0206a next = iterator2.next();
                final z zVar = next.f22158b;
                com.google.android.exoplayer2.util.j0.E0(next.f22157a, new Runnable() { // from class: com.google.android.exoplayer2.source.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        z.a.this.m(zVar, mVar, mediaLoadData);
                    }
                });
            }
        }

        public void w(m mVar, int i10, int i11, @Nullable Format format, int i12, @Nullable Object obj, long j10, long j11, IOException iOException, boolean z10) {
            y(mVar, new MediaLoadData(i10, i11, format, i12, obj, h(j10), h(j11)), iOException, z10);
        }

        public void x(m mVar, int i10, IOException iOException, boolean z10) {
            w(mVar, i10, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, iOException, z10);
        }

        public void y(final m mVar, final MediaLoadData mediaLoadData, final IOException iOException, final boolean z10) {
            Iterator<C0206a> iterator2 = this.f22155c.iterator2();
            while (iterator2.hasNext()) {
                C0206a next = iterator2.next();
                final z zVar = next.f22158b;
                com.google.android.exoplayer2.util.j0.E0(next.f22157a, new Runnable() { // from class: com.google.android.exoplayer2.source.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        z.a.this.n(zVar, mVar, mediaLoadData, iOException, z10);
                    }
                });
            }
        }

        public void z(m mVar, int i10) {
            A(mVar, i10, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }

        public a(CopyOnWriteArrayList<C0206a> copyOnWriteArrayList, int i10, @Nullable s.a aVar, long j10) {
            this.f22155c = copyOnWriteArrayList;
            this.f22153a = i10;
            this.f22154b = aVar;
            this.f22156d = j10;
        }
    }

    void F(int i10, @Nullable s.a aVar, m mVar, MediaLoadData mediaLoadData);

    void c(int i10, @Nullable s.a aVar, m mVar, MediaLoadData mediaLoadData);

    void g(int i10, s.a aVar, MediaLoadData mediaLoadData);

    void p(int i10, @Nullable s.a aVar, m mVar, MediaLoadData mediaLoadData, IOException iOException, boolean z10);

    void t(int i10, @Nullable s.a aVar, MediaLoadData mediaLoadData);

    void u(int i10, @Nullable s.a aVar, m mVar, MediaLoadData mediaLoadData);
}
