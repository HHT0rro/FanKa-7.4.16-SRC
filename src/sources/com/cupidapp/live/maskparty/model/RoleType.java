package com.cupidapp.live.maskparty.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: MaskPartyItemCardModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum RoleType {
    Bottom(0, "Bottom"),
    Top(1, "Top"),
    Vers(2, "Vers"),
    VersTop(3, "Vers Top"),
    VersBottom(4, "Vers Bottom"),
    Others(5, "Others");

    private final int type;

    @NotNull
    private final String value;

    RoleType(int i10, String str) {
        this.type = i10;
        this.value = str;
    }

    public final int getType() {
        return this.type;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
