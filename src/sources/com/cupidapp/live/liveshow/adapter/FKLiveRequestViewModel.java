package com.cupidapp.live.liveshow.adapter;

import com.cupidapp.live.liveshow.model.LiveRequestModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveConnectUserViewPagerAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveRequestViewModel {
    private boolean isChecked;

    @NotNull
    private final LiveRequestModel requestModel;

    public FKLiveRequestViewModel(@NotNull LiveRequestModel requestModel, boolean z10) {
        s.i(requestModel, "requestModel");
        this.requestModel = requestModel;
        this.isChecked = z10;
    }

    public static /* synthetic */ FKLiveRequestViewModel copy$default(FKLiveRequestViewModel fKLiveRequestViewModel, LiveRequestModel liveRequestModel, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            liveRequestModel = fKLiveRequestViewModel.requestModel;
        }
        if ((i10 & 2) != 0) {
            z10 = fKLiveRequestViewModel.isChecked;
        }
        return fKLiveRequestViewModel.copy(liveRequestModel, z10);
    }

    @NotNull
    public final LiveRequestModel component1() {
        return this.requestModel;
    }

    public final boolean component2() {
        return this.isChecked;
    }

    @NotNull
    public final FKLiveRequestViewModel copy(@NotNull LiveRequestModel requestModel, boolean z10) {
        s.i(requestModel, "requestModel");
        return new FKLiveRequestViewModel(requestModel, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKLiveRequestViewModel)) {
            return false;
        }
        FKLiveRequestViewModel fKLiveRequestViewModel = (FKLiveRequestViewModel) obj;
        return s.d(this.requestModel, fKLiveRequestViewModel.requestModel) && this.isChecked == fKLiveRequestViewModel.isChecked;
    }

    @NotNull
    public final LiveRequestModel getRequestModel() {
        return this.requestModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.requestModel.hashCode() * 31;
        boolean z10 = this.isChecked;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    public final boolean isChecked() {
        return this.isChecked;
    }

    public final void setChecked(boolean z10) {
        this.isChecked = z10;
    }

    @NotNull
    public String toString() {
        LiveRequestModel liveRequestModel = this.requestModel;
        return "FKLiveRequestViewModel(requestModel=" + ((Object) liveRequestModel) + ", isChecked=" + this.isChecked + ")";
    }

    public /* synthetic */ FKLiveRequestViewModel(LiveRequestModel liveRequestModel, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(liveRequestModel, (i10 & 2) != 0 ? false : z10);
    }
}
