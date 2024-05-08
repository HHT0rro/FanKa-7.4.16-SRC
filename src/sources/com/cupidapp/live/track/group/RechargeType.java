package com.cupidapp.live.track.group;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: GroupRechargeLog.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum RechargeType {
    FirstRecharge("FIRST_RECHARGE"),
    NonFirstRecharge("NON_FIRST_RECHARGE");


    @NotNull
    private final String type;

    RechargeType(String str) {
        this.type = str;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }
}
