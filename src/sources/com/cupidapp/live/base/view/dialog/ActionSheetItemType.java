package com.cupidapp.live.base.view.dialog;

import androidx.annotation.ColorInt;

/* compiled from: FKActionSheetItemLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum ActionSheetItemType {
    Recommend(-16084993),
    Warning(-49088),
    Default(-15066598);

    private final int textColor;

    ActionSheetItemType(@ColorInt int i10) {
        this.textColor = i10;
    }

    public final int getTextColor() {
        return this.textColor;
    }
}
