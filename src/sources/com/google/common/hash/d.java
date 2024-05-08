package com.google.common.hash;

import com.google.common.base.o;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: AbstractStreamingHasher.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class d extends c {

    /* renamed from: a, reason: collision with root package name */
    public final ByteBuffer f26655a;

    /* renamed from: b, reason: collision with root package name */
    public final int f26656b;

    /* renamed from: c, reason: collision with root package name */
    public final int f26657c;

    public d(int i10) {
        this(i10, i10);
    }

    @Override // com.google.common.hash.c, com.google.common.hash.f
    public final f g(byte[] bArr, int i10, int i11) {
        return p(ByteBuffer.wrap(bArr, i10, i11).order(ByteOrder.LITTLE_ENDIAN));
    }

    @Override // com.google.common.hash.f
    public final f h(ByteBuffer byteBuffer) {
        ByteOrder order = byteBuffer.order();
        try {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            return p(byteBuffer);
        } finally {
            byteBuffer.order(order);
        }
    }

    @Override // com.google.common.hash.f
    public final HashCode hash() {
        l();
        h.b(this.f26655a);
        if (this.f26655a.remaining() > 0) {
            o(this.f26655a);
            ByteBuffer byteBuffer = this.f26655a;
            h.c(byteBuffer, byteBuffer.limit());
        }
        return k();
    }

    @Override // com.google.common.hash.c
    public final f j(char c4) {
        this.f26655a.putChar(c4);
        m();
        return this;
    }

    public abstract HashCode k();

    public final void l() {
        h.b(this.f26655a);
        while (this.f26655a.remaining() >= this.f26657c) {
            n(this.f26655a);
        }
        this.f26655a.compact();
    }

    public final void m() {
        if (this.f26655a.remaining() < 8) {
            l();
        }
    }

    public abstract void n(ByteBuffer byteBuffer);

    public abstract void o(ByteBuffer byteBuffer);

    public final f p(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= this.f26655a.remaining()) {
            this.f26655a.put(byteBuffer);
            m();
            return this;
        }
        int position = this.f26656b - this.f26655a.position();
        for (int i10 = 0; i10 < position; i10++) {
            this.f26655a.put(byteBuffer.get());
        }
        l();
        while (byteBuffer.remaining() >= this.f26657c) {
            n(byteBuffer);
        }
        this.f26655a.put(byteBuffer);
        return this;
    }

    public d(int i10, int i11) {
        o.d(i11 % i10 == 0);
        this.f26655a = ByteBuffer.allocate(i11 + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.f26656b = i11;
        this.f26657c = i10;
    }

    @Override // com.google.common.hash.k
    public final f a(int i10) {
        this.f26655a.putInt(i10);
        m();
        return this;
    }

    @Override // com.google.common.hash.k
    public final f b(long j10) {
        this.f26655a.putLong(j10);
        m();
        return this;
    }
}
