package com.cupidapp.live.liveshow.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LivePushModel {

    @Nullable
    private final Long pushEnableTime;

    public LivePushModel(@Nullable Long l10) {
        this.pushEnableTime = l10;
    }

    public static /* synthetic */ LivePushModel copy$default(LivePushModel livePushModel, Long l10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            l10 = livePushModel.pushEnableTime;
        }
        return livePushModel.copy(l10);
    }

    @Nullable
    public final Long component1() {
        return this.pushEnableTime;
    }

    @NotNull
    public final LivePushModel copy(@Nullable Long l10) {
        return new LivePushModel(l10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LivePushModel) && s.d(this.pushEnableTime, ((LivePushModel) obj).pushEnableTime);
    }

    @Nullable
    public final Long getPushEnableTime() {
        return this.pushEnableTime;
    }

    public int hashCode() {
        Long l10 = this.pushEnableTime;
        if (l10 == null) {
            return 0;
        }
        return l10.hashCode();
    }

    @NotNull
    public String toString() {
        return "LivePushModel(pushEnableTime=" + ((Object) this.pushEnableTime) + ")";
    }
}
