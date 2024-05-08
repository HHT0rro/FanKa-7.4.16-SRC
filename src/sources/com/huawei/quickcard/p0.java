package com.huawei.quickcard;

import com.huawei.quickcard.utils.ExpressionUtils;
import com.huawei.quickcard.watcher.Watcher;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class p0 {

    /* renamed from: a, reason: collision with root package name */
    private final String f34166a;

    /* renamed from: b, reason: collision with root package name */
    private final Watcher f34167b;

    public p0(String str, Watcher watcher) {
        this.f34166a = str;
        this.f34167b = watcher;
    }

    public String a() {
        return this.f34166a;
    }

    public boolean a(CardContext cardContext) {
        Object executeExpr;
        Watcher watcher = this.f34167b;
        if (watcher != null) {
            executeExpr = watcher.get();
        } else {
            executeExpr = cardContext.executeExpr(this.f34166a, false);
        }
        return ExpressionUtils.isTrue(executeExpr);
    }
}
