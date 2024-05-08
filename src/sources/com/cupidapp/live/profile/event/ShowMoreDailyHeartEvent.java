package com.cupidapp.live.profile.event;

import com.cupidapp.live.base.network.model.DailyLikeGuideModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProfileEvent.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ShowMoreDailyHeartEvent {

    @NotNull
    private final DailyLikeGuideModel model;

    public ShowMoreDailyHeartEvent(@NotNull DailyLikeGuideModel model) {
        s.i(model, "model");
        this.model = model;
    }

    public static /* synthetic */ ShowMoreDailyHeartEvent copy$default(ShowMoreDailyHeartEvent showMoreDailyHeartEvent, DailyLikeGuideModel dailyLikeGuideModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            dailyLikeGuideModel = showMoreDailyHeartEvent.model;
        }
        return showMoreDailyHeartEvent.copy(dailyLikeGuideModel);
    }

    @NotNull
    public final DailyLikeGuideModel component1() {
        return this.model;
    }

    @NotNull
    public final ShowMoreDailyHeartEvent copy(@NotNull DailyLikeGuideModel model) {
        s.i(model, "model");
        return new ShowMoreDailyHeartEvent(model);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ShowMoreDailyHeartEvent) && s.d(this.model, ((ShowMoreDailyHeartEvent) obj).model);
    }

    @NotNull
    public final DailyLikeGuideModel getModel() {
        return this.model;
    }

    public int hashCode() {
        return this.model.hashCode();
    }

    @NotNull
    public String toString() {
        return "ShowMoreDailyHeartEvent(model=" + ((Object) this.model) + ")";
    }
}
