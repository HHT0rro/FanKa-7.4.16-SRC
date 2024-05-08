package com.cupidapp.live.startup.model;

import kotlin.d;

/* compiled from: StartupModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum FKStartupMaterialType {
    Image(1),
    Video(2);

    private final int type;

    FKStartupMaterialType(int i10) {
        this.type = i10;
    }

    public final int getType() {
        return this.type;
    }
}
