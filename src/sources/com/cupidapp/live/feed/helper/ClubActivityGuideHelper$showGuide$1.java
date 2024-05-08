package com.cupidapp.live.feed.helper;

import android.app.AlertDialog;
import android.view.View;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.p;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubActivityGuideHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
final class ClubActivityGuideHelper$showGuide$1 extends Lambda implements Function1<View, p> {
    public final /* synthetic */ Function0<p> $clickCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubActivityGuideHelper$showGuide$1(Function0<p> function0) {
        super(1);
        this.$clickCallback = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ p invoke(View view) {
        invoke2(view);
        return p.f51048a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable View view) {
        AlertDialog alertDialog;
        alertDialog = c.f14311b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        this.$clickCallback.invoke();
    }
}
