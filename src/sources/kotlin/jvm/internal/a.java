package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* compiled from: ArrayIterators.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class a extends kotlin.collections.o {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final boolean[] f51005b;

    /* renamed from: c, reason: collision with root package name */
    public int f51006c;

    public a(@NotNull boolean[] array) {
        s.i(array, "array");
        this.f51005b = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f51006c < this.f51005b.length;
    }

    @Override // kotlin.collections.o
    public boolean nextBoolean() {
        try {
            boolean[] zArr = this.f51005b;
            int i10 = this.f51006c;
            this.f51006c = i10 + 1;
            return zArr[i10];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f51006c--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }
}
