package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* compiled from: ArrayIterators.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class b extends kotlin.collections.p {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final byte[] f51008b;

    /* renamed from: c, reason: collision with root package name */
    public int f51009c;

    public b(@NotNull byte[] array) {
        s.i(array, "array");
        this.f51008b = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f51009c < this.f51008b.length;
    }

    @Override // kotlin.collections.p
    public byte nextByte() {
        try {
            byte[] bArr = this.f51008b;
            int i10 = this.f51009c;
            this.f51009c = i10 + 1;
            return bArr[i10];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f51009c--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }
}
