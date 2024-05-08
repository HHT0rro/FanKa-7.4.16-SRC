package androidx.activity.contextaware;

import android.content.Context;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.r;
import kotlin.p;
import kotlinx.coroutines.m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sd.a;
import td.f;

/* compiled from: ContextAware.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ContextAwareKt {
    @Nullable
    public static final <R> Object withContextAvailable(@NotNull ContextAware contextAware, @NotNull Function1<Context, R> function1, @NotNull Continuation<R> continuation) {
        Context peekAvailableContext = contextAware.peekAvailableContext();
        if (peekAvailableContext != null) {
            return function1.invoke(peekAvailableContext);
        }
        m mVar = new m(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
        mVar.y();
        ContextAwareKt$withContextAvailable$2$listener$1 contextAwareKt$withContextAvailable$2$listener$1 = new ContextAwareKt$withContextAvailable$2$listener$1(mVar, function1);
        contextAware.addOnContextAvailableListener(contextAwareKt$withContextAvailable$2$listener$1);
        mVar.v(new ContextAwareKt$withContextAvailable$2$1(contextAware, contextAwareKt$withContextAvailable$2$listener$1));
        Object r10 = mVar.r();
        if (r10 == a.d()) {
            f.c(continuation);
        }
        return r10;
    }

    private static final <R> Object withContextAvailable$$forInline(ContextAware contextAware, Function1<Context, R> function1, Continuation<R> continuation) {
        Context peekAvailableContext = contextAware.peekAvailableContext();
        if (peekAvailableContext != null) {
            return function1.invoke(peekAvailableContext);
        }
        r.c(0);
        m mVar = new m(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
        mVar.y();
        ContextAwareKt$withContextAvailable$2$listener$1 contextAwareKt$withContextAvailable$2$listener$1 = new ContextAwareKt$withContextAvailable$2$listener$1(mVar, function1);
        contextAware.addOnContextAvailableListener(contextAwareKt$withContextAvailable$2$listener$1);
        mVar.v(new ContextAwareKt$withContextAvailable$2$1(contextAware, contextAwareKt$withContextAvailable$2$listener$1));
        p pVar = p.f51048a;
        Object r10 = mVar.r();
        if (r10 == a.d()) {
            f.c(continuation);
        }
        r.c(1);
        return r10;
    }
}
