package androidx.activity.contextaware;

import android.content.Context;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.e;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlinx.coroutines.l;
import org.jetbrains.annotations.NotNull;

/* compiled from: ContextAware.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ContextAwareKt$withContextAvailable$2$listener$1 implements OnContextAvailableListener {
    public final /* synthetic */ l<R> $co;
    public final /* synthetic */ Function1<Context, R> $onContextAvailable;

    public ContextAwareKt$withContextAvailable$2$listener$1(l<R> lVar, Function1<Context, R> function1) {
        this.$co = lVar;
        this.$onContextAvailable = function1;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public void onContextAvailable(@NotNull Context context) {
        Object m3565constructorimpl;
        s.i(context, "context");
        Continuation continuation = this.$co;
        Function1<Context, R> function1 = this.$onContextAvailable;
        try {
            Result.Companion companion = Result.Companion;
            m3565constructorimpl = Result.m3565constructorimpl(function1.invoke(context));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m3565constructorimpl = Result.m3565constructorimpl(e.a(th));
        }
        continuation.resumeWith(m3565constructorimpl);
    }
}
