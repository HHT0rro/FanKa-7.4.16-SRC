package com.huawei.flexiblelayout.css;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CSSSelector {

    /* renamed from: a, reason: collision with root package name */
    private String f27957a;

    private CSSSelector(String str) {
        if (str != null) {
            this.f27957a = str;
        }
    }

    public static CSSSelector build(String str) {
        return new CSSSelector(str);
    }

    public CSSRule getRule(CSSLink cSSLink) {
        String str;
        if (cSSLink == null || (str = this.f27957a) == null) {
            return null;
        }
        return cSSLink.getRule(str);
    }
}
