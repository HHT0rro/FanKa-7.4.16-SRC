package com.alibaba.security.biometrics.service.build;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.alibaba.security.biometrics.service.build.ah;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: MediaMuxerManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class al implements am {

    /* renamed from: a, reason: collision with root package name */
    public MediaMuxer f2641a;

    /* renamed from: b, reason: collision with root package name */
    public Thread f2642b;

    /* renamed from: c, reason: collision with root package name */
    public int f2643c = -1;

    /* renamed from: d, reason: collision with root package name */
    public LinkedBlockingQueue<ah.b> f2644d = new LinkedBlockingQueue<>();

    /* renamed from: e, reason: collision with root package name */
    public final Object f2645e = new Object();

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f2646f;

    /* renamed from: g, reason: collision with root package name */
    private final Context f2647g;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f2648h;

    public al(Context context) {
        this.f2647g = context;
    }

    private void c() {
        this.f2646f = false;
        Thread thread = this.f2642b;
        if (thread != null) {
            thread.interrupt();
        }
    }

    public final boolean a(String str, int i10) {
        try {
            MediaMuxer mediaMuxer = new MediaMuxer(str, 0);
            this.f2641a = mediaMuxer;
            mediaMuxer.setOrientationHint(i10);
            Thread thread = new Thread("muxer_thread") { // from class: com.alibaba.security.biometrics.service.build.al.1
                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    synchronized (al.this.f2645e) {
                        try {
                            al.this.f2645e.wait();
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    }
                    while (al.this.f2646f && !Thread.interrupted()) {
                        try {
                            ah.b take = al.this.f2644d.take();
                            al alVar = al.this;
                            alVar.f2641a.writeSampleData(alVar.f2643c, take.f2612b, take.f2613c);
                        } catch (InterruptedException unused) {
                        }
                    }
                    al.this.f2644d.clear();
                    al.this.b();
                }
            };
            this.f2642b = thread;
            thread.start();
            this.f2646f = true;
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public final void b() {
        if (this.f2648h) {
            this.f2641a.stop();
            this.f2641a.release();
            this.f2648h = false;
        }
    }

    public final void a() {
        if (this.f2648h) {
            return;
        }
        synchronized (this.f2645e) {
            this.f2641a.start();
            this.f2648h = true;
            this.f2645e.notify();
        }
    }

    @Override // com.alibaba.security.biometrics.service.build.am
    public final void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        try {
            this.f2644d.put(new ah.b(byteBuffer, bufferInfo));
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.alibaba.security.biometrics.service.build.am
    public final void a(MediaFormat mediaFormat) {
        MediaMuxer mediaMuxer = this.f2641a;
        if (mediaMuxer != null) {
            this.f2643c = mediaMuxer.addTrack(mediaFormat);
        }
        a();
    }
}
