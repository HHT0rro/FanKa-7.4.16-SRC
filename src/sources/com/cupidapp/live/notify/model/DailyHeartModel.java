package com.cupidapp.live.notify.model;

import com.cupidapp.live.match.model.NearbyUserModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DailyHeartModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class DailyHeartModel {

    @NotNull
    private final NearbyUserModel fromUser;
    private boolean mosaic;

    @Nullable
    private String remainTime;

    public DailyHeartModel(@NotNull NearbyUserModel fromUser, boolean z10, @Nullable String str) {
        s.i(fromUser, "fromUser");
        this.fromUser = fromUser;
        this.mosaic = z10;
        this.remainTime = str;
    }

    public static /* synthetic */ DailyHeartModel copy$default(DailyHeartModel dailyHeartModel, NearbyUserModel nearbyUserModel, boolean z10, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            nearbyUserModel = dailyHeartModel.fromUser;
        }
        if ((i10 & 2) != 0) {
            z10 = dailyHeartModel.mosaic;
        }
        if ((i10 & 4) != 0) {
            str = dailyHeartModel.remainTime;
        }
        return dailyHeartModel.copy(nearbyUserModel, z10, str);
    }

    @NotNull
    public final NearbyUserModel component1() {
        return this.fromUser;
    }

    public final boolean component2() {
        return this.mosaic;
    }

    @Nullable
    public final String component3() {
        return this.remainTime;
    }

    @NotNull
    public final DailyHeartModel copy(@NotNull NearbyUserModel fromUser, boolean z10, @Nullable String str) {
        s.i(fromUser, "fromUser");
        return new DailyHeartModel(fromUser, z10, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DailyHeartModel)) {
            return false;
        }
        DailyHeartModel dailyHeartModel = (DailyHeartModel) obj;
        return s.d(this.fromUser, dailyHeartModel.fromUser) && this.mosaic == dailyHeartModel.mosaic && s.d(this.remainTime, dailyHeartModel.remainTime);
    }

    @NotNull
    public final NearbyUserModel getFromUser() {
        return this.fromUser;
    }

    public final boolean getMosaic() {
        return this.mosaic;
    }

    @Nullable
    public final String getRemainTime() {
        return this.remainTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.fromUser.hashCode() * 31;
        boolean z10 = this.mosaic;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode + i10) * 31;
        String str = this.remainTime;
        return i11 + (str == null ? 0 : str.hashCode());
    }

    public final void setMosaic(boolean z10) {
        this.mosaic = z10;
    }

    public final void setRemainTime(@Nullable String str) {
        this.remainTime = str;
    }

    @NotNull
    public String toString() {
        NearbyUserModel nearbyUserModel = this.fromUser;
        return "DailyHeartModel(fromUser=" + ((Object) nearbyUserModel) + ", mosaic=" + this.mosaic + ", remainTime=" + this.remainTime + ")";
    }

    public /* synthetic */ DailyHeartModel(NearbyUserModel nearbyUserModel, boolean z10, String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(nearbyUserModel, (i10 & 2) != 0 ? false : z10, (i10 & 4) != 0 ? null : str);
    }
}
