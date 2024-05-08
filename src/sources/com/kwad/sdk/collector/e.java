package com.kwad.sdk.collector;

import com.kwad.sdk.utils.m;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e {
    public static String cs(String str) {
        try {
            return new String(com.kwad.sdk.core.a.c.Ds().encode(m.k(q.U(new File(str)))));
        } catch (IOException e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
            return null;
        }
    }
}
