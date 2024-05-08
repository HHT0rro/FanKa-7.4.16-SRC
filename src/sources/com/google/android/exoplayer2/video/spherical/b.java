package com.google.android.exoplayer2.video.spherical;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.j0;
import java.nio.ByteBuffer;

/* compiled from: CameraMotionRenderer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b extends com.google.android.exoplayer2.f {

    /* renamed from: n, reason: collision with root package name */
    public final DecoderInputBuffer f23120n;

    /* renamed from: o, reason: collision with root package name */
    public final ParsableByteArray f23121o;

    /* renamed from: p, reason: collision with root package name */
    public long f23122p;

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public a f23123q;

    /* renamed from: r, reason: collision with root package name */
    public long f23124r;

    public b() {
        super(6);
        this.f23120n = new DecoderInputBuffer(1);
        this.f23121o = new ParsableByteArray();
    }

    @Override // com.google.android.exoplayer2.f
    public void E() {
        O();
    }

    @Override // com.google.android.exoplayer2.f
    public void G(long j10, boolean z10) {
        this.f23124r = Long.MIN_VALUE;
        O();
    }

    @Override // com.google.android.exoplayer2.f
    public void K(Format[] formatArr, long j10, long j11) {
        this.f23122p = j11;
    }

    @Nullable
    public final float[] N(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() != 16) {
            return null;
        }
        this.f23121o.N(byteBuffer.array(), byteBuffer.limit());
        this.f23121o.P(byteBuffer.arrayOffset() + 4);
        float[] fArr = new float[3];
        for (int i10 = 0; i10 < 3; i10++) {
            fArr[i10] = Float.intBitsToFloat(this.f23121o.q());
        }
        return fArr;
    }

    public final void O() {
        a aVar = this.f23123q;
        if (aVar != null) {
            aVar.d();
        }
    }

    @Override // com.google.android.exoplayer2.n1
    public int a(Format format) {
        if ("application/x-camera-motion".equals(format.f19544m)) {
            return m1.a(4);
        }
        return m1.a(0);
    }

    @Override // com.google.android.exoplayer2.l1
    public boolean b() {
        return h();
    }

    @Override // com.google.android.exoplayer2.l1, com.google.android.exoplayer2.n1
    public String getName() {
        return "CameraMotionRenderer";
    }

    @Override // com.google.android.exoplayer2.f, com.google.android.exoplayer2.PlayerMessage.Target
    public void i(int i10, @Nullable Object obj) throws ExoPlaybackException {
        if (i10 == 7) {
            this.f23123q = (a) obj;
        } else {
            super.i(i10, obj);
        }
    }

    @Override // com.google.android.exoplayer2.l1
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.l1
    public void k(long j10, long j11) {
        while (!h() && this.f23124r < 100000 + j10) {
            this.f23120n.h();
            if (L(A(), this.f23120n, 0) != -4 || this.f23120n.m()) {
                return;
            }
            DecoderInputBuffer decoderInputBuffer = this.f23120n;
            this.f23124r = decoderInputBuffer.f19884f;
            if (this.f23123q != null && !decoderInputBuffer.l()) {
                this.f23120n.r();
                float[] N = N((ByteBuffer) j0.j(this.f23120n.f19882d));
                if (N != null) {
                    ((a) j0.j(this.f23123q)).c(this.f23124r - this.f23122p, N);
                }
            }
        }
    }
}
