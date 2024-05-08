package com.cupidapp.live.match.model;

import com.cupidapp.live.base.network.model.DailyLikeGuideModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MatchResult {

    @Nullable
    private final Integer alohaOrNopeResidueNum;

    @Nullable
    private final Integer avatarWindowTipStyle;

    @Nullable
    private final DailyLikeGuideModel dailyLikePopInfo;

    @Nullable
    private List<MatchRecommendModel> list;

    public MatchResult(@Nullable List<MatchRecommendModel> list, @Nullable DailyLikeGuideModel dailyLikeGuideModel, @Nullable Integer num, @Nullable Integer num2) {
        this.list = list;
        this.dailyLikePopInfo = dailyLikeGuideModel;
        this.avatarWindowTipStyle = num;
        this.alohaOrNopeResidueNum = num2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MatchResult copy$default(MatchResult matchResult, List list, DailyLikeGuideModel dailyLikeGuideModel, Integer num, Integer num2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = matchResult.list;
        }
        if ((i10 & 2) != 0) {
            dailyLikeGuideModel = matchResult.dailyLikePopInfo;
        }
        if ((i10 & 4) != 0) {
            num = matchResult.avatarWindowTipStyle;
        }
        if ((i10 & 8) != 0) {
            num2 = matchResult.alohaOrNopeResidueNum;
        }
        return matchResult.copy(list, dailyLikeGuideModel, num, num2);
    }

    @Nullable
    public final List<MatchRecommendModel> component1() {
        return this.list;
    }

    @Nullable
    public final DailyLikeGuideModel component2() {
        return this.dailyLikePopInfo;
    }

    @Nullable
    public final Integer component3() {
        return this.avatarWindowTipStyle;
    }

    @Nullable
    public final Integer component4() {
        return this.alohaOrNopeResidueNum;
    }

    @NotNull
    public final MatchResult copy(@Nullable List<MatchRecommendModel> list, @Nullable DailyLikeGuideModel dailyLikeGuideModel, @Nullable Integer num, @Nullable Integer num2) {
        return new MatchResult(list, dailyLikeGuideModel, num, num2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchResult)) {
            return false;
        }
        MatchResult matchResult = (MatchResult) obj;
        return s.d(this.list, matchResult.list) && s.d(this.dailyLikePopInfo, matchResult.dailyLikePopInfo) && s.d(this.avatarWindowTipStyle, matchResult.avatarWindowTipStyle) && s.d(this.alohaOrNopeResidueNum, matchResult.alohaOrNopeResidueNum);
    }

    @Nullable
    public final Integer getAlohaOrNopeResidueNum() {
        return this.alohaOrNopeResidueNum;
    }

    @Nullable
    public final Integer getAvatarWindowTipStyle() {
        return this.avatarWindowTipStyle;
    }

    @Nullable
    public final DailyLikeGuideModel getDailyLikePopInfo() {
        return this.dailyLikePopInfo;
    }

    @Nullable
    public final List<MatchRecommendModel> getList() {
        return this.list;
    }

    public int hashCode() {
        List<MatchRecommendModel> list = this.list;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        DailyLikeGuideModel dailyLikeGuideModel = this.dailyLikePopInfo;
        int hashCode2 = (hashCode + (dailyLikeGuideModel == null ? 0 : dailyLikeGuideModel.hashCode())) * 31;
        Integer num = this.avatarWindowTipStyle;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.alohaOrNopeResidueNum;
        return hashCode3 + (num2 != null ? num2.hashCode() : 0);
    }

    public final void setList(@Nullable List<MatchRecommendModel> list) {
        this.list = list;
    }

    @NotNull
    public String toString() {
        return "MatchResult(list=" + ((Object) this.list) + ", dailyLikePopInfo=" + ((Object) this.dailyLikePopInfo) + ", avatarWindowTipStyle=" + ((Object) this.avatarWindowTipStyle) + ", alohaOrNopeResidueNum=" + ((Object) this.alohaOrNopeResidueNum) + ")";
    }

    public /* synthetic */ MatchResult(List list, DailyLikeGuideModel dailyLikeGuideModel, Integer num, Integer num2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, dailyLikeGuideModel, (i10 & 4) != 0 ? null : num, num2);
    }
}
