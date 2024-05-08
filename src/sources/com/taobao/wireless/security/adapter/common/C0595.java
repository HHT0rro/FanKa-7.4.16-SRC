package com.taobao.wireless.security.adapter.common;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
/* renamed from: com.taobao.wireless.security.adapter.common.а, reason: contains not printable characters */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
public class C0595 {
    /* renamed from: а, reason: contains not printable characters */
    public static boolean m2878(String... strArr) {
        return !m2879(strArr);
    }

    /* renamed from: б, reason: contains not printable characters */
    public static boolean m2879(String... strArr) {
        for (String str : strArr) {
            if (str == null || "".equals(str)) {
                return true;
            }
        }
        return false;
    }
}
