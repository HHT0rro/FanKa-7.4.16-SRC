package com.cupidapp.live.liveshow.beauty.model;

import com.cupidapp.live.liveshow.beauty.view.FKLiveFilterViewModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveBeautyItemModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveBeautyFilterEditItemModel extends FKLiveBeautyItemModel {

    @NotNull
    private final FKLiveBeautyButtonEnum buttonType;

    @Nullable
    private FKLiveFilterViewModel filterModel;

    public /* synthetic */ FKLiveBeautyFilterEditItemModel(FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum, FKLiveFilterViewModel fKLiveFilterViewModel, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(fKLiveBeautyButtonEnum, (i10 & 2) != 0 ? null : fKLiveFilterViewModel);
    }

    public static /* synthetic */ FKLiveBeautyFilterEditItemModel copy$default(FKLiveBeautyFilterEditItemModel fKLiveBeautyFilterEditItemModel, FKLiveBeautyButtonEnum fKLiveBeautyButtonEnum, FKLiveFilterViewModel fKLiveFilterViewModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            fKLiveBeautyButtonEnum = fKLiveBeautyFilterEditItemModel.getButtonType();
        }
        if ((i10 & 2) != 0) {
            fKLiveFilterViewModel = fKLiveBeautyFilterEditItemModel.filterModel;
        }
        return fKLiveBeautyFilterEditItemModel.copy(fKLiveBeautyButtonEnum, fKLiveFilterViewModel);
    }

    @NotNull
    public final FKLiveBeautyButtonEnum component1() {
        return getButtonType();
    }

    @Nullable
    public final FKLiveFilterViewModel component2() {
        return this.filterModel;
    }

    @NotNull
    public final FKLiveBeautyFilterEditItemModel copy(@NotNull FKLiveBeautyButtonEnum buttonType, @Nullable FKLiveFilterViewModel fKLiveFilterViewModel) {
        s.i(buttonType, "buttonType");
        return new FKLiveBeautyFilterEditItemModel(buttonType, fKLiveFilterViewModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKLiveBeautyFilterEditItemModel)) {
            return false;
        }
        FKLiveBeautyFilterEditItemModel fKLiveBeautyFilterEditItemModel = (FKLiveBeautyFilterEditItemModel) obj;
        return getButtonType() == fKLiveBeautyFilterEditItemModel.getButtonType() && s.d(this.filterModel, fKLiveBeautyFilterEditItemModel.filterModel);
    }

    @Override // com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyItemModel
    @NotNull
    public FKLiveBeautyButtonEnum getButtonType() {
        return this.buttonType;
    }

    @Nullable
    public final FKLiveFilterViewModel getFilterModel() {
        return this.filterModel;
    }

    public int hashCode() {
        int hashCode = getButtonType().hashCode() * 31;
        FKLiveFilterViewModel fKLiveFilterViewModel = this.filterModel;
        return hashCode + (fKLiveFilterViewModel == null ? 0 : fKLiveFilterViewModel.hashCode());
    }

    public final void setFilterModel(@Nullable FKLiveFilterViewModel fKLiveFilterViewModel) {
        this.filterModel = fKLiveFilterViewModel;
    }

    @NotNull
    public String toString() {
        return "FKLiveBeautyFilterEditItemModel(buttonType=" + ((Object) getButtonType()) + ", filterModel=" + ((Object) this.filterModel) + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveBeautyFilterEditItemModel(@NotNull FKLiveBeautyButtonEnum buttonType, @Nullable FKLiveFilterViewModel fKLiveFilterViewModel) {
        super(buttonType);
        s.i(buttonType, "buttonType");
        this.buttonType = buttonType;
        this.filterModel = fKLiveFilterViewModel;
    }
}
