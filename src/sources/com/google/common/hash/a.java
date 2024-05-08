package com.google.common.hash;

import com.google.common.base.o;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: AbstractByteHasher.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class a extends c {

    /* renamed from: a, reason: collision with root package name */
    public final ByteBuffer f26654a = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);

    @Override // com.google.common.hash.c, com.google.common.hash.f
    public f g(byte[] bArr, int i10, int i11) {
        o.w(i10, i10 + i11, bArr.length);
        o(bArr, i10, i11);
        return this;
    }

    @Override // com.google.common.hash.f
    public f h(ByteBuffer byteBuffer) {
        m(byteBuffer);
        return this;
    }

    @Override // com.google.common.hash.c, com.google.common.hash.k
    /* renamed from: i */
    public f e(byte[] bArr) {
        o.r(bArr);
        n(bArr);
        return this;
    }

    @Override // com.google.common.hash.c
    public f j(char c4) {
        this.f26654a.putChar(c4);
        return k(2);
    }

    public final f k(int i10) {
        try {
            o(this.f26654a.array(), 0, i10);
            return this;
        } finally {
            h.a(this.f26654a);
        }
    }

    public abstract void l(byte b4);

    public void m(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            o(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            h.c(byteBuffer, byteBuffer.limit());
        } else {
            for (int remaining = byteBuffer.remaining(); remaining > 0; remaining--) {
                l(byteBuffer.get());
            }
        }
    }

    public void n(byte[] bArr) {
        o(bArr, 0, bArr.length);
    }

    public abstract void o(byte[] bArr, int i10, int i11);

    @Override // com.google.common.hash.k
    public f a(int i10) {
        this.f26654a.putInt(i10);
        return k(4);
    }

    @Override // com.google.common.hash.k
    public f b(long j10) {
        this.f26654a.putLong(j10);
        return k(8);
    }
}
