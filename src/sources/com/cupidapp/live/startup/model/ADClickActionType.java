package com.cupidapp.live.startup.model;

import kotlin.d;

/* compiled from: ApiAdModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum ADClickActionType {
    EXPOSURE(1),
    WEBVIEWOPEN(2),
    DOWNLOAD(3),
    WECHAT(4);

    private final int value;

    ADClickActionType(int i10) {
        this.value = i10;
    }

    public final int getValue() {
        return this.value;
    }
}
