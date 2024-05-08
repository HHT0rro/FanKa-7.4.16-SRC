package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.j0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import x4.x;

/* compiled from: SonicAudioProcessor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class i implements AudioProcessor {

    /* renamed from: b, reason: collision with root package name */
    public int f19813b;

    /* renamed from: c, reason: collision with root package name */
    public float f19814c = 1.0f;

    /* renamed from: d, reason: collision with root package name */
    public float f19815d = 1.0f;

    /* renamed from: e, reason: collision with root package name */
    public AudioProcessor.a f19816e;

    /* renamed from: f, reason: collision with root package name */
    public AudioProcessor.a f19817f;

    /* renamed from: g, reason: collision with root package name */
    public AudioProcessor.a f19818g;

    /* renamed from: h, reason: collision with root package name */
    public AudioProcessor.a f19819h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f19820i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public x f19821j;

    /* renamed from: k, reason: collision with root package name */
    public ByteBuffer f19822k;

    /* renamed from: l, reason: collision with root package name */
    public ShortBuffer f19823l;

    /* renamed from: m, reason: collision with root package name */
    public ByteBuffer f19824m;

    /* renamed from: n, reason: collision with root package name */
    public long f19825n;

    /* renamed from: o, reason: collision with root package name */
    public long f19826o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f19827p;

    public i() {
        AudioProcessor.a aVar = AudioProcessor.a.f19702e;
        this.f19816e = aVar;
        this.f19817f = aVar;
        this.f19818g = aVar;
        this.f19819h = aVar;
        ByteBuffer byteBuffer = AudioProcessor.f19701a;
        this.f19822k = byteBuffer;
        this.f19823l = byteBuffer.asShortBuffer();
        this.f19824m = byteBuffer;
        this.f19813b = -1;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void a(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            x xVar = (x) com.google.android.exoplayer2.util.a.e(this.f19821j);
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.f19825n += remaining;
            xVar.t(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean b() {
        x xVar;
        return this.f19827p && ((xVar = this.f19821j) == null || xVar.k() == 0);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void c() {
        x xVar = this.f19821j;
        if (xVar != null) {
            xVar.s();
        }
        this.f19827p = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer d() {
        int k10;
        x xVar = this.f19821j;
        if (xVar != null && (k10 = xVar.k()) > 0) {
            if (this.f19822k.capacity() < k10) {
                ByteBuffer order = ByteBuffer.allocateDirect(k10).order(ByteOrder.nativeOrder());
                this.f19822k = order;
                this.f19823l = order.asShortBuffer();
            } else {
                this.f19822k.clear();
                this.f19823l.clear();
            }
            xVar.j(this.f19823l);
            this.f19826o += k10;
            this.f19822k.limit(k10);
            this.f19824m = this.f19822k;
        }
        ByteBuffer byteBuffer = this.f19824m;
        this.f19824m = AudioProcessor.f19701a;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public AudioProcessor.a e(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        if (aVar.f19705c == 2) {
            int i10 = this.f19813b;
            if (i10 == -1) {
                i10 = aVar.f19703a;
            }
            this.f19816e = aVar;
            AudioProcessor.a aVar2 = new AudioProcessor.a(i10, aVar.f19704b, 2);
            this.f19817f = aVar2;
            this.f19820i = true;
            return aVar2;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(aVar);
    }

    public long f(long j10) {
        if (this.f19826o >= 1024) {
            long l10 = this.f19825n - ((x) com.google.android.exoplayer2.util.a.e(this.f19821j)).l();
            int i10 = this.f19819h.f19703a;
            int i11 = this.f19818g.f19703a;
            if (i10 == i11) {
                return j0.H0(j10, l10, this.f19826o);
            }
            return j0.H0(j10, l10 * i10, this.f19826o * i11);
        }
        return (long) (this.f19814c * j10);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        if (isActive()) {
            AudioProcessor.a aVar = this.f19816e;
            this.f19818g = aVar;
            AudioProcessor.a aVar2 = this.f19817f;
            this.f19819h = aVar2;
            if (this.f19820i) {
                this.f19821j = new x(aVar.f19703a, aVar.f19704b, this.f19814c, this.f19815d, aVar2.f19703a);
            } else {
                x xVar = this.f19821j;
                if (xVar != null) {
                    xVar.i();
                }
            }
        }
        this.f19824m = AudioProcessor.f19701a;
        this.f19825n = 0L;
        this.f19826o = 0L;
        this.f19827p = false;
    }

    public void g(float f10) {
        if (this.f19815d != f10) {
            this.f19815d = f10;
            this.f19820i = true;
        }
    }

    public void h(float f10) {
        if (this.f19814c != f10) {
            this.f19814c = f10;
            this.f19820i = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.f19817f.f19703a != -1 && (Math.abs(this.f19814c - 1.0f) >= 1.0E-4f || Math.abs(this.f19815d - 1.0f) >= 1.0E-4f || this.f19817f.f19703a != this.f19816e.f19703a);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        this.f19814c = 1.0f;
        this.f19815d = 1.0f;
        AudioProcessor.a aVar = AudioProcessor.a.f19702e;
        this.f19816e = aVar;
        this.f19817f = aVar;
        this.f19818g = aVar;
        this.f19819h = aVar;
        ByteBuffer byteBuffer = AudioProcessor.f19701a;
        this.f19822k = byteBuffer;
        this.f19823l = byteBuffer.asShortBuffer();
        this.f19824m = byteBuffer;
        this.f19813b = -1;
        this.f19820i = false;
        this.f19821j = null;
        this.f19825n = 0L;
        this.f19826o = 0L;
        this.f19827p = false;
    }
}
