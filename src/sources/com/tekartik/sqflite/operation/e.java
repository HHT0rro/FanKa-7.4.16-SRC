package com.tekartik.sqflite.operation;

import java.util.HashMap;
import java.util.Map;
import yb.d0;

/* compiled from: SqlErrorInfo.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class e {
    public static Map<String, Object> a(c cVar) {
        d0 c4 = cVar.c();
        if (c4 == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("sql", c4.c());
        hashMap.put("arguments", c4.b());
        return hashMap;
    }
}
