package kotlin.random;

import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: PlatformRandom.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class b extends kotlin.random.a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final a f51054a = new a();

    /* compiled from: PlatformRandom.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a extends ThreadLocal<java.util.Random> {
        @Override // java.lang.ThreadLocal
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.util.Random initialValue() {
            return new java.util.Random();
        }
    }

    @Override // kotlin.random.a
    @NotNull
    public java.util.Random getImpl() {
        java.util.Random random = this.f51054a.get();
        s.h(random, "implStorage.get()");
        return random;
    }
}
