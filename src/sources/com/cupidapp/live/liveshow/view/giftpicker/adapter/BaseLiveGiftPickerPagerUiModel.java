package com.cupidapp.live.liveshow.view.giftpicker.adapter;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKLiveGiftPickerPageAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BaseLiveGiftPickerPagerUiModel {

    @NotNull
    private final String tabName;
    private final int tabPosition;

    public BaseLiveGiftPickerPagerUiModel(int i10, @NotNull String tabName) {
        s.i(tabName, "tabName");
        this.tabPosition = i10;
        this.tabName = tabName;
    }

    @NotNull
    public final String getTabName() {
        return this.tabName;
    }

    public final int getTabPosition() {
        return this.tabPosition;
    }
}
