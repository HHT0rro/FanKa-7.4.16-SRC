package com.android.internal.org.bouncycastle.util;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class Objects {
    public static boolean areEqual(Object a10, Object b4) {
        return a10 == b4 || !(a10 == null || b4 == null || !a10.equals(b4));
    }

    public static int hashCode(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }
}
