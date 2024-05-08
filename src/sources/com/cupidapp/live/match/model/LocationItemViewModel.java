package com.cupidapp.live.match.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FilterModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class LocationItemViewModel {

    @Nullable
    private String filterRegion;
    private final boolean fromNearby;

    @Nullable
    private final List<RegionModel> hotCities;

    @Nullable
    private final List<RegionModel> regions;

    @Nullable
    private String selectedRegion;
    private boolean useRecommend;

    public LocationItemViewModel(boolean z10, @Nullable String str, @Nullable String str2, @Nullable List<RegionModel> list, @Nullable List<RegionModel> list2, boolean z11) {
        this.useRecommend = z10;
        this.filterRegion = str;
        this.selectedRegion = str2;
        this.hotCities = list;
        this.regions = list2;
        this.fromNearby = z11;
    }

    public static /* synthetic */ LocationItemViewModel copy$default(LocationItemViewModel locationItemViewModel, boolean z10, String str, String str2, List list, List list2, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = locationItemViewModel.useRecommend;
        }
        if ((i10 & 2) != 0) {
            str = locationItemViewModel.filterRegion;
        }
        String str3 = str;
        if ((i10 & 4) != 0) {
            str2 = locationItemViewModel.selectedRegion;
        }
        String str4 = str2;
        if ((i10 & 8) != 0) {
            list = locationItemViewModel.hotCities;
        }
        List list3 = list;
        if ((i10 & 16) != 0) {
            list2 = locationItemViewModel.regions;
        }
        List list4 = list2;
        if ((i10 & 32) != 0) {
            z11 = locationItemViewModel.fromNearby;
        }
        return locationItemViewModel.copy(z10, str3, str4, list3, list4, z11);
    }

    public final boolean component1() {
        return this.useRecommend;
    }

    @Nullable
    public final String component2() {
        return this.filterRegion;
    }

    @Nullable
    public final String component3() {
        return this.selectedRegion;
    }

    @Nullable
    public final List<RegionModel> component4() {
        return this.hotCities;
    }

    @Nullable
    public final List<RegionModel> component5() {
        return this.regions;
    }

    public final boolean component6() {
        return this.fromNearby;
    }

    @NotNull
    public final LocationItemViewModel copy(boolean z10, @Nullable String str, @Nullable String str2, @Nullable List<RegionModel> list, @Nullable List<RegionModel> list2, boolean z11) {
        return new LocationItemViewModel(z10, str, str2, list, list2, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationItemViewModel)) {
            return false;
        }
        LocationItemViewModel locationItemViewModel = (LocationItemViewModel) obj;
        return this.useRecommend == locationItemViewModel.useRecommend && s.d(this.filterRegion, locationItemViewModel.filterRegion) && s.d(this.selectedRegion, locationItemViewModel.selectedRegion) && s.d(this.hotCities, locationItemViewModel.hotCities) && s.d(this.regions, locationItemViewModel.regions) && this.fromNearby == locationItemViewModel.fromNearby;
    }

    @Nullable
    public final String getFilterRegion() {
        return this.filterRegion;
    }

    public final boolean getFromNearby() {
        return this.fromNearby;
    }

    @Nullable
    public final List<RegionModel> getHotCities() {
        return this.hotCities;
    }

    @Nullable
    public final List<RegionModel> getRegions() {
        return this.regions;
    }

    @Nullable
    public final String getSelectedRegion() {
        return this.selectedRegion;
    }

    public final boolean getUseRecommend() {
        return this.useRecommend;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public int hashCode() {
        boolean z10 = this.useRecommend;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        String str = this.filterRegion;
        int hashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.selectedRegion;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<RegionModel> list = this.hotCities;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        List<RegionModel> list2 = this.regions;
        int hashCode4 = (hashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31;
        boolean z11 = this.fromNearby;
        return hashCode4 + (z11 ? 1 : z11 ? 1 : 0);
    }

    public final void setFilterRegion(@Nullable String str) {
        this.filterRegion = str;
    }

    public final void setSelectedRegion(@Nullable String str) {
        this.selectedRegion = str;
    }

    public final void setUseRecommend(boolean z10) {
        this.useRecommend = z10;
    }

    public final void setUseRecommendConditionData() {
        this.useRecommend = true;
        this.filterRegion = "";
        this.selectedRegion = "";
    }

    @NotNull
    public String toString() {
        boolean z10 = this.useRecommend;
        String str = this.filterRegion;
        String str2 = this.selectedRegion;
        List<RegionModel> list = this.hotCities;
        List<RegionModel> list2 = this.regions;
        return "LocationItemViewModel(useRecommend=" + z10 + ", filterRegion=" + str + ", selectedRegion=" + str2 + ", hotCities=" + ((Object) list) + ", regions=" + ((Object) list2) + ", fromNearby=" + this.fromNearby + ")";
    }
}
