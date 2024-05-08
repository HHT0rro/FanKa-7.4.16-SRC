package androidx.activity.contextaware;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.p;
import org.jetbrains.annotations.Nullable;

/* compiled from: ContextAware.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ContextAwareKt$withContextAvailable$2$1 extends Lambda implements Function1<Throwable, p> {
    public final /* synthetic */ ContextAwareKt$withContextAvailable$2$listener$1 $listener;
    public final /* synthetic */ ContextAware $this_withContextAvailable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContextAwareKt$withContextAvailable$2$1(ContextAware contextAware, ContextAwareKt$withContextAvailable$2$listener$1 contextAwareKt$withContextAvailable$2$listener$1) {
        super(1);
        this.$this_withContextAvailable = contextAware;
        this.$listener = contextAwareKt$withContextAvailable$2$listener$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ p invoke(Throwable th) {
        invoke2(th);
        return p.f51048a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable Throwable th) {
        this.$this_withContextAvailable.removeOnContextAvailableListener(this.$listener);
    }
}
