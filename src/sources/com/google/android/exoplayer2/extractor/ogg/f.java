package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

/* compiled from: OggPageHeader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public int f20308a;

    /* renamed from: b, reason: collision with root package name */
    public int f20309b;

    /* renamed from: c, reason: collision with root package name */
    public long f20310c;

    /* renamed from: d, reason: collision with root package name */
    public long f20311d;

    /* renamed from: e, reason: collision with root package name */
    public long f20312e;

    /* renamed from: f, reason: collision with root package name */
    public long f20313f;

    /* renamed from: g, reason: collision with root package name */
    public int f20314g;

    /* renamed from: h, reason: collision with root package name */
    public int f20315h;

    /* renamed from: i, reason: collision with root package name */
    public int f20316i;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f20317j = new int[255];

    /* renamed from: k, reason: collision with root package name */
    public final ParsableByteArray f20318k = new ParsableByteArray(255);

    public boolean a(d5.d dVar, boolean z10) throws IOException {
        b();
        this.f20318k.L(27);
        if (!d5.f.b(dVar, this.f20318k.d(), 0, 27, z10) || this.f20318k.F() != 1332176723) {
            return false;
        }
        int D = this.f20318k.D();
        this.f20308a = D;
        if (D != 0) {
            if (z10) {
                return false;
            }
            throw ParserException.createForUnsupportedContainerFeature("unsupported bit stream revision");
        }
        this.f20309b = this.f20318k.D();
        this.f20310c = this.f20318k.r();
        this.f20311d = this.f20318k.t();
        this.f20312e = this.f20318k.t();
        this.f20313f = this.f20318k.t();
        int D2 = this.f20318k.D();
        this.f20314g = D2;
        this.f20315h = D2 + 27;
        this.f20318k.L(D2);
        if (!d5.f.b(dVar, this.f20318k.d(), 0, this.f20314g, z10)) {
            return false;
        }
        for (int i10 = 0; i10 < this.f20314g; i10++) {
            this.f20317j[i10] = this.f20318k.D();
            this.f20316i += this.f20317j[i10];
        }
        return true;
    }

    public void b() {
        this.f20308a = 0;
        this.f20309b = 0;
        this.f20310c = 0L;
        this.f20311d = 0L;
        this.f20312e = 0L;
        this.f20313f = 0L;
        this.f20314g = 0;
        this.f20315h = 0;
        this.f20316i = 0;
    }

    public boolean c(d5.d dVar) throws IOException {
        return d(dVar, -1L);
    }

    public boolean d(d5.d dVar, long j10) throws IOException {
        com.google.android.exoplayer2.util.a.a(dVar.getPosition() == dVar.o());
        this.f20318k.L(4);
        while (true) {
            if ((j10 == -1 || dVar.getPosition() + 4 < j10) && d5.f.b(dVar, this.f20318k.d(), 0, 4, true)) {
                this.f20318k.P(0);
                if (this.f20318k.F() == 1332176723) {
                    dVar.m();
                    return true;
                }
                dVar.r(1);
            }
        }
        do {
            if (j10 != -1 && dVar.getPosition() >= j10) {
                break;
            }
        } while (dVar.g(1) != -1);
        return false;
    }
}
