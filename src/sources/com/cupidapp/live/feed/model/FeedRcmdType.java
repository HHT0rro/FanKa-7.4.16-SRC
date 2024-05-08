package com.cupidapp.live.feed.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: FeedModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum FeedRcmdType {
    AdTagPost("adTagPost");


    @NotNull
    private final String value;

    FeedRcmdType(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
