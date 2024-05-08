package com.cupidapp.live.mediapicker.event;

import com.cupidapp.live.base.sensorslog.SensorPosition;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedPublishSuccessEvent.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class TabRedDotEvent {
    private final boolean isShow;

    @NotNull
    private final SensorPosition sensorPosition;

    public TabRedDotEvent(boolean z10, @NotNull SensorPosition sensorPosition) {
        s.i(sensorPosition, "sensorPosition");
        this.isShow = z10;
        this.sensorPosition = sensorPosition;
    }

    public static /* synthetic */ TabRedDotEvent copy$default(TabRedDotEvent tabRedDotEvent, boolean z10, SensorPosition sensorPosition, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = tabRedDotEvent.isShow;
        }
        if ((i10 & 2) != 0) {
            sensorPosition = tabRedDotEvent.sensorPosition;
        }
        return tabRedDotEvent.copy(z10, sensorPosition);
    }

    public final boolean component1() {
        return this.isShow;
    }

    @NotNull
    public final SensorPosition component2() {
        return this.sensorPosition;
    }

    @NotNull
    public final TabRedDotEvent copy(boolean z10, @NotNull SensorPosition sensorPosition) {
        s.i(sensorPosition, "sensorPosition");
        return new TabRedDotEvent(z10, sensorPosition);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TabRedDotEvent)) {
            return false;
        }
        TabRedDotEvent tabRedDotEvent = (TabRedDotEvent) obj;
        return this.isShow == tabRedDotEvent.isShow && this.sensorPosition == tabRedDotEvent.sensorPosition;
    }

    @NotNull
    public final SensorPosition getSensorPosition() {
        return this.sensorPosition;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z10 = this.isShow;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        return (r02 * 31) + this.sensorPosition.hashCode();
    }

    public final boolean isShow() {
        return this.isShow;
    }

    @NotNull
    public String toString() {
        return "TabRedDotEvent(isShow=" + this.isShow + ", sensorPosition=" + ((Object) this.sensorPosition) + ")";
    }
}
