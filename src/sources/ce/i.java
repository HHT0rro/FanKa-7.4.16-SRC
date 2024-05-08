package ce;

import java.util.NoSuchElementException;
import kotlin.collections.e0;

/* compiled from: ProgressionIterators.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class i extends e0 {

    /* renamed from: b, reason: collision with root package name */
    public final int f1612b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1613c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1614d;

    /* renamed from: e, reason: collision with root package name */
    public int f1615e;

    public i(int i10, int i11, int i12) {
        this.f1612b = i12;
        this.f1613c = i11;
        boolean z10 = true;
        if (i12 <= 0 ? i10 < i11 : i10 > i11) {
            z10 = false;
        }
        this.f1614d = z10;
        this.f1615e = z10 ? i10 : i11;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f1614d;
    }

    @Override // kotlin.collections.e0
    public int nextInt() {
        int i10 = this.f1615e;
        if (i10 == this.f1613c) {
            if (this.f1614d) {
                this.f1614d = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f1615e = this.f1612b + i10;
        }
        return i10;
    }
}
