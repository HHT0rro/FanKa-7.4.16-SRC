package com.cupidapp.live.base.network.model;

import com.cupidapp.live.liveshow.model.AdModel;
import com.cupidapp.live.setting.model.GameModel;
import com.cupidapp.live.setting.model.ProfilePasterAdModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProfileResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ProfileInfoResult {

    /* renamed from: ad, reason: collision with root package name */
    @Nullable
    private final List<AdModel> f12011ad;

    @Nullable
    private final String adMoreUrl;

    @Nullable
    private final List<EquityModel> featuredServicesList;

    @Nullable
    private final List<List<InnerFunctionModel>> innerFunction;

    @Nullable
    private final MarketingSpotModel marketingSpot;

    @Nullable
    private final String matchListGuideContent;

    @Nullable
    private final String matchListGuideName;

    @Nullable
    private final List<GameModel> outFunctionList;

    @Nullable
    private final ProfilePasterAdModel profilePasterAd;

    @Nullable
    private final TodayLuckyScoreModel todayLuckyScore;

    @Nullable
    private final List<EquityModel> valueEquityTopList;

    /* JADX WARN: Multi-variable type inference failed */
    public ProfileInfoResult(@Nullable ProfilePasterAdModel profilePasterAdModel, @Nullable List<AdModel> list, @Nullable String str, @Nullable List<GameModel> list2, @Nullable List<? extends List<InnerFunctionModel>> list3, @Nullable MarketingSpotModel marketingSpotModel, @Nullable List<EquityModel> list4, @Nullable List<EquityModel> list5, @Nullable TodayLuckyScoreModel todayLuckyScoreModel, @Nullable String str2, @Nullable String str3) {
        this.profilePasterAd = profilePasterAdModel;
        this.f12011ad = list;
        this.adMoreUrl = str;
        this.outFunctionList = list2;
        this.innerFunction = list3;
        this.marketingSpot = marketingSpotModel;
        this.valueEquityTopList = list4;
        this.featuredServicesList = list5;
        this.todayLuckyScore = todayLuckyScoreModel;
        this.matchListGuideName = str2;
        this.matchListGuideContent = str3;
    }

    @Nullable
    public final ProfilePasterAdModel component1() {
        return this.profilePasterAd;
    }

    @Nullable
    public final String component10() {
        return this.matchListGuideName;
    }

    @Nullable
    public final String component11() {
        return this.matchListGuideContent;
    }

    @Nullable
    public final List<AdModel> component2() {
        return this.f12011ad;
    }

    @Nullable
    public final String component3() {
        return this.adMoreUrl;
    }

    @Nullable
    public final List<GameModel> component4() {
        return this.outFunctionList;
    }

    @Nullable
    public final List<List<InnerFunctionModel>> component5() {
        return this.innerFunction;
    }

    @Nullable
    public final MarketingSpotModel component6() {
        return this.marketingSpot;
    }

    @Nullable
    public final List<EquityModel> component7() {
        return this.valueEquityTopList;
    }

    @Nullable
    public final List<EquityModel> component8() {
        return this.featuredServicesList;
    }

    @Nullable
    public final TodayLuckyScoreModel component9() {
        return this.todayLuckyScore;
    }

    @NotNull
    public final ProfileInfoResult copy(@Nullable ProfilePasterAdModel profilePasterAdModel, @Nullable List<AdModel> list, @Nullable String str, @Nullable List<GameModel> list2, @Nullable List<? extends List<InnerFunctionModel>> list3, @Nullable MarketingSpotModel marketingSpotModel, @Nullable List<EquityModel> list4, @Nullable List<EquityModel> list5, @Nullable TodayLuckyScoreModel todayLuckyScoreModel, @Nullable String str2, @Nullable String str3) {
        return new ProfileInfoResult(profilePasterAdModel, list, str, list2, list3, marketingSpotModel, list4, list5, todayLuckyScoreModel, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileInfoResult)) {
            return false;
        }
        ProfileInfoResult profileInfoResult = (ProfileInfoResult) obj;
        return s.d(this.profilePasterAd, profileInfoResult.profilePasterAd) && s.d(this.f12011ad, profileInfoResult.f12011ad) && s.d(this.adMoreUrl, profileInfoResult.adMoreUrl) && s.d(this.outFunctionList, profileInfoResult.outFunctionList) && s.d(this.innerFunction, profileInfoResult.innerFunction) && s.d(this.marketingSpot, profileInfoResult.marketingSpot) && s.d(this.valueEquityTopList, profileInfoResult.valueEquityTopList) && s.d(this.featuredServicesList, profileInfoResult.featuredServicesList) && s.d(this.todayLuckyScore, profileInfoResult.todayLuckyScore) && s.d(this.matchListGuideName, profileInfoResult.matchListGuideName) && s.d(this.matchListGuideContent, profileInfoResult.matchListGuideContent);
    }

    @Nullable
    public final List<AdModel> getAd() {
        return this.f12011ad;
    }

    @Nullable
    public final String getAdMoreUrl() {
        return this.adMoreUrl;
    }

    @Nullable
    public final List<EquityModel> getFeaturedServicesList() {
        return this.featuredServicesList;
    }

    @Nullable
    public final List<List<InnerFunctionModel>> getInnerFunction() {
        return this.innerFunction;
    }

    @Nullable
    public final MarketingSpotModel getMarketingSpot() {
        return this.marketingSpot;
    }

    @Nullable
    public final String getMatchListGuideContent() {
        return this.matchListGuideContent;
    }

    @Nullable
    public final String getMatchListGuideName() {
        return this.matchListGuideName;
    }

    @Nullable
    public final List<GameModel> getOutFunctionList() {
        return this.outFunctionList;
    }

    @Nullable
    public final ProfilePasterAdModel getProfilePasterAd() {
        return this.profilePasterAd;
    }

    @Nullable
    public final TodayLuckyScoreModel getTodayLuckyScore() {
        return this.todayLuckyScore;
    }

    @Nullable
    public final List<EquityModel> getValueEquityTopList() {
        return this.valueEquityTopList;
    }

    public int hashCode() {
        ProfilePasterAdModel profilePasterAdModel = this.profilePasterAd;
        int hashCode = (profilePasterAdModel == null ? 0 : profilePasterAdModel.hashCode()) * 31;
        List<AdModel> list = this.f12011ad;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.adMoreUrl;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        List<GameModel> list2 = this.outFunctionList;
        int hashCode4 = (hashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<List<InnerFunctionModel>> list3 = this.innerFunction;
        int hashCode5 = (hashCode4 + (list3 == null ? 0 : list3.hashCode())) * 31;
        MarketingSpotModel marketingSpotModel = this.marketingSpot;
        int hashCode6 = (hashCode5 + (marketingSpotModel == null ? 0 : marketingSpotModel.hashCode())) * 31;
        List<EquityModel> list4 = this.valueEquityTopList;
        int hashCode7 = (hashCode6 + (list4 == null ? 0 : list4.hashCode())) * 31;
        List<EquityModel> list5 = this.featuredServicesList;
        int hashCode8 = (hashCode7 + (list5 == null ? 0 : list5.hashCode())) * 31;
        TodayLuckyScoreModel todayLuckyScoreModel = this.todayLuckyScore;
        int hashCode9 = (hashCode8 + (todayLuckyScoreModel == null ? 0 : todayLuckyScoreModel.hashCode())) * 31;
        String str2 = this.matchListGuideName;
        int hashCode10 = (hashCode9 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.matchListGuideContent;
        return hashCode10 + (str3 != null ? str3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        ProfilePasterAdModel profilePasterAdModel = this.profilePasterAd;
        List<AdModel> list = this.f12011ad;
        String str = this.adMoreUrl;
        List<GameModel> list2 = this.outFunctionList;
        List<List<InnerFunctionModel>> list3 = this.innerFunction;
        MarketingSpotModel marketingSpotModel = this.marketingSpot;
        List<EquityModel> list4 = this.valueEquityTopList;
        List<EquityModel> list5 = this.featuredServicesList;
        TodayLuckyScoreModel todayLuckyScoreModel = this.todayLuckyScore;
        return "ProfileInfoResult(profilePasterAd=" + ((Object) profilePasterAdModel) + ", ad=" + ((Object) list) + ", adMoreUrl=" + str + ", outFunctionList=" + ((Object) list2) + ", innerFunction=" + ((Object) list3) + ", marketingSpot=" + ((Object) marketingSpotModel) + ", valueEquityTopList=" + ((Object) list4) + ", featuredServicesList=" + ((Object) list5) + ", todayLuckyScore=" + ((Object) todayLuckyScoreModel) + ", matchListGuideName=" + this.matchListGuideName + ", matchListGuideContent=" + this.matchListGuideContent + ")";
    }

    public /* synthetic */ ProfileInfoResult(ProfilePasterAdModel profilePasterAdModel, List list, String str, List list2, List list3, MarketingSpotModel marketingSpotModel, List list4, List list5, TodayLuckyScoreModel todayLuckyScoreModel, String str2, String str3, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(profilePasterAdModel, (i10 & 2) != 0 ? null : list, (i10 & 4) != 0 ? null : str, list2, list3, marketingSpotModel, list4, list5, todayLuckyScoreModel, str2, str3);
    }
}
