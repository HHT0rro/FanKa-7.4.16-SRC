package com.alipay.sdk.widget;

import java.util.Iterator;
import java.util.Stack;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private Stack<WebViewWindow> f4836a = new Stack<>();

    public WebViewWindow a() {
        return this.f4836a.pop();
    }

    public boolean b() {
        return this.f4836a.isEmpty();
    }

    public void c() {
        if (b()) {
            return;
        }
        Iterator<WebViewWindow> it = this.f4836a.iterator2();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f4836a.clear();
    }

    public void a(WebViewWindow webViewWindow) {
        this.f4836a.push(webViewWindow);
    }
}
