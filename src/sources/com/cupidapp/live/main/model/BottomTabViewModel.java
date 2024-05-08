package com.cupidapp.live.main.model;

import androidx.annotation.DrawableRes;
import kotlin.d;

/* compiled from: BottomTabViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class BottomTabViewModel {
    private final int selectedResId;
    private final int unSelectedResId;

    public BottomTabViewModel(@DrawableRes int i10, @DrawableRes int i11) {
        this.selectedResId = i10;
        this.unSelectedResId = i11;
    }

    public final int getSelectedResId() {
        return this.selectedResId;
    }

    public final int getUnSelectedResId() {
        return this.unSelectedResId;
    }
}
