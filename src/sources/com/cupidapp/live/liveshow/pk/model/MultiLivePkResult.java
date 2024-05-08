package com.cupidapp.live.liveshow.pk.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: MultiPersonPkModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum MultiLivePkResult {
    LivePkWin("win"),
    LivePkFailed("lose"),
    LivePkDraw("draw");


    @NotNull
    private final String value;

    MultiLivePkResult(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
