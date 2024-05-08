package com.cupidapp.live.base.network;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.p;

/* compiled from: ObservableExtension.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ObservableExtensionKt$handle$disposed$1 extends Lambda implements Function1<Object, p> {
    public final /* synthetic */ Function1<Object, p> $success;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableExtensionKt$handle$disposed$1(Function1<Object, p> function1) {
        super(1);
        this.$success = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ p invoke(Object obj) {
        invoke2(obj);
        return p.f51048a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Object obj) {
        this.$success.invoke(obj);
    }
}
