package com.cupidapp.live.base.network.helper;

import com.cupidapp.live.base.utils.j;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.functions.Consumer;
import io.reactivex.plugins.RxJavaPlugins;
import java.io.IOException;
import java.lang.Thread;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: RxJavaErrorHandlerHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class RxJavaErrorHandlerHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final RxJavaErrorHandlerHelper f12006a = new RxJavaErrorHandlerHelper();

    public static final void c(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void b() {
        if (k1.a.f50625a.a()) {
            return;
        }
        if (RxJavaPlugins.getErrorHandler() == null && !RxJavaPlugins.isLockdown()) {
            final RxJavaErrorHandlerHelper$setRxJavaErrorHandler$1 rxJavaErrorHandlerHelper$setRxJavaErrorHandler$1 = new Function1<Throwable, p>() { // from class: com.cupidapp.live.base.network.helper.RxJavaErrorHandlerHelper$setRxJavaErrorHandler$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Throwable th) {
                    invoke2(th);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    if (th instanceof UndeliverableException) {
                        j.f12332a.a("RxJavaErrorHandlerHelper", "第一类  message:" + th.getMessage() + "  cause:" + ((Object) th.getCause()));
                        return;
                    }
                    if (th instanceof IOException ? true : th instanceof InterruptedException) {
                        j.f12332a.a("RxJavaErrorHandlerHelper", "第二类  message:" + th.getMessage() + "  cause:" + ((Object) th.getCause()));
                        return;
                    }
                    if (th instanceof NullPointerException ? true : th instanceof IllegalArgumentException ? true : th instanceof IllegalStateException) {
                        j.f12332a.a("RxJavaErrorHandlerHelper", "第三类  message:" + th.getMessage() + "  cause:" + ((Object) th.getCause()));
                        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = Thread.currentThread().getUncaughtExceptionHandler();
                        if (uncaughtExceptionHandler != null) {
                            uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
                        }
                    }
                }
            };
            RxJavaPlugins.setErrorHandler(new Consumer() { // from class: com.cupidapp.live.base.network.helper.a
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    RxJavaErrorHandlerHelper.c(Function1.this, obj);
                }
            });
        } else {
            j.f12332a.a("RxJavaErrorHandlerHelper", "getErrorHandler不为null，或isLockdown");
        }
    }
}
