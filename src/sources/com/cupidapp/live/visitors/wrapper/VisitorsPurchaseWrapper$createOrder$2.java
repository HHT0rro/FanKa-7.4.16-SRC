package com.cupidapp.live.visitors.wrapper;

import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: VisitorsPurchaseWrapper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
final class VisitorsPurchaseWrapper$createOrder$2 extends Lambda implements Function1<Throwable, Boolean> {
    public final /* synthetic */ VisitorsPurchaseWrapper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VisitorsPurchaseWrapper$createOrder$2(VisitorsPurchaseWrapper visitorsPurchaseWrapper) {
        super(1);
        this.this$0 = visitorsPurchaseWrapper;
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Boolean invoke(@NotNull Throwable it) {
        s.i(it, "it");
        this.this$0.a();
        return Boolean.FALSE;
    }
}
