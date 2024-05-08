package com.tencent.cloud.huiyansdkface.wehttp2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class Pin {

    /* renamed from: a, reason: collision with root package name */
    private String f42293a;

    /* renamed from: b, reason: collision with root package name */
    private String f42294b;

    public Pin(String str, String str2) {
        this.f42293a = str;
        this.f42294b = str2;
    }

    public static Collection<? extends Pin> create(String str, String[] strArr) {
        if (str == null) {
            throw new IllegalArgumentException("host pattern must not be null");
        }
        if (strArr == null || strArr.length == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str2 : strArr) {
            if (str2 != null) {
                arrayList.add(new Pin(str, str2));
            }
        }
        return arrayList;
    }

    public String getPattern() {
        return this.f42293a;
    }

    public String getPin() {
        return this.f42294b;
    }

    public boolean match(String str) {
        return this.f42293a.startsWith("**.") ? str.endsWith(this.f42293a.substring(2)) : this.f42293a.startsWith("*.") ? this.f42293a.substring(1).equals(str.substring(str.indexOf("."))) : this.f42293a.equals(str);
    }
}
