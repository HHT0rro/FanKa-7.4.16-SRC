package com.xiaomi.push;

import java.io.File;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class r7 {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap<String, String> f48144a;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        f48144a = hashMap;
        hashMap.put("FFD8FF", "jpg");
        hashMap.put("89504E47", "png");
        hashMap.put(com.huawei.openalliance.ad.constant.u.an, "gif");
        hashMap.put("474946", "gif");
        hashMap.put("424D", "bmp");
    }

    public static long a(File file) {
        long j10 = 0;
        try {
            File[] listFiles = file.listFiles();
            for (int i10 = 0; i10 < listFiles.length; i10++) {
                j10 += listFiles[i10].isDirectory() ? a(listFiles[i10]) : listFiles[i10].length();
            }
        } catch (Exception e2) {
            fc.c.k(e2);
        }
        return j10;
    }
}
