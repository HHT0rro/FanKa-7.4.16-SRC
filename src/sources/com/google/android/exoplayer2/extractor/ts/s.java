package com.google.android.exoplayer2.extractor.ts;

import androidx.annotation.Nullable;
import com.android.internal.midi.MidiConstants;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.h0;
import com.google.android.exoplayer2.util.ParsableByteArray;
import x4.v;

/* compiled from: MpegAudioReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class s implements m {

    /* renamed from: a, reason: collision with root package name */
    public final ParsableByteArray f20619a;

    /* renamed from: b, reason: collision with root package name */
    public final v.a f20620b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f20621c;

    /* renamed from: d, reason: collision with root package name */
    public TrackOutput f20622d;

    /* renamed from: e, reason: collision with root package name */
    public String f20623e;

    /* renamed from: f, reason: collision with root package name */
    public int f20624f;

    /* renamed from: g, reason: collision with root package name */
    public int f20625g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f20626h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f20627i;

    /* renamed from: j, reason: collision with root package name */
    public long f20628j;

    /* renamed from: k, reason: collision with root package name */
    public int f20629k;

    /* renamed from: l, reason: collision with root package name */
    public long f20630l;

    public s() {
        this(null);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void a() {
        this.f20624f = 0;
        this.f20625g = 0;
        this.f20627i = false;
        this.f20630l = -9223372036854775807L;
    }

    public final void b(ParsableByteArray parsableByteArray) {
        byte[] d10 = parsableByteArray.d();
        int f10 = parsableByteArray.f();
        for (int e2 = parsableByteArray.e(); e2 < f10; e2++) {
            boolean z10 = (d10[e2] & 255) == 255;
            boolean z11 = this.f20627i && (d10[e2] & MidiConstants.STATUS_PITCH_BEND) == 224;
            this.f20627i = z10;
            if (z11) {
                parsableByteArray.P(e2 + 1);
                this.f20627i = false;
                this.f20619a.d()[1] = d10[e2];
                this.f20625g = 2;
                this.f20624f = 1;
                return;
            }
        }
        parsableByteArray.P(f10);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void c(ParsableByteArray parsableByteArray) {
        com.google.android.exoplayer2.util.a.i(this.f20622d);
        while (parsableByteArray.a() > 0) {
            int i10 = this.f20624f;
            if (i10 == 0) {
                b(parsableByteArray);
            } else if (i10 == 1) {
                h(parsableByteArray);
            } else if (i10 == 2) {
                g(parsableByteArray);
            } else {
                throw new IllegalStateException();
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void d() {
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void e(d5.e eVar, h0.d dVar) {
        dVar.a();
        this.f20623e = dVar.b();
        this.f20622d = eVar.c(dVar.c(), 1);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void f(long j10, int i10) {
        if (j10 != -9223372036854775807L) {
            this.f20630l = j10;
        }
    }

    public final void g(ParsableByteArray parsableByteArray) {
        int min = Math.min(parsableByteArray.a(), this.f20629k - this.f20625g);
        this.f20622d.a(parsableByteArray, min);
        int i10 = this.f20625g + min;
        this.f20625g = i10;
        int i11 = this.f20629k;
        if (i10 < i11) {
            return;
        }
        long j10 = this.f20630l;
        if (j10 != -9223372036854775807L) {
            this.f20622d.d(j10, 1, i11, 0, null);
            this.f20630l += this.f20628j;
        }
        this.f20625g = 0;
        this.f20624f = 0;
    }

    public final void h(ParsableByteArray parsableByteArray) {
        int min = Math.min(parsableByteArray.a(), 4 - this.f20625g);
        parsableByteArray.j(this.f20619a.d(), this.f20625g, min);
        int i10 = this.f20625g + min;
        this.f20625g = i10;
        if (i10 < 4) {
            return;
        }
        this.f20619a.P(0);
        if (!this.f20620b.a(this.f20619a.n())) {
            this.f20625g = 0;
            this.f20624f = 1;
            return;
        }
        this.f20629k = this.f20620b.f54451c;
        if (!this.f20626h) {
            this.f20628j = (r8.f54455g * 1000000) / r8.f54452d;
            this.f20622d.b(new Format.b().S(this.f20623e).e0(this.f20620b.f54450b).W(4096).H(this.f20620b.f54453e).f0(this.f20620b.f54452d).V(this.f20621c).E());
            this.f20626h = true;
        }
        this.f20619a.P(0);
        this.f20622d.a(this.f20619a, 4);
        this.f20624f = 2;
    }

    public s(@Nullable String str) {
        this.f20624f = 0;
        ParsableByteArray parsableByteArray = new ParsableByteArray(4);
        this.f20619a = parsableByteArray;
        parsableByteArray.d()[0] = -1;
        this.f20620b = new v.a();
        this.f20630l = -9223372036854775807L;
        this.f20621c = str;
    }
}
