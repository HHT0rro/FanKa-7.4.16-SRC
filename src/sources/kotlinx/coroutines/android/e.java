package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.annotation.VisibleForTesting;
import java.util.Objects;
import kotlin.Result;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HandlerDispatcher.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public static final d f51131a;

    @Nullable
    private static volatile Choreographer choreographer;

    static {
        Object m3565constructorimpl;
        byte b4 = 0;
        byte b10 = 0;
        try {
            Result.Companion companion = Result.Companion;
            m3565constructorimpl = Result.m3565constructorimpl(new HandlerContext(a(Looper.getMainLooper(), true), b10 == true ? 1 : 0, 2, b4 == true ? 1 : 0));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m3565constructorimpl = Result.m3565constructorimpl(kotlin.e.a(th));
        }
        f51131a = (d) (Result.m3571isFailureimpl(m3565constructorimpl) ? null : m3565constructorimpl);
    }

    @VisibleForTesting
    @NotNull
    public static final Handler a(@NotNull Looper looper, boolean z10) {
        if (z10) {
            if (Build.VERSION.SDK_INT >= 28) {
                Object invoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
                Objects.requireNonNull(invoke, "null cannot be cast to non-null type android.os.Handler");
                return (Handler) invoke;
            }
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
                return new Handler(looper);
            }
        }
        return new Handler(looper);
    }
}
