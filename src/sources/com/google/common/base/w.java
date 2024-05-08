package com.google.common.base;

/* compiled from: Verify.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class w {
    public static void a(boolean z10, String str, Object obj) {
        if (!z10) {
            throw new VerifyException(s.c(str, obj));
        }
    }
}
