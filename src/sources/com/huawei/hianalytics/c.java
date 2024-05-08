package com.huawei.hianalytics;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class c {
    public static c ikl;
    public static Map<String, z> klm = new ConcurrentHashMap();
    public e lmn = new e();

    public static c klm() {
        if (ikl == null) {
            synchronized (c.class) {
                if (ikl == null) {
                    ikl = new c();
                }
            }
        }
        return ikl;
    }

    public z lmn(String str) {
        return klm.get(str);
    }

    public e lmn() {
        return this.lmn;
    }
}
