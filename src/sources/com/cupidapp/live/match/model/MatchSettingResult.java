package com.cupidapp.live.match.model;

import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchSetttingModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MatchSettingResult implements Serializable {
    private final int filterAgeRangeEnd;
    private final int filterAgeRangeStart;

    @Nullable
    private final String filterRegion;

    @Nullable
    private final List<FilterTabModel> filterTabs;

    @Nullable
    private final List<MatchFilterModel> filters;

    @Nullable
    private final List<RegionModel> hotCities;
    private final boolean limitTimeReward;

    @Nullable
    private final Integer matchFilterSettingType;

    @Nullable
    private final List<String> matchKeywords;

    @Nullable
    private final List<String> matchKeywordsOption;

    @Nullable
    private final Integer nearbyFilterSettingType;

    @Nullable
    private final List<RegionModel> regions;

    @Nullable
    private final List<String> selectedRegion;

    @NotNull
    private final List<SuperFilterModel> superFilters;
    private final boolean useRecommend;

    @Nullable
    private final UserTypeModel userFilters;

    @Nullable
    private final SuperFilterOptionModel zodiacFilters;

    public MatchSettingResult(boolean z10, boolean z11, @Nullable String str, @Nullable List<RegionModel> list, @Nullable List<RegionModel> list2, @Nullable List<String> list3, int i10, int i11, @Nullable Integer num, @Nullable Integer num2, @Nullable List<MatchFilterModel> list4, @NotNull List<SuperFilterModel> superFilters, @Nullable List<String> list5, @Nullable List<String> list6, @Nullable List<FilterTabModel> list7, @Nullable UserTypeModel userTypeModel, @Nullable SuperFilterOptionModel superFilterOptionModel) {
        s.i(superFilters, "superFilters");
        this.limitTimeReward = z10;
        this.useRecommend = z11;
        this.filterRegion = str;
        this.regions = list;
        this.hotCities = list2;
        this.selectedRegion = list3;
        this.filterAgeRangeStart = i10;
        this.filterAgeRangeEnd = i11;
        this.matchFilterSettingType = num;
        this.nearbyFilterSettingType = num2;
        this.filters = list4;
        this.superFilters = superFilters;
        this.matchKeywords = list5;
        this.matchKeywordsOption = list6;
        this.filterTabs = list7;
        this.userFilters = userTypeModel;
        this.zodiacFilters = superFilterOptionModel;
    }

    public final boolean component1() {
        return this.limitTimeReward;
    }

    @Nullable
    public final Integer component10() {
        return this.nearbyFilterSettingType;
    }

    @Nullable
    public final List<MatchFilterModel> component11() {
        return this.filters;
    }

    @NotNull
    public final List<SuperFilterModel> component12() {
        return this.superFilters;
    }

    @Nullable
    public final List<String> component13() {
        return this.matchKeywords;
    }

    @Nullable
    public final List<String> component14() {
        return this.matchKeywordsOption;
    }

    @Nullable
    public final List<FilterTabModel> component15() {
        return this.filterTabs;
    }

    @Nullable
    public final UserTypeModel component16() {
        return this.userFilters;
    }

    @Nullable
    public final SuperFilterOptionModel component17() {
        return this.zodiacFilters;
    }

    public final boolean component2() {
        return this.useRecommend;
    }

    @Nullable
    public final String component3() {
        return this.filterRegion;
    }

    @Nullable
    public final List<RegionModel> component4() {
        return this.regions;
    }

    @Nullable
    public final List<RegionModel> component5() {
        return this.hotCities;
    }

    @Nullable
    public final List<String> component6() {
        return this.selectedRegion;
    }

    public final int component7() {
        return this.filterAgeRangeStart;
    }

    public final int component8() {
        return this.filterAgeRangeEnd;
    }

    @Nullable
    public final Integer component9() {
        return this.matchFilterSettingType;
    }

    @NotNull
    public final MatchSettingResult copy(boolean z10, boolean z11, @Nullable String str, @Nullable List<RegionModel> list, @Nullable List<RegionModel> list2, @Nullable List<String> list3, int i10, int i11, @Nullable Integer num, @Nullable Integer num2, @Nullable List<MatchFilterModel> list4, @NotNull List<SuperFilterModel> superFilters, @Nullable List<String> list5, @Nullable List<String> list6, @Nullable List<FilterTabModel> list7, @Nullable UserTypeModel userTypeModel, @Nullable SuperFilterOptionModel superFilterOptionModel) {
        s.i(superFilters, "superFilters");
        return new MatchSettingResult(z10, z11, str, list, list2, list3, i10, i11, num, num2, list4, superFilters, list5, list6, list7, userTypeModel, superFilterOptionModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchSettingResult)) {
            return false;
        }
        MatchSettingResult matchSettingResult = (MatchSettingResult) obj;
        return this.limitTimeReward == matchSettingResult.limitTimeReward && this.useRecommend == matchSettingResult.useRecommend && s.d(this.filterRegion, matchSettingResult.filterRegion) && s.d(this.regions, matchSettingResult.regions) && s.d(this.hotCities, matchSettingResult.hotCities) && s.d(this.selectedRegion, matchSettingResult.selectedRegion) && this.filterAgeRangeStart == matchSettingResult.filterAgeRangeStart && this.filterAgeRangeEnd == matchSettingResult.filterAgeRangeEnd && s.d(this.matchFilterSettingType, matchSettingResult.matchFilterSettingType) && s.d(this.nearbyFilterSettingType, matchSettingResult.nearbyFilterSettingType) && s.d(this.filters, matchSettingResult.filters) && s.d(this.superFilters, matchSettingResult.superFilters) && s.d(this.matchKeywords, matchSettingResult.matchKeywords) && s.d(this.matchKeywordsOption, matchSettingResult.matchKeywordsOption) && s.d(this.filterTabs, matchSettingResult.filterTabs) && s.d(this.userFilters, matchSettingResult.userFilters) && s.d(this.zodiacFilters, matchSettingResult.zodiacFilters);
    }

    public final int getFilterAgeRangeEnd() {
        return this.filterAgeRangeEnd;
    }

    public final int getFilterAgeRangeStart() {
        return this.filterAgeRangeStart;
    }

    @Nullable
    public final String getFilterRegion() {
        return this.filterRegion;
    }

    @Nullable
    public final List<FilterTabModel> getFilterTabs() {
        return this.filterTabs;
    }

    @Nullable
    public final List<MatchFilterModel> getFilters() {
        return this.filters;
    }

    @Nullable
    public final List<RegionModel> getHotCities() {
        return this.hotCities;
    }

    public final boolean getLimitTimeReward() {
        return this.limitTimeReward;
    }

    @Nullable
    public final Integer getMatchFilterSettingType() {
        return this.matchFilterSettingType;
    }

    @Nullable
    public final List<String> getMatchKeywords() {
        return this.matchKeywords;
    }

    @Nullable
    public final List<String> getMatchKeywordsOption() {
        return this.matchKeywordsOption;
    }

    @Nullable
    public final Integer getNearbyFilterSettingType() {
        return this.nearbyFilterSettingType;
    }

    @Nullable
    public final List<RegionModel> getRegions() {
        return this.regions;
    }

    @Nullable
    public final List<String> getSelectedRegion() {
        return this.selectedRegion;
    }

    @NotNull
    public final List<SuperFilterModel> getSuperFilters() {
        return this.superFilters;
    }

    public final boolean getUseRecommend() {
        return this.useRecommend;
    }

    @Nullable
    public final UserTypeModel getUserFilters() {
        return this.userFilters;
    }

    @Nullable
    public final SuperFilterOptionModel getZodiacFilters() {
        return this.zodiacFilters;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference failed for: r0v35 */
    public int hashCode() {
        boolean z10 = this.limitTimeReward;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        boolean z11 = this.useRecommend;
        int i11 = (i10 + (z11 ? 1 : z11 ? 1 : 0)) * 31;
        String str = this.filterRegion;
        int hashCode = (i11 + (str == null ? 0 : str.hashCode())) * 31;
        List<RegionModel> list = this.regions;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<RegionModel> list2 = this.hotCities;
        int hashCode3 = (hashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<String> list3 = this.selectedRegion;
        int hashCode4 = (((((hashCode3 + (list3 == null ? 0 : list3.hashCode())) * 31) + this.filterAgeRangeStart) * 31) + this.filterAgeRangeEnd) * 31;
        Integer num = this.matchFilterSettingType;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.nearbyFilterSettingType;
        int hashCode6 = (hashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        List<MatchFilterModel> list4 = this.filters;
        int hashCode7 = (((hashCode6 + (list4 == null ? 0 : list4.hashCode())) * 31) + this.superFilters.hashCode()) * 31;
        List<String> list5 = this.matchKeywords;
        int hashCode8 = (hashCode7 + (list5 == null ? 0 : list5.hashCode())) * 31;
        List<String> list6 = this.matchKeywordsOption;
        int hashCode9 = (hashCode8 + (list6 == null ? 0 : list6.hashCode())) * 31;
        List<FilterTabModel> list7 = this.filterTabs;
        int hashCode10 = (hashCode9 + (list7 == null ? 0 : list7.hashCode())) * 31;
        UserTypeModel userTypeModel = this.userFilters;
        int hashCode11 = (hashCode10 + (userTypeModel == null ? 0 : userTypeModel.hashCode())) * 31;
        SuperFilterOptionModel superFilterOptionModel = this.zodiacFilters;
        return hashCode11 + (superFilterOptionModel != null ? superFilterOptionModel.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        boolean z10 = this.limitTimeReward;
        boolean z11 = this.useRecommend;
        String str = this.filterRegion;
        List<RegionModel> list = this.regions;
        List<RegionModel> list2 = this.hotCities;
        List<String> list3 = this.selectedRegion;
        return "MatchSettingResult(limitTimeReward=" + z10 + ", useRecommend=" + z11 + ", filterRegion=" + str + ", regions=" + ((Object) list) + ", hotCities=" + ((Object) list2) + ", selectedRegion=" + ((Object) list3) + ", filterAgeRangeStart=" + this.filterAgeRangeStart + ", filterAgeRangeEnd=" + this.filterAgeRangeEnd + ", matchFilterSettingType=" + ((Object) this.matchFilterSettingType) + ", nearbyFilterSettingType=" + ((Object) this.nearbyFilterSettingType) + ", filters=" + ((Object) this.filters) + ", superFilters=" + ((Object) this.superFilters) + ", matchKeywords=" + ((Object) this.matchKeywords) + ", matchKeywordsOption=" + ((Object) this.matchKeywordsOption) + ", filterTabs=" + ((Object) this.filterTabs) + ", userFilters=" + ((Object) this.userFilters) + ", zodiacFilters=" + ((Object) this.zodiacFilters) + ")";
    }

    public /* synthetic */ MatchSettingResult(boolean z10, boolean z11, String str, List list, List list2, List list3, int i10, int i11, Integer num, Integer num2, List list4, List list5, List list6, List list7, List list8, UserTypeModel userTypeModel, SuperFilterOptionModel superFilterOptionModel, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? false : z10, z11, str, list, list2, list3, i10, i11, num, num2, list4, list5, list6, list7, list8, userTypeModel, superFilterOptionModel);
    }
}
