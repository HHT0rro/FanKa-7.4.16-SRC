package com.kwad.sdk.pngencrypt;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public enum ErrorBehaviour {
    STRICT(0),
    LENIENT1_CRC(1),
    LENIENT2_ANCILLARY(3),
    SUPER_LENIENT(5);


    /* renamed from: c, reason: collision with root package name */
    public final int f36651c;

    ErrorBehaviour(int i10) {
        this.f36651c = i10;
    }
}
