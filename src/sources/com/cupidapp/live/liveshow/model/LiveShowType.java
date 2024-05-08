package com.cupidapp.live.liveshow.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum LiveShowType {
    LiveShow("LiveShow"),
    Banner("Banner");


    @NotNull
    private final String type;

    LiveShowType(String str) {
        this.type = str;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }
}
