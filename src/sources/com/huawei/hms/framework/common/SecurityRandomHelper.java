package com.huawei.hms.framework.common;

import va.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class SecurityRandomHelper {
    public static volatile SecurityRandomHelper instance;

    private SecurityRandomHelper() {
    }

    public static SecurityRandomHelper getInstance() {
        if (instance == null) {
            synchronized (SecurityRandomHelper.class) {
                if (instance == null) {
                    b.e(true);
                    instance = new SecurityRandomHelper();
                }
            }
        }
        return instance;
    }

    public byte[] generateSecureRandom(int i10) {
        return b.c(i10);
    }

    public String generateSecureRandomStr(int i10) {
        return b.d(i10);
    }
}
