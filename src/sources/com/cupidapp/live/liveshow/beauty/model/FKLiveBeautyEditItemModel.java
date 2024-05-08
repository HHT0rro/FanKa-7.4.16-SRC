package com.cupidapp.live.liveshow.beauty.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveBeautyItemModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveBeautyEditItemModel extends FKLiveBeautyItemModel {

    @NotNull
    private final FKLiveBeautyButtonEnum buttonType;

    @Nullable
    private Float cacheValue;

    public /* synthetic */ FKLiveBeautyEditItemModel(FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum, Float f10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(fKLiveBeautyButtonEnum, (i10 & 2) != 0 ? null : f10);
    }

    public static /* synthetic */ FKLiveBeautyEditItemModel copy$default(FKLiveBeautyEditItemModel fKLiveBeautyEditItemModel, FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum, Float f10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            fKLiveBeautyButtonEnum = fKLiveBeautyEditItemModel.getButtonType();
        }
        if ((i10 & 2) != 0) {
            f10 = fKLiveBeautyEditItemModel.cacheValue;
        }
        return fKLiveBeautyEditItemModel.copy(fKLiveBeautyButtonEnum, f10);
    }

    @NotNull
    public final FKLiveBeautyButtonEnum component1() {
        return getButtonType();
    }

    @Nullable
    public final Float component2() {
        return this.cacheValue;
    }

    @NotNull
    public final FKLiveBeautyEditItemModel copy(@NotNull FKLiveBeautyButtonEnum buttonType, @Nullable Float f10) {
        s.i(buttonType, "buttonType");
        return new FKLiveBeautyEditItemModel(buttonType, f10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKLiveBeautyEditItemModel)) {
            return false;
        }
        FKLiveBeautyEditItemModel fKLiveBeautyEditItemModel = (FKLiveBeautyEditItemModel) obj;
        return getButtonType() == fKLiveBeautyEditItemModel.getButtonType() && s.d(this.cacheValue, fKLiveBeautyEditItemModel.cacheValue);
    }

    @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyItemModel
    @NotNull
    public FKLiveBeautyButtonEnum getButtonType() {
        return this.buttonType;
    }

    @Nullable
    public final Float getCacheValue() {
        return this.cacheValue;
    }

    public int hashCode() {
        int hashCode = getButtonType().hashCode() * 31;
        Float f10 = this.cacheValue;
        return hashCode + (f10 == null ? 0 : f10.hashCode());
    }

    public final void setCacheValue(@Nullable Float f10) {
        this.cacheValue = f10;
    }

    @NotNull
    public String toString() {
        return "FKLiveBeautyEditItemModel(buttonType=" + ((Object) getButtonType()) + ", cacheValue=" + ((Object) this.cacheValue) + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveBeautyEditItemModel(@NotNull FKLiveBeautyButtonEnum buttonType, @Nullable Float f10) {
        super(buttonType);
        s.i(buttonType, "buttonType");
        this.buttonType = buttonType;
        this.cacheValue = f10;
    }
}
