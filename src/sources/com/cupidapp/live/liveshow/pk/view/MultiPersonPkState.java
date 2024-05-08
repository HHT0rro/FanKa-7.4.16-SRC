package com.cupidapp.live.liveshow.pk.view;

import org.jetbrains.annotations.NotNull;

/* compiled from: MultiPkLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum MultiPersonPkState {
    PKPrepare("ready"),
    PKing("start"),
    PKInteract("interact"),
    PKEnd("end");


    @NotNull
    private final String value;

    MultiPersonPkState(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
