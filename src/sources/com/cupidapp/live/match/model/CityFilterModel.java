package com.cupidapp.live.match.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FilterModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class CityFilterModel {

    @Nullable
    private String filterRegion;

    @Nullable
    private final List<RegionModel> hotCities;

    @Nullable
    private final List<RegionModel> regions;

    @Nullable
    private String selectedRegion;

    public CityFilterModel(@Nullable String str, @Nullable String str2, @Nullable List<RegionModel> list, @Nullable List<RegionModel> list2) {
        this.filterRegion = str;
        this.selectedRegion = str2;
        this.hotCities = list;
        this.regions = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CityFilterModel copy$default(CityFilterModel cityFilterModel, String str, String str2, List list, List list2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = cityFilterModel.filterRegion;
        }
        if ((i10 & 2) != 0) {
            str2 = cityFilterModel.selectedRegion;
        }
        if ((i10 & 4) != 0) {
            list = cityFilterModel.hotCities;
        }
        if ((i10 & 8) != 0) {
            list2 = cityFilterModel.regions;
        }
        return cityFilterModel.copy(str, str2, list, list2);
    }

    @Nullable
    public final String component1() {
        return this.filterRegion;
    }

    @Nullable
    public final String component2() {
        return this.selectedRegion;
    }

    @Nullable
    public final List<RegionModel> component3() {
        return this.hotCities;
    }

    @Nullable
    public final List<RegionModel> component4() {
        return this.regions;
    }

    @NotNull
    public final CityFilterModel copy(@Nullable String str, @Nullable String str2, @Nullable List<RegionModel> list, @Nullable List<RegionModel> list2) {
        return new CityFilterModel(str, str2, list, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CityFilterModel)) {
            return false;
        }
        CityFilterModel cityFilterModel = (CityFilterModel) obj;
        return s.d(this.filterRegion, cityFilterModel.filterRegion) && s.d(this.selectedRegion, cityFilterModel.selectedRegion) && s.d(this.hotCities, cityFilterModel.hotCities) && s.d(this.regions, cityFilterModel.regions);
    }

    @Nullable
    public final String getFilterRegion() {
        return this.filterRegion;
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

    public int hashCode() {
        String str = this.filterRegion;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.selectedRegion;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<RegionModel> list = this.hotCities;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        List<RegionModel> list2 = this.regions;
        return hashCode3 + (list2 != null ? list2.hashCode() : 0);
    }

    public final void setFilterRegion(@Nullable String str) {
        this.filterRegion = str;
    }

    public final void setSelectedRegion(@Nullable String str) {
        this.selectedRegion = str;
    }

    @NotNull
    public String toString() {
        return "CityFilterModel(filterRegion=" + this.filterRegion + ", selectedRegion=" + this.selectedRegion + ", hotCities=" + ((Object) this.hotCities) + ", regions=" + ((Object) this.regions) + ")";
    }
}
