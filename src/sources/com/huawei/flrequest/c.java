package com.huawei.flrequest;

import com.huawei.serverrequest.api.service.HttpException;

/* compiled from: ErrorCodeUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class c {
    public static int a(HttpException httpException) {
        int i10 = httpException.code;
        int i11 = 1;
        if (i10 != 1) {
            i11 = 2;
            if (i10 != 2) {
                i11 = 3;
                if (i10 != 3) {
                    i11 = 4;
                    if (i10 != 4) {
                        return -1;
                    }
                }
            }
        }
        return i11;
    }
}
