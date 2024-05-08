package com.cupidapp.live.match.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ActivityJumpModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ActivityJumpModel {

    @Nullable
    private final String activityJumpUrl;

    public ActivityJumpModel(@Nullable String str) {
        this.activityJumpUrl = str;
    }

    public static /* synthetic */ ActivityJumpModel copy$default(ActivityJumpModel activityJumpModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = activityJumpModel.activityJumpUrl;
        }
        return activityJumpModel.copy(str);
    }

    @Nullable
    public final String component1() {
        return this.activityJumpUrl;
    }

    @NotNull
    public final ActivityJumpModel copy(@Nullable String str) {
        return new ActivityJumpModel(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ActivityJumpModel) && s.d(this.activityJumpUrl, ((ActivityJumpModel) obj).activityJumpUrl);
    }

    @Nullable
    public final String getActivityJumpUrl() {
        return this.activityJumpUrl;
    }

    public int hashCode() {
        String str = this.activityJumpUrl;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        return "ActivityJumpModel(activityJumpUrl=" + this.activityJumpUrl + ")";
    }
}
