package com.jd.ad.sdk.fdt.utils;

import java.util.UUID;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class UUIDUtils {
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
