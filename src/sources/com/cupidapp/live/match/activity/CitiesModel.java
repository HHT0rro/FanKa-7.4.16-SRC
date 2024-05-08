package com.cupidapp.live.match.activity;

import com.cupidapp.live.match.model.RegionModel;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AreaListActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class CitiesModel implements Serializable {

    @Nullable
    private final List<RegionModel> hotCities;

    @Nullable
    private final List<RegionModel> regions;

    @Nullable
    private final RegionModel selectRegion;
    private final boolean subCity;

    @NotNull
    private final String title;

    public CitiesModel(@NotNull String title, @Nullable List<RegionModel> list, @Nullable List<RegionModel> list2, boolean z10, @Nullable RegionModel regionModel) {
        kotlin.jvm.internal.s.i(title, "title");
        this.title = title;
        this.hotCities = list;
        this.regions = list2;
        this.subCity = z10;
        this.selectRegion = regionModel;
    }

    public static /* synthetic */ CitiesModel copy$default(CitiesModel citiesModel, String str, List list, List list2, boolean z10, RegionModel regionModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = citiesModel.title;
        }
        if ((i10 & 2) != 0) {
            list = citiesModel.hotCities;
        }
        List list3 = list;
        if ((i10 & 4) != 0) {
            list2 = citiesModel.regions;
        }
        List list4 = list2;
        if ((i10 & 8) != 0) {
            z10 = citiesModel.subCity;
        }
        boolean z11 = z10;
        if ((i10 & 16) != 0) {
            regionModel = citiesModel.selectRegion;
        }
        return citiesModel.copy(str, list3, list4, z11, regionModel);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final List<RegionModel> component2() {
        return this.hotCities;
    }

    @Nullable
    public final List<RegionModel> component3() {
        return this.regions;
    }

    public final boolean component4() {
        return this.subCity;
    }

    @Nullable
    public final RegionModel component5() {
        return this.selectRegion;
    }

    @NotNull
    public final CitiesModel copy(@NotNull String title, @Nullable List<RegionModel> list, @Nullable List<RegionModel> list2, boolean z10, @Nullable RegionModel regionModel) {
        kotlin.jvm.internal.s.i(title, "title");
        return new CitiesModel(title, list, list2, z10, regionModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CitiesModel)) {
            return false;
        }
        CitiesModel citiesModel = (CitiesModel) obj;
        return kotlin.jvm.internal.s.d(this.title, citiesModel.title) && kotlin.jvm.internal.s.d(this.hotCities, citiesModel.hotCities) && kotlin.jvm.internal.s.d(this.regions, citiesModel.regions) && this.subCity == citiesModel.subCity && kotlin.jvm.internal.s.d(this.selectRegion, citiesModel.selectRegion);
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
    public final RegionModel getSelectRegion() {
        return this.selectRegion;
    }

    public final boolean getSubCity() {
        return this.subCity;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.title.hashCode() * 31;
        List<RegionModel> list = this.hotCities;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<RegionModel> list2 = this.regions;
        int hashCode3 = (hashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        boolean z10 = this.subCity;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode3 + i10) * 31;
        RegionModel regionModel = this.selectRegion;
        return i11 + (regionModel != null ? regionModel.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.title;
        List<RegionModel> list = this.hotCities;
        List<RegionModel> list2 = this.regions;
        return "CitiesModel(title=" + str + ", hotCities=" + ((Object) list) + ", regions=" + ((Object) list2) + ", subCity=" + this.subCity + ", selectRegion=" + ((Object) this.selectRegion) + ")";
    }

    public /* synthetic */ CitiesModel(String str, List list, List list2, boolean z10, RegionModel regionModel, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, list2, z10, (i10 & 16) != 0 ? null : regionModel);
    }
}
