package com.cupidapp.live.profile.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UserRankModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UserRankModel {

    @Nullable
    private final Boolean annualVip;

    @Nullable
    private final String rank1;

    @Nullable
    private final Integer rank2;

    @Nullable
    private final String rank2Level;

    @Nullable
    private final Boolean realAvatar;

    @Nullable
    private final Integer ssvipCount;

    @Nullable
    private final Integer superLikeRemains;

    @Nullable
    private final Integer svipCount;

    @Nullable
    private final Boolean vip;

    @Nullable
    private final Integer vipCount;
    private final int vipType;

    @Nullable
    private final Integer visitorCount;

    @Nullable
    private Boolean visitorEnable;

    public UserRankModel(@Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable Boolean bool, int i10, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable Integer num5, @Nullable Integer num6) {
        this.rank1 = str;
        this.rank2 = num;
        this.rank2Level = str2;
        this.vip = bool;
        this.vipType = i10;
        this.annualVip = bool2;
        this.visitorEnable = bool3;
        this.realAvatar = bool4;
        this.superLikeRemains = num2;
        this.vipCount = num3;
        this.svipCount = num4;
        this.visitorCount = num5;
        this.ssvipCount = num6;
    }

    @Nullable
    public final String component1() {
        return this.rank1;
    }

    @Nullable
    public final Integer component10() {
        return this.vipCount;
    }

    @Nullable
    public final Integer component11() {
        return this.svipCount;
    }

    @Nullable
    public final Integer component12() {
        return this.visitorCount;
    }

    @Nullable
    public final Integer component13() {
        return this.ssvipCount;
    }

    @Nullable
    public final Integer component2() {
        return this.rank2;
    }

    @Nullable
    public final String component3() {
        return this.rank2Level;
    }

    @Nullable
    public final Boolean component4() {
        return this.vip;
    }

    public final int component5() {
        return this.vipType;
    }

    @Nullable
    public final Boolean component6() {
        return this.annualVip;
    }

    @Nullable
    public final Boolean component7() {
        return this.visitorEnable;
    }

    @Nullable
    public final Boolean component8() {
        return this.realAvatar;
    }

    @Nullable
    public final Integer component9() {
        return this.superLikeRemains;
    }

    @NotNull
    public final UserRankModel copy(@Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable Boolean bool, int i10, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable Integer num5, @Nullable Integer num6) {
        return new UserRankModel(str, num, str2, bool, i10, bool2, bool3, bool4, num2, num3, num4, num5, num6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserRankModel)) {
            return false;
        }
        UserRankModel userRankModel = (UserRankModel) obj;
        return s.d(this.rank1, userRankModel.rank1) && s.d(this.rank2, userRankModel.rank2) && s.d(this.rank2Level, userRankModel.rank2Level) && s.d(this.vip, userRankModel.vip) && this.vipType == userRankModel.vipType && s.d(this.annualVip, userRankModel.annualVip) && s.d(this.visitorEnable, userRankModel.visitorEnable) && s.d(this.realAvatar, userRankModel.realAvatar) && s.d(this.superLikeRemains, userRankModel.superLikeRemains) && s.d(this.vipCount, userRankModel.vipCount) && s.d(this.svipCount, userRankModel.svipCount) && s.d(this.visitorCount, userRankModel.visitorCount) && s.d(this.ssvipCount, userRankModel.ssvipCount);
    }

    @Nullable
    public final Boolean getAnnualVip() {
        return this.annualVip;
    }

    @Nullable
    public final String getRank1() {
        return this.rank1;
    }

    @Nullable
    public final Integer getRank2() {
        return this.rank2;
    }

    @Nullable
    public final String getRank2Level() {
        return this.rank2Level;
    }

    @Nullable
    public final Boolean getRealAvatar() {
        return this.realAvatar;
    }

    @Nullable
    public final Integer getSsvipCount() {
        return this.ssvipCount;
    }

    @Nullable
    public final Integer getSuperLikeRemains() {
        return this.superLikeRemains;
    }

    @Nullable
    public final Integer getSvipCount() {
        return this.svipCount;
    }

    @Nullable
    public final Boolean getVip() {
        return this.vip;
    }

    @Nullable
    public final Integer getVipCount() {
        return this.vipCount;
    }

    public final int getVipType() {
        return this.vipType;
    }

    @Nullable
    public final Integer getVisitorCount() {
        return this.visitorCount;
    }

    @Nullable
    public final Boolean getVisitorEnable() {
        return this.visitorEnable;
    }

    public int hashCode() {
        String str = this.rank1;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.rank2;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.rank2Level;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.vip;
        int hashCode4 = (((hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31) + this.vipType) * 31;
        Boolean bool2 = this.annualVip;
        int hashCode5 = (hashCode4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.visitorEnable;
        int hashCode6 = (hashCode5 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.realAvatar;
        int hashCode7 = (hashCode6 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Integer num2 = this.superLikeRemains;
        int hashCode8 = (hashCode7 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.vipCount;
        int hashCode9 = (hashCode8 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.svipCount;
        int hashCode10 = (hashCode9 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.visitorCount;
        int hashCode11 = (hashCode10 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.ssvipCount;
        return hashCode11 + (num6 != null ? num6.hashCode() : 0);
    }

    public final void setVisitorEnable(@Nullable Boolean bool) {
        this.visitorEnable = bool;
    }

    @NotNull
    public String toString() {
        String str = this.rank1;
        Integer num = this.rank2;
        String str2 = this.rank2Level;
        Boolean bool = this.vip;
        return "UserRankModel(rank1=" + str + ", rank2=" + ((Object) num) + ", rank2Level=" + str2 + ", vip=" + ((Object) bool) + ", vipType=" + this.vipType + ", annualVip=" + ((Object) this.annualVip) + ", visitorEnable=" + ((Object) this.visitorEnable) + ", realAvatar=" + ((Object) this.realAvatar) + ", superLikeRemains=" + ((Object) this.superLikeRemains) + ", vipCount=" + ((Object) this.vipCount) + ", svipCount=" + ((Object) this.svipCount) + ", visitorCount=" + ((Object) this.visitorCount) + ", ssvipCount=" + ((Object) this.ssvipCount) + ")";
    }
}
