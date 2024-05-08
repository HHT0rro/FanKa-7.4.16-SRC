package com.cupidapp.live.liveshow.fanclub.adapter;

import com.cupidapp.live.liveshow.fanclub.model.FKFanClubTaskDataModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKFanClubTaskAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKFanClubTaskModel {
    private boolean expired;

    @NotNull
    private final FKFanClubTaskDataModel taskModel;

    public FKFanClubTaskModel(@NotNull FKFanClubTaskDataModel taskModel, boolean z10) {
        s.i(taskModel, "taskModel");
        this.taskModel = taskModel;
        this.expired = z10;
    }

    public static /* synthetic */ FKFanClubTaskModel copy$default(FKFanClubTaskModel fKFanClubTaskModel, FKFanClubTaskDataModel fKFanClubTaskDataModel, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            fKFanClubTaskDataModel = fKFanClubTaskModel.taskModel;
        }
        if ((i10 & 2) != 0) {
            z10 = fKFanClubTaskModel.expired;
        }
        return fKFanClubTaskModel.copy(fKFanClubTaskDataModel, z10);
    }

    @NotNull
    public final FKFanClubTaskDataModel component1() {
        return this.taskModel;
    }

    public final boolean component2() {
        return this.expired;
    }

    @NotNull
    public final FKFanClubTaskModel copy(@NotNull FKFanClubTaskDataModel taskModel, boolean z10) {
        s.i(taskModel, "taskModel");
        return new FKFanClubTaskModel(taskModel, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKFanClubTaskModel)) {
            return false;
        }
        FKFanClubTaskModel fKFanClubTaskModel = (FKFanClubTaskModel) obj;
        return s.d(this.taskModel, fKFanClubTaskModel.taskModel) && this.expired == fKFanClubTaskModel.expired;
    }

    public final boolean getExpired() {
        return this.expired;
    }

    @NotNull
    public final FKFanClubTaskDataModel getTaskModel() {
        return this.taskModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.taskModel.hashCode() * 31;
        boolean z10 = this.expired;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    public final void setExpired(boolean z10) {
        this.expired = z10;
    }

    @NotNull
    public String toString() {
        FKFanClubTaskDataModel fKFanClubTaskDataModel = this.taskModel;
        return "FKFanClubTaskModel(taskModel=" + ((Object) fKFanClubTaskDataModel) + ", expired=" + this.expired + ")";
    }
}
