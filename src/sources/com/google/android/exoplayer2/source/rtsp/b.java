package com.google.android.exoplayer2.source.rtsp;

import android.os.Handler;
import b6.p;
import com.google.android.exoplayer2.source.rtsp.a;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.j0;
import d5.n;
import java.io.IOException;

/* compiled from: RtpDataLoadable.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b implements Loader.e {

    /* renamed from: a, reason: collision with root package name */
    public final int f21900a;

    /* renamed from: b, reason: collision with root package name */
    public final p f21901b;

    /* renamed from: c, reason: collision with root package name */
    public final a f21902c;

    /* renamed from: d, reason: collision with root package name */
    public final d5.e f21903d;

    /* renamed from: f, reason: collision with root package name */
    public final a.InterfaceC0200a f21905f;

    /* renamed from: g, reason: collision with root package name */
    public b6.d f21906g;

    /* renamed from: h, reason: collision with root package name */
    public volatile boolean f21907h;

    /* renamed from: j, reason: collision with root package name */
    public volatile long f21909j;

    /* renamed from: e, reason: collision with root package name */
    public final Handler f21904e = j0.x();

    /* renamed from: i, reason: collision with root package name */
    public volatile long f21908i = -9223372036854775807L;

    /* compiled from: RtpDataLoadable.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        void a(String str, com.google.android.exoplayer2.source.rtsp.a aVar);
    }

    public b(int i10, p pVar, a aVar, d5.e eVar, a.InterfaceC0200a interfaceC0200a) {
        this.f21900a = i10;
        this.f21901b = pVar;
        this.f21902c = aVar;
        this.f21903d = eVar;
        this.f21905f = interfaceC0200a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(String str, com.google.android.exoplayer2.source.rtsp.a aVar) {
        this.f21902c.a(str, aVar);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void b() {
        this.f21907h = true;
    }

    public void d() {
        ((b6.d) com.google.android.exoplayer2.util.a.e(this.f21906g)).e();
    }

    public void e(long j10, long j11) {
        this.f21908i = j10;
        this.f21909j = j11;
    }

    public void f(int i10) {
        if (((b6.d) com.google.android.exoplayer2.util.a.e(this.f21906g)).d()) {
            return;
        }
        this.f21906g.h(i10);
    }

    public void g(long j10) {
        if (j10 == -9223372036854775807L || ((b6.d) com.google.android.exoplayer2.util.a.e(this.f21906g)).d()) {
            return;
        }
        this.f21906g.i(j10);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void load() throws IOException {
        final com.google.android.exoplayer2.source.rtsp.a aVar = null;
        try {
            aVar = this.f21905f.b(this.f21900a);
            final String k10 = aVar.k();
            this.f21904e.post(new Runnable() { // from class: b6.c
                @Override // java.lang.Runnable
                public final void run() {
                    com.google.android.exoplayer2.source.rtsp.b.this.c(k10, aVar);
                }
            });
            d5.b bVar = new d5.b((o6.g) com.google.android.exoplayer2.util.a.e(aVar), 0L, -1L);
            b6.d dVar = new b6.d(this.f21901b.f1352a, this.f21900a);
            this.f21906g = dVar;
            dVar.b(this.f21903d);
            while (!this.f21907h) {
                if (this.f21908i != -9223372036854775807L) {
                    this.f21906g.a(this.f21909j, this.f21908i);
                    this.f21908i = -9223372036854775807L;
                }
                if (this.f21906g.f(bVar, new n()) == -1) {
                    break;
                }
            }
        } finally {
            j0.n(aVar);
        }
    }
}
