package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import b6.x;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.r0;
import com.google.android.exoplayer2.source.a0;
import com.google.android.exoplayer2.source.n0;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.rtsp.RtspMediaSource;
import com.google.android.exoplayer2.source.rtsp.a;
import com.google.android.exoplayer2.source.rtsp.f;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.w0;
import java.io.IOException;
import o6.v;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class RtspMediaSource extends com.google.android.exoplayer2.source.a {

    /* renamed from: h, reason: collision with root package name */
    public final w0 f21889h;

    /* renamed from: i, reason: collision with root package name */
    public final a.InterfaceC0200a f21890i;

    /* renamed from: j, reason: collision with root package name */
    public final String f21891j;

    /* renamed from: k, reason: collision with root package name */
    public final Uri f21892k;

    /* renamed from: m, reason: collision with root package name */
    public boolean f21894m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f21895n;

    /* renamed from: l, reason: collision with root package name */
    public long f21893l = -9223372036854775807L;

    /* renamed from: o, reason: collision with root package name */
    public boolean f21896o = true;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class Factory implements a0 {

        /* renamed from: a, reason: collision with root package name */
        public long f21897a = 8000;

        /* renamed from: b, reason: collision with root package name */
        public String f21898b = "ExoPlayerLib/2.15.1";

        /* renamed from: c, reason: collision with root package name */
        public boolean f21899c;

        @Override // com.google.android.exoplayer2.source.a0
        public int[] a() {
            return new int[]{3};
        }

        @Override // com.google.android.exoplayer2.source.a0
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public RtspMediaSource b(w0 w0Var) {
            a.InterfaceC0200a mVar;
            com.google.android.exoplayer2.util.a.e(w0Var.f23163b);
            if (this.f21899c) {
                mVar = new k(this.f21897a);
            } else {
                mVar = new m(this.f21897a);
            }
            return new RtspMediaSource(w0Var, mVar, this.f21898b);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class RtspPlaybackException extends IOException {
        public RtspPlaybackException(String str) {
            super(str);
        }

        public RtspPlaybackException(Throwable th) {
            super(th);
        }

        public RtspPlaybackException(String str, Throwable th) {
            super(str, th);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a extends com.google.android.exoplayer2.source.k {
        public a(RtspMediaSource rtspMediaSource, Timeline timeline) {
            super(timeline);
        }

        @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.Timeline
        public Timeline.b g(int i10, Timeline.b bVar, boolean z10) {
            super.g(i10, bVar, z10);
            bVar.f19661f = true;
            return bVar;
        }

        @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.Timeline
        public Timeline.c o(int i10, Timeline.c cVar, long j10) {
            super.o(i10, cVar, j10);
            cVar.f19678l = true;
            return cVar;
        }
    }

    static {
        r0.a("goog.exo.rtsp");
    }

    @VisibleForTesting
    public RtspMediaSource(w0 w0Var, a.InterfaceC0200a interfaceC0200a, String str) {
        this.f21889h = w0Var;
        this.f21890i = interfaceC0200a;
        this.f21891j = str;
        this.f21892k = ((w0.g) com.google.android.exoplayer2.util.a.e(w0Var.f23163b)).f23216a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(x xVar) {
        this.f21893l = com.google.android.exoplayer2.h.d(xVar.a());
        this.f21894m = !xVar.c();
        this.f21895n = xVar.c();
        this.f21896o = false;
        G();
    }

    @Override // com.google.android.exoplayer2.source.a
    public void B(@Nullable v vVar) {
        G();
    }

    @Override // com.google.android.exoplayer2.source.a
    public void D() {
    }

    public final void G() {
        Timeline n0Var = new n0(this.f21893l, this.f21894m, false, this.f21895n, null, this.f21889h);
        if (this.f21896o) {
            n0Var = new a(this, n0Var);
        }
        C(n0Var);
    }

    @Override // com.google.android.exoplayer2.source.s
    public w0 d() {
        return this.f21889h;
    }

    @Override // com.google.android.exoplayer2.source.s
    public p e(s.a aVar, o6.b bVar, long j10) {
        return new f(bVar, this.f21890i, this.f21892k, new f.c() { // from class: b6.o
            @Override // com.google.android.exoplayer2.source.rtsp.f.c
            public final void a(x xVar) {
                RtspMediaSource.this.F(xVar);
            }
        }, this.f21891j);
    }

    @Override // com.google.android.exoplayer2.source.s
    public void f() {
    }

    @Override // com.google.android.exoplayer2.source.s
    public void j(p pVar) {
        ((f) pVar).P();
    }
}
