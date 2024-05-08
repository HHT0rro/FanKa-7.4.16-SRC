package com.huawei.flexiblelayout;

import java.util.HashSet;
import java.util.Set;

/* compiled from: SelectorSymbol.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
class g0 {

    /* renamed from: a, reason: collision with root package name */
    public static final String f28132a = " ";

    /* renamed from: b, reason: collision with root package name */
    public static final String f28133b = "~";

    /* renamed from: c, reason: collision with root package name */
    private static Set<String> f28134c = new HashSet();

    public g0() {
        f28134c.add(" ");
        f28134c.add("~");
    }

    public static boolean a(String str) {
        return f28134c.contains(str);
    }
}
