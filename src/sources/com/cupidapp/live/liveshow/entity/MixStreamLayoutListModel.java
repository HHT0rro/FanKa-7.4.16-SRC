package com.cupidapp.live.liveshow.entity;

import java.util.List;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ZGMixStreamPublisher.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MixStreamLayoutListModel {

    @NotNull
    private final List<MixStreamLayoutModel> layoutList;

    public MixStreamLayoutListModel(@NotNull List<MixStreamLayoutModel> layoutList) {
        s.i(layoutList, "layoutList");
        this.layoutList = layoutList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MixStreamLayoutListModel copy$default(MixStreamLayoutListModel mixStreamLayoutListModel, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = mixStreamLayoutListModel.layoutList;
        }
        return mixStreamLayoutListModel.copy(list);
    }

    @NotNull
    public final List<MixStreamLayoutModel> component1() {
        return this.layoutList;
    }

    @NotNull
    public final MixStreamLayoutListModel copy(@NotNull List<MixStreamLayoutModel> layoutList) {
        s.i(layoutList, "layoutList");
        return new MixStreamLayoutListModel(layoutList);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MixStreamLayoutListModel) && s.d(this.layoutList, ((MixStreamLayoutListModel) obj).layoutList);
    }

    @NotNull
    public final List<MixStreamLayoutModel> getLayoutList() {
        return this.layoutList;
    }

    public int hashCode() {
        return this.layoutList.hashCode();
    }

    @NotNull
    public String toString() {
        return "MixStreamLayoutListModel(layoutList=" + ((Object) this.layoutList) + ")";
    }
}
