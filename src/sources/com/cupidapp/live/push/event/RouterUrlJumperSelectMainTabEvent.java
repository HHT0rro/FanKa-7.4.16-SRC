package com.cupidapp.live.push.event;

import com.cupidapp.live.MainActivity;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: PushEvent.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class RouterUrlJumperSelectMainTabEvent {

    @NotNull
    private final MainActivity.MainPagerType type;

    public RouterUrlJumperSelectMainTabEvent(@NotNull MainActivity.MainPagerType type) {
        s.i(type, "type");
        this.type = type;
    }

    @NotNull
    public final MainActivity.MainPagerType getType() {
        return this.type;
    }
}
