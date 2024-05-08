package q6;

import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.util.j0;
import q6.x;

/* compiled from: VideoRendererEventListener.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface x {

    /* compiled from: VideoRendererEventListener.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        public final Handler f53144a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public final x f53145b;

        public a(@Nullable Handler handler, @Nullable x xVar) {
            this.f53144a = xVar != null ? (Handler) com.google.android.exoplayer2.util.a.e(handler) : null;
            this.f53145b = xVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(String str, long j10, long j11) {
            ((x) j0.j(this.f53145b)).s(str, j10, j11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(String str) {
            ((x) j0.j(this.f53145b)).a(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(z4.d dVar) {
            dVar.c();
            ((x) j0.j(this.f53145b)).C(dVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void t(int i10, long j10) {
            ((x) j0.j(this.f53145b)).i(i10, j10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void u(z4.d dVar) {
            ((x) j0.j(this.f53145b)).h(dVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void v(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            ((x) j0.j(this.f53145b)).x(format);
            ((x) j0.j(this.f53145b)).y(format, decoderReuseEvaluation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void w(Object obj, long j10) {
            ((x) j0.j(this.f53145b)).D(obj, j10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void x(long j10, int i10) {
            ((x) j0.j(this.f53145b)).q(j10, i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void y(Exception exc) {
            ((x) j0.j(this.f53145b)).A(exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void z(y yVar) {
            ((x) j0.j(this.f53145b)).onVideoSizeChanged(yVar);
        }

        public void A(final Object obj) {
            if (this.f53144a != null) {
                final long elapsedRealtime = SystemClock.elapsedRealtime();
                this.f53144a.post(new Runnable() { // from class: q6.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        x.a.this.w(obj, elapsedRealtime);
                    }
                });
            }
        }

        public void B(final long j10, final int i10) {
            Handler handler = this.f53144a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: q6.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        x.a.this.x(j10, i10);
                    }
                });
            }
        }

        public void C(final Exception exc) {
            Handler handler = this.f53144a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: q6.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        x.a.this.y(exc);
                    }
                });
            }
        }

        public void D(final y yVar) {
            Handler handler = this.f53144a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: q6.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        x.a.this.z(yVar);
                    }
                });
            }
        }

        public void k(final String str, final long j10, final long j11) {
            Handler handler = this.f53144a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: q6.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        x.a.this.q(str, j10, j11);
                    }
                });
            }
        }

        public void l(final String str) {
            Handler handler = this.f53144a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: q6.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        x.a.this.r(str);
                    }
                });
            }
        }

        public void m(final z4.d dVar) {
            dVar.c();
            Handler handler = this.f53144a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: q6.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        x.a.this.s(dVar);
                    }
                });
            }
        }

        public void n(final int i10, final long j10) {
            Handler handler = this.f53144a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: q6.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        x.a.this.t(i10, j10);
                    }
                });
            }
        }

        public void o(final z4.d dVar) {
            Handler handler = this.f53144a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: q6.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        x.a.this.u(dVar);
                    }
                });
            }
        }

        public void p(final Format format, @Nullable final DecoderReuseEvaluation decoderReuseEvaluation) {
            Handler handler = this.f53144a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: q6.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        x.a.this.v(format, decoderReuseEvaluation);
                    }
                });
            }
        }
    }

    void A(Exception exc);

    void C(z4.d dVar);

    void D(Object obj, long j10);

    void a(String str);

    void h(z4.d dVar);

    void i(int i10, long j10);

    void onVideoSizeChanged(y yVar);

    void q(long j10, int i10);

    void s(String str, long j10, long j11);

    @Deprecated
    void x(Format format);

    void y(Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation);
}
