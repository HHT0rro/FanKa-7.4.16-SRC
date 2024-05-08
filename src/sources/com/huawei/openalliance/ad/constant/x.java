package com.huawei.openalliance.ad.constant;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class x {
    public static final Set<String> Code;
    private static final String I = "com.huawei.browser";
    private static final String V = "com.android.browser";
    private static final Set<String> Z;

    static {
        HashSet hashSet = new HashSet();
        Z = hashSet;
        hashSet.add("com.android.browser");
        hashSet.add("com.huawei.browser");
        Code = Collections.unmodifiableSet(hashSet);
    }
}
