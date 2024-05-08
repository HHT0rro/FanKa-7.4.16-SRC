package com.tencent.turingcam;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class FLlEM {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, s7Dnc> f45398a;

    static {
        HashMap hashMap = new HashMap();
        f45398a = hashMap;
        hashMap.put("4", new nyvKz());
        hashMap.put("3", new ucT3w());
        hashMap.put("5", new yiZAu());
    }

    public static s7Dnc a(String str) {
        return f45398a.get(str);
    }
}
