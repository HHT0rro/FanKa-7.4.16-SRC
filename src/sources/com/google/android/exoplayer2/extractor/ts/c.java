package com.google.android.exoplayer2.extractor.ts;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.h0;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.ObjectStreamConstants;
import x4.b;

/* compiled from: Ac3Reader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c implements m {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.u f20375a;

    /* renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f20376b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f20377c;

    /* renamed from: d, reason: collision with root package name */
    public String f20378d;

    /* renamed from: e, reason: collision with root package name */
    public TrackOutput f20379e;

    /* renamed from: f, reason: collision with root package name */
    public int f20380f;

    /* renamed from: g, reason: collision with root package name */
    public int f20381g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f20382h;

    /* renamed from: i, reason: collision with root package name */
    public long f20383i;

    /* renamed from: j, reason: collision with root package name */
    public Format f20384j;

    /* renamed from: k, reason: collision with root package name */
    public int f20385k;

    /* renamed from: l, reason: collision with root package name */
    public long f20386l;

    public c() {
        this(null);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void a() {
        this.f20380f = 0;
        this.f20381g = 0;
        this.f20382h = false;
        this.f20386l = -9223372036854775807L;
    }

    public final boolean b(ParsableByteArray parsableByteArray, byte[] bArr, int i10) {
        int min = Math.min(parsableByteArray.a(), i10 - this.f20381g);
        parsableByteArray.j(bArr, this.f20381g, min);
        int i11 = this.f20381g + min;
        this.f20381g = i11;
        return i11 == i10;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void c(ParsableByteArray parsableByteArray) {
        com.google.android.exoplayer2.util.a.i(this.f20379e);
        while (parsableByteArray.a() > 0) {
            int i10 = this.f20380f;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        int min = Math.min(parsableByteArray.a(), this.f20385k - this.f20381g);
                        this.f20379e.a(parsableByteArray, min);
                        int i11 = this.f20381g + min;
                        this.f20381g = i11;
                        int i12 = this.f20385k;
                        if (i11 == i12) {
                            long j10 = this.f20386l;
                            if (j10 != -9223372036854775807L) {
                                this.f20379e.d(j10, 1, i12, 0, null);
                                this.f20386l += this.f20383i;
                            }
                            this.f20380f = 0;
                        }
                    }
                } else if (b(parsableByteArray, this.f20376b.d(), 128)) {
                    g();
                    this.f20376b.P(0);
                    this.f20379e.a(this.f20376b, 128);
                    this.f20380f = 2;
                }
            } else if (h(parsableByteArray)) {
                this.f20380f = 1;
                this.f20376b.d()[0] = 11;
                this.f20376b.d()[1] = ObjectStreamConstants.TC_BLOCKDATA;
                this.f20381g = 2;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void d() {
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void e(d5.e eVar, h0.d dVar) {
        dVar.a();
        this.f20378d = dVar.b();
        this.f20379e = eVar.c(dVar.c(), 1);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void f(long j10, int i10) {
        if (j10 != -9223372036854775807L) {
            this.f20386l = j10;
        }
    }

    public final void g() {
        this.f20375a.p(0);
        b.C0838b e2 = x4.b.e(this.f20375a);
        Format format = this.f20384j;
        if (format == null || e2.f54375d != format.f19557z || e2.f54374c != format.A || !com.google.android.exoplayer2.util.j0.c(e2.f54372a, format.f19544m)) {
            Format E = new Format.b().S(this.f20378d).e0(e2.f54372a).H(e2.f54375d).f0(e2.f54374c).V(this.f20377c).E();
            this.f20384j = E;
            this.f20379e.b(E);
        }
        this.f20385k = e2.f54376e;
        this.f20383i = (e2.f54377f * 1000000) / this.f20384j.A;
    }

    public final boolean h(ParsableByteArray parsableByteArray) {
        while (true) {
            if (parsableByteArray.a() <= 0) {
                return false;
            }
            if (!this.f20382h) {
                this.f20382h = parsableByteArray.D() == 11;
            } else {
                int D = parsableByteArray.D();
                if (D == 119) {
                    this.f20382h = false;
                    return true;
                }
                this.f20382h = D == 11;
            }
        }
    }

    public c(@Nullable String str) {
        com.google.android.exoplayer2.util.u uVar = new com.google.android.exoplayer2.util.u(new byte[128]);
        this.f20375a = uVar;
        this.f20376b = new ParsableByteArray(uVar.f23029a);
        this.f20380f = 0;
        this.f20386l = -9223372036854775807L;
        this.f20377c = str;
    }
}
