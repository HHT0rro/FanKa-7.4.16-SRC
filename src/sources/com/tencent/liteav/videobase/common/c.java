package com.tencent.liteav.videobase.common;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public enum c {
    UNKNOWN(65535),
    IDR(0),
    P(1),
    B(6),
    P_MULTI_REF(7),
    I(8),
    SEI(17),
    SPS(18),
    PPS(19),
    VPS(20);


    /* renamed from: k, reason: collision with root package name */
    private static final c[] f43390k = values();
    public final int mValue;

    c(int i10) {
        this.mValue = i10;
    }

    public static c a(int i10) {
        for (c cVar : f43390k) {
            if (cVar.mValue == i10) {
                return cVar;
            }
        }
        return UNKNOWN;
    }
}
