package com.cupidapp.live.appdialog.model;

import com.cupidapp.live.base.sensorslog.SensorPosition;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: RechangeTabEvent.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ReChangeTabEvent {

    @NotNull
    private final SensorPosition position;

    public ReChangeTabEvent(@NotNull SensorPosition position) {
        s.i(position, "position");
        this.position = position;
    }

    @NotNull
    public final SensorPosition getPosition() {
        return this.position;
    }
}
