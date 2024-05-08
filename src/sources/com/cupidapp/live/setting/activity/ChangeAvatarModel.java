package com.cupidapp.live.setting.activity;

import com.cupidapp.live.base.sensorslog.SensorPosition;
import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChangeAvatarActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ChangeAvatarModel implements Serializable {

    @NotNull
    private final SensorPosition changeAvatarPosition;

    @Nullable
    private final String deleteAvatarId;
    private final boolean isVideoAvatar;

    @Nullable
    private final String uploadSuccessToastStr;

    public ChangeAvatarModel(@Nullable String str, @NotNull SensorPosition changeAvatarPosition, @Nullable String str2, boolean z10) {
        kotlin.jvm.internal.s.i(changeAvatarPosition, "changeAvatarPosition");
        this.deleteAvatarId = str;
        this.changeAvatarPosition = changeAvatarPosition;
        this.uploadSuccessToastStr = str2;
        this.isVideoAvatar = z10;
    }

    public static /* synthetic */ ChangeAvatarModel copy$default(ChangeAvatarModel changeAvatarModel, String str, SensorPosition sensorPosition, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = changeAvatarModel.deleteAvatarId;
        }
        if ((i10 & 2) != 0) {
            sensorPosition = changeAvatarModel.changeAvatarPosition;
        }
        if ((i10 & 4) != 0) {
            str2 = changeAvatarModel.uploadSuccessToastStr;
        }
        if ((i10 & 8) != 0) {
            z10 = changeAvatarModel.isVideoAvatar;
        }
        return changeAvatarModel.copy(str, sensorPosition, str2, z10);
    }

    @Nullable
    public final String component1() {
        return this.deleteAvatarId;
    }

    @NotNull
    public final SensorPosition component2() {
        return this.changeAvatarPosition;
    }

    @Nullable
    public final String component3() {
        return this.uploadSuccessToastStr;
    }

    public final boolean component4() {
        return this.isVideoAvatar;
    }

    @NotNull
    public final ChangeAvatarModel copy(@Nullable String str, @NotNull SensorPosition changeAvatarPosition, @Nullable String str2, boolean z10) {
        kotlin.jvm.internal.s.i(changeAvatarPosition, "changeAvatarPosition");
        return new ChangeAvatarModel(str, changeAvatarPosition, str2, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChangeAvatarModel)) {
            return false;
        }
        ChangeAvatarModel changeAvatarModel = (ChangeAvatarModel) obj;
        return kotlin.jvm.internal.s.d(this.deleteAvatarId, changeAvatarModel.deleteAvatarId) && this.changeAvatarPosition == changeAvatarModel.changeAvatarPosition && kotlin.jvm.internal.s.d(this.uploadSuccessToastStr, changeAvatarModel.uploadSuccessToastStr) && this.isVideoAvatar == changeAvatarModel.isVideoAvatar;
    }

    @NotNull
    public final SensorPosition getChangeAvatarPosition() {
        return this.changeAvatarPosition;
    }

    @Nullable
    public final String getDeleteAvatarId() {
        return this.deleteAvatarId;
    }

    @Nullable
    public final String getUploadSuccessToastStr() {
        return this.uploadSuccessToastStr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.deleteAvatarId;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.changeAvatarPosition.hashCode()) * 31;
        String str2 = this.uploadSuccessToastStr;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z10 = this.isVideoAvatar;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode2 + i10;
    }

    public final boolean isVideoAvatar() {
        return this.isVideoAvatar;
    }

    @NotNull
    public String toString() {
        String str = this.deleteAvatarId;
        SensorPosition sensorPosition = this.changeAvatarPosition;
        return "ChangeAvatarModel(deleteAvatarId=" + str + ", changeAvatarPosition=" + ((Object) sensorPosition) + ", uploadSuccessToastStr=" + this.uploadSuccessToastStr + ", isVideoAvatar=" + this.isVideoAvatar + ")";
    }
}
