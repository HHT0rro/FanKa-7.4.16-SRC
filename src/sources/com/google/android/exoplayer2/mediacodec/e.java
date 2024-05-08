package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.mediacodec.b;
import com.google.android.exoplayer2.util.g0;
import com.google.android.exoplayer2.util.j0;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: SynchronousMediaCodecAdapter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class e implements com.google.android.exoplayer2.mediacodec.b {

    /* renamed from: a, reason: collision with root package name */
    public final MediaCodec f20844a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public ByteBuffer[] f20845b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public ByteBuffer[] f20846c;

    /* compiled from: SynchronousMediaCodecAdapter.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class b implements b.InterfaceC0191b {
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.exoplayer2.mediacodec.e$a] */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v3 */
        @Override // com.google.android.exoplayer2.mediacodec.b.InterfaceC0191b
        public com.google.android.exoplayer2.mediacodec.b a(b.a aVar) throws IOException {
            MediaCodec mediaCodec = 0;
            mediaCodec = 0;
            try {
                MediaCodec b4 = b(aVar);
                try {
                    g0.a("configureCodec");
                    b4.configure(aVar.f20826b, aVar.f20828d, aVar.f20829e, aVar.f20830f);
                    g0.c();
                    g0.a("startCodec");
                    b4.start();
                    g0.c();
                    return new e(b4);
                } catch (IOException | RuntimeException e2) {
                    e = e2;
                    mediaCodec = b4;
                    if (mediaCodec != 0) {
                        mediaCodec.release();
                    }
                    throw e;
                }
            } catch (IOException e10) {
                e = e10;
            } catch (RuntimeException e11) {
                e = e11;
            }
        }

        public MediaCodec b(b.a aVar) throws IOException {
            com.google.android.exoplayer2.util.a.e(aVar.f20825a);
            String str = aVar.f20825a.f20832a;
            String valueOf = String.valueOf(str);
            g0.a(valueOf.length() != 0 ? "createCodec:".concat(valueOf) : new String("createCodec:"));
            MediaCodec createByCodecName = MediaCodec.createByCodecName(str);
            g0.c();
            return createByCodecName;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(b.c cVar, MediaCodec mediaCodec, long j10, long j11) {
        cVar.a(this, j10, j11);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public void a(int i10) {
        this.f20844a.setVideoScalingMode(i10);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public boolean b() {
        return false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    @RequiresApi(19)
    public void c(Bundle bundle) {
        this.f20844a.setParameters(bundle);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    @RequiresApi(21)
    public void d(int i10, long j10) {
        this.f20844a.releaseOutputBuffer(i10, j10);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public int e(MediaCodec.BufferInfo bufferInfo) {
        int dequeueOutputBuffer;
        do {
            dequeueOutputBuffer = this.f20844a.dequeueOutputBuffer(bufferInfo, 0L);
            if (dequeueOutputBuffer == -3 && j0.f22990a < 21) {
                this.f20846c = this.f20844a.getOutputBuffers();
            }
        } while (dequeueOutputBuffer == -3);
        return dequeueOutputBuffer;
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public void f(int i10, boolean z10) {
        this.f20844a.releaseOutputBuffer(i10, z10);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public void flush() {
        this.f20844a.flush();
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public MediaFormat g() {
        return this.f20844a.getOutputFormat();
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    @Nullable
    public ByteBuffer getInputBuffer(int i10) {
        if (j0.f22990a >= 21) {
            return this.f20844a.getInputBuffer(i10);
        }
        return ((ByteBuffer[]) j0.j(this.f20845b))[i10];
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    @RequiresApi(23)
    public void h(final b.c cVar, Handler handler) {
        this.f20844a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: m5.o
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j10, long j11) {
                com.google.android.exoplayer2.mediacodec.e.this.o(cVar, mediaCodec, j10, j11);
            }
        }, handler);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    @RequiresApi(23)
    public void i(Surface surface) {
        this.f20844a.setOutputSurface(surface);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public void j(int i10, int i11, int i12, long j10, int i13) {
        this.f20844a.queueInputBuffer(i10, i11, i12, j10, i13);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public void k(int i10, int i11, z4.b bVar, long j10, int i12) {
        this.f20844a.queueSecureInputBuffer(i10, i11, bVar.a(), j10, i12);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public int l() {
        return this.f20844a.dequeueInputBuffer(0L);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    @Nullable
    public ByteBuffer m(int i10) {
        if (j0.f22990a >= 21) {
            return this.f20844a.getOutputBuffer(i10);
        }
        return ((ByteBuffer[]) j0.j(this.f20846c))[i10];
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public void release() {
        this.f20845b = null;
        this.f20846c = null;
        this.f20844a.release();
    }

    public e(MediaCodec mediaCodec) {
        this.f20844a = mediaCodec;
        if (j0.f22990a < 21) {
            this.f20845b = mediaCodec.getInputBuffers();
            this.f20846c = mediaCodec.getOutputBuffers();
        }
    }
}
