package com.cupidapp.live.liveshow.view.giftpicker.adapter;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveGiftPickerPageAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveGiftPickerEmptyUiModel extends BaseLiveGiftPickerPagerUiModel {

    @Nullable
    private final Integer emptyImage;

    @Nullable
    private final Integer emptyTextRes;

    public /* synthetic */ FKLiveGiftPickerEmptyUiModel(Integer num, Integer num2, int i10, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : num, (i11 & 2) != 0 ? null : num2, i10, str);
    }

    @Nullable
    public final Integer getEmptyImage() {
        return this.emptyImage;
    }

    @Nullable
    public final Integer getEmptyTextRes() {
        return this.emptyTextRes;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveGiftPickerEmptyUiModel(@Nullable Integer num, @Nullable Integer num2, int i10, @NotNull String tabName) {
        super(i10, tabName);
        s.i(tabName, "tabName");
        this.emptyImage = num;
        this.emptyTextRes = num2;
    }
}
