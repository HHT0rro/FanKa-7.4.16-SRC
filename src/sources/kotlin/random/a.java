package kotlin.random;

import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: PlatformRandom.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class a extends Random {
    @NotNull
    public abstract java.util.Random getImpl();

    @Override // kotlin.random.Random
    public int nextBits(int i10) {
        return d.f(getImpl().nextInt(), i10);
    }

    @Override // kotlin.random.Random
    public boolean nextBoolean() {
        return getImpl().nextBoolean();
    }

    @Override // kotlin.random.Random
    @NotNull
    public byte[] nextBytes(@NotNull byte[] array) {
        s.i(array, "array");
        getImpl().nextBytes(array);
        return array;
    }

    @Override // kotlin.random.Random
    public double nextDouble() {
        return getImpl().nextDouble();
    }

    @Override // kotlin.random.Random
    public float nextFloat() {
        return getImpl().nextFloat();
    }

    @Override // kotlin.random.Random
    public int nextInt() {
        return getImpl().nextInt();
    }

    @Override // kotlin.random.Random
    public long nextLong() {
        return getImpl().nextLong();
    }

    @Override // kotlin.random.Random
    public int nextInt(int i10) {
        return getImpl().nextInt(i10);
    }
}
