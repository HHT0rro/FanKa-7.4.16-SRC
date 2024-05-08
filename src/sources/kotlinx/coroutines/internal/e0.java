package kotlinx.coroutines.internal;

import kotlin.Result;
import org.jetbrains.annotations.NotNull;

/* compiled from: StackTraceRecovery.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public static final String f51379a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f51380b;

    static {
        Object m3565constructorimpl;
        Object m3565constructorimpl2;
        try {
            Result.Companion companion = Result.Companion;
            m3565constructorimpl = Result.m3565constructorimpl(Class.forName("kotlin.coroutines.jvm.internal.BaseContinuationImpl").getCanonicalName());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m3565constructorimpl = Result.m3565constructorimpl(kotlin.e.a(th));
        }
        if (Result.m3568exceptionOrNullimpl(m3565constructorimpl) != null) {
            m3565constructorimpl = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        f51379a = (String) m3565constructorimpl;
        try {
            Result.Companion companion3 = Result.Companion;
            m3565constructorimpl2 = Result.m3565constructorimpl(e0.class.getCanonicalName());
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            m3565constructorimpl2 = Result.m3565constructorimpl(kotlin.e.a(th2));
        }
        if (Result.m3568exceptionOrNullimpl(m3565constructorimpl2) != null) {
            m3565constructorimpl2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        f51380b = (String) m3565constructorimpl2;
    }

    @NotNull
    public static final <E extends Throwable> E a(@NotNull E e2) {
        return e2;
    }
}
