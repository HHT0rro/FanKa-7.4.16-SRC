package com.cupidapp.live.main.event;

import com.cupidapp.live.MainActivity;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: MainEvent.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class RefreshSpecifyTabUnreadCountEvent {

    @NotNull
    private final MainActivity.MainPagerType type;

    public RefreshSpecifyTabUnreadCountEvent(@NotNull MainActivity.MainPagerType type) {
        s.i(type, "type");
        this.type = type;
    }

    @NotNull
    public final MainActivity.MainPagerType getType() {
        return this.type;
    }
}
