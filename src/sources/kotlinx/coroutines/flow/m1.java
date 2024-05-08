package kotlinx.coroutines.flow;

import org.jetbrains.annotations.NotNull;

/* compiled from: SharingStarted.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface m1 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f51339a = a.f51340a;

    /* compiled from: SharingStarted.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f51340a = new a();

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public static final m1 f51341b = new n1();

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        public static final m1 f51342c = new StartedLazily();

        @NotNull
        public final m1 a() {
            return f51341b;
        }

        @NotNull
        public final m1 b() {
            return f51342c;
        }
    }

    @NotNull
    c<SharingCommand> a(@NotNull p1<Integer> p1Var);
}
