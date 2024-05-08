package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.mediacodec.a;
import com.google.android.exoplayer2.mediacodec.b;
import com.google.android.exoplayer2.util.g0;
import com.google.common.base.t;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Objects;
import m5.g;

/* compiled from: AsynchronousMediaCodecAdapter.java */
@RequiresApi(23)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a implements com.google.android.exoplayer2.mediacodec.b {

    /* renamed from: a, reason: collision with root package name */
    public final MediaCodec f20815a;

    /* renamed from: b, reason: collision with root package name */
    public final g f20816b;

    /* renamed from: c, reason: collision with root package name */
    public final m5.e f20817c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f20818d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f20819e;

    /* renamed from: f, reason: collision with root package name */
    public int f20820f;

    /* compiled from: AsynchronousMediaCodecAdapter.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements b.InterfaceC0191b {

        /* renamed from: b, reason: collision with root package name */
        public final t<HandlerThread> f20821b;

        /* renamed from: c, reason: collision with root package name */
        public final t<HandlerThread> f20822c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f20823d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f20824e;

        public b(final int i10, boolean z10, boolean z11) {
            this(new t() { // from class: m5.c
                @Override // com.google.common.base.t
                public final Object get() {
                    HandlerThread e2;
                    e2 = a.b.e(i10);
                    return e2;
                }
            }, new t() { // from class: m5.d
                @Override // com.google.common.base.t
                public final Object get() {
                    HandlerThread f10;
                    f10 = a.b.f(i10);
                    return f10;
                }
            }, z10, z11);
        }

        public static /* synthetic */ HandlerThread e(int i10) {
            return new HandlerThread(a.r(i10));
        }

        public static /* synthetic */ HandlerThread f(int i10) {
            return new HandlerThread(a.s(i10));
        }

        @Override // com.google.android.exoplayer2.mediacodec.b.InterfaceC0191b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a(b.a aVar) throws IOException {
            MediaCodec mediaCodec;
            a aVar2;
            String str = aVar.f20825a.f20832a;
            a aVar3 = null;
            try {
                String valueOf = String.valueOf(str);
                g0.a(valueOf.length() != 0 ? "createCodec:".concat(valueOf) : new String("createCodec:"));
                mediaCodec = MediaCodec.createByCodecName(str);
                try {
                    aVar2 = new a(mediaCodec, this.f20821b.get(), this.f20822c.get(), this.f20823d, this.f20824e);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e10) {
                e = e10;
                mediaCodec = null;
            }
            try {
                g0.c();
                aVar2.u(aVar.f20826b, aVar.f20828d, aVar.f20829e, aVar.f20830f);
                return aVar2;
            } catch (Exception e11) {
                e = e11;
                aVar3 = aVar2;
                if (aVar3 != null) {
                    aVar3.release();
                } else if (mediaCodec != null) {
                    mediaCodec.release();
                }
                throw e;
            }
        }

        @VisibleForTesting
        public b(t<HandlerThread> tVar, t<HandlerThread> tVar2, boolean z10, boolean z11) {
            this.f20821b = tVar;
            this.f20822c = tVar2;
            this.f20823d = z10;
            this.f20824e = z11;
        }
    }

    public static String r(int i10) {
        return t(i10, "ExoPlayer:MediaCodecAsyncAdapter:");
    }

    public static String s(int i10) {
        return t(i10, "ExoPlayer:MediaCodecQueueingThread:");
    }

    public static String t(int i10, String str) {
        StringBuilder sb2 = new StringBuilder(str);
        if (i10 == 1) {
            sb2.append("Audio");
        } else if (i10 == 2) {
            sb2.append("Video");
        } else {
            sb2.append("Unknown(");
            sb2.append(i10);
            sb2.append(")");
        }
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(b.c cVar, MediaCodec mediaCodec, long j10, long j11) {
        cVar.a(this, j10, j11);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public void a(int i10) {
        w();
        this.f20815a.setVideoScalingMode(i10);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public boolean b() {
        return false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public void c(Bundle bundle) {
        w();
        this.f20815a.setParameters(bundle);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public void d(int i10, long j10) {
        this.f20815a.releaseOutputBuffer(i10, j10);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public int e(MediaCodec.BufferInfo bufferInfo) {
        return this.f20816b.d(bufferInfo);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public void f(int i10, boolean z10) {
        this.f20815a.releaseOutputBuffer(i10, z10);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public void flush() {
        this.f20817c.i();
        this.f20815a.flush();
        g gVar = this.f20816b;
        final MediaCodec mediaCodec = this.f20815a;
        Objects.requireNonNull(mediaCodec);
        gVar.e(new Runnable() { // from class: m5.b
            @Override // java.lang.Runnable
            public final void run() {
                mediaCodec.start();
            }
        });
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public MediaFormat g() {
        return this.f20816b.g();
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    @Nullable
    public ByteBuffer getInputBuffer(int i10) {
        return this.f20815a.getInputBuffer(i10);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public void h(final b.c cVar, Handler handler) {
        w();
        this.f20815a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: m5.a
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j10, long j11) {
                com.google.android.exoplayer2.mediacodec.a.this.v(cVar, mediaCodec, j10, j11);
            }
        }, handler);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public void i(Surface surface) {
        w();
        this.f20815a.setOutputSurface(surface);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public void j(int i10, int i11, int i12, long j10, int i13) {
        this.f20817c.n(i10, i11, i12, j10, i13);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public void k(int i10, int i11, z4.b bVar, long j10, int i12) {
        this.f20817c.o(i10, i11, bVar, j10, i12);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public int l() {
        return this.f20816b.c();
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    @Nullable
    public ByteBuffer m(int i10) {
        return this.f20815a.getOutputBuffer(i10);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public void release() {
        try {
            if (this.f20820f == 1) {
                this.f20817c.r();
                this.f20816b.q();
            }
            this.f20820f = 2;
        } finally {
            if (!this.f20819e) {
                this.f20815a.release();
                this.f20819e = true;
            }
        }
    }

    public final void u(@Nullable MediaFormat mediaFormat, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i10) {
        this.f20816b.h(this.f20815a);
        g0.a("configureCodec");
        this.f20815a.configure(mediaFormat, surface, mediaCrypto, i10);
        g0.c();
        this.f20817c.s();
        g0.a("startCodec");
        this.f20815a.start();
        g0.c();
        this.f20820f = 1;
    }

    public final void w() {
        if (this.f20818d) {
            try {
                this.f20817c.t();
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e2);
            }
        }
    }

    public a(MediaCodec mediaCodec, HandlerThread handlerThread, HandlerThread handlerThread2, boolean z10, boolean z11) {
        this.f20815a = mediaCodec;
        this.f20816b = new g(handlerThread);
        this.f20817c = new m5.e(mediaCodec, handlerThread2, z10);
        this.f20818d = z11;
        this.f20820f = 0;
    }
}
