package com.github.penfeizhou.animation.webp.decode;

import java.io.IOException;

/* compiled from: VP8XChunk.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class k extends e {

    /* renamed from: g, reason: collision with root package name */
    public static final int f19289g = e.a("VP8X");

    /* renamed from: d, reason: collision with root package name */
    public byte f19290d;

    /* renamed from: e, reason: collision with root package name */
    public int f19291e;

    /* renamed from: f, reason: collision with root package name */
    public int f19292f;

    @Override // com.github.penfeizhou.animation.webp.decode.e
    public void b(j4.a aVar) throws IOException {
        this.f19290d = aVar.peek();
        aVar.skip(3L);
        this.f19291e = aVar.d();
        this.f19292f = aVar.d();
    }

    public boolean d() {
        return (this.f19290d & 16) == 16;
    }
}
