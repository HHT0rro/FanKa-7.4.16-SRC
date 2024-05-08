package com.cupidapp.live.notify.fragment;

import com.cupidapp.live.base.sensorslog.SensorPosition;
import org.jetbrains.annotations.NotNull;

/* compiled from: NotifyContainerNewFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum NotifyPageType {
    Follow(0, SensorPosition.NotifyAloha),
    AiIdentify(1, SensorPosition.AiIdentify),
    Praise(2, SensorPosition.NotifyGetLike),
    Dynamic(3, SensorPosition.NotifyMention),
    DailyHeart(4, SensorPosition.DailyHeart);

    private final int index;

    @NotNull
    private final SensorPosition pageName;

    NotifyPageType(int i10, SensorPosition sensorPosition) {
        this.index = i10;
        this.pageName = sensorPosition;
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getOldIndex() {
        if (this == Follow) {
            return this.index;
        }
        return this.index - 1;
    }

    @NotNull
    public final SensorPosition getPageName() {
        return this.pageName;
    }
}
