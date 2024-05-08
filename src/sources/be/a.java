package be;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: PlatformThreadLocalRandom.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class a extends kotlin.random.a {
    @Override // kotlin.random.a
    @NotNull
    public Random getImpl() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        s.h(current, "current()");
        return current;
    }

    @Override // kotlin.random.Random
    public double nextDouble(double d10) {
        return ThreadLocalRandom.current().nextDouble(d10);
    }

    @Override // kotlin.random.Random
    public int nextInt(int i10, int i11) {
        return ThreadLocalRandom.current().nextInt(i10, i11);
    }

    @Override // kotlin.random.Random
    public long nextLong(long j10) {
        return ThreadLocalRandom.current().nextLong(j10);
    }

    @Override // kotlin.random.Random
    public long nextLong(long j10, long j11) {
        return ThreadLocalRandom.current().nextLong(j10, j11);
    }
}
