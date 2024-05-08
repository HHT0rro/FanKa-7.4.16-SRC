package com.danlan.android.cognition;

import com.danlan.android.security.obfuscator.StringFogImpl;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class StringFog {
    private static final StringFogImpl IMPL = new StringFogImpl();

    public static String decrypt(String str) {
        return IMPL.decrypt(str, "!#$#!#$!");
    }

    public static boolean overflow(String str) {
        return IMPL.overflow(str, "!#$#!#$!");
    }
}
