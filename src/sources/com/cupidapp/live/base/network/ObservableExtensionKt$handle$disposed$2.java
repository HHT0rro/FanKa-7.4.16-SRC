package com.cupidapp.live.base.network;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.p;

/* compiled from: ObservableExtension.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ObservableExtensionKt$handle$disposed$2 extends Lambda implements Function1<Throwable, p> {
    public final /* synthetic */ g $apiRequestDisposedWatcher;
    public final /* synthetic */ Function1<Throwable, Boolean> $errorCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ObservableExtensionKt$handle$disposed$2(Function1<? super Throwable, Boolean> function1, g gVar) {
        super(1);
        this.$errorCallback = function1;
        this.$apiRequestDisposedWatcher = gVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ p invoke(Throwable th) {
        invoke2(th);
        return p.f51048a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable it) {
        Function1<Throwable, Boolean> function1 = this.$errorCallback;
        if (function1 != null) {
            s.h(it, "it");
            if (function1.invoke(it).booleanValue()) {
                return;
            }
        }
        j jVar = j.f12008a;
        s.h(it, "it");
        g gVar = this.$apiRequestDisposedWatcher;
        j.f(jVar, it, gVar != null ? gVar.getStartApiRequestContext() : null, null, null, 12, null);
    }
}
