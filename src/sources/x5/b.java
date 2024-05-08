package x5;

import java.util.NoSuchElementException;

/* compiled from: BaseMediaChunkIterator.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class b implements o {

    /* renamed from: b, reason: collision with root package name */
    public final long f54482b;

    /* renamed from: c, reason: collision with root package name */
    public final long f54483c;

    /* renamed from: d, reason: collision with root package name */
    public long f54484d;

    public b(long j10, long j11) {
        this.f54482b = j10;
        this.f54483c = j11;
        f();
    }

    public final void c() {
        long j10 = this.f54484d;
        if (j10 < this.f54482b || j10 > this.f54483c) {
            throw new NoSuchElementException();
        }
    }

    public final long d() {
        return this.f54484d;
    }

    public boolean e() {
        return this.f54484d > this.f54483c;
    }

    public void f() {
        this.f54484d = this.f54482b - 1;
    }

    @Override // x5.o
    public boolean next() {
        this.f54484d++;
        return !e();
    }
}
