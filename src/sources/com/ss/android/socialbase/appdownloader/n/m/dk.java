package com.ss.android.socialbase.appdownloader.n.m;

import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class dk {
    public static final void m(l lVar, int i10) throws IOException {
        int dk = lVar.dk();
        if (dk == i10) {
            return;
        }
        throw new IOException("Expected chunk of type 0x" + Integer.toHexString(i10) + ", read 0x" + Integer.toHexString(dk) + ".");
    }
}
