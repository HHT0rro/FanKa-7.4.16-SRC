package com.android.internal.os;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IZygoteArgumentsExt {
    default boolean canParseArg(String arg) {
        return false;
    }

    default void doParseArg(String arg) throws IllegalArgumentException {
    }

    default String[] getOplusHiddenApiExemptions() {
        return null;
    }
}
