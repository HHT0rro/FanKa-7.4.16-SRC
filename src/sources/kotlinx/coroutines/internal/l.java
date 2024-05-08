package kotlinx.coroutines.internal;

import kotlin.Result;

/* compiled from: FastServiceLoader.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f51396a;

    static {
        Object m3565constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            m3565constructorimpl = Result.m3565constructorimpl(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m3565constructorimpl = Result.m3565constructorimpl(kotlin.e.a(th));
        }
        f51396a = Result.m3572isSuccessimpl(m3565constructorimpl);
    }

    public static final boolean a() {
        return f51396a;
    }
}
