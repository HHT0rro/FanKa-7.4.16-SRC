package com.google.common.collect;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public enum BoundType {
    OPEN(false),
    CLOSED(true);

    public final boolean inclusive;

    BoundType(boolean z10) {
        this.inclusive = z10;
    }

    public static BoundType forBoolean(boolean z10) {
        return z10 ? CLOSED : OPEN;
    }
}
