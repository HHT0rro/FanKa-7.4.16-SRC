package com.google.android.exoplayer2.util;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: TimedValueQueue.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e0<V> {

    /* renamed from: a, reason: collision with root package name */
    public long[] f22972a;

    /* renamed from: b, reason: collision with root package name */
    public V[] f22973b;

    /* renamed from: c, reason: collision with root package name */
    public int f22974c;

    /* renamed from: d, reason: collision with root package name */
    public int f22975d;

    public e0() {
        this(10);
    }

    public static <V> V[] f(int i10) {
        return (V[]) new Object[i10];
    }

    public synchronized void a(long j10, V v2) {
        d(j10);
        e();
        b(j10, v2);
    }

    public final void b(long j10, V v2) {
        int i10 = this.f22974c;
        int i11 = this.f22975d;
        V[] vArr = this.f22973b;
        int length = (i10 + i11) % vArr.length;
        this.f22972a[length] = j10;
        vArr[length] = v2;
        this.f22975d = i11 + 1;
    }

    public synchronized void c() {
        this.f22974c = 0;
        this.f22975d = 0;
        Arrays.fill(this.f22973b, (Object) null);
    }

    public final void d(long j10) {
        if (this.f22975d > 0) {
            if (j10 <= this.f22972a[((this.f22974c + r0) - 1) % this.f22973b.length]) {
                c();
            }
        }
    }

    public final void e() {
        int length = this.f22973b.length;
        if (this.f22975d < length) {
            return;
        }
        int i10 = length * 2;
        long[] jArr = new long[i10];
        V[] vArr = (V[]) f(i10);
        int i11 = this.f22974c;
        int i12 = length - i11;
        System.arraycopy((Object) this.f22972a, i11, (Object) jArr, 0, i12);
        System.arraycopy(this.f22973b, this.f22974c, vArr, 0, i12);
        int i13 = this.f22974c;
        if (i13 > 0) {
            System.arraycopy((Object) this.f22972a, 0, (Object) jArr, i12, i13);
            System.arraycopy(this.f22973b, 0, vArr, i12, this.f22974c);
        }
        this.f22972a = jArr;
        this.f22973b = vArr;
        this.f22974c = 0;
    }

    @Nullable
    public synchronized V g(long j10) {
        return h(j10, false);
    }

    @Nullable
    public final V h(long j10, boolean z10) {
        V v2 = null;
        long j11 = Long.MAX_VALUE;
        while (this.f22975d > 0) {
            long j12 = j10 - this.f22972a[this.f22974c];
            if (j12 < 0 && (z10 || (-j12) >= j11)) {
                break;
            }
            v2 = k();
            j11 = j12;
        }
        return v2;
    }

    @Nullable
    public synchronized V i() {
        return this.f22975d == 0 ? null : k();
    }

    @Nullable
    public synchronized V j(long j10) {
        return h(j10, true);
    }

    @Nullable
    public final V k() {
        a.g(this.f22975d > 0);
        V[] vArr = this.f22973b;
        int i10 = this.f22974c;
        V v2 = vArr[i10];
        vArr[i10] = null;
        this.f22974c = (i10 + 1) % vArr.length;
        this.f22975d--;
        return v2;
    }

    public synchronized int l() {
        return this.f22975d;
    }

    public e0(int i10) {
        this.f22972a = new long[i10];
        this.f22973b = (V[]) f(i10);
    }
}
