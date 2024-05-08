package com.cupidapp.live.setting.model;

import com.cupidapp.live.profile.logic.c;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PrivacySettingDataResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PrivacySettingDataResult {
    private boolean advertising;
    private boolean aiGraphHide;

    @Nullable
    private String distancePopInfo;
    private boolean expireTextRemind;

    @Nullable
    private Integer footmarkDelCount;

    @Nullable
    private Integer footmarkDelPerMonth;
    private boolean giftExpirationReminder;
    private boolean hidden;
    private boolean hiddenActive;
    private boolean hiddenFootmark;
    private boolean hideBalanceLevel;

    @Nullable
    private String hidePopInfo;

    @Nullable
    private Integer matchExcludeDistanceKm;
    private boolean notInNearbyForBoot;

    @Nullable
    private Boolean openPersonalizedRecommendation;
    private boolean stealthMessage;

    @Nullable
    private Boolean upgradeFlag;
    private boolean vipIconHide;

    public PrivacySettingDataResult(@Nullable Integer num, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, @Nullable Integer num2, @Nullable Integer num3, boolean z16, boolean z17, @Nullable Boolean bool, @Nullable String str, @Nullable String str2, @Nullable Boolean bool2, boolean z18, boolean z19, boolean z20) {
        this.matchExcludeDistanceKm = num;
        this.hiddenActive = z10;
        this.aiGraphHide = z11;
        this.hidden = z12;
        this.hideBalanceLevel = z13;
        this.advertising = z14;
        this.hiddenFootmark = z15;
        this.footmarkDelCount = num2;
        this.footmarkDelPerMonth = num3;
        this.stealthMessage = z16;
        this.vipIconHide = z17;
        this.upgradeFlag = bool;
        this.hidePopInfo = str;
        this.distancePopInfo = str2;
        this.openPersonalizedRecommendation = bool2;
        this.giftExpirationReminder = z18;
        this.expireTextRemind = z19;
        this.notInNearbyForBoot = z20;
    }

    @Nullable
    public final Integer component1() {
        return this.matchExcludeDistanceKm;
    }

    public final boolean component10() {
        return this.stealthMessage;
    }

    public final boolean component11() {
        return this.vipIconHide;
    }

    @Nullable
    public final Boolean component12() {
        return this.upgradeFlag;
    }

    @Nullable
    public final String component13() {
        return this.hidePopInfo;
    }

    @Nullable
    public final String component14() {
        return this.distancePopInfo;
    }

    @Nullable
    public final Boolean component15() {
        return this.openPersonalizedRecommendation;
    }

    public final boolean component16() {
        return this.giftExpirationReminder;
    }

    public final boolean component17() {
        return this.expireTextRemind;
    }

    public final boolean component18() {
        return this.notInNearbyForBoot;
    }

    public final boolean component2() {
        return this.hiddenActive;
    }

    public final boolean component3() {
        return this.aiGraphHide;
    }

    public final boolean component4() {
        return this.hidden;
    }

    public final boolean component5() {
        return this.hideBalanceLevel;
    }

    public final boolean component6() {
        return this.advertising;
    }

    public final boolean component7() {
        return this.hiddenFootmark;
    }

    @Nullable
    public final Integer component8() {
        return this.footmarkDelCount;
    }

    @Nullable
    public final Integer component9() {
        return this.footmarkDelPerMonth;
    }

    @NotNull
    public final PrivacySettingDataResult copy(@Nullable Integer num, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, @Nullable Integer num2, @Nullable Integer num3, boolean z16, boolean z17, @Nullable Boolean bool, @Nullable String str, @Nullable String str2, @Nullable Boolean bool2, boolean z18, boolean z19, boolean z20) {
        return new PrivacySettingDataResult(num, z10, z11, z12, z13, z14, z15, num2, num3, z16, z17, bool, str, str2, bool2, z18, z19, z20);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PrivacySettingDataResult)) {
            return false;
        }
        PrivacySettingDataResult privacySettingDataResult = (PrivacySettingDataResult) obj;
        return s.d(this.matchExcludeDistanceKm, privacySettingDataResult.matchExcludeDistanceKm) && this.hiddenActive == privacySettingDataResult.hiddenActive && this.aiGraphHide == privacySettingDataResult.aiGraphHide && this.hidden == privacySettingDataResult.hidden && this.hideBalanceLevel == privacySettingDataResult.hideBalanceLevel && this.advertising == privacySettingDataResult.advertising && this.hiddenFootmark == privacySettingDataResult.hiddenFootmark && s.d(this.footmarkDelCount, privacySettingDataResult.footmarkDelCount) && s.d(this.footmarkDelPerMonth, privacySettingDataResult.footmarkDelPerMonth) && this.stealthMessage == privacySettingDataResult.stealthMessage && this.vipIconHide == privacySettingDataResult.vipIconHide && s.d(this.upgradeFlag, privacySettingDataResult.upgradeFlag) && s.d(this.hidePopInfo, privacySettingDataResult.hidePopInfo) && s.d(this.distancePopInfo, privacySettingDataResult.distancePopInfo) && s.d(this.openPersonalizedRecommendation, privacySettingDataResult.openPersonalizedRecommendation) && this.giftExpirationReminder == privacySettingDataResult.giftExpirationReminder && this.expireTextRemind == privacySettingDataResult.expireTextRemind && this.notInNearbyForBoot == privacySettingDataResult.notInNearbyForBoot;
    }

    public final boolean getAdvertising() {
        return this.advertising;
    }

    public final boolean getAiGraphHide() {
        return this.aiGraphHide;
    }

    @Nullable
    public final String getDistancePopInfo() {
        return this.distancePopInfo;
    }

    public final boolean getExpireTextRemind() {
        return this.expireTextRemind;
    }

    @Nullable
    public final Integer getFootmarkDelCount() {
        return this.footmarkDelCount;
    }

    @Nullable
    public final Integer getFootmarkDelPerMonth() {
        return this.footmarkDelPerMonth;
    }

    public final boolean getGiftExpirationReminder() {
        return this.giftExpirationReminder;
    }

    public final boolean getHidden() {
        return this.hidden;
    }

    public final boolean getHiddenActive() {
        return this.hiddenActive;
    }

    public final boolean getHiddenFootmark() {
        return this.hiddenFootmark;
    }

    public final boolean getHideBalanceLevel() {
        return this.hideBalanceLevel;
    }

    @Nullable
    public final String getHidePopInfo() {
        return this.hidePopInfo;
    }

    @Nullable
    public final Integer getMatchExcludeDistanceKm() {
        return this.matchExcludeDistanceKm;
    }

    public final boolean getNotInNearbyForBoot() {
        return this.notInNearbyForBoot;
    }

    @Nullable
    public final Boolean getOpenPersonalizedRecommendation() {
        return this.openPersonalizedRecommendation;
    }

    public final boolean getStealthMessage() {
        return this.stealthMessage;
    }

    @Nullable
    public final Boolean getUpgradeFlag() {
        return this.upgradeFlag;
    }

    public final boolean getVipIconHide() {
        return this.vipIconHide;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Integer num = this.matchExcludeDistanceKm;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        boolean z10 = this.hiddenActive;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode + i10) * 31;
        boolean z11 = this.aiGraphHide;
        int i12 = z11;
        if (z11 != 0) {
            i12 = 1;
        }
        int i13 = (i11 + i12) * 31;
        boolean z12 = this.hidden;
        int i14 = z12;
        if (z12 != 0) {
            i14 = 1;
        }
        int i15 = (i13 + i14) * 31;
        boolean z13 = this.hideBalanceLevel;
        int i16 = z13;
        if (z13 != 0) {
            i16 = 1;
        }
        int i17 = (i15 + i16) * 31;
        boolean z14 = this.advertising;
        int i18 = z14;
        if (z14 != 0) {
            i18 = 1;
        }
        int i19 = (i17 + i18) * 31;
        boolean z15 = this.hiddenFootmark;
        int i20 = z15;
        if (z15 != 0) {
            i20 = 1;
        }
        int i21 = (i19 + i20) * 31;
        Integer num2 = this.footmarkDelCount;
        int hashCode2 = (i21 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.footmarkDelPerMonth;
        int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        boolean z16 = this.stealthMessage;
        int i22 = z16;
        if (z16 != 0) {
            i22 = 1;
        }
        int i23 = (hashCode3 + i22) * 31;
        boolean z17 = this.vipIconHide;
        int i24 = z17;
        if (z17 != 0) {
            i24 = 1;
        }
        int i25 = (i23 + i24) * 31;
        Boolean bool = this.upgradeFlag;
        int hashCode4 = (i25 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.hidePopInfo;
        int hashCode5 = (hashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.distancePopInfo;
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool2 = this.openPersonalizedRecommendation;
        int hashCode7 = (hashCode6 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        boolean z18 = this.giftExpirationReminder;
        int i26 = z18;
        if (z18 != 0) {
            i26 = 1;
        }
        int i27 = (hashCode7 + i26) * 31;
        boolean z19 = this.expireTextRemind;
        int i28 = z19;
        if (z19 != 0) {
            i28 = 1;
        }
        int i29 = (i27 + i28) * 31;
        boolean z20 = this.notInNearbyForBoot;
        return i29 + (z20 ? 1 : z20 ? 1 : 0);
    }

    public final boolean isShowVipIcon() {
        return c.f17839a.f() && !this.vipIconHide;
    }

    public final void setAdvertising(boolean z10) {
        this.advertising = z10;
    }

    public final void setAiGraphHide(boolean z10) {
        this.aiGraphHide = z10;
    }

    public final void setDistancePopInfo(@Nullable String str) {
        this.distancePopInfo = str;
    }

    public final void setExpireTextRemind(boolean z10) {
        this.expireTextRemind = z10;
    }

    public final void setFootmarkDelCount(@Nullable Integer num) {
        this.footmarkDelCount = num;
    }

    public final void setFootmarkDelPerMonth(@Nullable Integer num) {
        this.footmarkDelPerMonth = num;
    }

    public final void setGiftExpirationReminder(boolean z10) {
        this.giftExpirationReminder = z10;
    }

    public final void setHidden(boolean z10) {
        this.hidden = z10;
    }

    public final void setHiddenActive(boolean z10) {
        this.hiddenActive = z10;
    }

    public final void setHiddenFootmark(boolean z10) {
        this.hiddenFootmark = z10;
    }

    public final void setHideBalanceLevel(boolean z10) {
        this.hideBalanceLevel = z10;
    }

    public final void setHidePopInfo(@Nullable String str) {
        this.hidePopInfo = str;
    }

    public final void setMatchExcludeDistanceKm(@Nullable Integer num) {
        this.matchExcludeDistanceKm = num;
    }

    public final void setNotInNearbyForBoot(boolean z10) {
        this.notInNearbyForBoot = z10;
    }

    public final void setOpenPersonalizedRecommendation(@Nullable Boolean bool) {
        this.openPersonalizedRecommendation = bool;
    }

    public final void setStealthMessage(boolean z10) {
        this.stealthMessage = z10;
    }

    public final void setUpgradeFlag(@Nullable Boolean bool) {
        this.upgradeFlag = bool;
    }

    public final void setVipIconHide(boolean z10) {
        this.vipIconHide = z10;
    }

    @NotNull
    public String toString() {
        Integer num = this.matchExcludeDistanceKm;
        boolean z10 = this.hiddenActive;
        boolean z11 = this.aiGraphHide;
        boolean z12 = this.hidden;
        boolean z13 = this.hideBalanceLevel;
        boolean z14 = this.advertising;
        boolean z15 = this.hiddenFootmark;
        Integer num2 = this.footmarkDelCount;
        Integer num3 = this.footmarkDelPerMonth;
        boolean z16 = this.stealthMessage;
        boolean z17 = this.vipIconHide;
        Boolean bool = this.upgradeFlag;
        String str = this.hidePopInfo;
        String str2 = this.distancePopInfo;
        Boolean bool2 = this.openPersonalizedRecommendation;
        return "PrivacySettingDataResult(matchExcludeDistanceKm=" + ((Object) num) + ", hiddenActive=" + z10 + ", aiGraphHide=" + z11 + ", hidden=" + z12 + ", hideBalanceLevel=" + z13 + ", advertising=" + z14 + ", hiddenFootmark=" + z15 + ", footmarkDelCount=" + ((Object) num2) + ", footmarkDelPerMonth=" + ((Object) num3) + ", stealthMessage=" + z16 + ", vipIconHide=" + z17 + ", upgradeFlag=" + ((Object) bool) + ", hidePopInfo=" + str + ", distancePopInfo=" + str2 + ", openPersonalizedRecommendation=" + ((Object) bool2) + ", giftExpirationReminder=" + this.giftExpirationReminder + ", expireTextRemind=" + this.expireTextRemind + ", notInNearbyForBoot=" + this.notInNearbyForBoot + ")";
    }

    public /* synthetic */ PrivacySettingDataResult(Integer num, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, Integer num2, Integer num3, boolean z16, boolean z17, Boolean bool, String str, String str2, Boolean bool2, boolean z18, boolean z19, boolean z20, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, (i10 & 2) != 0 ? false : z10, (i10 & 4) != 0 ? false : z11, (i10 & 8) != 0 ? false : z12, (i10 & 16) != 0 ? false : z13, (i10 & 32) != 0 ? true : z14, (i10 & 64) != 0 ? false : z15, (i10 & 128) != 0 ? null : num2, (i10 & 256) != 0 ? null : num3, (i10 & 512) != 0 ? false : z16, (i10 & 1024) != 0 ? false : z17, (i10 & 2048) != 0 ? Boolean.TRUE : bool, (i10 & 4096) != 0 ? null : str, (i10 & 8192) != 0 ? null : str2, (i10 & 16384) == 0 ? bool2 : null, (32768 & i10) != 0 ? false : z18, (i10 & 65536) != 0 ? false : z19, (i10 & 131072) != 0 ? false : z20);
    }
}
