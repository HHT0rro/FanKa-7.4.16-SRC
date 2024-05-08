package o6;

import android.os.Handler;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import o6.e;

/* compiled from: BandwidthMeter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface e {

    /* compiled from: BandwidthMeter.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {

        /* compiled from: BandwidthMeter.java */
        /* renamed from: o6.e$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static final class C0800a {

            /* renamed from: a, reason: collision with root package name */
            public final CopyOnWriteArrayList<C0801a> f52293a = new CopyOnWriteArrayList<>();

            /* compiled from: BandwidthMeter.java */
            /* renamed from: o6.e$a$a$a, reason: collision with other inner class name */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
            public static final class C0801a {

                /* renamed from: a, reason: collision with root package name */
                public final Handler f52294a;

                /* renamed from: b, reason: collision with root package name */
                public final a f52295b;

                /* renamed from: c, reason: collision with root package name */
                public boolean f52296c;

                public C0801a(Handler handler, a aVar) {
                    this.f52294a = handler;
                    this.f52295b = aVar;
                }

                public void d() {
                    this.f52296c = true;
                }
            }

            public static /* synthetic */ void d(C0801a c0801a, int i10, long j10, long j11) {
                c0801a.f52295b.d(i10, j10, j11);
            }

            public void b(Handler handler, a aVar) {
                com.google.android.exoplayer2.util.a.e(handler);
                com.google.android.exoplayer2.util.a.e(aVar);
                e(aVar);
                this.f52293a.add(new C0801a(handler, aVar));
            }

            public void c(final int i10, final long j10, final long j11) {
                Iterator<C0801a> it = this.f52293a.iterator();
                while (it.hasNext()) {
                    final C0801a next = it.next();
                    if (!next.f52296c) {
                        next.f52294a.post(new Runnable() { // from class: o6.d
                            @Override // java.lang.Runnable
                            public final void run() {
                                e.a.C0800a.d(e.a.C0800a.C0801a.this, i10, j10, j11);
                            }
                        });
                    }
                }
            }

            public void e(a aVar) {
                Iterator<C0801a> it = this.f52293a.iterator();
                while (it.hasNext()) {
                    C0801a next = it.next();
                    if (next.f52295b == aVar) {
                        next.d();
                        this.f52293a.remove(next);
                    }
                }
            }
        }

        void d(int i10, long j10, long j11);
    }

    void a(Handler handler, a aVar);

    long c();

    long f();

    void g(a aVar);

    @Nullable
    v h();
}
