package com.huawei.hms.framework.network.grs.h;

import com.huawei.hms.framework.common.Logger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f30044a = "e";

    public static boolean a(Long l10) {
        if (l10 == null) {
            Logger.v(f30044a, "Method isTimeExpire input param expireTime is null.");
            return true;
        }
        try {
        } catch (NumberFormatException unused) {
            Logger.v(f30044a, "isSpExpire spValue NumberFormatException.");
        }
        if (l10.longValue() - System.currentTimeMillis() >= 0) {
            Logger.i(f30044a, "isSpExpire false.");
            return false;
        }
        Logger.i(f30044a, "isSpExpire true.");
        return true;
    }

    public static boolean a(Long l10, long j10) {
        if (l10 == null) {
            Logger.v(f30044a, "Method isTimeWillExpire input param expireTime is null.");
            return true;
        }
        try {
            if (l10.longValue() - (System.currentTimeMillis() + j10) >= 0) {
                Logger.v(f30044a, "isSpExpire false.");
                return false;
            }
        } catch (NumberFormatException unused) {
            Logger.v(f30044a, "isSpExpire spValue NumberFormatException.");
        }
        return true;
    }
}
