package com.huawei.flexiblelayout.css;

import android.view.View;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CSSViewProxy {

    /* renamed from: a, reason: collision with root package name */
    private View f27961a;

    /* renamed from: b, reason: collision with root package name */
    private CSSRule f27962b;

    public CSSViewProxy(View view, CSSRule cSSRule) {
        this.f27961a = view;
        this.f27962b = cSSRule;
    }

    public CSSRule getRule() {
        return this.f27962b;
    }

    public View getView() {
        return this.f27961a;
    }

    public CSSViewProxy render(View view) {
        CSSView.wrap(view, this.f27962b).renderSelf();
        return this;
    }

    public CSSViewProxy render() {
        return render(this.f27961a);
    }
}
