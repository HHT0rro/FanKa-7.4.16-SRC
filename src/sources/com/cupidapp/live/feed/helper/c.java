package com.cupidapp.live.feed.helper;

import android.app.AlertDialog;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubActivityGuideHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f14310a = new c();

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public static AlertDialog f14311b;

    public final void b() {
        AlertDialog alertDialog;
        AlertDialog alertDialog2 = f14311b;
        if (!(alertDialog2 != null && alertDialog2.isShowing()) || (alertDialog = f14311b) == null) {
            return;
        }
        alertDialog.dismiss();
    }
}
