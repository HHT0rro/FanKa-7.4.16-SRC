package com.cupidapp.live.push.event;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: PushEvent.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class RouterUrlJumperSelectSecondTabEvent {

    @NotNull
    private final String type;

    public RouterUrlJumperSelectSecondTabEvent(@NotNull String type) {
        s.i(type, "type");
        this.type = type;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }
}
