package com.cupidapp.live.appdialog.layout;

import android.app.AlertDialog;
import android.view.View;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: SVipFunctionGuideWithSVGADialog.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
final class SVipFunctionGuideWithSVGADialog$setButton$1 extends Lambda implements Function1<View, kotlin.p> {
    public final /* synthetic */ Function0<kotlin.p> $positiveCallback;
    public final /* synthetic */ SVipFunctionGuideWithSVGADialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVipFunctionGuideWithSVGADialog$setButton$1(Function0<kotlin.p> function0, SVipFunctionGuideWithSVGADialog sVipFunctionGuideWithSVGADialog) {
        super(1);
        this.$positiveCallback = function0;
        this.this$0 = sVipFunctionGuideWithSVGADialog;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
        invoke2(view);
        return kotlin.p.f51048a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable View view) {
        AlertDialog alertDialog;
        Function0<kotlin.p> function0 = this.$positiveCallback;
        if (function0 != null) {
            function0.invoke();
        }
        alertDialog = this.this$0.f11706b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }
}
