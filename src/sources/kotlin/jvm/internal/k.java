package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.o0;
import org.jetbrains.annotations.NotNull;

/* compiled from: ArrayIterators.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class k extends o0 {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final short[] f51022b;

    /* renamed from: c, reason: collision with root package name */
    public int f51023c;

    public k(@NotNull short[] array) {
        s.i(array, "array");
        this.f51022b = array;
    }

    @Override // kotlin.collections.o0
    public short a() {
        try {
            short[] sArr = this.f51022b;
            int i10 = this.f51023c;
            this.f51023c = i10 + 1;
            return sArr[i10];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f51023c--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f51023c < this.f51022b.length;
    }
}
