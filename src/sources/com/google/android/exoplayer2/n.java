package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import java.util.ArrayList;

/* compiled from: DefaultRenderersFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class n implements o1 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f20957a;

    /* renamed from: d, reason: collision with root package name */
    public boolean f20960d;

    /* renamed from: f, reason: collision with root package name */
    public boolean f20962f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f20963g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f20964h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f20965i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f20966j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f20967k;

    /* renamed from: b, reason: collision with root package name */
    public int f20958b = 0;

    /* renamed from: c, reason: collision with root package name */
    public long f20959c = 5000;

    /* renamed from: e, reason: collision with root package name */
    public com.google.android.exoplayer2.mediacodec.d f20961e = com.google.android.exoplayer2.mediacodec.d.f20843a;

    public n(Context context) {
        this.f20957a = context;
    }

    @Override // com.google.android.exoplayer2.o1
    public l1[] a(Handler handler, q6.x xVar, com.google.android.exoplayer2.audio.a aVar, e6.j jVar, n5.e eVar) {
        ArrayList<l1> arrayList = new ArrayList<>();
        h(this.f20957a, this.f20958b, this.f20961e, this.f20960d, handler, xVar, this.f20959c, arrayList);
        AudioSink c4 = c(this.f20957a, this.f20965i, this.f20966j, this.f20967k);
        if (c4 != null) {
            b(this.f20957a, this.f20958b, this.f20961e, this.f20960d, c4, handler, aVar, arrayList);
        }
        g(this.f20957a, jVar, handler.getLooper(), this.f20958b, arrayList);
        e(this.f20957a, eVar, handler.getLooper(), this.f20958b, arrayList);
        d(this.f20957a, this.f20958b, arrayList);
        f(this.f20957a, handler, this.f20958b, arrayList);
        return (l1[]) arrayList.toArray(new l1[0]);
    }

    public void b(Context context, int i10, com.google.android.exoplayer2.mediacodec.d dVar, boolean z10, AudioSink audioSink, Handler handler, com.google.android.exoplayer2.audio.a aVar, ArrayList<l1> arrayList) {
        int i11;
        int i12;
        com.google.android.exoplayer2.audio.f fVar = new com.google.android.exoplayer2.audio.f(context, dVar, z10, handler, aVar, audioSink);
        fVar.g0(this.f20962f);
        fVar.h0(this.f20963g);
        fVar.i0(this.f20964h);
        arrayList.add(fVar);
        if (i10 == 0) {
            return;
        }
        int size = arrayList.size();
        if (i10 == 2) {
            size--;
        }
        try {
            try {
                i11 = size + 1;
                try {
                    arrayList.add(size, (l1) Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(Handler.class, com.google.android.exoplayer2.audio.a.class, AudioSink.class).newInstance(handler, aVar, audioSink));
                    com.google.android.exoplayer2.util.m.f("DefaultRenderersFactory", "Loaded LibopusAudioRenderer.");
                } catch (ClassNotFoundException unused) {
                    size = i11;
                    i11 = size;
                    try {
                        i12 = i11 + 1;
                        arrayList.add(i11, (l1) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, com.google.android.exoplayer2.audio.a.class, AudioSink.class).newInstance(handler, aVar, audioSink));
                        com.google.android.exoplayer2.util.m.f("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
                        arrayList.add(i12, (l1) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, com.google.android.exoplayer2.audio.a.class, AudioSink.class).newInstance(handler, aVar, audioSink));
                        com.google.android.exoplayer2.util.m.f("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
                    } catch (Exception e2) {
                        throw new RuntimeException("Error instantiating FLAC extension", e2);
                    }
                }
            } catch (ClassNotFoundException unused2) {
            }
            try {
                i12 = i11 + 1;
            } catch (ClassNotFoundException unused3) {
            }
            try {
                try {
                    arrayList.add(i11, (l1) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, com.google.android.exoplayer2.audio.a.class, AudioSink.class).newInstance(handler, aVar, audioSink));
                    com.google.android.exoplayer2.util.m.f("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
                } catch (ClassNotFoundException unused4) {
                    i11 = i12;
                    i12 = i11;
                    arrayList.add(i12, (l1) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, com.google.android.exoplayer2.audio.a.class, AudioSink.class).newInstance(handler, aVar, audioSink));
                    com.google.android.exoplayer2.util.m.f("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
                }
                arrayList.add(i12, (l1) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, com.google.android.exoplayer2.audio.a.class, AudioSink.class).newInstance(handler, aVar, audioSink));
                com.google.android.exoplayer2.util.m.f("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
            } catch (ClassNotFoundException unused5) {
            } catch (Exception e10) {
                throw new RuntimeException("Error instantiating FFmpeg extension", e10);
            }
        } catch (Exception e11) {
            throw new RuntimeException("Error instantiating Opus extension", e11);
        }
    }

    @Nullable
    public AudioSink c(Context context, boolean z10, boolean z11, boolean z12) {
        return new DefaultAudioSink(x4.e.c(context), new DefaultAudioSink.d(new AudioProcessor[0]), z10, z11, z12 ? 1 : 0);
    }

    public void d(Context context, int i10, ArrayList<l1> arrayList) {
        arrayList.add(new com.google.android.exoplayer2.video.spherical.b());
    }

    public void e(Context context, n5.e eVar, Looper looper, int i10, ArrayList<l1> arrayList) {
        arrayList.add(new com.google.android.exoplayer2.metadata.a(eVar, looper));
    }

    public void f(Context context, Handler handler, int i10, ArrayList<l1> arrayList) {
    }

    public void g(Context context, e6.j jVar, Looper looper, int i10, ArrayList<l1> arrayList) {
        arrayList.add(new e6.k(jVar, looper));
    }

    public void h(Context context, int i10, com.google.android.exoplayer2.mediacodec.d dVar, boolean z10, Handler handler, q6.x xVar, long j10, ArrayList<l1> arrayList) {
        int i11;
        q6.e eVar = new q6.e(context, dVar, j10, z10, handler, xVar, 50);
        eVar.g0(this.f20962f);
        eVar.h0(this.f20963g);
        eVar.i0(this.f20964h);
        arrayList.add(eVar);
        if (i10 == 0) {
            return;
        }
        int size = arrayList.size();
        if (i10 == 2) {
            size--;
        }
        try {
            try {
                i11 = size + 1;
                try {
                    arrayList.add(size, (l1) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(Long.TYPE, Handler.class, q6.x.class, Integer.TYPE).newInstance(Long.valueOf(j10), handler, xVar, 50));
                    com.google.android.exoplayer2.util.m.f("DefaultRenderersFactory", "Loaded LibvpxVideoRenderer.");
                } catch (ClassNotFoundException unused) {
                    size = i11;
                    i11 = size;
                    arrayList.add(i11, (l1) Class.forName("com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(Long.TYPE, Handler.class, q6.x.class, Integer.TYPE).newInstance(Long.valueOf(j10), handler, xVar, 50));
                    com.google.android.exoplayer2.util.m.f("DefaultRenderersFactory", "Loaded Libgav1VideoRenderer.");
                }
            } catch (ClassNotFoundException unused2) {
            }
            try {
                arrayList.add(i11, (l1) Class.forName("com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(Long.TYPE, Handler.class, q6.x.class, Integer.TYPE).newInstance(Long.valueOf(j10), handler, xVar, 50));
                com.google.android.exoplayer2.util.m.f("DefaultRenderersFactory", "Loaded Libgav1VideoRenderer.");
            } catch (ClassNotFoundException unused3) {
            } catch (Exception e2) {
                throw new RuntimeException("Error instantiating AV1 extension", e2);
            }
        } catch (Exception e10) {
            throw new RuntimeException("Error instantiating VP9 extension", e10);
        }
    }
}
