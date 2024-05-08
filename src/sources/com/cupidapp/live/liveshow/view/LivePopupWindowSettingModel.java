package com.cupidapp.live.liveshow.view;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLivePopupWindowView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LivePopupWindowSettingModel {

    @NotNull
    private String livePopupWindowId;
    private int showCount;
    private long showPopTime;

    public LivePopupWindowSettingModel() {
        this(null, 0, 0L, 7, null);
    }

    public LivePopupWindowSettingModel(@NotNull String livePopupWindowId, int i10, long j10) {
        s.i(livePopupWindowId, "livePopupWindowId");
        this.livePopupWindowId = livePopupWindowId;
        this.showCount = i10;
        this.showPopTime = j10;
    }

    public static /* synthetic */ LivePopupWindowSettingModel copy$default(LivePopupWindowSettingModel livePopupWindowSettingModel, String str, int i10, long j10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = livePopupWindowSettingModel.livePopupWindowId;
        }
        if ((i11 & 2) != 0) {
            i10 = livePopupWindowSettingModel.showCount;
        }
        if ((i11 & 4) != 0) {
            j10 = livePopupWindowSettingModel.showPopTime;
        }
        return livePopupWindowSettingModel.copy(str, i10, j10);
    }

    @NotNull
    public final String component1() {
        return this.livePopupWindowId;
    }

    public final int component2() {
        return this.showCount;
    }

    public final long component3() {
        return this.showPopTime;
    }

    @NotNull
    public final LivePopupWindowSettingModel copy(@NotNull String livePopupWindowId, int i10, long j10) {
        s.i(livePopupWindowId, "livePopupWindowId");
        return new LivePopupWindowSettingModel(livePopupWindowId, i10, j10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LivePopupWindowSettingModel)) {
            return false;
        }
        LivePopupWindowSettingModel livePopupWindowSettingModel = (LivePopupWindowSettingModel) obj;
        return s.d(this.livePopupWindowId, livePopupWindowSettingModel.livePopupWindowId) && this.showCount == livePopupWindowSettingModel.showCount && this.showPopTime == livePopupWindowSettingModel.showPopTime;
    }

    @NotNull
    public final String getLivePopupWindowId() {
        return this.livePopupWindowId;
    }

    public final int getShowCount() {
        return this.showCount;
    }

    public final long getShowPopTime() {
        return this.showPopTime;
    }

    public int hashCode() {
        return (((this.livePopupWindowId.hashCode() * 31) + this.showCount) * 31) + b2.a.a(this.showPopTime);
    }

    public final void setLivePopupWindowId(@NotNull String str) {
        s.i(str, "<set-?>");
        this.livePopupWindowId = str;
    }

    public final void setShowCount(int i10) {
        this.showCount = i10;
    }

    public final void setShowPopTime(long j10) {
        this.showPopTime = j10;
    }

    @NotNull
    public String toString() {
        return "LivePopupWindowSettingModel(livePopupWindowId=" + this.livePopupWindowId + ", showCount=" + this.showCount + ", showPopTime=" + this.showPopTime + ")";
    }

    public /* synthetic */ LivePopupWindowSettingModel(String str, int i10, long j10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? 0 : i10, (i11 & 4) != 0 ? 0L : j10);
    }
}
