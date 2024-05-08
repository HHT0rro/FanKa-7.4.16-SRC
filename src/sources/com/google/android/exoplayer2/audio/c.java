package com.google.android.exoplayer2.audio;

import androidx.annotation.CallSuper;
import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: BaseAudioProcessor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class c implements AudioProcessor {

    /* renamed from: b, reason: collision with root package name */
    public AudioProcessor.a f19789b;

    /* renamed from: c, reason: collision with root package name */
    public AudioProcessor.a f19790c;

    /* renamed from: d, reason: collision with root package name */
    public AudioProcessor.a f19791d;

    /* renamed from: e, reason: collision with root package name */
    public AudioProcessor.a f19792e;

    /* renamed from: f, reason: collision with root package name */
    public ByteBuffer f19793f;

    /* renamed from: g, reason: collision with root package name */
    public ByteBuffer f19794g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f19795h;

    public c() {
        ByteBuffer byteBuffer = AudioProcessor.f19701a;
        this.f19793f = byteBuffer;
        this.f19794g = byteBuffer;
        AudioProcessor.a aVar = AudioProcessor.a.f19702e;
        this.f19791d = aVar;
        this.f19792e = aVar;
        this.f19789b = aVar;
        this.f19790c = aVar;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    @CallSuper
    public boolean b() {
        return this.f19795h && this.f19794g == AudioProcessor.f19701a;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final void c() {
        this.f19795h = true;
        i();
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    @CallSuper
    public ByteBuffer d() {
        ByteBuffer byteBuffer = this.f19794g;
        this.f19794g = AudioProcessor.f19701a;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final AudioProcessor.a e(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        this.f19791d = aVar;
        this.f19792e = g(aVar);
        return isActive() ? this.f19792e : AudioProcessor.a.f19702e;
    }

    public final boolean f() {
        return this.f19794g.hasRemaining();
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final void flush() {
        this.f19794g = AudioProcessor.f19701a;
        this.f19795h = false;
        this.f19789b = this.f19791d;
        this.f19790c = this.f19792e;
        h();
    }

    public abstract AudioProcessor.a g(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException;

    public void h() {
    }

    public void i() {
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.f19792e != AudioProcessor.a.f19702e;
    }

    public void j() {
    }

    public final ByteBuffer k(int i10) {
        if (this.f19793f.capacity() < i10) {
            this.f19793f = ByteBuffer.allocateDirect(i10).order(ByteOrder.nativeOrder());
        } else {
            this.f19793f.clear();
        }
        ByteBuffer byteBuffer = this.f19793f;
        this.f19794g = byteBuffer;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final void reset() {
        flush();
        this.f19793f = AudioProcessor.f19701a;
        AudioProcessor.a aVar = AudioProcessor.a.f19702e;
        this.f19791d = aVar;
        this.f19792e = aVar;
        this.f19789b = aVar;
        this.f19790c = aVar;
        j();
    }
}
