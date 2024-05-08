package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.c0;
import org.jetbrains.annotations.NotNull;

/* compiled from: ArrayIterators.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class e extends c0 {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final float[] f51014b;

    /* renamed from: c, reason: collision with root package name */
    public int f51015c;

    public e(@NotNull float[] array) {
        s.i(array, "array");
        this.f51014b = array;
    }

    @Override // kotlin.collections.c0
    public float a() {
        try {
            float[] fArr = this.f51014b;
            int i10 = this.f51015c;
            this.f51015c = i10 + 1;
            return fArr[i10];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f51015c--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f51015c < this.f51014b.length;
    }
}
