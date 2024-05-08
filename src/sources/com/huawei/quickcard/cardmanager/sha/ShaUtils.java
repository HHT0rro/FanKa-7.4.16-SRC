package com.huawei.quickcard.cardmanager.sha;

import com.huawei.quickcard.cardmanager.log.ManagerLogUtil;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ShaUtils {

    /* renamed from: a, reason: collision with root package name */
    private static SHA f33561a;

    public static void setSha(SHA sha) {
        f33561a = sha;
    }

    public static String sha256Encrypt(String str) {
        SHA sha = f33561a;
        if (sha == null) {
            ManagerLogUtil.w("ShaUtils.sha256Encrypt does not set SHA impl");
            return null;
        }
        return sha.sha256Encrypt(str);
    }
}
