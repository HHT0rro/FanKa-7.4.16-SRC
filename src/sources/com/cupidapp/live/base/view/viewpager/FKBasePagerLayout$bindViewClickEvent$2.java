package com.cupidapp.live.base.view.viewpager;

import android.view.View;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.p;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKBasePagerLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
final class FKBasePagerLayout$bindViewClickEvent$2 extends Lambda implements Function1<View, p> {
    public final /* synthetic */ Object $model;
    public final /* synthetic */ com.cupidapp.live.base.recyclerview.d $viewHolderConfig;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKBasePagerLayout$bindViewClickEvent$2(com.cupidapp.live.base.recyclerview.d dVar, Object obj) {
        super(1);
        this.$viewHolderConfig = dVar;
        this.$model = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ p invoke(View view) {
        invoke2(view);
        return p.f51048a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable View view) {
        Function1<Object, p> b4 = this.$viewHolderConfig.b();
        if (b4 != null) {
            b4.invoke(this.$model);
        }
    }
}
