package com.cupidapp.live.startup.model;

import kotlin.d;

/* compiled from: StartupModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum FKExpressAdType {
    Sponsor(1),
    ShowCase(2),
    Program(3);

    private final int type;

    FKExpressAdType(int i10) {
        this.type = i10;
    }

    public final int getType() {
        return this.type;
    }
}
