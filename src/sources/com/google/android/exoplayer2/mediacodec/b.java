package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.mediacodec.e;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: MediaCodecAdapter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface b {

    /* compiled from: MediaCodecAdapter.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.mediacodec.c f20825a;

        /* renamed from: b, reason: collision with root package name */
        public final MediaFormat f20826b;

        /* renamed from: c, reason: collision with root package name */
        public final Format f20827c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        public final Surface f20828d;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        public final MediaCrypto f20829e;

        /* renamed from: f, reason: collision with root package name */
        public final int f20830f;

        public a(com.google.android.exoplayer2.mediacodec.c cVar, MediaFormat mediaFormat, Format format, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i10) {
            this.f20825a = cVar;
            this.f20826b = mediaFormat;
            this.f20827c = format;
            this.f20828d = surface;
            this.f20829e = mediaCrypto;
            this.f20830f = i10;
        }
    }

    /* compiled from: MediaCodecAdapter.java */
    /* renamed from: com.google.android.exoplayer2.mediacodec.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface InterfaceC0191b {

        /* renamed from: a, reason: collision with root package name */
        public static final InterfaceC0191b f20831a = new e.b();

        b a(a aVar) throws IOException;
    }

    /* compiled from: MediaCodecAdapter.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface c {
        void a(b bVar, long j10, long j11);
    }

    void a(int i10);

    boolean b();

    @RequiresApi(19)
    void c(Bundle bundle);

    @RequiresApi(21)
    void d(int i10, long j10);

    int e(MediaCodec.BufferInfo bufferInfo);

    void f(int i10, boolean z10);

    void flush();

    MediaFormat g();

    @Nullable
    ByteBuffer getInputBuffer(int i10);

    @RequiresApi(23)
    void h(c cVar, Handler handler);

    @RequiresApi(23)
    void i(Surface surface);

    void j(int i10, int i11, int i12, long j10, int i13);

    void k(int i10, int i11, z4.b bVar, long j10, int i12);

    int l();

    @Nullable
    ByteBuffer m(int i10);

    void release();
}
