package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* compiled from: ArrayIterators.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class c extends kotlin.collections.q {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final char[] f51010b;

    /* renamed from: c, reason: collision with root package name */
    public int f51011c;

    public c(@NotNull char[] array) {
        s.i(array, "array");
        this.f51010b = array;
    }

    @Override // kotlin.collections.q
    public char a() {
        try {
            char[] cArr = this.f51010b;
            int i10 = this.f51011c;
            this.f51011c = i10 + 1;
            return cArr[i10];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f51011c--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f51011c < this.f51010b.length;
    }
}
