package com.cupidapp.live.base.view.dialog;

import android.view.View;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.p;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKAlertDialog.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
final class FKAlertDialog$setShowCloseImg$1 extends Lambda implements Function1<View, p> {
    public final /* synthetic */ FKAlertDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKAlertDialog$setShowCloseImg$1(FKAlertDialog fKAlertDialog) {
        super(1);
        this.this$0 = fKAlertDialog;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ p invoke(View view) {
        invoke2(view);
        return p.f51048a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable View view) {
        this.this$0.g();
    }
}
