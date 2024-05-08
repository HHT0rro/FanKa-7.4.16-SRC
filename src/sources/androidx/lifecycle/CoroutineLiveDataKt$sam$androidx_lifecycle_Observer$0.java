package androidx.lifecycle;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CoroutineLiveData.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class CoroutineLiveDataKt$sam$androidx_lifecycle_Observer$0 implements Observer, p {
    private final /* synthetic */ Function1 function;

    public CoroutineLiveDataKt$sam$androidx_lifecycle_Observer$0(Function1 function) {
        s.i(function, "function");
        this.function = function;
    }

    public final boolean equals(@Nullable Object obj) {
        if ((obj instanceof Observer) && (obj instanceof p)) {
            return s.d(getFunctionDelegate(), ((p) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.p
    @NotNull
    public final kotlin.b<?> getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // androidx.lifecycle.Observer
    public final /* synthetic */ void onChanged(Object obj) {
        this.function.invoke(obj);
    }
}
