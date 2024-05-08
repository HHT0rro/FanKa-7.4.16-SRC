package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.j0;
import java.nio.ByteBuffer;

/* compiled from: TrimmingAudioProcessor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class j extends c {

    /* renamed from: i, reason: collision with root package name */
    public int f19828i;

    /* renamed from: j, reason: collision with root package name */
    public int f19829j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f19830k;

    /* renamed from: l, reason: collision with root package name */
    public int f19831l;

    /* renamed from: m, reason: collision with root package name */
    public byte[] f19832m = j0.f22995f;

    /* renamed from: n, reason: collision with root package name */
    public int f19833n;

    /* renamed from: o, reason: collision with root package name */
    public long f19834o;

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i10 = limit - position;
        if (i10 == 0) {
            return;
        }
        int min = Math.min(i10, this.f19831l);
        this.f19834o += min / this.f19789b.f19706d;
        this.f19831l -= min;
        byteBuffer.position(position + min);
        if (this.f19831l > 0) {
            return;
        }
        int i11 = i10 - min;
        int length = (this.f19833n + i11) - this.f19832m.length;
        ByteBuffer k10 = k(length);
        int r10 = j0.r(length, 0, this.f19833n);
        k10.put(this.f19832m, 0, r10);
        int r11 = j0.r(length - r10, 0, i11);
        byteBuffer.limit(byteBuffer.position() + r11);
        k10.put(byteBuffer);
        byteBuffer.limit(limit);
        int i12 = i11 - r11;
        int i13 = this.f19833n - r10;
        this.f19833n = i13;
        byte[] bArr = this.f19832m;
        System.arraycopy((Object) bArr, r10, (Object) bArr, 0, i13);
        byteBuffer.get(this.f19832m, this.f19833n, i12);
        this.f19833n += i12;
        k10.flip();
    }

    @Override // com.google.android.exoplayer2.audio.c, com.google.android.exoplayer2.audio.AudioProcessor
    public boolean b() {
        return super.b() && this.f19833n == 0;
    }

    @Override // com.google.android.exoplayer2.audio.c, com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer d() {
        int i10;
        if (super.b() && (i10 = this.f19833n) > 0) {
            k(i10).put(this.f19832m, 0, this.f19833n).flip();
            this.f19833n = 0;
        }
        return super.d();
    }

    @Override // com.google.android.exoplayer2.audio.c
    public AudioProcessor.a g(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        if (aVar.f19705c == 2) {
            this.f19830k = true;
            return (this.f19828i == 0 && this.f19829j == 0) ? AudioProcessor.a.f19702e : aVar;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(aVar);
    }

    @Override // com.google.android.exoplayer2.audio.c
    public void h() {
        if (this.f19830k) {
            this.f19830k = false;
            int i10 = this.f19829j;
            int i11 = this.f19789b.f19706d;
            this.f19832m = new byte[i10 * i11];
            this.f19831l = this.f19828i * i11;
        }
        this.f19833n = 0;
    }

    @Override // com.google.android.exoplayer2.audio.c
    public void i() {
        if (this.f19830k) {
            if (this.f19833n > 0) {
                this.f19834o += r0 / this.f19789b.f19706d;
            }
            this.f19833n = 0;
        }
    }

    @Override // com.google.android.exoplayer2.audio.c
    public void j() {
        this.f19832m = j0.f22995f;
    }

    public long l() {
        return this.f19834o;
    }

    public void m() {
        this.f19834o = 0L;
    }

    public void n(int i10, int i11) {
        this.f19828i = i10;
        this.f19829j = i11;
    }
}
