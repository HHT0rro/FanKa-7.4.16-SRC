package com.cupidapp.live.club.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubTotalModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubListResult {

    @Nullable
    private final ImageModel cityIcon;

    @Nullable
    private final List<ClubModel> mineList;

    @Nullable
    private final String nextCursorId;

    @Nullable
    private final List<ClubModel> sameCityList;

    public ClubListResult(@Nullable List<ClubModel> list, @Nullable List<ClubModel> list2, @Nullable ImageModel imageModel, @Nullable String str) {
        this.mineList = list;
        this.sameCityList = list2;
        this.cityIcon = imageModel;
        this.nextCursorId = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ClubListResult copy$default(ClubListResult clubListResult, List list, List list2, ImageModel imageModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = clubListResult.mineList;
        }
        if ((i10 & 2) != 0) {
            list2 = clubListResult.sameCityList;
        }
        if ((i10 & 4) != 0) {
            imageModel = clubListResult.cityIcon;
        }
        if ((i10 & 8) != 0) {
            str = clubListResult.nextCursorId;
        }
        return clubListResult.copy(list, list2, imageModel, str);
    }

    @Nullable
    public final List<ClubModel> component1() {
        return this.mineList;
    }

    @Nullable
    public final List<ClubModel> component2() {
        return this.sameCityList;
    }

    @Nullable
    public final ImageModel component3() {
        return this.cityIcon;
    }

    @Nullable
    public final String component4() {
        return this.nextCursorId;
    }

    @NotNull
    public final ClubListResult copy(@Nullable List<ClubModel> list, @Nullable List<ClubModel> list2, @Nullable ImageModel imageModel, @Nullable String str) {
        return new ClubListResult(list, list2, imageModel, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClubListResult)) {
            return false;
        }
        ClubListResult clubListResult = (ClubListResult) obj;
        return s.d(this.mineList, clubListResult.mineList) && s.d(this.sameCityList, clubListResult.sameCityList) && s.d(this.cityIcon, clubListResult.cityIcon) && s.d(this.nextCursorId, clubListResult.nextCursorId);
    }

    @Nullable
    public final ImageModel getCityIcon() {
        return this.cityIcon;
    }

    @Nullable
    public final List<ClubModel> getMineList() {
        return this.mineList;
    }

    @Nullable
    public final String getNextCursorId() {
        return this.nextCursorId;
    }

    @Nullable
    public final List<ClubModel> getSameCityList() {
        return this.sameCityList;
    }

    public int hashCode() {
        List<ClubModel> list = this.mineList;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<ClubModel> list2 = this.sameCityList;
        int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        ImageModel imageModel = this.cityIcon;
        int hashCode3 = (hashCode2 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str = this.nextCursorId;
        return hashCode3 + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        List<ClubModel> list = this.mineList;
        List<ClubModel> list2 = this.sameCityList;
        ImageModel imageModel = this.cityIcon;
        return "ClubListResult(mineList=" + ((Object) list) + ", sameCityList=" + ((Object) list2) + ", cityIcon=" + ((Object) imageModel) + ", nextCursorId=" + this.nextCursorId + ")";
    }
}
