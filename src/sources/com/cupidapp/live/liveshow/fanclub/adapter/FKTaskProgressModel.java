package com.cupidapp.live.liveshow.fanclub.adapter;

import com.cupidapp.live.liveshow.fanclub.model.FKFanClubTaskSummaryDataModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKFanClubForAnchorAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKTaskProgressModel {

    @NotNull
    private final List<FKFanClubTaskSummaryDataModel> list;

    public FKTaskProgressModel(@NotNull List<FKFanClubTaskSummaryDataModel> list) {
        s.i(list, "list");
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FKTaskProgressModel copy$default(FKTaskProgressModel fKTaskProgressModel, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = fKTaskProgressModel.list;
        }
        return fKTaskProgressModel.copy(list);
    }

    @NotNull
    public final List<FKFanClubTaskSummaryDataModel> component1() {
        return this.list;
    }

    @NotNull
    public final FKTaskProgressModel copy(@NotNull List<FKFanClubTaskSummaryDataModel> list) {
        s.i(list, "list");
        return new FKTaskProgressModel(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FKTaskProgressModel) && s.d(this.list, ((FKTaskProgressModel) obj).list);
    }

    @NotNull
    public final List<FKFanClubTaskSummaryDataModel> getList() {
        return this.list;
    }

    public int hashCode() {
        return this.list.hashCode();
    }

    @NotNull
    public String toString() {
        return "FKTaskProgressModel(list=" + ((Object) this.list) + ")";
    }
}
