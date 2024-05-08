package androidx.core.os;

import kotlin.jvm.functions.Function0;
import kotlin.p;

/* compiled from: Handler.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class HandlerKt$postDelayed$runnable$1 implements Runnable {
    public final /* synthetic */ Function0<p> $action;

    public HandlerKt$postDelayed$runnable$1(Function0<p> function0) {
        this.$action = function0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$action.invoke();
    }
}
