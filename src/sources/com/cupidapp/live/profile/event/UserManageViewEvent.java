package com.cupidapp.live.profile.event;

import com.cupidapp.live.base.sensorslog.SensorPosition;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: UserManageViewEvent.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UserManageViewEvent {
    private final boolean dataChanged;

    @NotNull
    private final SensorPosition position;

    public UserManageViewEvent(@NotNull SensorPosition position, boolean z10) {
        s.i(position, "position");
        this.position = position;
        this.dataChanged = z10;
    }

    public final boolean getDataChanged() {
        return this.dataChanged;
    }

    @NotNull
    public final SensorPosition getPosition() {
        return this.position;
    }
}
