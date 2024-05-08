package com.huawei.hms.scankit.p;

import java.security.SecureRandom;

/* compiled from: RandomUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class n6 {

    /* renamed from: a, reason: collision with root package name */
    private static final SecureRandom f31313a = new SecureRandom();

    public static int a(int i10) {
        return f31313a.nextInt(i10);
    }

    public static float a(float f10) {
        return f31313a.nextFloat() * f10;
    }
}
