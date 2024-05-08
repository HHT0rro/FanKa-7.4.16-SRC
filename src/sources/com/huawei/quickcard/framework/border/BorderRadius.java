package com.huawei.quickcard.framework.border;

import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.o1;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class BorderRadius {

    /* renamed from: a, reason: collision with root package name */
    private o1 f33825a;

    /* renamed from: b, reason: collision with root package name */
    private o1 f33826b;

    /* renamed from: c, reason: collision with root package name */
    private o1 f33827c;

    /* renamed from: d, reason: collision with root package name */
    private o1 f33828d;

    /* renamed from: e, reason: collision with root package name */
    private o1 f33829e;

    private boolean a(o1 o1Var) {
        return o1Var == null || Float.compare(o1Var.f34141a, 0.0f) == 0;
    }

    public boolean allSame() {
        o1 o1Var;
        o1 o1Var2 = this.f33825a;
        return o1Var2 == this.f33826b && (o1Var = this.f33828d) == this.f33827c && o1Var2 == o1Var;
    }

    public o1 getAllRadius() {
        return this.f33829e;
    }

    public o1 getBottomLeft() {
        return this.f33828d;
    }

    public o1 getBottomRight() {
        return this.f33827c;
    }

    public o1 getTopLeft() {
        return this.f33825a;
    }

    public o1 getTopRight() {
        return this.f33826b;
    }

    public boolean isRectangle() {
        return allSame() && a(this.f33825a) && a(this.f33829e);
    }

    public void setAllRadius(o1 o1Var) {
        this.f33829e = o1Var;
    }

    public void setBottomLeft(o1 o1Var) {
        this.f33828d = o1Var;
    }

    public void setBottomRight(o1 o1Var) {
        this.f33827c = o1Var;
    }

    public void setTopLeft(o1 o1Var) {
        this.f33825a = o1Var;
    }

    public void setTopRight(o1 o1Var) {
        this.f33826b = o1Var;
    }
}
