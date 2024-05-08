package com.cupidapp.live.liveshow.beauty.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveBeautyItemModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveBeautyStickerEditItemModel extends FKLiveBeautyItemModel {

    @NotNull
    private final FKLiveBeautyButtonEnum buttonType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveBeautyStickerEditItemModel(@NotNull FKLiveBeautyButtonEnum buttonType) {
        super(buttonType);
        s.i(buttonType, "buttonType");
        this.buttonType = buttonType;
    }

    public static /* synthetic */ FKLiveBeautyStickerEditItemModel copy$default(FKLiveBeautyStickerEditItemModel fKLiveBeautyStickerEditItemModel, FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            fKLiveBeautyButtonEnum = fKLiveBeautyStickerEditItemModel.getButtonType();
        }
        return fKLiveBeautyStickerEditItemModel.copy(fKLiveBeautyButtonEnum);
    }

    @NotNull
    public final FKLiveBeautyButtonEnum component1() {
        return getButtonType();
    }

    @NotNull
    public final FKLiveBeautyStickerEditItemModel copy(@NotNull FKLiveBeautyButtonEnum buttonType) {
        s.i(buttonType, "buttonType");
        return new FKLiveBeautyStickerEditItemModel(buttonType);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FKLiveBeautyStickerEditItemModel) && getButtonType() == ((FKLiveBeautyStickerEditItemModel) obj).getButtonType();
    }

    @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyItemModel
    @NotNull
    public FKLiveBeautyButtonEnum getButtonType() {
        return this.buttonType;
    }

    public int hashCode() {
        return getButtonType().hashCode();
    }

    @NotNull
    public String toString() {
        return "FKLiveBeautyStickerEditItemModel(buttonType=" + ((Object) getButtonType()) + ")";
    }
}
