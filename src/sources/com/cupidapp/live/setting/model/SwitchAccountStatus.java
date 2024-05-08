package com.cupidapp.live.setting.model;

import kotlin.d;

/* compiled from: SwitchAccountModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum SwitchAccountStatus {
    Normal(0),
    Ban(1),
    Close(2);

    private final int value;

    SwitchAccountStatus(int i10) {
        this.value = i10;
    }

    public final int getValue() {
        return this.value;
    }
}
