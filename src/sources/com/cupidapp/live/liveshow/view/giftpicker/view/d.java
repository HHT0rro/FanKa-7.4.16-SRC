package com.cupidapp.live.liveshow.view.giftpicker.view;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKCustomGiftSendCountLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class d extends Dialog {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull Context context) {
        super(context);
        s.i(context, "context");
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        View currentFocus = getCurrentFocus();
        Context context = getContext();
        s.h(context, "context");
        z0.h.p(context, currentFocus);
        super.dismiss();
    }
}
