package com.cupidapp.live.track.group;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: GroupIncrementLog.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum SensorIconType {
    ICON("icon"),
    FILTER("筛选");


    @NotNull
    private final String type;

    SensorIconType(String str) {
        this.type = str;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }
}
