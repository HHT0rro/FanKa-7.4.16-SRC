package com.cupidapp.live.match.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NearByModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NearbySameCityRecommendViewModel {
    private final boolean isUsingMap;

    @NotNull
    private final List<List<NearbyUserModel>> sameCityUserList;

    public NearbySameCityRecommendViewModel(@NotNull List<List<NearbyUserModel>> sameCityUserList, boolean z10) {
        s.i(sameCityUserList, "sameCityUserList");
        this.sameCityUserList = sameCityUserList;
        this.isUsingMap = z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NearbySameCityRecommendViewModel copy$default(NearbySameCityRecommendViewModel nearbySameCityRecommendViewModel, List list, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = nearbySameCityRecommendViewModel.sameCityUserList;
        }
        if ((i10 & 2) != 0) {
            z10 = nearbySameCityRecommendViewModel.isUsingMap;
        }
        return nearbySameCityRecommendViewModel.copy(list, z10);
    }

    @NotNull
    public final List<List<NearbyUserModel>> component1() {
        return this.sameCityUserList;
    }

    public final boolean component2() {
        return this.isUsingMap;
    }

    @NotNull
    public final NearbySameCityRecommendViewModel copy(@NotNull List<List<NearbyUserModel>> sameCityUserList, boolean z10) {
        s.i(sameCityUserList, "sameCityUserList");
        return new NearbySameCityRecommendViewModel(sameCityUserList, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NearbySameCityRecommendViewModel)) {
            return false;
        }
        NearbySameCityRecommendViewModel nearbySameCityRecommendViewModel = (NearbySameCityRecommendViewModel) obj;
        return s.d(this.sameCityUserList, nearbySameCityRecommendViewModel.sameCityUserList) && this.isUsingMap == nearbySameCityRecommendViewModel.isUsingMap;
    }

    @NotNull
    public final List<List<NearbyUserModel>> getSameCityUserList() {
        return this.sameCityUserList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.sameCityUserList.hashCode() * 31;
        boolean z10 = this.isUsingMap;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    public final boolean isUsingMap() {
        return this.isUsingMap;
    }

    @NotNull
    public String toString() {
        List<List<NearbyUserModel>> list = this.sameCityUserList;
        return "NearbySameCityRecommendViewModel(sameCityUserList=" + ((Object) list) + ", isUsingMap=" + this.isUsingMap + ")";
    }
}
