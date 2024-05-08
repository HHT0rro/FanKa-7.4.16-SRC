package com.cupidapp.live.liveshow.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKLiveHornLinkModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum LiveHornStyle {
    Common("common"),
    Lucky("lucky");


    @NotNull
    private final String value;

    LiveHornStyle(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
