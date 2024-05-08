package com.cupidapp.live.maskparty.model;

import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyChatRoomModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyChatRoomModel {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @Nullable
    private final String autoMsg;

    @Nullable
    private final String autoTip;
    private final int inputTimerSeconds;

    @Nullable
    private final Integer judgeTime;
    private final int playType;

    @Nullable
    private final Integer publicHomepageTime;

    @NotNull
    private final String roomId;

    @Nullable
    private final Integer score;

    @NotNull
    private final User targetUserInfo;

    /* compiled from: MaskPartyChatRoomModel.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(@Nullable Integer num) {
            if (num == null) {
                return true;
            }
            num.intValue();
            return num.intValue() < 100;
        }
    }

    public MaskPartyChatRoomModel(@NotNull String roomId, @Nullable Integer num, @Nullable String str, int i10, @Nullable String str2, @NotNull User targetUserInfo, int i11, @Nullable Integer num2, @Nullable Integer num3) {
        s.i(roomId, "roomId");
        s.i(targetUserInfo, "targetUserInfo");
        this.roomId = roomId;
        this.score = num;
        this.autoTip = str;
        this.playType = i10;
        this.autoMsg = str2;
        this.targetUserInfo = targetUserInfo;
        this.inputTimerSeconds = i11;
        this.judgeTime = num2;
        this.publicHomepageTime = num3;
    }

    @NotNull
    public final String component1() {
        return this.roomId;
    }

    @Nullable
    public final Integer component2() {
        return this.score;
    }

    @Nullable
    public final String component3() {
        return this.autoTip;
    }

    public final int component4() {
        return this.playType;
    }

    @Nullable
    public final String component5() {
        return this.autoMsg;
    }

    @NotNull
    public final User component6() {
        return this.targetUserInfo;
    }

    public final int component7() {
        return this.inputTimerSeconds;
    }

    @Nullable
    public final Integer component8() {
        return this.judgeTime;
    }

    @Nullable
    public final Integer component9() {
        return this.publicHomepageTime;
    }

    @NotNull
    public final MaskPartyChatRoomModel copy(@NotNull String roomId, @Nullable Integer num, @Nullable String str, int i10, @Nullable String str2, @NotNull User targetUserInfo, int i11, @Nullable Integer num2, @Nullable Integer num3) {
        s.i(roomId, "roomId");
        s.i(targetUserInfo, "targetUserInfo");
        return new MaskPartyChatRoomModel(roomId, num, str, i10, str2, targetUserInfo, i11, num2, num3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MaskPartyChatRoomModel)) {
            return false;
        }
        MaskPartyChatRoomModel maskPartyChatRoomModel = (MaskPartyChatRoomModel) obj;
        return s.d(this.roomId, maskPartyChatRoomModel.roomId) && s.d(this.score, maskPartyChatRoomModel.score) && s.d(this.autoTip, maskPartyChatRoomModel.autoTip) && this.playType == maskPartyChatRoomModel.playType && s.d(this.autoMsg, maskPartyChatRoomModel.autoMsg) && s.d(this.targetUserInfo, maskPartyChatRoomModel.targetUserInfo) && this.inputTimerSeconds == maskPartyChatRoomModel.inputTimerSeconds && s.d(this.judgeTime, maskPartyChatRoomModel.judgeTime) && s.d(this.publicHomepageTime, maskPartyChatRoomModel.publicHomepageTime);
    }

    @Nullable
    public final String getAutoMsg() {
        return this.autoMsg;
    }

    @Nullable
    public final String getAutoTip() {
        return this.autoTip;
    }

    public final int getInputTimerSeconds() {
        return this.inputTimerSeconds;
    }

    @Nullable
    public final Integer getJudgeTime() {
        return this.judgeTime;
    }

    public final int getPlayType() {
        return this.playType;
    }

    @Nullable
    public final Integer getPublicHomepageTime() {
        return this.publicHomepageTime;
    }

    @NotNull
    public final String getRoomId() {
        return this.roomId;
    }

    @Nullable
    public final Integer getScore() {
        return this.score;
    }

    @NotNull
    public final User getTargetUserInfo() {
        return this.targetUserInfo;
    }

    public int hashCode() {
        int hashCode = this.roomId.hashCode() * 31;
        Integer num = this.score;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.autoTip;
        int hashCode3 = (((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + this.playType) * 31;
        String str2 = this.autoMsg;
        int hashCode4 = (((((hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.targetUserInfo.hashCode()) * 31) + this.inputTimerSeconds) * 31;
        Integer num2 = this.judgeTime;
        int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.publicHomepageTime;
        return hashCode5 + (num3 != null ? num3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.roomId;
        Integer num = this.score;
        String str2 = this.autoTip;
        int i10 = this.playType;
        String str3 = this.autoMsg;
        User user = this.targetUserInfo;
        return "MaskPartyChatRoomModel(roomId=" + str + ", score=" + ((Object) num) + ", autoTip=" + str2 + ", playType=" + i10 + ", autoMsg=" + str3 + ", targetUserInfo=" + ((Object) user) + ", inputTimerSeconds=" + this.inputTimerSeconds + ", judgeTime=" + ((Object) this.judgeTime) + ", publicHomepageTime=" + ((Object) this.publicHomepageTime) + ")";
    }
}
