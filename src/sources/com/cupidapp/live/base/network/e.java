package com.cupidapp.live.base.network;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;

/* compiled from: ObservableExtension.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final /* synthetic */ class e implements Consumer {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f11997b;

    public e(Function1 function) {
        s.i(function, "function");
        this.f11997b = function;
    }

    @Override // io.reactivex.functions.Consumer
    public final /* synthetic */ void accept(Object obj) {
        this.f11997b.invoke(obj);
    }
}
