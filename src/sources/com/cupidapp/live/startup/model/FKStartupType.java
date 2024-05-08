package com.cupidapp.live.startup.model;

import kotlin.d;

/* compiled from: StartupModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum FKStartupType {
    ProgrammaticAdvertising(1),
    DirectCustomerAdvertising(2),
    OperatingAdvertising(3);

    private final int type;

    FKStartupType(int i10) {
        this.type = i10;
    }

    public final int getType() {
        return this.type;
    }
}
