package com.cupidapp.live.base.view.dialog;

import androidx.annotation.StringRes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKActionItemDialog.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKActionItemModel {

    @NotNull
    private final Function0<p> clickListener;
    private final int textResId;

    public FKActionItemModel(@StringRes int i10, @NotNull Function0<p> clickListener) {
        s.i(clickListener, "clickListener");
        this.textResId = i10;
        this.clickListener = clickListener;
    }

    @NotNull
    public final Function0<p> getClickListener() {
        return this.clickListener;
    }

    public final int getTextResId() {
        return this.textResId;
    }
}
