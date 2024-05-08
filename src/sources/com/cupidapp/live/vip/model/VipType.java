package com.cupidapp.live.vip.model;

import kotlin.d;

/* compiled from: VipType.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum VipType {
    SUPER(0),
    NORMAL(1),
    RAINBOW(2),
    VISITOR(3);

    private final int value;

    VipType(int i10) {
        this.value = i10;
    }

    public final int getValue() {
        return this.value;
    }
}
