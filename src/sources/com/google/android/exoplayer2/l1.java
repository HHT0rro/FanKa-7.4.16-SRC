package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.source.SampleStream;
import java.io.IOException;

/* compiled from: Renderer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface l1 extends PlayerMessage.Target {

    /* compiled from: Renderer.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        void a();

        void b(long j10);
    }

    boolean b();

    void e();

    void f(int i10);

    int g();

    String getName();

    int getState();

    boolean h();

    boolean isReady();

    boolean j();

    void k(long j10, long j11) throws ExoPlaybackException;

    @Nullable
    SampleStream l();

    long m();

    void n(long j10) throws ExoPlaybackException;

    @Nullable
    com.google.android.exoplayer2.util.o o();

    void p();

    void q() throws IOException;

    void r(Format[] formatArr, SampleStream sampleStream, long j10, long j11) throws ExoPlaybackException;

    void reset();

    n1 s();

    void start() throws ExoPlaybackException;

    void stop();

    void u(float f10, float f11) throws ExoPlaybackException;

    void v(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, long j10, boolean z10, boolean z11, long j11, long j12) throws ExoPlaybackException;
}
