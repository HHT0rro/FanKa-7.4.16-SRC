package com.cupidapp.live.liveshow.activity;

import org.jetbrains.annotations.NotNull;

/* compiled from: FKStartLiveShowActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum LiveshowOpenSource {
    RecommendLive("RecommendLive"),
    Recommend("Recommend"),
    Nearby("Nearby"),
    Follow("Follow"),
    General("General");


    @NotNull
    private final String value;

    LiveshowOpenSource(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
