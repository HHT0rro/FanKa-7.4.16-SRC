package com.huawei.hianalytics.log;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class LogTag {
    public static String get(Class<?> cls, Class<?>... clsArr) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cls.getSimpleName());
        for (Class<?> cls2 : clsArr) {
            sb2.append('.');
            sb2.append(cls2.getSimpleName());
        }
        return sb2.toString();
    }
}
