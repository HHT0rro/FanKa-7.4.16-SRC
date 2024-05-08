package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* compiled from: ArrayIterators.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class d extends kotlin.collections.a0 {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final double[] f51012b;

    /* renamed from: c, reason: collision with root package name */
    public int f51013c;

    public d(@NotNull double[] array) {
        s.i(array, "array");
        this.f51012b = array;
    }

    @Override // kotlin.collections.a0
    public double a() {
        try {
            double[] dArr = this.f51012b;
            int i10 = this.f51013c;
            this.f51013c = i10 + 1;
            return dArr[i10];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f51013c--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f51013c < this.f51012b.length;
    }
}
