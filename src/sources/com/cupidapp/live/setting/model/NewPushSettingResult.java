package com.cupidapp.live.setting.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NewPushSettingResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NewPushSettingResult {
    private boolean pushAloha;
    private boolean pushAlohaSound;
    private boolean pushEnable;

    @Nullable
    private Long pushEndTime;
    private boolean pushGreet;
    private boolean pushHideDetail;
    private boolean pushInbox;
    private boolean pushNewMatch;

    @NotNull
    private PushPauseOptionModel pushPauseOption;

    @NotNull
    private String pushPauseTemp;

    @Nullable
    private Integer pushPostAtV2;

    @Nullable
    private Integer pushPostCommentV2;

    @Nullable
    private Integer pushPostLikeV2;

    @Nullable
    private Integer pushPostPublishV2;
    private boolean pushPostTag;
    private boolean pushSafeMode;
    private boolean pushSound;

    @Nullable
    private Long pushStartTime;
    private boolean pushVibration;

    public NewPushSettingResult(boolean z10, @NotNull String pushPauseTemp, @NotNull PushPauseOptionModel pushPauseOption, @Nullable Long l10, @Nullable Long l11, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19, boolean z20, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4) {
        s.i(pushPauseTemp, "pushPauseTemp");
        s.i(pushPauseOption, "pushPauseOption");
        this.pushEnable = z10;
        this.pushPauseTemp = pushPauseTemp;
        this.pushPauseOption = pushPauseOption;
        this.pushStartTime = l10;
        this.pushEndTime = l11;
        this.pushAlohaSound = z11;
        this.pushSafeMode = z12;
        this.pushHideDetail = z13;
        this.pushGreet = z14;
        this.pushInbox = z15;
        this.pushAloha = z16;
        this.pushNewMatch = z17;
        this.pushPostTag = z18;
        this.pushSound = z19;
        this.pushVibration = z20;
        this.pushPostLikeV2 = num;
        this.pushPostCommentV2 = num2;
        this.pushPostAtV2 = num3;
        this.pushPostPublishV2 = num4;
    }

    public final boolean component1() {
        return this.pushEnable;
    }

    public final boolean component10() {
        return this.pushInbox;
    }

    public final boolean component11() {
        return this.pushAloha;
    }

    public final boolean component12() {
        return this.pushNewMatch;
    }

    public final boolean component13() {
        return this.pushPostTag;
    }

    public final boolean component14() {
        return this.pushSound;
    }

    public final boolean component15() {
        return this.pushVibration;
    }

    @Nullable
    public final Integer component16() {
        return this.pushPostLikeV2;
    }

    @Nullable
    public final Integer component17() {
        return this.pushPostCommentV2;
    }

    @Nullable
    public final Integer component18() {
        return this.pushPostAtV2;
    }

    @Nullable
    public final Integer component19() {
        return this.pushPostPublishV2;
    }

    @NotNull
    public final String component2() {
        return this.pushPauseTemp;
    }

    @NotNull
    public final PushPauseOptionModel component3() {
        return this.pushPauseOption;
    }

    @Nullable
    public final Long component4() {
        return this.pushStartTime;
    }

    @Nullable
    public final Long component5() {
        return this.pushEndTime;
    }

    public final boolean component6() {
        return this.pushAlohaSound;
    }

    public final boolean component7() {
        return this.pushSafeMode;
    }

    public final boolean component8() {
        return this.pushHideDetail;
    }

    public final boolean component9() {
        return this.pushGreet;
    }

    @NotNull
    public final NewPushSettingResult copy(boolean z10, @NotNull String pushPauseTemp, @NotNull PushPauseOptionModel pushPauseOption, @Nullable Long l10, @Nullable Long l11, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19, boolean z20, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4) {
        s.i(pushPauseTemp, "pushPauseTemp");
        s.i(pushPauseOption, "pushPauseOption");
        return new NewPushSettingResult(z10, pushPauseTemp, pushPauseOption, l10, l11, z11, z12, z13, z14, z15, z16, z17, z18, z19, z20, num, num2, num3, num4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NewPushSettingResult)) {
            return false;
        }
        NewPushSettingResult newPushSettingResult = (NewPushSettingResult) obj;
        return this.pushEnable == newPushSettingResult.pushEnable && s.d(this.pushPauseTemp, newPushSettingResult.pushPauseTemp) && s.d(this.pushPauseOption, newPushSettingResult.pushPauseOption) && s.d(this.pushStartTime, newPushSettingResult.pushStartTime) && s.d(this.pushEndTime, newPushSettingResult.pushEndTime) && this.pushAlohaSound == newPushSettingResult.pushAlohaSound && this.pushSafeMode == newPushSettingResult.pushSafeMode && this.pushHideDetail == newPushSettingResult.pushHideDetail && this.pushGreet == newPushSettingResult.pushGreet && this.pushInbox == newPushSettingResult.pushInbox && this.pushAloha == newPushSettingResult.pushAloha && this.pushNewMatch == newPushSettingResult.pushNewMatch && this.pushPostTag == newPushSettingResult.pushPostTag && this.pushSound == newPushSettingResult.pushSound && this.pushVibration == newPushSettingResult.pushVibration && s.d(this.pushPostLikeV2, newPushSettingResult.pushPostLikeV2) && s.d(this.pushPostCommentV2, newPushSettingResult.pushPostCommentV2) && s.d(this.pushPostAtV2, newPushSettingResult.pushPostAtV2) && s.d(this.pushPostPublishV2, newPushSettingResult.pushPostPublishV2);
    }

    public final boolean getPushAloha() {
        return this.pushAloha;
    }

    public final boolean getPushAlohaSound() {
        return this.pushAlohaSound;
    }

    public final boolean getPushEnable() {
        return this.pushEnable;
    }

    @Nullable
    public final Long getPushEndTime() {
        return this.pushEndTime;
    }

    public final boolean getPushGreet() {
        return this.pushGreet;
    }

    public final boolean getPushHideDetail() {
        return this.pushHideDetail;
    }

    public final boolean getPushInbox() {
        return this.pushInbox;
    }

    public final boolean getPushNewMatch() {
        return this.pushNewMatch;
    }

    @NotNull
    public final PushPauseOptionModel getPushPauseOption() {
        return this.pushPauseOption;
    }

    @NotNull
    public final String getPushPauseTemp() {
        return this.pushPauseTemp;
    }

    @Nullable
    public final Integer getPushPostAtV2() {
        return this.pushPostAtV2;
    }

    @Nullable
    public final Integer getPushPostCommentV2() {
        return this.pushPostCommentV2;
    }

    @Nullable
    public final Integer getPushPostLikeV2() {
        return this.pushPostLikeV2;
    }

    @Nullable
    public final Integer getPushPostPublishV2() {
        return this.pushPostPublishV2;
    }

    public final boolean getPushPostTag() {
        return this.pushPostTag;
    }

    public final boolean getPushSafeMode() {
        return this.pushSafeMode;
    }

    public final boolean getPushSound() {
        return this.pushSound;
    }

    @Nullable
    public final Long getPushStartTime() {
        return this.pushStartTime;
    }

    public final boolean getPushVibration() {
        return this.pushVibration;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r2v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v16, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v18, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v20, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v22, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v24, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v26, types: [boolean] */
    public int hashCode() {
        boolean z10 = this.pushEnable;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int hashCode = ((((r02 * 31) + this.pushPauseTemp.hashCode()) * 31) + this.pushPauseOption.hashCode()) * 31;
        Long l10 = this.pushStartTime;
        int hashCode2 = (hashCode + (l10 == null ? 0 : l10.hashCode())) * 31;
        Long l11 = this.pushEndTime;
        int hashCode3 = (hashCode2 + (l11 == null ? 0 : l11.hashCode())) * 31;
        ?? r22 = this.pushAlohaSound;
        int i10 = r22;
        if (r22 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode3 + i10) * 31;
        ?? r23 = this.pushSafeMode;
        int i12 = r23;
        if (r23 != 0) {
            i12 = 1;
        }
        int i13 = (i11 + i12) * 31;
        ?? r24 = this.pushHideDetail;
        int i14 = r24;
        if (r24 != 0) {
            i14 = 1;
        }
        int i15 = (i13 + i14) * 31;
        ?? r25 = this.pushGreet;
        int i16 = r25;
        if (r25 != 0) {
            i16 = 1;
        }
        int i17 = (i15 + i16) * 31;
        ?? r26 = this.pushInbox;
        int i18 = r26;
        if (r26 != 0) {
            i18 = 1;
        }
        int i19 = (i17 + i18) * 31;
        ?? r27 = this.pushAloha;
        int i20 = r27;
        if (r27 != 0) {
            i20 = 1;
        }
        int i21 = (i19 + i20) * 31;
        ?? r28 = this.pushNewMatch;
        int i22 = r28;
        if (r28 != 0) {
            i22 = 1;
        }
        int i23 = (i21 + i22) * 31;
        ?? r29 = this.pushPostTag;
        int i24 = r29;
        if (r29 != 0) {
            i24 = 1;
        }
        int i25 = (i23 + i24) * 31;
        ?? r210 = this.pushSound;
        int i26 = r210;
        if (r210 != 0) {
            i26 = 1;
        }
        int i27 = (i25 + i26) * 31;
        boolean z11 = this.pushVibration;
        int i28 = (i27 + (z11 ? 1 : z11 ? 1 : 0)) * 31;
        Integer num = this.pushPostLikeV2;
        int hashCode4 = (i28 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.pushPostCommentV2;
        int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.pushPostAtV2;
        int hashCode6 = (hashCode5 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.pushPostPublishV2;
        return hashCode6 + (num4 != null ? num4.hashCode() : 0);
    }

    public final void setPushAloha(boolean z10) {
        this.pushAloha = z10;
    }

    public final void setPushAlohaSound(boolean z10) {
        this.pushAlohaSound = z10;
    }

    public final void setPushEnable(boolean z10) {
        this.pushEnable = z10;
    }

    public final void setPushEndTime(@Nullable Long l10) {
        this.pushEndTime = l10;
    }

    public final void setPushGreet(boolean z10) {
        this.pushGreet = z10;
    }

    public final void setPushHideDetail(boolean z10) {
        this.pushHideDetail = z10;
    }

    public final void setPushInbox(boolean z10) {
        this.pushInbox = z10;
    }

    public final void setPushNewMatch(boolean z10) {
        this.pushNewMatch = z10;
    }

    public final void setPushPauseOption(@NotNull PushPauseOptionModel pushPauseOptionModel) {
        s.i(pushPauseOptionModel, "<set-?>");
        this.pushPauseOption = pushPauseOptionModel;
    }

    public final void setPushPauseTemp(@NotNull String str) {
        s.i(str, "<set-?>");
        this.pushPauseTemp = str;
    }

    public final void setPushPostAtV2(@Nullable Integer num) {
        this.pushPostAtV2 = num;
    }

    public final void setPushPostCommentV2(@Nullable Integer num) {
        this.pushPostCommentV2 = num;
    }

    public final void setPushPostLikeV2(@Nullable Integer num) {
        this.pushPostLikeV2 = num;
    }

    public final void setPushPostPublishV2(@Nullable Integer num) {
        this.pushPostPublishV2 = num;
    }

    public final void setPushPostTag(boolean z10) {
        this.pushPostTag = z10;
    }

    public final void setPushSafeMode(boolean z10) {
        this.pushSafeMode = z10;
    }

    public final void setPushSound(boolean z10) {
        this.pushSound = z10;
    }

    public final void setPushStartTime(@Nullable Long l10) {
        this.pushStartTime = l10;
    }

    public final void setPushVibration(boolean z10) {
        this.pushVibration = z10;
    }

    @NotNull
    public String toString() {
        boolean z10 = this.pushEnable;
        String str = this.pushPauseTemp;
        PushPauseOptionModel pushPauseOptionModel = this.pushPauseOption;
        Long l10 = this.pushStartTime;
        Long l11 = this.pushEndTime;
        return "NewPushSettingResult(pushEnable=" + z10 + ", pushPauseTemp=" + str + ", pushPauseOption=" + ((Object) pushPauseOptionModel) + ", pushStartTime=" + ((Object) l10) + ", pushEndTime=" + ((Object) l11) + ", pushAlohaSound=" + this.pushAlohaSound + ", pushSafeMode=" + this.pushSafeMode + ", pushHideDetail=" + this.pushHideDetail + ", pushGreet=" + this.pushGreet + ", pushInbox=" + this.pushInbox + ", pushAloha=" + this.pushAloha + ", pushNewMatch=" + this.pushNewMatch + ", pushPostTag=" + this.pushPostTag + ", pushSound=" + this.pushSound + ", pushVibration=" + this.pushVibration + ", pushPostLikeV2=" + ((Object) this.pushPostLikeV2) + ", pushPostCommentV2=" + ((Object) this.pushPostCommentV2) + ", pushPostAtV2=" + ((Object) this.pushPostAtV2) + ", pushPostPublishV2=" + ((Object) this.pushPostPublishV2) + ")";
    }

    public /* synthetic */ NewPushSettingResult(boolean z10, String str, PushPauseOptionModel pushPauseOptionModel, Long l10, Long l11, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19, boolean z20, Integer num, Integer num2, Integer num3, Integer num4, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? false : z10, str, pushPauseOptionModel, (i10 & 8) != 0 ? null : l10, (i10 & 16) != 0 ? null : l11, (i10 & 32) != 0 ? false : z11, (i10 & 64) != 0 ? false : z12, (i10 & 128) != 0 ? false : z13, (i10 & 256) != 0 ? false : z14, (i10 & 512) != 0 ? false : z15, (i10 & 1024) != 0 ? false : z16, (i10 & 2048) != 0 ? false : z17, (i10 & 4096) != 0 ? false : z18, (i10 & 8192) != 0 ? false : z19, (i10 & 16384) != 0 ? false : z20, (32768 & i10) != 0 ? 0 : num, (65536 & i10) != 0 ? 0 : num2, (131072 & i10) != 0 ? 0 : num3, (i10 & 262144) != 0 ? 0 : num4);
    }
}
