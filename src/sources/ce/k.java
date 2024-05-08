package ce;

import java.util.NoSuchElementException;
import kotlin.collections.f0;

/* compiled from: ProgressionIterators.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class k extends f0 {

    /* renamed from: b, reason: collision with root package name */
    public final long f1620b;

    /* renamed from: c, reason: collision with root package name */
    public final long f1621c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1622d;

    /* renamed from: e, reason: collision with root package name */
    public long f1623e;

    public k(long j10, long j11, long j12) {
        this.f1620b = j12;
        this.f1621c = j11;
        boolean z10 = true;
        if (j12 <= 0 ? j10 < j11 : j10 > j11) {
            z10 = false;
        }
        this.f1622d = z10;
        this.f1623e = z10 ? j10 : j11;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f1622d;
    }

    @Override // kotlin.collections.f0
    public long nextLong() {
        long j10 = this.f1623e;
        if (j10 == this.f1621c) {
            if (this.f1622d) {
                this.f1622d = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f1623e = this.f1620b + j10;
        }
        return j10;
    }
}
