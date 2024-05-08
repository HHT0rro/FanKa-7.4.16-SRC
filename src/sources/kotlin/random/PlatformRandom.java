package kotlin.random;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: PlatformRandom.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class PlatformRandom extends kotlin.random.a implements Serializable {

    @NotNull
    private static final a Companion = new a(null);
    private static final long serialVersionUID = 0;

    @NotNull
    private final java.util.Random impl;

    /* compiled from: PlatformRandom.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PlatformRandom(@NotNull java.util.Random impl) {
        s.i(impl, "impl");
        this.impl = impl;
    }

    @Override // kotlin.random.a
    @NotNull
    public java.util.Random getImpl() {
        return this.impl;
    }
}
