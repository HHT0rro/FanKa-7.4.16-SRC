package com.cupidapp.live.setting.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NewPushLiveShowItemModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NewPushLiveShowModel {

    @NotNull
    private List<NewPushLiveShowItemModel> anchorList;
    private boolean pushLiveShow;

    public NewPushLiveShowModel(boolean z10, @NotNull List<NewPushLiveShowItemModel> anchorList) {
        s.i(anchorList, "anchorList");
        this.pushLiveShow = z10;
        this.anchorList = anchorList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NewPushLiveShowModel copy$default(NewPushLiveShowModel newPushLiveShowModel, boolean z10, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = newPushLiveShowModel.pushLiveShow;
        }
        if ((i10 & 2) != 0) {
            list = newPushLiveShowModel.anchorList;
        }
        return newPushLiveShowModel.copy(z10, list);
    }

    public final boolean component1() {
        return this.pushLiveShow;
    }

    @NotNull
    public final List<NewPushLiveShowItemModel> component2() {
        return this.anchorList;
    }

    @NotNull
    public final NewPushLiveShowModel copy(boolean z10, @NotNull List<NewPushLiveShowItemModel> anchorList) {
        s.i(anchorList, "anchorList");
        return new NewPushLiveShowModel(z10, anchorList);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NewPushLiveShowModel)) {
            return false;
        }
        NewPushLiveShowModel newPushLiveShowModel = (NewPushLiveShowModel) obj;
        return this.pushLiveShow == newPushLiveShowModel.pushLiveShow && s.d(this.anchorList, newPushLiveShowModel.anchorList);
    }

    @NotNull
    public final List<NewPushLiveShowItemModel> getAnchorList() {
        return this.anchorList;
    }

    public final boolean getPushLiveShow() {
        return this.pushLiveShow;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z10 = this.pushLiveShow;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        return (r02 * 31) + this.anchorList.hashCode();
    }

    public final void setAnchorList(@NotNull List<NewPushLiveShowItemModel> list) {
        s.i(list, "<set-?>");
        this.anchorList = list;
    }

    public final void setPushLiveShow(boolean z10) {
        this.pushLiveShow = z10;
    }

    @NotNull
    public String toString() {
        return "NewPushLiveShowModel(pushLiveShow=" + this.pushLiveShow + ", anchorList=" + ((Object) this.anchorList) + ")";
    }
}
