package com.huawei.quickcard.framework.border;

import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.j;
import com.huawei.quickcard.o;
import com.huawei.quickcard.p;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Border {

    /* renamed from: a, reason: collision with root package name */
    private BorderRadius f33821a;

    /* renamed from: b, reason: collision with root package name */
    private o f33822b;

    /* renamed from: c, reason: collision with root package name */
    private p f33823c;

    /* renamed from: d, reason: collision with root package name */
    private j f33824d;

    public j getBorderColor() {
        return this.f33824d;
    }

    public BorderRadius getBorderRadius() {
        return this.f33821a;
    }

    public o getBorderStyle() {
        return this.f33822b;
    }

    public p getBorderWidth() {
        return this.f33823c;
    }

    public void setBorderColor(j jVar) {
        this.f33824d = jVar;
    }

    public void setBorderRadius(BorderRadius borderRadius) {
        this.f33821a = borderRadius;
    }

    public void setBorderStyle(o oVar) {
        this.f33822b = oVar;
    }

    public void setBorderWidth(p pVar) {
        this.f33823c = pVar;
    }
}
