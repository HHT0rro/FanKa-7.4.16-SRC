package com.tencent.turingface.sdk.mfa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class V124r {

    /* renamed from: a, reason: collision with root package name */
    public static Map<String, Set<String>> f45714a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public static Map<String, Integer> f45715b = new HashMap();

    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Map<java.lang.String, java.util.Set<java.lang.String>>, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.Map<java.lang.String, java.util.Set<java.lang.String>>, java.util.HashMap] */
    static {
        HashSet hashSet = new HashSet();
        hashSet.add("18C867F0717AA67B2AB7347505BA07ED");
        ?? r12 = f45714a;
        int[] iArr = kC0XR.J;
        r12.put(kC0XR.a(iArr), hashSet);
        HashSet hashSet2 = new HashSet();
        hashSet2.add("31223B0BDF1DEF1FE8252971ADA3B577");
        hashSet2.add("CCD4AD38DC6669F875BC37E3F8840648");
        hashSet2.add("AA3978F41FD96FF9914A669E186474C7");
        hashSet2.add("775E696D09856872FDD8AB4F3F06B1E0");
        hashSet2.add("A6B745BF24A2C277527716F6F36EB68D");
        hashSet2.add("A01EECAB85E9E3BA2B0F6A158C855C29");
        ?? r13 = f45714a;
        int[] iArr2 = kC0XR.K;
        r13.put(kC0XR.a(iArr2), hashSet2);
        f45715b.put(kC0XR.a(iArr), 105118);
        f45715b.put(kC0XR.a(iArr2), 105178);
    }
}
