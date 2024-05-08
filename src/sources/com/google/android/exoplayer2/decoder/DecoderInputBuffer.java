package com.google.android.exoplayer2.decoder;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import z4.a;
import z4.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class DecoderInputBuffer extends a {

    /* renamed from: c, reason: collision with root package name */
    public final b f19881c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public ByteBuffer f19882d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f19883e;

    /* renamed from: f, reason: collision with root package name */
    public long f19884f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public ByteBuffer f19885g;

    /* renamed from: h, reason: collision with root package name */
    public final int f19886h;

    /* renamed from: i, reason: collision with root package name */
    public final int f19887i;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class InsufficientCapacityException extends IllegalStateException {
        public final int currentCapacity;
        public final int requiredCapacity;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public InsufficientCapacityException(int r3, int r4) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r1 = 44
                r0.<init>(r1)
                java.lang.String r1 = "Buffer too small ("
                r0.append(r1)
                r0.append(r3)
                java.lang.String r1 = " < "
                r0.append(r1)
                r0.append(r4)
                java.lang.String r1 = ")"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r2.<init>(r0)
                r2.currentCapacity = r3
                r2.requiredCapacity = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.decoder.DecoderInputBuffer.InsufficientCapacityException.<init>(int, int):void");
        }
    }

    public DecoderInputBuffer(int i10) {
        this(i10, 0);
    }

    public static DecoderInputBuffer t() {
        return new DecoderInputBuffer(0);
    }

    @Override // z4.a
    public void h() {
        super.h();
        ByteBuffer byteBuffer = this.f19882d;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.f19885g;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.f19883e = false;
    }

    public final ByteBuffer p(int i10) {
        int i11 = this.f19886h;
        if (i11 == 1) {
            return ByteBuffer.allocate(i10);
        }
        if (i11 == 2) {
            return ByteBuffer.allocateDirect(i10);
        }
        ByteBuffer byteBuffer = this.f19882d;
        throw new InsufficientCapacityException(byteBuffer == null ? 0 : byteBuffer.capacity(), i10);
    }

    public void q(int i10) {
        int i11 = i10 + this.f19887i;
        ByteBuffer byteBuffer = this.f19882d;
        if (byteBuffer == null) {
            this.f19882d = p(i11);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = byteBuffer.position();
        int i12 = i11 + position;
        if (capacity >= i12) {
            this.f19882d = byteBuffer;
            return;
        }
        ByteBuffer p10 = p(i12);
        p10.order(byteBuffer.order());
        if (position > 0) {
            byteBuffer.flip();
            p10.put(byteBuffer);
        }
        this.f19882d = p10;
    }

    public final void r() {
        ByteBuffer byteBuffer = this.f19882d;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.f19885g;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    public final boolean s() {
        return j(1073741824);
    }

    public void u(int i10) {
        ByteBuffer byteBuffer = this.f19885g;
        if (byteBuffer != null && byteBuffer.capacity() >= i10) {
            this.f19885g.clear();
        } else {
            this.f19885g = ByteBuffer.allocate(i10);
        }
    }

    public DecoderInputBuffer(int i10, int i11) {
        this.f19881c = new b();
        this.f19886h = i10;
        this.f19887i = i11;
    }
}
