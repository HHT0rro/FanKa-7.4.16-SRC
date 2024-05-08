package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: ArrayIterators.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class j extends f0 {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final long[] f51020b;

    /* renamed from: c, reason: collision with root package name */
    public int f51021c;

    public j(@NotNull long[] array) {
        s.i(array, "array");
        this.f51020b = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f51021c < this.f51020b.length;
    }

    @Override // kotlin.collections.f0
    public long nextLong() {
        try {
            long[] jArr = this.f51020b;
            int i10 = this.f51021c;
            this.f51021c = i10 + 1;
            return jArr[i10];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f51021c--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }
}
