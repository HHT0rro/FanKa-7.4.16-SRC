package com.google.android.exoplayer2.audio;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.a;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.util.j0;

/* compiled from: AudioRendererEventListener.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface a {

    /* compiled from: AudioRendererEventListener.java */
    /* renamed from: com.google.android.exoplayer2.audio.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class C0185a {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        public final Handler f19761a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public final a f19762b;

        public C0185a(@Nullable Handler handler, @Nullable a aVar) {
            this.f19761a = aVar != null ? (Handler) com.google.android.exoplayer2.util.a.e(handler) : null;
            this.f19762b = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void A(int i10, long j10, long j11) {
            ((a) j0.j(this.f19762b)).H(i10, j10, j11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(Exception exc) {
            ((a) j0.j(this.f19762b)).m(exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(Exception exc) {
            ((a) j0.j(this.f19762b)).b(exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void t(String str, long j10, long j11) {
            ((a) j0.j(this.f19762b)).f(str, j10, j11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void u(String str) {
            ((a) j0.j(this.f19762b)).e(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void v(z4.d dVar) {
            dVar.c();
            ((a) j0.j(this.f19762b)).j(dVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void w(z4.d dVar) {
            ((a) j0.j(this.f19762b)).o(dVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void x(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            ((a) j0.j(this.f19762b)).E(format);
            ((a) j0.j(this.f19762b)).k(format, decoderReuseEvaluation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void y(long j10) {
            ((a) j0.j(this.f19762b)).z(j10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void z(boolean z10) {
            ((a) j0.j(this.f19762b)).onSkipSilenceEnabledChanged(z10);
        }

        public void B(final long j10) {
            Handler handler = this.f19761a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: x4.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.C0185a.this.y(j10);
                    }
                });
            }
        }

        public void C(final boolean z10) {
            Handler handler = this.f19761a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: x4.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.C0185a.this.z(z10);
                    }
                });
            }
        }

        public void D(final int i10, final long j10, final long j11) {
            Handler handler = this.f19761a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: x4.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.C0185a.this.A(i10, j10, j11);
                    }
                });
            }
        }

        public void k(final Exception exc) {
            Handler handler = this.f19761a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: x4.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.C0185a.this.r(exc);
                    }
                });
            }
        }

        public void l(final Exception exc) {
            Handler handler = this.f19761a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: x4.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.C0185a.this.s(exc);
                    }
                });
            }
        }

        public void m(final String str, final long j10, final long j11) {
            Handler handler = this.f19761a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: x4.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.C0185a.this.t(str, j10, j11);
                    }
                });
            }
        }

        public void n(final String str) {
            Handler handler = this.f19761a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: x4.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.C0185a.this.u(str);
                    }
                });
            }
        }

        public void o(final z4.d dVar) {
            dVar.c();
            Handler handler = this.f19761a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: x4.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.C0185a.this.v(dVar);
                    }
                });
            }
        }

        public void p(final z4.d dVar) {
            Handler handler = this.f19761a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: x4.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.C0185a.this.w(dVar);
                    }
                });
            }
        }

        public void q(final Format format, @Nullable final DecoderReuseEvaluation decoderReuseEvaluation) {
            Handler handler = this.f19761a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: x4.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.C0185a.this.x(format, decoderReuseEvaluation);
                    }
                });
            }
        }
    }

    @Deprecated
    void E(Format format);

    void H(int i10, long j10, long j11);

    void b(Exception exc);

    void e(String str);

    void f(String str, long j10, long j11);

    void j(z4.d dVar);

    void k(Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation);

    void m(Exception exc);

    void o(z4.d dVar);

    void onSkipSilenceEnabledChanged(boolean z10);

    void z(long j10);
}
