package kotlinx.coroutines.internal;

import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ArrayQueue.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a<T> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public Object[] f51368a = new Object[16];

    /* renamed from: b, reason: collision with root package name */
    public int f51369b;

    /* renamed from: c, reason: collision with root package name */
    public int f51370c;

    public final void a(@NotNull T t2) {
        Object[] objArr = this.f51368a;
        int i10 = this.f51370c;
        objArr[i10] = t2;
        int length = (objArr.length - 1) & (i10 + 1);
        this.f51370c = length;
        if (length == this.f51369b) {
            b();
        }
    }

    public final void b() {
        Object[] objArr = this.f51368a;
        int length = objArr.length;
        Object[] objArr2 = new Object[length << 1];
        kotlin.collections.l.h(objArr, objArr2, 0, this.f51369b, 0, 10, null);
        Object[] objArr3 = this.f51368a;
        int length2 = objArr3.length;
        int i10 = this.f51369b;
        kotlin.collections.l.h(objArr3, objArr2, length2 - i10, 0, i10, 4, null);
        this.f51368a = objArr2;
        this.f51369b = 0;
        this.f51370c = length;
    }

    public final boolean c() {
        return this.f51369b == this.f51370c;
    }

    @Nullable
    public final T d() {
        int i10 = this.f51369b;
        if (i10 == this.f51370c) {
            return null;
        }
        Object[] objArr = this.f51368a;
        T t2 = (T) objArr[i10];
        objArr[i10] = null;
        this.f51369b = (i10 + 1) & (objArr.length - 1);
        Objects.requireNonNull(t2, "null cannot be cast to non-null type T of kotlinx.coroutines.internal.ArrayQueue");
        return t2;
    }
}
