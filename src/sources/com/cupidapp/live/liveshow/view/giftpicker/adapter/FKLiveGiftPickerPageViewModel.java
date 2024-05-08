package com.cupidapp.live.liveshow.view.giftpicker.adapter;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKLiveGiftPickerPageAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveGiftPickerPageViewModel extends BaseLiveGiftPickerPagerUiModel {
    private final int currentIndicatorCount;

    @NotNull
    private final List<FKLiveGiftPickerItemViewModel> onePageGiftList;
    private final int totalIndicatorCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveGiftPickerPageViewModel(@NotNull List<FKLiveGiftPickerItemViewModel> onePageGiftList, int i10, int i11, int i12, @NotNull String tabName) {
        super(i12, tabName);
        s.i(onePageGiftList, "onePageGiftList");
        s.i(tabName, "tabName");
        this.onePageGiftList = onePageGiftList;
        this.totalIndicatorCount = i10;
        this.currentIndicatorCount = i11;
    }

    public final int getCurrentIndicatorCount() {
        return this.currentIndicatorCount;
    }

    @NotNull
    public final List<FKLiveGiftPickerItemViewModel> getOnePageGiftList() {
        return this.onePageGiftList;
    }

    public final int getTotalIndicatorCount() {
        return this.totalIndicatorCount;
    }
}
