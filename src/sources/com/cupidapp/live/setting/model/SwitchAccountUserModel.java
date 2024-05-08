package com.cupidapp.live.setting.model;

import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SwitchAccountModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SwitchAccountUserModel implements Serializable {

    @NotNull
    private final ImageModel avatar;

    @Nullable
    private final String infoMsg;
    private boolean isRemoveState;

    @Nullable
    private final String jumpUrl;

    @Nullable
    private final String noticeMsg;

    @Nullable
    private SensorPosition sensorPosition;
    private final int status;

    @Nullable
    private final Boolean used;

    @NotNull
    private final String userId;

    @NotNull
    private final String userName;

    public SwitchAccountUserModel(@NotNull String userId, @NotNull String userName, @NotNull ImageModel avatar, @Nullable String str, @Nullable String str2, @Nullable Boolean bool, int i10, @Nullable String str3, boolean z10, @Nullable SensorPosition sensorPosition) {
        s.i(userId, "userId");
        s.i(userName, "userName");
        s.i(avatar, "avatar");
        this.userId = userId;
        this.userName = userName;
        this.avatar = avatar;
        this.noticeMsg = str;
        this.infoMsg = str2;
        this.used = bool;
        this.status = i10;
        this.jumpUrl = str3;
        this.isRemoveState = z10;
        this.sensorPosition = sensorPosition;
    }

    @NotNull
    public final String component1() {
        return this.userId;
    }

    @Nullable
    public final SensorPosition component10() {
        return this.sensorPosition;
    }

    @NotNull
    public final String component2() {
        return this.userName;
    }

    @NotNull
    public final ImageModel component3() {
        return this.avatar;
    }

    @Nullable
    public final String component4() {
        return this.noticeMsg;
    }

    @Nullable
    public final String component5() {
        return this.infoMsg;
    }

    @Nullable
    public final Boolean component6() {
        return this.used;
    }

    public final int component7() {
        return this.status;
    }

    @Nullable
    public final String component8() {
        return this.jumpUrl;
    }

    public final boolean component9() {
        return this.isRemoveState;
    }

    @NotNull
    public final SwitchAccountUserModel copy(@NotNull String userId, @NotNull String userName, @NotNull ImageModel avatar, @Nullable String str, @Nullable String str2, @Nullable Boolean bool, int i10, @Nullable String str3, boolean z10, @Nullable SensorPosition sensorPosition) {
        s.i(userId, "userId");
        s.i(userName, "userName");
        s.i(avatar, "avatar");
        return new SwitchAccountUserModel(userId, userName, avatar, str, str2, bool, i10, str3, z10, sensorPosition);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwitchAccountUserModel)) {
            return false;
        }
        SwitchAccountUserModel switchAccountUserModel = (SwitchAccountUserModel) obj;
        return s.d(this.userId, switchAccountUserModel.userId) && s.d(this.userName, switchAccountUserModel.userName) && s.d(this.avatar, switchAccountUserModel.avatar) && s.d(this.noticeMsg, switchAccountUserModel.noticeMsg) && s.d(this.infoMsg, switchAccountUserModel.infoMsg) && s.d(this.used, switchAccountUserModel.used) && this.status == switchAccountUserModel.status && s.d(this.jumpUrl, switchAccountUserModel.jumpUrl) && this.isRemoveState == switchAccountUserModel.isRemoveState && this.sensorPosition == switchAccountUserModel.sensorPosition;
    }

    @NotNull
    public final ImageModel getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final String getInfoMsg() {
        return this.infoMsg;
    }

    @Nullable
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @Nullable
    public final String getNoticeMsg() {
        return this.noticeMsg;
    }

    @Nullable
    public final SensorPosition getSensorPosition() {
        return this.sensorPosition;
    }

    public final int getStatus() {
        return this.status;
    }

    @Nullable
    public final Boolean getUsed() {
        return this.used;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    @NotNull
    public final String getUserName() {
        return this.userName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.userId.hashCode() * 31) + this.userName.hashCode()) * 31) + this.avatar.hashCode()) * 31;
        String str = this.noticeMsg;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.infoMsg;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.used;
        int hashCode4 = (((hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31) + this.status) * 31;
        String str3 = this.jumpUrl;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        boolean z10 = this.isRemoveState;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode5 + i10) * 31;
        SensorPosition sensorPosition = this.sensorPosition;
        return i11 + (sensorPosition != null ? sensorPosition.hashCode() : 0);
    }

    public final boolean isRemoveState() {
        return this.isRemoveState;
    }

    public final void setRemoveState(boolean z10) {
        this.isRemoveState = z10;
    }

    public final void setSensorPosition(@Nullable SensorPosition sensorPosition) {
        this.sensorPosition = sensorPosition;
    }

    @NotNull
    public String toString() {
        String str = this.userId;
        String str2 = this.userName;
        ImageModel imageModel = this.avatar;
        String str3 = this.noticeMsg;
        String str4 = this.infoMsg;
        Boolean bool = this.used;
        return "SwitchAccountUserModel(userId=" + str + ", userName=" + str2 + ", avatar=" + ((Object) imageModel) + ", noticeMsg=" + str3 + ", infoMsg=" + str4 + ", used=" + ((Object) bool) + ", status=" + this.status + ", jumpUrl=" + this.jumpUrl + ", isRemoveState=" + this.isRemoveState + ", sensorPosition=" + ((Object) this.sensorPosition) + ")";
    }
}
