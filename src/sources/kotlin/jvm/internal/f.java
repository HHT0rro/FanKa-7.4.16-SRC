package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.e0;
import org.jetbrains.annotations.NotNull;

/* compiled from: ArrayIterators.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class f extends e0 {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final int[] f51016b;

    /* renamed from: c, reason: collision with root package name */
    public int f51017c;

    public f(@NotNull int[] array) {
        s.i(array, "array");
        this.f51016b = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f51017c < this.f51016b.length;
    }

    @Override // kotlin.collections.e0
    public int nextInt() {
        try {
            int[] iArr = this.f51016b;
            int i10 = this.f51017c;
            this.f51017c = i10 + 1;
            return iArr[i10];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f51017c--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }
}
