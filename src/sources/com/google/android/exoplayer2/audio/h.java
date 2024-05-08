package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.j0;
import java.nio.ByteBuffer;

/* compiled from: SilenceSkippingAudioProcessor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class h extends c {

    /* renamed from: i, reason: collision with root package name */
    public final long f19801i;

    /* renamed from: j, reason: collision with root package name */
    public final long f19802j;

    /* renamed from: k, reason: collision with root package name */
    public final short f19803k;

    /* renamed from: l, reason: collision with root package name */
    public int f19804l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f19805m;

    /* renamed from: n, reason: collision with root package name */
    public byte[] f19806n;

    /* renamed from: o, reason: collision with root package name */
    public byte[] f19807o;

    /* renamed from: p, reason: collision with root package name */
    public int f19808p;

    /* renamed from: q, reason: collision with root package name */
    public int f19809q;

    /* renamed from: r, reason: collision with root package name */
    public int f19810r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f19811s;

    /* renamed from: t, reason: collision with root package name */
    public long f19812t;

    public h() {
        this(150000L, 20000L, (short) 1024);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void a(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining() && !f()) {
            int i10 = this.f19808p;
            if (i10 == 0) {
                s(byteBuffer);
            } else if (i10 == 1) {
                r(byteBuffer);
            } else if (i10 == 2) {
                t(byteBuffer);
            } else {
                throw new IllegalStateException();
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.c
    public AudioProcessor.a g(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        if (aVar.f19705c == 2) {
            return this.f19805m ? aVar : AudioProcessor.a.f19702e;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(aVar);
    }

    @Override // com.google.android.exoplayer2.audio.c
    public void h() {
        if (this.f19805m) {
            this.f19804l = this.f19789b.f19706d;
            int l10 = l(this.f19801i) * this.f19804l;
            if (this.f19806n.length != l10) {
                this.f19806n = new byte[l10];
            }
            int l11 = l(this.f19802j) * this.f19804l;
            this.f19810r = l11;
            if (this.f19807o.length != l11) {
                this.f19807o = new byte[l11];
            }
        }
        this.f19808p = 0;
        this.f19812t = 0L;
        this.f19809q = 0;
        this.f19811s = false;
    }

    @Override // com.google.android.exoplayer2.audio.c
    public void i() {
        int i10 = this.f19809q;
        if (i10 > 0) {
            q(this.f19806n, i10);
        }
        if (this.f19811s) {
            return;
        }
        this.f19812t += this.f19810r / this.f19804l;
    }

    @Override // com.google.android.exoplayer2.audio.c, com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.f19805m;
    }

    @Override // com.google.android.exoplayer2.audio.c
    public void j() {
        this.f19805m = false;
        this.f19810r = 0;
        byte[] bArr = j0.f22995f;
        this.f19806n = bArr;
        this.f19807o = bArr;
    }

    public final int l(long j10) {
        return (int) ((j10 * this.f19789b.f19703a) / 1000000);
    }

    public final int m(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        do {
            limit -= 2;
            if (limit < byteBuffer.position()) {
                return byteBuffer.position();
            }
        } while (Math.abs((int) byteBuffer.getShort(limit)) <= this.f19803k);
        int i10 = this.f19804l;
        return ((limit / i10) * i10) + i10;
    }

    public final int n(ByteBuffer byteBuffer) {
        for (int position = byteBuffer.position(); position < byteBuffer.limit(); position += 2) {
            if (Math.abs((int) byteBuffer.getShort(position)) > this.f19803k) {
                int i10 = this.f19804l;
                return i10 * (position / i10);
            }
        }
        return byteBuffer.limit();
    }

    public long o() {
        return this.f19812t;
    }

    public final void p(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        k(remaining).put(byteBuffer).flip();
        if (remaining > 0) {
            this.f19811s = true;
        }
    }

    public final void q(byte[] bArr, int i10) {
        k(i10).put(bArr, 0, i10).flip();
        if (i10 > 0) {
            this.f19811s = true;
        }
    }

    public final void r(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int n10 = n(byteBuffer);
        int position = n10 - byteBuffer.position();
        byte[] bArr = this.f19806n;
        int length = bArr.length;
        int i10 = this.f19809q;
        int i11 = length - i10;
        if (n10 < limit && position < i11) {
            q(bArr, i10);
            this.f19809q = 0;
            this.f19808p = 0;
            return;
        }
        int min = Math.min(position, i11);
        byteBuffer.limit(byteBuffer.position() + min);
        byteBuffer.get(this.f19806n, this.f19809q, min);
        int i12 = this.f19809q + min;
        this.f19809q = i12;
        byte[] bArr2 = this.f19806n;
        if (i12 == bArr2.length) {
            if (this.f19811s) {
                q(bArr2, this.f19810r);
                this.f19812t += (this.f19809q - (this.f19810r * 2)) / this.f19804l;
            } else {
                this.f19812t += (i12 - this.f19810r) / this.f19804l;
            }
            v(byteBuffer, this.f19806n, this.f19809q);
            this.f19809q = 0;
            this.f19808p = 2;
        }
        byteBuffer.limit(limit);
    }

    public final void s(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        byteBuffer.limit(Math.min(limit, byteBuffer.position() + this.f19806n.length));
        int m10 = m(byteBuffer);
        if (m10 == byteBuffer.position()) {
            this.f19808p = 1;
        } else {
            byteBuffer.limit(m10);
            p(byteBuffer);
        }
        byteBuffer.limit(limit);
    }

    public final void t(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int n10 = n(byteBuffer);
        byteBuffer.limit(n10);
        this.f19812t += byteBuffer.remaining() / this.f19804l;
        v(byteBuffer, this.f19807o, this.f19810r);
        if (n10 < limit) {
            q(this.f19807o, this.f19810r);
            this.f19808p = 0;
            byteBuffer.limit(limit);
        }
    }

    public void u(boolean z10) {
        this.f19805m = z10;
    }

    public final void v(ByteBuffer byteBuffer, byte[] bArr, int i10) {
        int min = Math.min(byteBuffer.remaining(), this.f19810r);
        int i11 = this.f19810r - min;
        System.arraycopy((Object) bArr, i10 - i11, (Object) this.f19807o, 0, i11);
        byteBuffer.position(byteBuffer.limit() - min);
        byteBuffer.get(this.f19807o, i11, min);
    }

    public h(long j10, long j11, short s2) {
        com.google.android.exoplayer2.util.a.a(j11 <= j10);
        this.f19801i = j10;
        this.f19802j = j11;
        this.f19803k = s2;
        byte[] bArr = j0.f22995f;
        this.f19806n = bArr;
        this.f19807o = bArr;
    }
}
