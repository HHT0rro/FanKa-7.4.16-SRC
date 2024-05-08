package com.google.android.exoplayer2.extractor.mp4;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

/* compiled from: TrackFragment.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public b f20239a;

    /* renamed from: b, reason: collision with root package name */
    public long f20240b;

    /* renamed from: c, reason: collision with root package name */
    public long f20241c;

    /* renamed from: d, reason: collision with root package name */
    public long f20242d;

    /* renamed from: e, reason: collision with root package name */
    public int f20243e;

    /* renamed from: f, reason: collision with root package name */
    public int f20244f;

    /* renamed from: m, reason: collision with root package name */
    public boolean f20251m;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    public TrackEncryptionBox f20253o;

    /* renamed from: q, reason: collision with root package name */
    public boolean f20255q;

    /* renamed from: r, reason: collision with root package name */
    public long f20256r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f20257s;

    /* renamed from: g, reason: collision with root package name */
    public long[] f20245g = new long[0];

    /* renamed from: h, reason: collision with root package name */
    public int[] f20246h = new int[0];

    /* renamed from: i, reason: collision with root package name */
    public int[] f20247i = new int[0];

    /* renamed from: j, reason: collision with root package name */
    public int[] f20248j = new int[0];

    /* renamed from: k, reason: collision with root package name */
    public long[] f20249k = new long[0];

    /* renamed from: l, reason: collision with root package name */
    public boolean[] f20250l = new boolean[0];

    /* renamed from: n, reason: collision with root package name */
    public boolean[] f20252n = new boolean[0];

    /* renamed from: p, reason: collision with root package name */
    public final ParsableByteArray f20254p = new ParsableByteArray();

    public void a(ParsableByteArray parsableByteArray) {
        parsableByteArray.j(this.f20254p.d(), 0, this.f20254p.f());
        this.f20254p.P(0);
        this.f20255q = false;
    }

    public void b(d5.d dVar) throws IOException {
        dVar.readFully(this.f20254p.d(), 0, this.f20254p.f());
        this.f20254p.P(0);
        this.f20255q = false;
    }

    public long c(int i10) {
        return this.f20249k[i10] + this.f20248j[i10];
    }

    public void d(int i10) {
        this.f20254p.L(i10);
        this.f20251m = true;
        this.f20255q = true;
    }

    public void e(int i10, int i11) {
        this.f20243e = i10;
        this.f20244f = i11;
        if (this.f20246h.length < i10) {
            this.f20245g = new long[i10];
            this.f20246h = new int[i10];
        }
        if (this.f20247i.length < i11) {
            int i12 = (i11 * 125) / 100;
            this.f20247i = new int[i12];
            this.f20248j = new int[i12];
            this.f20249k = new long[i12];
            this.f20250l = new boolean[i12];
            this.f20252n = new boolean[i12];
        }
    }

    public void f() {
        this.f20243e = 0;
        this.f20256r = 0L;
        this.f20257s = false;
        this.f20251m = false;
        this.f20255q = false;
        this.f20253o = null;
    }

    public boolean g(int i10) {
        return this.f20251m && this.f20252n[i10];
    }
}
