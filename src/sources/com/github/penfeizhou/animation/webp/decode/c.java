package com.github.penfeizhou.animation.webp.decode;

import java.io.IOException;

/* compiled from: ANMFChunk.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class c extends e {

    /* renamed from: m, reason: collision with root package name */
    public static final int f19265m = e.a("ANMF");

    /* renamed from: d, reason: collision with root package name */
    public int f19266d;

    /* renamed from: e, reason: collision with root package name */
    public int f19267e;

    /* renamed from: f, reason: collision with root package name */
    public int f19268f;

    /* renamed from: g, reason: collision with root package name */
    public int f19269g;

    /* renamed from: h, reason: collision with root package name */
    public int f19270h;

    /* renamed from: i, reason: collision with root package name */
    public byte f19271i;

    /* renamed from: j, reason: collision with root package name */
    public a f19272j;

    /* renamed from: k, reason: collision with root package name */
    public i f19273k;

    /* renamed from: l, reason: collision with root package name */
    public j f19274l;

    @Override // com.github.penfeizhou.animation.webp.decode.e
    public void b(j4.a aVar) throws IOException {
        int available = aVar.available();
        this.f19266d = aVar.g();
        this.f19267e = aVar.g();
        this.f19268f = aVar.d();
        this.f19269g = aVar.d();
        this.f19270h = aVar.g();
        this.f19271i = aVar.peek();
        long j10 = available - this.f19283b;
        while (aVar.available() > j10) {
            e b4 = WebPParser.b(aVar);
            if (b4 instanceof a) {
                this.f19272j = (a) b4;
            } else if (b4 instanceof i) {
                this.f19273k = (i) b4;
            } else if (b4 instanceof j) {
                this.f19274l = (j) b4;
            }
        }
    }

    public boolean d() {
        return (this.f19271i & 2) == 2;
    }

    public boolean e() {
        return (this.f19271i & 1) == 1;
    }
}
