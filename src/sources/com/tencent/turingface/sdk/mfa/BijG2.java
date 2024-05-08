package com.tencent.turingface.sdk.mfa;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class BijG2 {

    /* renamed from: a, reason: collision with root package name */
    public static final List<String> f45534a = new ArrayList();

    public static String a(Set<String> set) {
        StringBuilder sb2 = new StringBuilder();
        try {
            for (String str : set) {
                if (sb2.length() > 0) {
                    sb2.append("|");
                }
                sb2.append(str);
            }
        } catch (Throwable unused) {
        }
        return sb2.toString();
    }
}
