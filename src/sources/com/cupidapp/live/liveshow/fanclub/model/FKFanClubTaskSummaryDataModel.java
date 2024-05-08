package com.cupidapp.live.liveshow.fanclub.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKFanClubResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKFanClubTaskSummaryDataModel implements Serializable {
    private final int completedNums;

    @NotNull
    private final ImageModel icon;

    @NotNull
    private final String title;

    public FKFanClubTaskSummaryDataModel(@NotNull String title, @NotNull ImageModel icon, int i10) {
        s.i(title, "title");
        s.i(icon, "icon");
        this.title = title;
        this.icon = icon;
        this.completedNums = i10;
    }

    public static /* synthetic */ FKFanClubTaskSummaryDataModel copy$default(FKFanClubTaskSummaryDataModel fKFanClubTaskSummaryDataModel, String str, ImageModel imageModel, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = fKFanClubTaskSummaryDataModel.title;
        }
        if ((i11 & 2) != 0) {
            imageModel = fKFanClubTaskSummaryDataModel.icon;
        }
        if ((i11 & 4) != 0) {
            i10 = fKFanClubTaskSummaryDataModel.completedNums;
        }
        return fKFanClubTaskSummaryDataModel.copy(str, imageModel, i10);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final ImageModel component2() {
        return this.icon;
    }

    public final int component3() {
        return this.completedNums;
    }

    @NotNull
    public final FKFanClubTaskSummaryDataModel copy(@NotNull String title, @NotNull ImageModel icon, int i10) {
        s.i(title, "title");
        s.i(icon, "icon");
        return new FKFanClubTaskSummaryDataModel(title, icon, i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKFanClubTaskSummaryDataModel)) {
            return false;
        }
        FKFanClubTaskSummaryDataModel fKFanClubTaskSummaryDataModel = (FKFanClubTaskSummaryDataModel) obj;
        return s.d(this.title, fKFanClubTaskSummaryDataModel.title) && s.d(this.icon, fKFanClubTaskSummaryDataModel.icon) && this.completedNums == fKFanClubTaskSummaryDataModel.completedNums;
    }

    public final int getCompletedNums() {
        return this.completedNums;
    }

    @NotNull
    public final ImageModel getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((this.title.hashCode() * 31) + this.icon.hashCode()) * 31) + this.completedNums;
    }

    @NotNull
    public String toString() {
        String str = this.title;
        ImageModel imageModel = this.icon;
        return "FKFanClubTaskSummaryDataModel(title=" + str + ", icon=" + ((Object) imageModel) + ", completedNums=" + this.completedNums + ")";
    }
}
