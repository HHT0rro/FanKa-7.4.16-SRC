package com.kwad.sdk.components;

import com.kwad.sdk.components.DevelopMangerComponents;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class f {
    public static boolean cQ(String str) {
        DevelopMangerComponents.DevelopValue cP = c.cP(str);
        return cP != null && ((Boolean) cP.getValue()).booleanValue();
    }

    public static boolean encryptDisable() {
        return cQ("KEY_HOST_ENCRYPT_DISABLE");
    }
}
