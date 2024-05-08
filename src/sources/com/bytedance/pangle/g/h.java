package com.bytedance.pangle.g;

import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
final class h implements k {

    /* renamed from: a, reason: collision with root package name */
    private final ByteBuffer f10796a;

    public h(ByteBuffer byteBuffer) {
        this.f10796a = byteBuffer.slice();
    }

    @Override // com.bytedance.pangle.g.k
    public final long a() {
        return this.f10796a.capacity();
    }

    @Override // com.bytedance.pangle.g.k
    public final void a(j jVar, long j10, int i10) {
        ByteBuffer slice;
        synchronized (this.f10796a) {
            this.f10796a.position(0);
            int i11 = (int) j10;
            this.f10796a.limit(i10 + i11);
            this.f10796a.position(i11);
            slice = this.f10796a.slice();
        }
        jVar.a(slice);
    }
}
