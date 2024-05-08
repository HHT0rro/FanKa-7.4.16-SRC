package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CoroutineName.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class g0 extends kotlin.coroutines.a {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f51348c = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final String f51349b;

    /* compiled from: CoroutineName.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a implements CoroutineContext.b<g0> {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g0) && kotlin.jvm.internal.s.d(this.f51349b, ((g0) obj).f51349b);
    }

    public int hashCode() {
        return this.f51349b.hashCode();
    }

    @NotNull
    public String toString() {
        return "CoroutineName(" + this.f51349b + ')';
    }

    @NotNull
    public final String x() {
        return this.f51349b;
    }
}
