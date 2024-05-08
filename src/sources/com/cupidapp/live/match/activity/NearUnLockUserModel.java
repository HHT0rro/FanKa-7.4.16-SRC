package com.cupidapp.live.match.activity;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NearGuideUnLockActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NearUnLockUserModel implements Serializable {

    @Nullable
    private final ImageModel avatar;

    @Nullable
    private final String distance;

    @Nullable
    private final Integer remainTime;

    @NotNull
    private final String userId;

    public NearUnLockUserModel(@Nullable ImageModel imageModel, @NotNull String userId, @Nullable String str, @Nullable Integer num) {
        kotlin.jvm.internal.s.i(userId, "userId");
        this.avatar = imageModel;
        this.userId = userId;
        this.distance = str;
        this.remainTime = num;
    }

    public static /* synthetic */ NearUnLockUserModel copy$default(NearUnLockUserModel nearUnLockUserModel, ImageModel imageModel, String str, String str2, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            imageModel = nearUnLockUserModel.avatar;
        }
        if ((i10 & 2) != 0) {
            str = nearUnLockUserModel.userId;
        }
        if ((i10 & 4) != 0) {
            str2 = nearUnLockUserModel.distance;
        }
        if ((i10 & 8) != 0) {
            num = nearUnLockUserModel.remainTime;
        }
        return nearUnLockUserModel.copy(imageModel, str, str2, num);
    }

    @Nullable
    public final ImageModel component1() {
        return this.avatar;
    }

    @NotNull
    public final String component2() {
        return this.userId;
    }

    @Nullable
    public final String component3() {
        return this.distance;
    }

    @Nullable
    public final Integer component4() {
        return this.remainTime;
    }

    @NotNull
    public final NearUnLockUserModel copy(@Nullable ImageModel imageModel, @NotNull String userId, @Nullable String str, @Nullable Integer num) {
        kotlin.jvm.internal.s.i(userId, "userId");
        return new NearUnLockUserModel(imageModel, userId, str, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NearUnLockUserModel)) {
            return false;
        }
        NearUnLockUserModel nearUnLockUserModel = (NearUnLockUserModel) obj;
        return kotlin.jvm.internal.s.d(this.avatar, nearUnLockUserModel.avatar) && kotlin.jvm.internal.s.d(this.userId, nearUnLockUserModel.userId) && kotlin.jvm.internal.s.d(this.distance, nearUnLockUserModel.distance) && kotlin.jvm.internal.s.d(this.remainTime, nearUnLockUserModel.remainTime);
    }

    @Nullable
    public final ImageModel getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final String getDistance() {
        return this.distance;
    }

    @Nullable
    public final Integer getRemainTime() {
        return this.remainTime;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        ImageModel imageModel = this.avatar;
        int hashCode = (((imageModel == null ? 0 : imageModel.hashCode()) * 31) + this.userId.hashCode()) * 31;
        String str = this.distance;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.remainTime;
        return hashCode2 + (num != null ? num.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        ImageModel imageModel = this.avatar;
        return "NearUnLockUserModel(avatar=" + ((Object) imageModel) + ", userId=" + this.userId + ", distance=" + this.distance + ", remainTime=" + ((Object) this.remainTime) + ")";
    }
}
